package ui;

import core.*;
import db.DatabaseManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ConsoleUI {
    private final ParkingLotManager manager;
    private final DatabaseManager db;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(ParkingLotManager manager, DatabaseManager db) {
        this.manager = manager;
        this.db = db;
    }

    public void start() {
        while (true) {
            System.out.println("""
                1. Park Vehicle
                2. Release Vehicle
                3. View Available Slots
                4. Exit
                """);
            System.out.print("Choose: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1 -> parkVehicle();
                    case 2 -> releaseVehicle();
                    case 3 -> manager.showAvailableSlots();
                    case 4 -> System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void parkVehicle() throws Exception {
        System.out.print("License Plate: ");
        String plate = scanner.nextLine();
        System.out.print("Vehicle Type: ");
        String type = scanner.nextLine();
        LocalDateTime entryTime = LocalDateTime.now();

        Vehicle v = new Vehicle(plate, type, entryTime, null);
        ParkingSlot slot = manager.parkVehicle(v);
        if (slot != null) {
            db.insertEntry(plate, type, entryTime.toString());
            System.out.println("Vehicle parked in slot " + slot.getSlotNumber());
        } else {
            System.out.println("Parking Full!");
        }
    }

    private void releaseVehicle() throws Exception {
        System.out.print("License Plate: ");
        String plate = scanner.nextLine();
        LocalDateTime exitTime = LocalDateTime.now();

        ParkingSlot slot = manager.releaseVehicle(plate);
        if (slot != null) {
            double fee = 20.0; // Replace with dynamic fee logic
            db.updateExit(plate, exitTime.toString(), fee);
            System.out.printf("Vehicle %s exited. Fee: $%.2f\n", plate, fee);
        } else {
            System.out.println("Vehicle not found.");
        }
    }
}
