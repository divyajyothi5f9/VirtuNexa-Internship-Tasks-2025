import core.ParkingLotManager;
import db.DatabaseManager;
import ui.ConsoleUI;

public class Main {
    public static void main(String[] args) throws Exception {
        DatabaseManager db = new DatabaseManager();
        db.connect();
        db.initialize();

        ParkingLotManager manager = new ParkingLotManager(10); // 10-slot parking
        ConsoleUI ui = new ConsoleUI(manager, db);
        ui.start();
    }
}
