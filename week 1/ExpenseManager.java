
import java.util.Scanner;

public class ExpenseManager {
    private DBHelper dbHelper;
    private Scanner scanner;

    public ExpenseManager() {
        dbHelper = new DBHelper();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\n--- Expense Manager ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> dbHelper.viewExpenses();
                case 3 -> deleteExpense();
                case 4 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addExpense() {
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        dbHelper.insertExpense(amount, category);
    }

    private void deleteExpense() {
        System.out.print("Enter ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        dbHelper.deleteExpense(id);
    }
}
