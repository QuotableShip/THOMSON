import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AttendanceTrackerGUI implements ActionListener {
    private JFrame frame;
    private JLabel nameLabel, dateLabel, timeLabel, taskLabel;
    private JTextField nameField, dateField, timeField;
    private JButton recordButton, addButton, removeButton, calculatePercentageButton;
    private JComboBox<String> taskComboBox;
    private JTable attendanceTable;
    private DefaultTableModel attendanceTableModel;
    private JScrollPane attendanceScrollPane;

    private ArrayList<String[]> attendanceList = new ArrayList<>();

    // creating a JPanel class
    private JPanel panel = new JPanel();

    // Constructor for AttendanceTracker class
    public AttendanceTrackerGUI() {
        // Set layout to null
        panel.setLayout(null);

        // Set the title for the JFrame
        frame = new JFrame("Attendance Tracker");

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

        // Date label constructor
        dateLabel = new JLabel("Date:");
        dateLabel.setBounds(10, 80, 100, 20);
        panel.add(dateLabel);

        // Date TextField constructor
        dateField = new JTextField();
        dateField.setBounds(120, 80, 200, 20);
        panel.add(dateField);

        // Time label constructor
        timeLabel = new JLabel("Time:");
        timeLabel.setBounds(10, 110, 100, 20);
        panel.add(timeLabel);

        // Time TextField constructor
        timeField = new JTextField();
        timeField.setBounds(120, 110, 200, 20);
        panel.add(timeField);

        // Record Button constructor
        recordButton = new JButton("Record");
        recordButton.setBounds(350, 50, 100, 25);
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

        // Calculate Percentage Button constructor
        calculatePercentageButton = new JButton("Calculate Attendance Percentage");
        calculatePercentageButton.setBounds(10, 150, 250, 25);
        calculatePercentageButton.addActionListener(this);
        panel.add(calculatePercentageButton);

        // Table Model
        String[] attendanceColumnNames = {"Student Name", "Date", "Time"};
        attendanceTableModel = new DefaultTableModel(attendanceColumnNames, 0);

        // Attendance Table
        attendanceTable = new JTable(attendanceTableModel);
        attendanceScrollPane = new JScrollPane(attendanceTable);
        attendanceScrollPane.setBounds(10, 200, 350, 200);
        panel.add(attendanceScrollPane);

        // Initially hide the table
        attendanceScrollPane.setVisible(false);
    }

    // Implementing an action event listener class with a conditional statement
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == taskComboBox) {
            switchTask();
        } else if (e.getSource() == recordButton) {
            recordEntry();
        } else if (e.getSource() == addButton) {
            addEntry();
        } else if (e.getSource() == removeButton) {
            removeEntry();
        } else if (e.getSource() == calculatePercentageButton) {
            calculateAttendancePercentage();
        }
    }

    private void switchTask() {
        // Hide the table initially
        attendanceScrollPane.setVisible(false);

        // Clear all fields and table when switching tasks
        nameField.setText("");
        dateField.setText("");
        timeField.setText("");
        attendanceTableModel.setRowCount(0);
        attendanceList.clear();

        // Update table based on the selected task
        String selectedTask = (String) taskComboBox.getSelectedItem();
        if (selectedTask.equals("Attendance Tracking")) {
            attendanceScrollPane.setVisible(true);
            for (String[] attendanceEntry : attendanceList) {
                attendanceTableModel.addRow(attendanceEntry);
            }
        }
    }

    private void recordEntry() {
        String name = nameField.getText();
        String date = dateField.getText();
        String time = timeField.getText();

        // Validate input fields
        if (name.isEmpty() || date.isEmpty() || time.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
            return;
        }

        // Add entry to the list and table based on the selected task
        String selectedTask = (String) taskComboBox.getSelectedItem();
        if (selectedTask.equals("Attendance Tracking")) {
            String[] attendanceEntry = {name, date, time};
            attendanceList.add(attendanceEntry);
            attendanceTableModel.addRow(attendanceEntry);
        }

        // Clear input fields
        nameField.setText("");
        dateField.setText("");
        timeField.setText("");
    }

    private void addEntry() {
        // Add your logic for additional functionality here
    }

    private void removeEntry() {
        int selectedRow = attendanceTable.getSelectedRow();
        if (selectedRow != -1) {
            attendanceTableModel.removeRow(selectedRow);
            attendanceList.remove(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to remove");
        }
    }

    private void calculateAttendancePercentage() {
        int totalEntries = attendanceTableModel.getRowCount();
        if (totalEntries == 0) {
            JOptionPane.showMessageDialog(null, "No attendance records to calculate percentage");
            return;
        }

        double presentEntries = 0;
        for (int i = 0; i < totalEntries; i++) {
            String time = (String) attendanceTableModel.getValueAt(i, 2);
            if (!time.isEmpty()) {
                presentEntries++;
            }
        }

        double attendancePercentage = (presentEntries / totalEntries) * 100;
        JOptionPane.showMessageDialog(null, "Attendance Percentage: " + attendancePercentage + "%");
    }

    public static void main(String[] args) {
        // Create an instance of AttendanceTracker
        AttendanceTrackerGUI attendanceTracker = new AttendanceTrackerGUI();
        // Set the visibility of the JFrame to true
        attendanceTracker.frame.setVisible(true);
    }
}
