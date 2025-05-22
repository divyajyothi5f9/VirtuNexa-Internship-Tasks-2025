package core;

import java.util.*;

public class ParkingLotManager {
    private final List<ParkingSlot> slots;

    public ParkingLotManager(int capacity) {
        slots = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            slots.add(new ParkingSlot(i, false, null));
        }
    }

    public ParkingSlot parkVehicle(Vehicle vehicle) {
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                slot.setOccupied(true);
                slot.setVehiclePlate(vehicle.getLicensePlate());
                return slot;
            }
        }
        return null;
    }

    public ParkingSlot releaseVehicle(String licensePlate) {
        for (ParkingSlot slot : slots) {
            if (licensePlate.equals(slot.getVehiclePlate())) {
                slot.setOccupied(false);
                slot.setVehiclePlate(null);
                return slot;
            }
        }
        return null;
    }

    public void showAvailableSlots() {
        slots.stream().filter(s -> !s.isOccupied())
            .forEach(s -> System.out.println("Available Slot: " + s.getSlotNumber()));
    }
}
