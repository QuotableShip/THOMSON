import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GradeManagementGUI implements ActionListener {
    private JFrame frame;
    private JLabel nameLabel, gradeLabel, subjectLabel, taskLabel;
    private JTextField nameField, gradeField, subjectField;
    private JButton recordButton, addButton, removeButton;
    private JComboBox<String> taskComboBox;
    private JTable gradeTable;
    private DefaultTableModel gradeTableModel;
    private JScrollPane gradeScrollPane;

    private ArrayList<String[]> gradeList = new ArrayList<>();

    // creating a JPanel class
    private JPanel panel = new JPanel();

    // Constructor for GradeManager class
    public GradeManagementGUI() {
        // Set layout to null
        panel.setLayout(null);

        // Set the title for the JFrame
        frame = new JFrame("Grade Manager");

        // Add the panel to the frame
        frame.add(panel);

        // Set the size of the JFrame
        frame.setSize(new Dimension(800, 600));

        // Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Task label constructor
        taskLabel = new JLabel("Select Task:");
        taskLabel.setBounds(10, 20, 100, 20);
        panel.add(taskLabel);

        // Task ComboBox constructor
        String[] tasks = {"", "Attendance Tracking", "Grade Management"};
        taskComboBox = new JComboBox<>(tasks);
        taskComboBox.setBounds(120, 20, 200, 20);
        taskComboBox.addActionListener(this);
        panel.add(taskComboBox);

        // Student Name label constructor
        nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(10, 50, 100, 20);
        panel.add(nameLabel);

        // Student Name TextField constructor
        nameField = new JTextField();
        nameField.setBounds(120, 50, 200, 20);
        panel.add(nameField);

        // Grade label constructor
        gradeLabel = new JLabel("Grade:");
        gradeLabel.setBounds(10, 80, 100, 20);
        panel.add(gradeLabel);

        // Grade TextField constructor
        gradeField = new JTextField();
        gradeField.setBounds(120, 80, 200, 20);
        panel.add(gradeField);

        // Subject label constructor
        subjectLabel = new JLabel("Subject:");
        subjectLabel.setBounds(10, 110, 100, 20);
        panel.add(subjectLabel);

        // Subject TextField constructor
        subjectField = new JTextField();
        subjectField.setBounds(120, 110, 200, 20);
        panel.add(subjectField);

        // Record Button constructor
        recordButton = new JButton("Record Grade");
        recordButton.setBounds(350, 50, 150, 25);
        recordButton.addActionListener(this);
        panel.add(recordButton);

        // Add Button constructor
        addButton = new JButton("Add");
        addButton.setBounds(350, 80, 100, 25);
        addButton.addActionListener(this);
        panel.add(addButton);

        // Remove Button constructor
        removeButton = new JButton("Remove");
        removeButton.setBounds(350, 110, 100, 25);
        removeButton.addActionListener(this);
        panel.add(removeButton);

        // Table Model
        String[] gradeColumnNames = {"Student Name", "Grade", "Subject"};
        gradeTableModel = new DefaultTableModel(gradeColumnNames, 0);

        // Grade Table
        gradeTable = new JTable(gradeTableModel);
        gradeScrollPane = new JScrollPane(gradeTable);
        gradeScrollPane.setBounds(10, 200, 350, 200);
        panel.add(gradeScrollPane);

        // Initially hide the table
        gradeScrollPane.setVisible(false);
    }

    // Implementing an action event listener class with a conditional statement
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == taskComboBox) {
            switchTask();
        } else if (e.getSource() == recordButton) {
            recordGrade();
        } else if (e.getSource() == addButton) {
            addEntry();
        } else if (e.getSource() == removeButton) {
            removeEntry();
        }
    }

    private void switchTask() {
        // Hide the table initially
        gradeScrollPane.setVisible(false);

        // Clear all fields and table when switching tasks
        nameField.setText("");
        gradeField.setText("");
        subjectField.setText("");
        gradeTableModel.setRowCount(0);
        gradeList.clear();

        // Update table based on the selected task
        String selectedTask = (String) taskComboBox.getSelectedItem();
        if (selectedTask.equals("Grade Management")) {
            gradeScrollPane.setVisible(true);
            for (String[] gradeEntry : gradeList) {
                gradeTableModel.addRow(gradeEntry);
            }
        }
    }

    private void recordGrade() {
        String name = nameField.getText();
        String grade = gradeField.getText();
        String subject = subjectField.getText();

        // Validate input fields
        if (name.isEmpty() || grade.isEmpty() || subject.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
            return;
        }

        // Add grade to the list and table
        String[] gradeEntry = {name, grade, subject};
        gradeList.add(gradeEntry);
        gradeTableModel.addRow(gradeEntry);

        // Clear input fields
        nameField.setText("");
        gradeField.setText("");
        subjectField.setText("");
    }

    private void addEntry() {
        // Add your logic for additional functionality here
    }

    private void removeEntry() {
        int selectedRow = gradeTable.getSelectedRow();
        if (selectedRow != -1) {
            gradeTableModel.removeRow(selectedRow);
            gradeList.remove(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to remove");
        }
    }

    public static void main(String[] args) {
        // Create an instance of GradeManager
        GradeManagementGUI gradeManager = new GradeManagementGUI();
        // Set the visibility of the JFrame to true
        gradeManager.frame.setVisible(true);
    }
}
