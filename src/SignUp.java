
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignUp extends JFrame{
	

	private static final long serialVersionUID = 1L;
	/**
	 *  Basically creating the text field for the user to registry their information
	 */
	
	//
    private JPanel informationdisplay; // creating content to display for information
    private JTextField firstname; 
    private JTextField lastname;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton;  // registry button to click on after filling the information

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	SignUp frame = new SignUp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public SignUp() {  // create constructor 
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg")); // this method that creates the window that everything is stored 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597); // x, y, width, height for size of our window 
        setResizable(false);
        informationdisplay = new JPanel();  // create panel 
        informationdisplay.setBorder(new EmptyBorder(7, 7, 7, 7));
        setContentPane(informationdisplay);
        informationdisplay.setLayout(null);
      
        /**
         * This creates the labels for the user to see where to input their names, email, etc
         */
        JLabel labeluser_register = new JLabel("Welcome to User's Register");  
        labeluser_register.setFont(new Font("Times New Roman", Font.BOLD, 25));
        labeluser_register.setBounds(362, 52, 325, 50);
        informationdisplay.add(labeluser_register);

        JLabel labelName = new JLabel("First name");
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelName.setBounds(58, 152, 99, 43);
        informationdisplay.add(labelName);

        JLabel lastName = new JLabel("Last name");
        lastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lastName.setBounds(58, 243, 110, 29);
        informationdisplay.add(lastName);

        JLabel EmailAddress = new JLabel("Email\r\n address");
        EmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
        EmailAddress.setBounds(58, 324, 124, 36);
        informationdisplay.add(EmailAddress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 151, 228, 50);
        informationdisplay.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(214, 235, 228, 50);
        informationdisplay.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 320, 228, 50);
        informationdisplay.add(email);
        email.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(707, 151, 228, 50);
        informationdisplay.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 159, 99, 29);
        informationdisplay.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 99, 24);
        informationdisplay.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 329, 139, 26);
        informationdisplay.add(lblMobileNumber);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mob.setBounds(707, 320, 228, 50);
        informationdisplay.add(mob);
        mob.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(707, 235, 228, 50);
        informationdisplay.add(passwordField);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String emailId = email.getText();
                String userName = username.getText();
                String mobileNumber = mob.getText();
                int len = mobileNumber.length();
                String password = passwordField.getText();

                String msg = "" + firstName;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");

                    String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userName + "','" +
                        password + "','" + emailId + "','" + mobileNumber + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        informationdisplay.add(btnNewButton);
    }
}