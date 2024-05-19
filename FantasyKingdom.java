import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FantasyKingdom {
    private JFrame frame;
    private JTextField ageInputField;
    private JLabel resultLabel;
    private JLabel counterLabel;
    private int counter;

    public FantasyKingdom() {
        frame = new JFrame("Fantasy Kingdom Ticketing System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JLabel ageLabel = new JLabel("Enter the age of the person:");
        frame.add(ageLabel);

        ageInputField = new JTextField(10);
        frame.add(ageInputField);

        JButton checkButton = new JButton("Check Eligibility");
        checkButton.addActionListener(new CheckButtonListener());
        frame.add(checkButton);

        resultLabel = new JLabel("");
        frame.add(resultLabel);

        counterLabel = new JLabel("Counter: 0");
        frame.add(counterLabel);

        JButton increaseCounterButton = new JButton("Increase Counter");
        increaseCounterButton.addActionListener(new IncreaseCounterListener());
        frame.add(increaseCounterButton);

        JButton resetCounterButton = new JButton("Reset Counter");
        resetCounterButton.addActionListener(new ResetCounterListener());
        frame.add(resetCounterButton);
    }

    public void show() {
        frame.setVisible(true);
    }

    private class CheckButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int age = Integer.parseInt(ageInputField.getText());
                if (age < 15 || age > 60) {
                    resultLabel.setText("Not Allowed");
                } else {
                    resultLabel.setText("Allowed");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid age.");
            }
        }
    }

    private class IncreaseCounterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            counter++;
            counterLabel.setText("Counter: " + counter);
        }
    }

    private class ResetCounterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            counter = 0;
            counterLabel.setText("Counter: " + counter);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FantasyKingdom().show();
            }
        });
    }
}
