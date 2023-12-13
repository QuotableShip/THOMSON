import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main implements ActionListener {
    private JFrame mainFrame;
    private JTabbedPane tabbedPane;

    // AttendanceTracker components
    private JFrame attendanceFrame;
    private JLabel attendanceNameLabel, attendanceDateLabel, attendanceTimeLabel, attendanceTaskLabel;
    private JTextField attendanceNameField, attendanceDateField, attendanceTimeField;
    private JButton attendanceRecordButton, attendanceAddButton, attendanceRemoveButton, attendanceCalculatePercentageButton;
    private JComboBox<String> attendanceTaskComboBox;
    private JTable attendanceTable;
    private DefaultTableModel attendanceTableModel;
    private JScrollPane attendanceScrollPane;
    private ArrayList<String[]> attendanceList = new ArrayList<>();
    private JPanel attendancePanel = new JPanel();

    // GradeManager components
    private JFrame gradeFrame;
    private JLabel gradeNameLabel, gradeLabel, gradeSubjectLabel, gradeTaskLabel;
    private JTextField gradeNameField, gradeGradeField, gradeSubjectField;
    private JButton gradeRecordButton, gradeAddButton, gradeRemoveButton;
    private JComboBox<String> gradeTaskComboBox;
    private JTable gradeTable;
    private DefaultTableModel gradeTableModel;
    private JScrollPane gradeScrollPane;
    private ArrayList<String[]> gradeList = new ArrayList<>();
    private JPanel gradePanel = new JPanel();

    // ClassActivityRecorder components
    private JFrame activityFrame;
    private JLabel activityNameLabel, activityActivityLabel, activityParticipationLabel, activityTaskLabel;
    private JTextField activityNameField, activityActivityField, activityParticipationField;
    private JButton activityRecordButton, activityAddButton, activityRemoveButton;
    private JComboBox<String> activityTaskComboBox;
    private JTable activityTable;
    private DefaultTableModel activityTableModel;
    private JScrollPane activityScrollPane;
    private ArrayList<String[]> activityList = new ArrayList<>();
    private JPanel activityPanel = new JPanel();

    public Main() {
        initializeAttendanceComponents();
        initializeGradeComponents();
        initializeActivityComponents();

        // Main frame
        mainFrame = new JFrame("School Management System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Attendance Tracker", attendancePanel);
        tabbedPane.addTab("Grade Manager", gradePanel);
        tabbedPane.addTab("Class Activity Recorder", activityPanel);

        mainFrame.getContentPane().add(tabbedPane);
        mainFrame.setSize(800, 600);
        mainFrame.setVisible(true);
    }

    private void initializeAttendanceComponents() {
        // AttendanceTracker initialization...
        attendancePanel.setLayout(null);

        attendanceNameLabel = new JLabel("Student Name:");
        attendanceNameLabel.setBounds(10, 20, 100, 20);
        attendancePanel.add(attendanceNameLabel);

        // Add other attendance components...

        attendanceRecordButton = new JButton("Record Attendance");
        attendanceRecordButton.setBounds(10, 150, 150, 25);
        attendanceRecordButton.addActionListener(this);
        attendancePanel.add(attendanceRecordButton);

        attendanceScrollPane = new JScrollPane();
        attendanceScrollPane.setBounds(10, 200, 500, 200);
        attendancePanel.add(attendanceScrollPane);

        String[] attendanceColumnNames = {"Student Name", "Date", "Time"};
        attendanceTableModel = new DefaultTableModel(attendanceColumnNames, 0);
        attendanceTable = new JTable(attendanceTableModel);
        attendanceScrollPane.setViewportView(attendanceTable);
    }

    private void initializeGradeComponents() {
        // GradeManager initialization...
        gradePanel.setLayout(null);

        gradeNameLabel = new JLabel("Student Name:");
        gradeNameLabel.setBounds(10, 20, 100, 20);
        gradePanel.add(gradeNameLabel);

        // Add other grade components...

        gradeRecordButton = new JButton("Record Grade");
        gradeRecordButton.setBounds(10, 150, 150, 25);
        gradeRecordButton.addActionListener(this);
        gradePanel.add(gradeRecordButton);

        gradeScrollPane = new JScrollPane();
        gradeScrollPane.setBounds(10, 200, 500, 200);
        gradePanel.add(gradeScrollPane);

        String[] gradeColumnNames = {"Student Name", "Grade", "Subject"};
        gradeTableModel = new DefaultTableModel(gradeColumnNames, 0);
        gradeTable = new JTable(gradeTableModel);
        gradeScrollPane.setViewportView(gradeTable);
    }

    private void initializeActivityComponents() {
        // ClassActivityRecorder initialization...
        activityPanel.setLayout(null);

        activityNameLabel = new JLabel("Student Name:");
        activityNameLabel.setBounds(10, 20, 100, 20);
        activityPanel.add(activityNameLabel);

        // Add other activity components...

        activityRecordButton = new JButton("Record Activity");
        activityRecordButton.setBounds(10, 150, 150, 25);
        activityRecordButton.addActionListener(this);
        activityPanel.add(activityRecordButton);

        activityScrollPane = new JScrollPane();
        activityScrollPane.setBounds(10, 200, 500, 200);
        activityPanel.add(activityScrollPane);

        String[] activityColumnNames = {"Student Name", "Activity", "Participation"};
        activityTableModel = new DefaultTableModel(activityColumnNames, 0);
        activityTable = new JTable(activityTableModel);
        activityScrollPane.setViewportView(activityTable);
    }

    public void actionPerformed(ActionEvent e) {
        // Action event handling...
        if (e.getSource() == attendanceRecordButton) {
            recordAttendance();
        } else if (e.getSource() == gradeRecordButton) {
            recordGrade();
        } else if (e.getSource() == activityRecordButton) {
            recordActivity();
        }
    }

    private void recordAttendance() {
        // Record attendance logic...
        // Retrieve data from text fields and add to the attendance table.
    }

    private void recordGrade() {
        // Record grade logic...
        // Retrieve data from text fields and add to the grade table.
    }

    private void recordActivity() {
        // Record activity logic...
        // Retrieve data from text fields and add to the activity table.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
