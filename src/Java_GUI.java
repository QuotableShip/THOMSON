import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Java_GUI implements ActionListener {
    private static JLabel password1, label;
    private static JTextField username;
    private static JButton button;
    private static JPasswordField Password;

    // creating a JPanel class (Moved inside the constructor)
    JPanel panel = new JPanel();

    // JFrame class (Moved inside the constructor)
    JFrame frame = new JFrame();

    // Constructor for Java_GUI class
    public Java_GUI() {
        // Set layout to null
        panel.setLayout(null);

        // Set the title for the JFrame
        frame.setTitle("Login Page");

        // Set the location of the JFrame
        frame.setLocation(new Point(500, 300));

        // Add the panel to the frame
        frame.add(panel);

        // Set the size of the JFrame
        frame.setSize(new Dimension(400, 200));

        // Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Username label constructor
        label = new JLabel("Username");
        label.setBounds(100, 8, 70, 20);
        panel.add(label);

        // Username TextField constructor
        username = new JTextField();
        username.setBounds(100, 27, 193, 28);
        panel.add(username);

        // Password Label constructor
        password1 = new JLabel("Password");
        password1.setBounds(100, 55, 70, 20);
        panel.add(password1);

        // Password TextField
        Password = new JPasswordField();
        Password.setBounds(100, 75, 193, 28);
        panel.add(Password);

        // Button constructor
        button = new JButton("Submit");
        button.setBounds(100, 110, 90, 25);
        button.addActionListener(this); // Changed to "this" to refer to the current instance
        panel.add(button);
    }

    // Implementing an action event listener class with a conditional statement
    @Override
    public void actionPerformed(ActionEvent e) {
        String Username = username.getText();
        // Use getPassword() to get the password from JPasswordField
        String Password1 = new String(Password.getPassword());

        if (Username.equals("Thompson") && Password1.equals("Thompson123"))
            JOptionPane.showMessageDialog(null, "Login Successful");
        else
            JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
    }

    public static void main(String[] args) {
        // Create an instance of Java_GUI
        Java_GUI gui = new Java_GUI();
        // Set the visibility of the JFrame to true
        gui.frame.setVisible(true);
    }
}
