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
public class Client extends JComponent implements Runnable {
    public Client() throws IOException {

    }

    //Connect to the server
    Socket socket = new Socket("localhost", 5050);
    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter writer = new PrintWriter(socket.getOutputStream());

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Client());
    }

    //JFrame and JButton for main menu
    JFrame mainMenuFrame;
    JButton createAccountButton;
    JButton loginButton;
    JButton exitAppButton;

    //JFrame and JButton for create account
    JFrame createAccountFrame;
    JLabel usernameLabel1;
    JTextField usernameText1;
    JLabel passwordLabel1;
    JTextField passwordText1;
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

    JButton enterButton1;

    //JButton returnButton; //return to the main menu

    //JFrame and JButton for Log in
    JFrame loginFrame;
    JLabel usernameLabel2;
    JTextField usernameText2;
    JLabel passwordLabel2;
    JTextField passwordText2;
    JButton enterButton2;

    //JFrame and JButton after log in successfully

    //JFrame and JButton in the frame of actions (Add, delete, block, remove, search?)

    JFrame actionFrame;
    JButton addFriendButton;
    JButton deleteFriendButton;
    JButton blockUserButton;
    JButton unblockUserButton;

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

            usernameText1 = new JTextField(10);
            usernameText1.setBounds(300, 33, 120, 25);
            usernameLabel1 = new JLabel("Username");
            usernameLabel1.setBounds(180, 33, 120, 25);

            passwordText1 = new JTextField(10);
            passwordText1.setBounds(300, 66, 120, 25);
            passwordLabel1 = new JLabel("Password");
            passwordLabel1.setBounds(180, 66, 120, 25);

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

            enterButton1 = new JButton("Enter");
            enterButton1.setBounds(230, 270, 140, 30);
            enterButton1.addActionListener(actionListener);

            //returnButton = new JButton("Return");
            //returnButton.setBounds(240, 320, 140, 30);
            //returnButton.addActionListener(actionListener);

            content.add(usernameText1);
            content.add(usernameLabel1);
            content.add(passwordText1);
            content.add(passwordLabel1);
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
            content.add(enterButton1);
            //content.add(returnButton);

        }
        //Frame for log in account
        {
            loginFrame = new JFrame("Log In");
            Container content = loginFrame.getContentPane();
            content.setLayout(null);
            loginFrame.setSize(500, 300);
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Only set visible = true after client click the log in button
            loginFrame.setVisible(false);
            usernameText2 = new JTextField(10);
            usernameText2.setBounds(230, 50, 120, 25);
            usernameLabel2 = new JLabel("Username");
            usernameLabel2.setBounds(130, 50, 120, 25);

            passwordText2 = new JTextField(10);
            passwordText2.setBounds(230, 100, 120, 25);
            passwordLabel2 = new JLabel("Password");
            passwordLabel2.setBounds(130, 100, 120, 25);

            enterButton2 = new JButton("Enter");
            enterButton2.setBounds(180, 200, 140, 30);
            enterButton2.addActionListener(actionListener);

            content.add(usernameText2);
            content.add(usernameLabel2);
            content.add(passwordText2);
            content.add(passwordLabel2);
            content.add(enterButton2);

        }
        //Frame after log in successfully
        {
            //loginFrame = new JFrame("Log In");
        }
        //Frame for specific actions
        {
            actionFrame = new JFrame("Action");
            Container content = actionFrame.getContentPane();
            content.setLayout(null);
            actionFrame.setSize(600, 400);
            actionFrame.setLocationRelativeTo(null);
            actionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Only set visible = true after client click the action button
            actionFrame.setVisible(false);

            addFriendButton.addActionListener(actionListener);
            deleteFriendButton.addActionListener(actionListener);
            blockUserButton.addActionListener(actionListener);
            unblockUserButton.addActionListener(actionListener);

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
                    //Write Create account to server
                    writer.write("Create account");
                    writer.println();
                    writer.flush();
                    mainMenuFrame.setVisible(false);
                    createAccountFrame.setVisible(true);
                }
                if (e.getSource() == loginButton) {
                    //Write 2 to server
                    writer.write("Log in");
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
                if (e.getSource() == enterButton1) {
                    writer.println(usernameText1.getText());
                    writer.println(passwordText1.getText());
                    writer.println(ageText.getText());
                    writer.println(genderType.getSelectedItem());
                    writer.println(nationalityText.getText());
                    writer.println(jobText.getText());
                    writer.println(hobbyText.getText());
                    writer.flush();
                    String createAccountResult = reader.readLine();
                    if (createAccountResult.equals("Create account successfully.")) {
                        JOptionPane.showMessageDialog(null, createAccountResult, "Create Account", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, createAccountResult, "Create Account", JOptionPane.ERROR_MESSAGE);
                    }
                    //Return to the main menu so that user can log in
                    createAccountFrame.setVisible(false);
                    mainMenuFrame.setVisible(true);
                }
                /*
                if (e.getSource() == returnButton) {
                    createAccountFrame.setVisible(false);
                    mainMenuFrame.setVisible(true);
                }

                 */
                //Buttons in log in frame
                if (e.getSource() == enterButton2) {
                    writer.println(usernameText2.getText());
                    writer.println(passwordText2.getText());
                    writer.flush();
                    String loginResult = reader.readLine();
                    if (loginResult.equals("Log in successfully")) {
                        JOptionPane.showMessageDialog(null, loginResult, "Log in", JOptionPane.INFORMATION_MESSAGE);
                        //Go to another frame after log in
                        loginFrame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, loginResult, "Log in", JOptionPane.ERROR_MESSAGE);
                        //return to the main menu frame
                        loginFrame.setVisible(false);
                        mainMenuFrame.setVisible(true);
                    }
                }
                //Buttons after log in successfully


                //Buttons for specific action
                if (e.getSource() == addFriendButton) {

                }
                if (e.getSource() == deleteFriendButton) {

                }
                if (e.getSource() == blockUserButton) {

                }
                if (e.getSource() == unblockUserButton) {

                }

                //Buttons for message
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };
}
