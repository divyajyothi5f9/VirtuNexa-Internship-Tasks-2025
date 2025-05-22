public class User {
    private String id;
    private String pin;
    private double balance;

    public User(String id, String pin, double balance) {
        this.id = id;
        this.pin = pin;
        this.balance = balance;
    }

    public String getId() { return id; }
    public double getBalance() { return balance; }

    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { balance -= amount; }
}
