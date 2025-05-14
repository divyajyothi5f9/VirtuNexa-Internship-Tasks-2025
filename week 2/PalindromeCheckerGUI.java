import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PalindromeCheckerGUI {
    private JFrame frame;
    private JTextField inputField;
    private JTextArea resultArea;
    private JButton checkButton;

    public PalindromeCheckerGUI() {
        frame = new JFrame("Palindrome Checker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel inputLabel = new JLabel("Enter a word, phrase, or number:");
        inputLabel.setBounds(20, 20, 200, 30);
        frame.add(inputLabel);
        
        inputField = new JTextField();
        inputField.setBounds(20, 50, 340, 30);
        frame.add(inputField);

        checkButton = new JButton("Check");
        checkButton.setBounds(20, 90, 100, 30);
        frame.add(checkButton);

        resultArea = new JTextArea();
        resultArea.setBounds(20, 130, 340, 100);
        resultArea.setEditable(false);
        frame.add(resultArea);

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                PalindromeChecker checker = new PalindromeChecker();
                boolean isPalindrome = checker.isPalindrome(input);
                if (isPalindrome) {
                    resultArea.setText("The input is a palindrome.");
                } else {
                    resultArea.setText("The input is NOT a palindrome.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PalindromeCheckerGUI();
    }
}