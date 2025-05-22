public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:atm.db";

    static {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS users (id TEXT PRIMARY KEY, pin TEXT, balance REAL)");
            // Sample user
            stmt.execute("INSERT OR IGNORE INTO users (id, pin, balance) VALUES ('user1', '1234', 1000)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User authenticate(String id, String pin) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id=? AND pin=?")) {
            ps.setString(1, id);
            ps.setString(2, pin);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("id"), rs.getString("pin"), rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateBalance(User user) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement("UPDATE users SET balance=? WHERE id=?")) {
            ps.setDouble(1, user.getBalance());
            ps.setString(2, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
