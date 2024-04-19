import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Team Project
 *
 * Client.java
 *
 * @author Gabe Turner, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class NewClient extends JComponent implements Runnable {
    public NewClient() throws IOException {

    }

    //Connect to the server
    Socket socket = new Socket("localhost", 5050);
    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter writer = new PrintWriter(socket.getOutputStream());

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new NewClient());
    }

    //JFrame and JButton for main menu
    JFrame mainMenuFrame;
    JButton createAccountButton;
    JButton loginButton;
    JButton exitAppButton;

    //JFrame and JButton for create account
    JFrame createAccountFrame;
    JLabel usernameLabel;
    JTextField usernameText;
    JLabel passwordLabel;
    JTextField passwordText;
    JLabel ageLabel;
    JTextField ageText;
    JLabel genderLabel;
    JComboBox<String> genderType;
    JLabel nationalityLabel;
    JTextField nationalityText;
    JLabel jobLabel;
    JTextField jobText;
    JLabel hobbyLabel;
    JTextField hobbyText;

    JButton enterButton;

    JButton returnButton; //return to the main menu

    //JFrame and JButton for Log in
    JFrame loginFrame;

    //JFrame and JButton after log in successfully

    //JFrame and JButton in the frame of actions (Add, delete, block, remove, search?)

    //JFrame and JButton for the message frame


    //All of the frames in run()
    public void run() {
        //First frame is the main menu after the client connect to the server
        {
            mainMenuFrame = new JFrame("Main Menu");
            Container content = mainMenuFrame.getContentPane();
            content.setLayout(null);
            mainMenuFrame.setSize(600, 400);
            mainMenuFrame.setLocationRelativeTo(null);
            mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainMenuFrame.setVisible(true);

            loginButton = new JButton("Login");
            loginButton.setBounds(210, 50, 160, 70);
            createAccountButton = new JButton("Create account");
            createAccountButton.setBounds(210, 140, 160,70);
            exitAppButton = new JButton("Exit the app");
            exitAppButton.setBounds(210,230,160,70);

            createAccountButton.addActionListener(actionListener);
            loginButton.addActionListener(actionListener);
            exitAppButton.addActionListener(actionListener);

            content.add(loginButton);
            content.add(createAccountButton);
            content.add(exitAppButton);

        }
        //Frame for create account
        {
            createAccountFrame = new JFrame("Create Account");
            Container content = createAccountFrame.getContentPane();
            content.setLayout(null);
            createAccountFrame.setSize(600, 400);
            createAccountFrame.setLocationRelativeTo(null);
            createAccountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Only set visible = true after client click the create account button
            createAccountFrame.setVisible(false);

            usernameText = new JTextField(10);
            usernameText.setBounds(300, 33, 120, 25);
            usernameLabel = new JLabel("Username");
            usernameLabel.setBounds(180, 33, 120, 25);

            passwordText = new JTextField(10);
            passwordText.setBounds(300, 66, 120, 25);
            passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(180, 66, 120, 25);

            ageText = new JTextField(10);
            ageText.setBounds(300, 99, 120, 25);
            ageLabel = new JLabel("Age");
            ageLabel.setBounds(180, 99, 120, 25);

            genderType = new JComboBox<>();
            genderType.addItem("Male");
            genderType.addItem("Female");
            genderType.addItem("Other");
            genderType.setBounds(300, 132, 120, 25);
            genderLabel = new JLabel("Gender");
            genderLabel.setBounds(180, 132, 120, 25);

            nationalityText = new JTextField(10);
            nationalityText.setBounds(300, 165, 120, 25);
            nationalityLabel = new JLabel("Nationality");
            nationalityLabel.setBounds(180, 165, 120, 25);

            jobText = new JTextField(10);
            jobText.setBounds(300, 198, 120, 25);
            jobLabel = new JLabel("Job");
            jobLabel.setBounds(180, 198, 120, 25);

            hobbyText = new JTextField(10);
            hobbyText.setBounds(300, 231, 120, 25);
            hobbyLabel = new JLabel("Hobby");
            hobbyLabel.setBounds(180, 231, 120, 25);

            enterButton = new JButton("Enter");
            enterButton.setBounds(240, 270, 140, 30);
            enterButton.addActionListener(actionListener);

            returnButton = new JButton("Return");
            returnButton.setBounds(240, 320, 140, 30);
            returnButton.addActionListener(actionListener);

            content.add(usernameText);
            content.add(usernameLabel);
            content.add(passwordText);
            content.add(passwordLabel);
            content.add(ageText);
            content.add(ageLabel);
            content.add(genderType);
            content.add(genderLabel);
            content.add(nationalityText);
            content.add(nationalityLabel);
            content.add(jobText);
            content.add(jobLabel);
            content.add(hobbyText);
            content.add(hobbyLabel);
            content.add(enterButton);
            content.add(returnButton);

        }
        //Frame for log in account
        {
            loginFrame = new JFrame("Log In");
            Container content = loginFrame.getContentPane();
            content.setLayout(null);
            loginFrame.setSize(600, 400);
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Only set visible = true after client click the log in button
            loginFrame.setVisible(false);
        }
        //Frame after log in successfully
        {

        }
        //Frame for specific actions
        {

        }
        //Frame for the messages
        {

        }
    }

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                //Buttons in main menu frame
                if (e.getSource() == createAccountButton) {
                    //Write 1 to server
                    writer.write("1");
                    writer.println();
                    writer.flush();
                    mainMenuFrame.setVisible(false);
                    createAccountFrame.setVisible(true);
                }
                if (e.getSource() == loginButton) {
                    //Write 2 to server
                    writer.write("2");
                    writer.println();
                    writer.flush();
                    mainMenuFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
                if (e.getSource() == exitAppButton) {
                    //close
                    mainMenuFrame.dispose();
                }
                //Buttons in create account frame
                if (e.getSource() == enterButton) {
                }
                if (e.getSource() == returnButton) {
                    createAccountFrame.setVisible(false);
                    mainMenuFrame.setVisible(true);
                }
                //Buttons in log in frame
                //Buttons after log in successfully
                //Buttons for specific action
                //Buttons for message
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };
}
