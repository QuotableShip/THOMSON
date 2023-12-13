import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClassActivityRecorderGUI implements ActionListener {
    private JFrame frame;
    private JLabel nameLabel, activityLabel, participationLabel, taskLabel;
    private JTextField nameField, activityField, participationField;
    private JButton recordButton, addButton, removeButton;
    private JComboBox<String> taskComboBox;
    private JTable activityTable;
    private DefaultTableModel activityTableModel;
    private JScrollPane activityScrollPane;

    private ArrayList<String[]> activityList = new ArrayList<>();

    // creating a JPanel class
    private JPanel panel = new JPanel();

    // Constructor for ClassActivityRecorder class
    public ClassActivityRecorderGUI() {
        // Set layout to null
        panel.setLayout(null);

        // Set the title for the JFrame
        frame = new JFrame("Class Activity Recorder");

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
        String[] tasks = {"", "Attendance Tracking", "Grade Management", "Class Activity Records"};
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

        // Activity label constructor
        activityLabel = new JLabel("Activity:");
        activityLabel.setBounds(10, 80, 100, 20);
        panel.add(activityLabel);

        // Activity TextField constructor
        activityField = new JTextField();
        activityField.setBounds(120, 80, 200, 20);
        panel.add(activityField);

        // Participation label constructor
        participationLabel = new JLabel("Participation:");
        participationLabel.setBounds(10, 110, 100, 20);
        panel.add(participationLabel);

        // Participation TextField constructor
        participationField = new JTextField();
        participationField.setBounds(120, 110, 200, 20);
        panel.add(participationField);

        // Record Button constructor
        recordButton = new JButton("Record Activity");
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
        String[] activityColumnNames = {"Student Name", "Activity", "Participation"};
        activityTableModel = new DefaultTableModel(activityColumnNames, 0);

        // Activity Table
        activityTable = new JTable(activityTableModel);
        activityScrollPane = new JScrollPane(activityTable);
        activityScrollPane.setBounds(10, 200, 350, 200);
        panel.add(activityScrollPane);

        // Initially hide the table
        activityScrollPane.setVisible(false);
    }

    // Implementing an action event listener class with a conditional statement
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == taskComboBox) {
            switchTask();
        } else if (e.getSource() == recordButton) {
            recordActivity();
        } else if (e.getSource() == addButton) {
            addEntry();
        } else if (e.getSource() == removeButton) {
            removeEntry();
        }
    }

    private void switchTask() {
        // Hide the table initially
        activityScrollPane.setVisible(false);

        // Clear all fields and table when switching tasks
        nameField.setText("");
        activityField.setText("");
        participationField.setText("");
        activityTableModel.setRowCount(0);
        activityList.clear();

        // Update table based on the selected task
        String selectedTask = (String) taskComboBox.getSelectedItem();
        if (selectedTask.equals("Class Activity Records")) {
            activityScrollPane.setVisible(true);
            for (String[] activityEntry : activityList) {
                activityTableModel.addRow(activityEntry);
            }
        }
    }

    private void recordActivity() {
        String name = nameField.getText();
        String activity = activityField.getText();
        String participation = participationField.getText();

        // Validate input fields
        if (name.isEmpty() || activity.isEmpty() || participation.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
            return;
        }

        // Add activity to the list and table
        String[] activityEntry = {name, activity, participation};
        activityList.add(activityEntry);
        activityTableModel.addRow(activityEntry);

        // Clear input fields
        nameField.setText("");
        activityField.setText("");
        participationField.setText("");
    }

    private void addEntry() {
        // Add your logic for additional functionality here
    }

    private void removeEntry() {
        int selectedRow = activityTable.getSelectedRow();
        if (selectedRow != -1) {
            activityTableModel.removeRow(selectedRow);
            activityList.remove(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to remove");
        }
    }

    public static void main(String[] args) {
        // Create an instance of ClassActivityRecorder
        ClassActivityRecorderGUI activityRecorder = new ClassActivityRecorderGUI();
        // Set the visibility of the JFrame to true
        activityRecorder.frame.setVisible(true);
    }
}
