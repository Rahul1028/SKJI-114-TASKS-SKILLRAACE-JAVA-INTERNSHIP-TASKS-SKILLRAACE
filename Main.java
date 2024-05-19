import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
    private static JTextField amountField;
    private static JLabel resultLabel;

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Smallest Number of Notes Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Create panel for input components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        // Create input label and text field
        JLabel amountLabel = new JLabel("Enter the change amount: ");
        amountField = new JTextField(10);
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);

        // Create calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        inputPanel.add(calculateButton);

        // Create panel for result
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());

        // Create result label
        resultLabel = new JLabel();

        resultPanel.add(resultLabel);

        // Add input and result panels to main frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(resultPanel, BorderLayout.CENTER);

        // Set frame visible
        frame.setVisible(true);
    }

    public static void calculate() {
        try {
            int N = Integer.parseInt(amountField.getText());
            int notesCount = smallestNotes(N);
            resultLabel.setText("The smallest number of notes required is: " + notesCount);
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid integer amount.");
        }
    }

    public static int smallestNotes(int N) {
        int[] denominations = { 100, 50, 10, 5, 2, 1 };
        int notesCount = 0;

        for (int denomination : denominations) {
            notesCount += N / denomination;
            N %= denomination;
        }

        return notesCount;
    }
}
