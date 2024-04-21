import javax.swing.*;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    //JFrame and JButton for Log in
    JFrame loginFrame;
    JLabel usernameLabel2;
    JTextField usernameText2;
    JLabel passwordLabel2;
    JTextField passwordText2;
    JButton enterButton2;

    //JFrame and JButton after log in successfully
    JButton actionButton;

    //JFrame and JButton in the frame of actions (Add, delete, block, remove, view other user prorile)

    JFrame actionFrame;
    JTextField otherUsernameText;
    JLabel otherUsernameLabel;
    JButton addFriendButton;
    JButton deleteFriendButton;
    JButton blockUserButton;
    JButton unblockUserButton;
    JButton viewOtherProfileButton;

    //JFrame and JButton in the frame of view other user profile

    JFrame viewOtherProfileFrame;
    JLabel viewInformationLabel;
    JButton viewAgeButton;
    JButton viewGenderButton;
    JButton viewNationalityButton;
    JButton viewJobButton;
    JButton viewHobbyButton;


    //JFrame and JButton in edit that user profile

    //JFrame and JButton for the message frame
    JTextArea messageTextArea;
    JTextField recipientField;
    JButton sendButton;
    JButton cancelButton;
    JTextArea messageDisplayArea;
    Highlighter highlighter;
    JButton deleteButton;

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
            actionButton = new JButton("action");
            actionButton.setBounds(210,280,160,70);

            createAccountButton.addActionListener(actionListener);
            loginButton.addActionListener(actionListener);
            exitAppButton.addActionListener(actionListener);
            //viewOtherProfileButton.addActionListener(actionListener);

            content.add(loginButton);
            content.add(createAccountButton);
            content.add(exitAppButton);
            //content.add(viewOtherProfileButton);

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

            otherUsernameLabel = new JLabel("Enter other username");
            otherUsernameLabel.setBounds(50, 170, 140, 25);
            otherUsernameText = new JTextField(10);
            otherUsernameText.setBounds(220, 170, 140, 25);

            addFriendButton = new JButton("Add friend");
            addFriendButton.setBounds(400, 40, 140, 50);
            deleteFriendButton = new JButton("Delete friend");
            deleteFriendButton.setBounds(400, 100,140,50);
            blockUserButton = new JButton("Block user");
            blockUserButton.setBounds(400, 160,140,50);
            unblockUserButton = new JButton("Unblock user");
            unblockUserButton.setBounds(400, 220,140,50);
            viewOtherProfileButton = new JButton("View other profile");
            viewOtherProfileButton.setBounds(400, 280,140,50);

            addFriendButton.addActionListener(actionListener);
            deleteFriendButton.addActionListener(actionListener);
            blockUserButton.addActionListener(actionListener);
            unblockUserButton.addActionListener(actionListener);
            viewOtherProfileButton.addActionListener(actionListener);

            content.add(otherUsernameLabel);
            content.add(otherUsernameText);
            content.add(addFriendButton);
            content.add(deleteFriendButton);
            content.add(blockUserButton);
            content.add(unblockUserButton);
            content.add(viewOtherProfileButton);

        }
        //Frame for view other user profile
        {
            viewOtherProfileFrame = new JFrame("View other profile");
            Container content = viewOtherProfileFrame.getContentPane();
            content.setLayout(null);
            viewOtherProfileFrame.setSize(600, 400);
            viewOtherProfileFrame.setLocationRelativeTo(null);
            viewOtherProfileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Only set visible = true after client click the view other profile button
            //in action Frame
            viewOtherProfileFrame.setVisible(false);

            viewInformationLabel = new JLabel("Click to the information that you want to see");
            //viewInformationLabel.setBounds();
            viewAgeButton = new JButton("Age");
            viewAgeButton.setBounds(400, 40, 140, 50);
            viewGenderButton = new JButton("Delete friend");
            viewGenderButton.setBounds(400, 100,140,50);
            viewNationalityButton = new JButton("Block user");
            viewNationalityButton.setBounds(400, 160,140,50);
            viewJobButton = new JButton("Unblock user");
            viewJobButton.setBounds(400, 220,140,50);
            viewHobbyButton = new JButton("View other profile");
            viewHobbyButton.setBounds(400, 280,140,50);

            viewAgeButton.addActionListener(actionListener);
            viewGenderButton.addActionListener(actionListener);
            viewNationalityButton.addActionListener(actionListener);
            viewJobButton.addActionListener(actionListener);
            viewHobbyButton.addActionListener(actionListener);

            content.add(viewAgeButton);
            content.add(viewGenderButton);
            content.add(viewNationalityButton);
            content.add(viewJobButton);
            content.add(viewHobbyButton);
        }
        //Frame for edit that user profile
        {

        }
        //Frame for the messages
        {
            JFrame messageFrame = new JFrame("Message");


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
                    //Write Log in to the server
                    writer.write("Log in");
                    writer.println();
                    writer.flush();
                    mainMenuFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
                if (e.getSource() == exitAppButton) {
                    //close and write log out to the server
                    writer.write("Log out");
                    writer.println();
                    writer.flush();
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
                        JOptionPane.showMessageDialog(null, createAccountResult,
                                "Create Account", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, createAccountResult,
                                "Create Account", JOptionPane.ERROR_MESSAGE);
                    }
                    //Return to the main menu so that user can log in
                    createAccountFrame.setVisible(false);
                    mainMenuFrame.setVisible(true);
                }
                //Buttons in log in frame
                if (e.getSource() == enterButton2) {
                    writer.println(usernameText2.getText());
                    writer.println(passwordText2.getText());
                    writer.flush();
                    String loginResult = reader.readLine();
                    if (loginResult.equals("Log in successfully")) {
                        JOptionPane.showMessageDialog(null, loginResult,
                                "Log in", JOptionPane.INFORMATION_MESSAGE);
                        //Go to another frame after log in
                        loginFrame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, loginResult,
                                "Log in", JOptionPane.ERROR_MESSAGE);
                        //return to the main menu frame
                        loginFrame.setVisible(false);
                        mainMenuFrame.setVisible(true);
                    }
                }
                //Buttons after log in successfully
                if (e.getSource() == actionButton) {
                    mainMenuFrame.setVisible(false);
                    actionFrame.setVisible(true);
                }


                //Buttons for specific action
                if (e.getSource() == addFriendButton) {
                    writer.write("Add friend");
                    writer.println();
                    writer.write(otherUsernameText.getText());
                    writer.println();
                    writer.flush();
                    String addFriendResult = reader.readLine();
                    if (addFriendResult.equals("Add friend successfully")) {
                        JOptionPane.showMessageDialog(null, addFriendResult,
                                "Actions", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, addFriendResult,
                                "Actions", JOptionPane.ERROR_MESSAGE);
                    }
                    actionFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    //.setVisible(true)
                }
                if (e.getSource() == deleteFriendButton) {
                    writer.write("Unfriend");
                    writer.println();
                    writer.write(otherUsernameText.getText());
                    writer.println();
                    writer.flush();
                    String deleteFriendResult = reader.readLine();
                    if (deleteFriendResult.equals("Unfriend successfully")) {
                        JOptionPane.showMessageDialog(null, deleteFriendResult,
                                "Actions", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, deleteFriendResult,
                                "Actions", JOptionPane.ERROR_MESSAGE);
                    }
                    actionFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    //.setVisible(true);
                }
                if (e.getSource() == blockUserButton) {
                    writer.write("Block user");
                    writer.println();
                    writer.write(otherUsernameText.getText());
                    writer.println();
                    writer.flush();
                    String blockUserResult = reader.readLine();
                    if (blockUserResult.equals("Block user successfully")) {
                        JOptionPane.showMessageDialog(null, blockUserResult,
                                "Actions", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, blockUserResult,
                                "Actions", JOptionPane.ERROR_MESSAGE);
                    }
                    actionFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    //.setVisible(true);
                }
                if (e.getSource() == unblockUserButton) {
                    writer.write("Unblock user");
                    writer.println();
                    writer.write(otherUsernameText.getText());
                    writer.println();
                    writer.flush();
                    String unblockUserResult = reader.readLine();
                    if (unblockUserResult.equals("Unblock successfully")) {
                        JOptionPane.showMessageDialog(null, unblockUserResult,
                                "Actions", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, unblockUserResult,
                                "Actions", JOptionPane.ERROR_MESSAGE);
                    }
                    actionFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    //.setVisible(true);

                }
                if (e.getSource() == viewOtherProfileButton) {
                    actionFrame.setVisible(false);
                    writer.write("View other user profile");
                    writer.println();
                    writer.flush();
                    String viewOtherProfileResult = reader.readLine();
                    if (viewOtherProfileResult.equals("Can not view that user profile")) {
                        JOptionPane.showMessageDialog(null, viewOtherProfileResult,
                                "Actions", JOptionPane.ERROR_MESSAGE);
                    } else {
                        viewOtherProfileFrame.setVisible(true);
                    }
                }
                //Buttons for view other profile
                if (e.getSource() == viewAgeButton) {
                    writer.write("Age");
                    writer.println();
                    writer.flush();
                    String viewAgeResult = reader.readLine();
                    JOptionPane.showMessageDialog(null, "The age of that user is " +
                                    viewAgeResult,
                            "View other profile", JOptionPane.INFORMATION_MESSAGE);
                    viewOtherProfileFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    //.setVisible(true);
                }
                if (e.getSource() == viewGenderButton) {
                    writer.write("Gender");
                    writer.println();
                    writer.flush();
                    String viewGenderResult = reader.readLine();
                    JOptionPane.showMessageDialog(null, "The gender of that user is " +
                                    viewGenderResult,
                            "View other profile", JOptionPane.INFORMATION_MESSAGE);
                    viewOtherProfileFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    //.setVisible(true);
                }
                if (e.getSource() == viewNationalityButton) {
                    writer.write("Nationality");
                    writer.println();
                    writer.flush();
                    String viewNationalityResult = reader.readLine();
                    JOptionPane.showMessageDialog(null, "The nationality of that user is " +
                                    viewNationalityResult,
                            "View other profile", JOptionPane.INFORMATION_MESSAGE);
                    viewOtherProfileFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    //.setVisible(true);
                }
                if (e.getSource() == viewJobButton) {
                    writer.write("Job");
                    writer.println();
                    writer.flush();
                    String viewJobResult = reader.readLine();
                    JOptionPane.showMessageDialog(null, "The job of that user is " +
                                    viewJobResult,
                            "View other profile", JOptionPane.INFORMATION_MESSAGE);
                    viewOtherProfileFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    //.setVisible(true);
                }
                if (e.getSource() == viewHobbyButton) {
                    writer.write("Hobby");
                    writer.println();
                    writer.flush();
                    String viewHobbyResult = reader.readLine();
                    JOptionPane.showMessageDialog(null, "The hobby of that user is " +
                                    viewHobbyResult,
                            "View other profile", JOptionPane.INFORMATION_MESSAGE);
                    viewOtherProfileFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    //.setVisible(true);
                }
                //Buttons for edit profile
                //Buttons for message
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };

}

class MessagingGUI extends JFrame {
    private JTextArea messageTextArea;
    private JTextField recipientField;
    private JButton sendButton;
    private JButton cancelButton;
    private JButton deleteMessageButton;
    private JTextArea messageDisplayArea;
    private Highlighter highlighter;
    private JButton deleteButton;

    public MessagingGUI(String receiver) {
        setTitle(receiver);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Message composition area
        JPanel composePanel = new JPanel(new BorderLayout());
        messageTextArea = new JTextArea();
        composePanel.add(new JScrollPane(messageTextArea), BorderLayout.CENTER);
        sendButton = new JButton("Send");
        composePanel.add(sendButton, BorderLayout.EAST);
        add(composePanel, BorderLayout.NORTH);


        // Recipient selection
        JPanel recipientPanel = new JPanel(new BorderLayout());
        recipientField = new JTextField();
        recipientPanel.add(new JLabel("Recipient:"), BorderLayout.WEST);
        recipientPanel.add(recipientField, BorderLayout.CENTER);
        add(recipientPanel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new BorderLayout());
        deleteButton = new JButton("Delete Selected Message"); // Initialize deleteButton here
        JTextField conversationID = new JTextField();
        conversationID.setText("Please enter the ID of the conversation you want to delete");
        buttonPanel.add(deleteButton, BorderLayout.WEST);
        buttonPanel.add(conversationID, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Message display area
        messageDisplayArea = new JTextArea();
        messageDisplayArea.setEditable(false);
        add(new JScrollPane(messageDisplayArea), BorderLayout.CENTER);
        highlighter = messageDisplayArea.getHighlighter();

        // Action Listeners
        sendButton.addActionListener(e -> sendMessage());
        //cancelButton.addActionListener(e -> cancelMessage());
        deleteButton.addActionListener(e -> deleteMessage());

    }

    private void sendMessage() {
        String recipient = recipientField.getText();
        String messageContent = messageTextArea.getText();

        // Here, you would send the message to the server and handle the response

        // For demonstration purposes, let's just display the sent message in the display area
        displayMessage("You", messageContent);

        // Clear the message composition area after sending
        messageTextArea.setText("");
    }

    private void displayMessage(String sender, String messageContent) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String timestamp = dateFormat.format(new Date());
        String formattedMessage = "[" + timestamp + "] " + sender + ": " + messageContent + "\n";
        messageDisplayArea.append(formattedMessage);
    }


    private void deleteMessage() {
        // Here, you would send a message to the server to request deletion of the selected message
        // You can get the selected message from the messageDisplayArea
        String selectedMessage = messageDisplayArea.getSelectedText();
        if (selectedMessage != null) {
            // Implement logic to send deletion request to server
            // Then remove the message from the display area
            messageDisplayArea.replaceSelection("");
            // Also remove the delete button
            messageDisplayArea.remove(deleteButton);
            messageDisplayArea.revalidate();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MessagingGUI gui = new MessagingGUI("Yanxin");
            gui.setVisible(true);
        });
    }
}




