
package MilestoneCalculator;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class milestoneCalculator {
    public static void main(String[] args) {
                FlatLightLaf.setup();
                
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Milestone Calculator");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setUndecorated(true);
                frame.setLocationRelativeTo(null); // Center the frame on the screen
                
                // Add rounded corners to the frame
                frame.setShape(new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 20, 20));

                JPanel contentPane = new JPanel(new BorderLayout());
                
                contentPane.setBackground(new Color(44, 62, 80)); // Dark blue background
                frame.setContentPane(contentPane);

                JLabel titleLabel = new JLabel("Milestone Calculator");
                titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
                titleLabel.setForeground(Color.WHITE); // White text color
                titleLabel.setFont(new Font("Consolas", Font.BOLD, 24)); // Larger, bold font
                titleLabel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
                contentPane.add(titleLabel, BorderLayout.NORTH);

                JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // Grid layout with gaps
                inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding
                inputPanel.setBackground( Color.WHITE); 
                JTextField milestone1Field = createTextField("Milestone 1 (25%)");
                inputPanel.add(milestone1Field);

                JTextField milestone2Field = createTextField("Milestone 2 (40%)");
                inputPanel.add(milestone2Field);

                JTextField terminalAssessmentField = createTextField("Terminal Assessment (35%)");
                inputPanel.add(terminalAssessmentField);

                contentPane.add(inputPanel, BorderLayout.CENTER);

                JButton calculateButton = new JButton("Calculate");
                calculateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Calculate the total grade
                        double milestone1 = parseDouble(milestone1Field.getText());
                        double milestone2 = parseDouble(milestone2Field.getText());
                        double terminalAssessment = parseDouble(terminalAssessmentField.getText());

                        // Display the result in a pop-up message
                        double totalGrade = (milestone1 * 0.25) + (milestone2 * 0.40) + (terminalAssessment * 0.35);
                        JOptionPane.showMessageDialog(frame, "Final Grade: " + String.format("%.2f", totalGrade), "Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
                calculateButton.setBackground(new Color(52, 152, 219)); // Blue button color
                calculateButton.setForeground(Color.WHITE); // White text color
                calculateButton.setFont(new Font("Consolas", Font.BOLD, 16)); // Larger, bold font
                calculateButton.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
                contentPane.add(calculateButton, BorderLayout.SOUTH);

                frame.setVisible(true);
            }
        });
    }

    private static JTextField createTextField(String title) {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createTitledBorder(title));
        textField.setFont(new Font("Consolas", Font.PLAIN, 14)); // Regular font
        return textField;
    }

    private static double parseDouble(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return 0; // Default value if parsing fails
        }
    }
}
