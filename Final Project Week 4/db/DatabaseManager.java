package db;

import java.sql.*;

public class DatabaseManager {
    private Connection connection;

    public void connect() throws SQLException {
        String url = "jdbc:sqlite:parking.db";
        connection = DriverManager.getConnection(url);
    }

    public void initialize() throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS vehicles (
                license_plate TEXT PRIMARY KEY,
                vehicle_type TEXT,
                entry_time TEXT,
                exit_time TEXT,
                fee REAL
            );
        """;
        connection.createStatement().execute(sql);
    }

    public void insertEntry(String plate, String type, String entryTime) throws SQLException {
        String sql = "INSERT INTO vehicles (license_plate, vehicle_type, entry_time) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, plate);
            stmt.setString(2, type);
            stmt.setString(3, entryTime);
            stmt.executeUpdate();
        }
    }

    public void updateExit(String plate, String exitTime, double fee) throws SQLException {
        String sql = "UPDATE vehicles SET exit_time = ?, fee = ? WHERE license_plate = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, exitTime);
            stmt.setDouble(2, fee);
            stmt.setString(3, plate);
            stmt.executeUpdate();
        }
    }
}
