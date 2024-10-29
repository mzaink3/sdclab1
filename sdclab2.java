//M. Zain Khan
//2022F-BSE-003/A

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sdclab2 extends JFrame {
    private JTextField nameField, totalMarksField, obtainedMarksField;
    private JTextArea resultArea;
    
    public sdclab2() {
        JLabel nameLabel = new JLabel("Student Name:");
        nameField = new JTextField(20);
        
        JLabel totalMarksLabel = new JLabel("Total Marks:");
        totalMarksField = new JTextField(10);
        
        JLabel obtainedMarksLabel = new JLabel("Obtained Marks:");
        obtainedMarksField = new JTextField(10);
        
        JButton calculateButton = new JButton("Calculate");
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResults();
            }
        });

        JPanel panel = new JPanel();
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(totalMarksLabel);
        panel.add(totalMarksField);
        panel.add(obtainedMarksLabel);
        panel.add(obtainedMarksField);
        panel.add(calculateButton);
        panel.add(new JScrollPane(resultArea));
        
        add(panel);
        setTitle("Mark Sheet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
    
    private void calculateResults() {
        try {
            String studentName = nameField.getText();
            int totalMarks = Integer.parseInt(totalMarksField.getText());
            int obtainedMarks = Integer.parseInt(obtainedMarksField.getText());
            
            if (totalMarks <= 0) {
                JOptionPane.showMessageDialog(this, "Total marks must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            double percentage = (double) obtainedMarks / totalMarks * 100;
            String grade = calculateGrade(percentage);
            double gpa = calculateGPA(percentage);
            
            String result = String.format("Student Name: %s\nPercentage: %.2f%%\nGrade: %s\nGPA: %.2f", 
                                           studentName, percentage, grade, gpa);
            resultArea.setText(result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for total and obtained marks.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private String calculateGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B+";
        else if (percentage >= 60) return "B";
        else if (percentage >= 50) return "C";
        else return "F";
    }
    
    private double calculateGPA(double percentage) {
        if (percentage >= 90) return 4.0;
        else if (percentage >= 80) return 3.7;
        else if (percentage >= 70) return 3.3;
        else if (percentage >= 60) return 3.0;
        else if (percentage >= 50) return 2.0;
        else return 0.0;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            sdclab2 markSheet = new sdclab2();
            markSheet.setVisible(true);
        });
    }
}
