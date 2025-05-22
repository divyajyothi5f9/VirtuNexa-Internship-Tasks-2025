public class ATM {
    private Scanner scanner = new Scanner(System.in);
    private User currentUser;

    public void run() {
        System.out.println("Welcome to ATM Simulator");

        while (true) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            currentUser = DatabaseManager.authenticate(userId, pin);
            if (currentUser != null) break;
            else System.out.println("Invalid credentials.");
        }

        showMenu();
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": System.out.println("Balance: $" + currentUser.getBalance()); break;
                case "2": deposit(); break;
                case "3": withdraw(); break;
                case "4": System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private void deposit() {
        System.out.print("Amount to deposit: ");
        double amount = scanner.nextDouble(); scanner.nextLine();
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        currentUser.deposit(amount);
        DatabaseManager.updateBalance(currentUser);
        System.out.println("Deposit successful.");
    }

    private void withdraw() {
        System.out.print("Amount to withdraw: ");
        double amount = scanner.nextDouble(); scanner.nextLine();
        if (amount <= 0 || amount > currentUser.getBalance()) {
            System.out.println("Invalid amount or insufficient funds.");
            return;
        }
        currentUser.withdraw(amount);
        DatabaseManager.updateBalance(currentUser);
        System.out.println("Withdrawal successful.");
    }
}
