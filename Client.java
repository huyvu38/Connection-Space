import javax.swing.*;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
    ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
    ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Client());
    }

    //JFrame and JButton for main menu
    JFrame mainMenuFrame;
    JButton createAccountButton;
    JButton loginButton;

    //JFrame and JButton for create account
    JFrame createAccountFrame;
    JLabel usernameLabel1;
    JTextField usernameText1;
    JLabel usernameFormatLabel;
    JLabel passwordLabel1;
    JTextField passwordText1;
    JLabel passwordFormatLabel;
    JLabel ageLabel;
    JTextField ageText;
    JLabel ageFormatLabel;
    JLabel genderLabel;
    JComboBox<String> genderType;
    JLabel nationalityLabel;
    JTextField nationalityText;
    JLabel jobLabel;
    JTextField jobText;
    JLabel hobbyLabel;
    JTextField hobbyText;
    JButton enterButton1;
    JLabel informationFormatLabel;

    //JFrame and JButton for Log in
    JFrame loginFrame;
    JLabel usernameLabel2;
    JTextField usernameText2;
    JLabel passwordLabel2;
    JTextField passwordText2;
    JButton enterButton2;

    //JFrame and JButton in the frame of actions (Add, delete, block, remove, view other user profile)

    JFrame actionFrame;
    JTextField otherUsernameText;
    JLabel otherUsernameLabel;
    JButton addFriendButton;
    JButton deleteFriendButton;
    JButton blockUserButton;
    JButton unblockUserButton;
    JButton viewOtherProfileButton;
    JButton backButton;
    JButton contactButton;

    //JFrame and JButton in the frame of view other user profile

    JFrame viewOtherProfileFrame;
    JLabel viewInformationLabel;
    JButton viewAgeButton;
    JButton viewGenderButton;
    JButton viewNationalityButton;
    JButton viewJobButton;
    JButton viewHobbyButton;

    //JFrame and JButton after log in successfully

    JFrame userFrame;
    JPanel westPanel;
    JPanel eastPanel;
    JPanel centerPanel;

    JButton logOutButton;

    // Create and configure the popup menu
    JPopupMenu popupMenu;
    JMenuItem menuItem1;
    JMenuItem menuItem2;

    //for user own profile
    private JTextField passwordText3, ageText3, nationalityText3, jobText3, hobbyText3;

    private JButton saveButton;
    private JComboBox genderType3;
    private JLabel usernameLabel3, usernameLabel4, passwordLabel3, genderLabel3,
            ageLabel3, nationalityLabel3, jobLabel3, hobbyLabel3;

    //elements for eastPanel
    private JTextField inputField;

    String selectedUser2;

    String selectedUser3;

    JButton getFriendListButton;
    JButton getBlockUserButton;

    JComboBox<String> resultCombo2;

    JComboBox<String> resultCombo3;

    ArrayList<String> allFriendList;
    ArrayList<String> allBlockList;

    JButton searchButton;
    JButton actionButton;

    JComboBox<String> resultCombo1;
    ArrayList<String> allUsernames;  // This would be fetched from your database
    String selectedUser;

    //element for view other profile
    //JFrame viewProfileFrame;

    //JFrame and JButton for the message frame
    private JTextArea messageTextArea;
    private JTextField recipientField;
    private JButton sendButton;
    private JTextArea messageDisplayArea;
    private Highlighter highlighter;
    private JButton deleteButton;
    private final String conversationIDMessage = "Please enter conversationID to delete the message";
    private String receiver;
    JFrame messageFrame;
    JTextField conversationID;

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
            loginButton.setBounds(220, 80, 160, 70);
            createAccountButton = new JButton("Create account");

            loginButton = new JButton("Login");
            loginButton.setBounds(220, 80, 160, 70);
            createAccountButton = new JButton("Create account");
            createAccountButton.setBounds(220, 180, 160,70);

            createAccountButton.addActionListener(actionListener);
            loginButton.addActionListener(actionListener);


            content.add(loginButton);
            content.add(createAccountButton);

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
            usernameText1.setBounds(280, 33, 120, 25);
            usernameLabel1 = new JLabel("Username");
            usernameLabel1.setBounds(160, 33, 120, 25);
            usernameFormatLabel = new JLabel("At least 4 characters");
            usernameFormatLabel.setBounds(420, 33, 120,25);

            passwordText1 = new JTextField(10);
            passwordText1.setBounds(280, 66, 120, 25);
            passwordLabel1 = new JLabel("Password");
            passwordLabel1.setBounds(160, 66, 120, 25);
            passwordFormatLabel = new JLabel("At least 6 characters");
            passwordFormatLabel.setBounds(420, 66, 120,25);

            ageText = new JTextField(10);
            ageText.setBounds(280, 99, 120, 25);
            ageLabel = new JLabel("Age");
            ageLabel.setBounds(160, 99, 120, 25);
            ageFormatLabel = new JLabel("Greater than 0");
            ageFormatLabel.setBounds(420, 99, 120, 25);

            genderType = new JComboBox<>();
            genderType.addItem("Male");
            genderType.addItem("Female");
            genderType.addItem("Other");
            genderType.setBounds(280, 132, 120, 25);
            genderLabel = new JLabel("Gender");
            genderLabel.setBounds(160, 132, 120, 25);

            nationalityText = new JTextField(10);
            nationalityText.setBounds(280, 165, 120, 25);
            nationalityLabel = new JLabel("Nationality");
            nationalityLabel.setBounds(160, 165, 120, 25);

            jobText = new JTextField(10);
            jobText.setBounds(280, 198, 120, 25);
            jobLabel = new JLabel("Job");
            jobLabel.setBounds(160, 198, 120, 25);

            hobbyText = new JTextField(10);
            hobbyText.setBounds(280, 231, 120, 25);
            hobbyLabel = new JLabel("Hobby");
            hobbyLabel.setBounds(160, 231, 120, 25);

            informationFormatLabel = new JLabel("*** Do not contain any spaces or semicolons in any information");
            informationFormatLabel.setBounds(120, 320, 400,30);

            enterButton1 = new JButton("Enter");
            enterButton1.setBounds(230, 280, 140, 30);
            enterButton1.addActionListener(actionListener);


            content.add(usernameText1);
            content.add(usernameLabel1);
            content.add(usernameFormatLabel);
            content.add(passwordText1);
            content.add(passwordLabel1);
            content.add(passwordFormatLabel);
            content.add(ageText);
            content.add(ageLabel);
            content.add(ageFormatLabel);
            content.add(genderType);
            content.add(genderLabel);
            content.add(nationalityText);
            content.add(nationalityLabel);
            content.add(jobText);
            content.add(jobLabel);
            content.add(hobbyText);
            content.add(hobbyLabel);
            content.add(informationFormatLabel);
            content.add(enterButton1);

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
            viewInformationLabel.setBounds(170, 60,300,30);
            viewAgeButton = new JButton("Age");
            viewAgeButton.setBounds(20, 180, 90, 32);
            viewGenderButton = new JButton("Gender");
            viewGenderButton.setBounds(130, 180,90,32);
            viewNationalityButton = new JButton("Nationality");
            viewNationalityButton.setBounds(240, 180,90,32);
            viewJobButton = new JButton("Job");
            viewJobButton.setBounds(350, 180,90,32);
            viewHobbyButton = new JButton("Hobby");
            viewHobbyButton.setBounds(460, 180,90,32);

            viewAgeButton.addActionListener(actionListener);
            viewGenderButton.addActionListener(actionListener);
            viewNationalityButton.addActionListener(actionListener);
            viewJobButton.addActionListener(actionListener);
            viewHobbyButton.addActionListener(actionListener);

            content.add(viewInformationLabel);
            content.add(viewAgeButton);
            content.add(viewGenderButton);
            content.add(viewNationalityButton);
            content.add(viewJobButton);
            content.add(viewHobbyButton);
        }
        //Frame for User after login
        //The title is the name of the app??
        {
            userFrame = new JFrame("Connection Space");
            userFrame.setSize(800, 300);
            userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            userFrame.setLocationRelativeTo(null);
            userFrame.setLayout(new BorderLayout());

            // West side panel
            westPanel = new JPanel(new GridLayout(4, 1));

            resultCombo2 = new JComboBox<>();
            resultCombo2.setMaximumSize(new Dimension(Integer.MAX_VALUE, resultCombo2.getPreferredSize().height));
            resultCombo2.addActionListener(e -> {
                selectedUser2 = (String) resultCombo2.getSelectedItem();
            });

            resultCombo3 = new JComboBox<>();
            resultCombo3.setMaximumSize(new Dimension(Integer.MAX_VALUE, resultCombo3.getPreferredSize().height));
            resultCombo3.addActionListener(e -> {
                selectedUser3 = (String) resultCombo3.getSelectedItem();
            });

            // Initialize the get friend button
            getFriendListButton = new JButton("Get friend list");
            getFriendListButton.setAlignmentX(Component.CENTER_ALIGNMENT);  // Ensure the button is center-aligned
            getFriendListButton.addActionListener(actionListener);

            // Initialize the get block user button
            getBlockUserButton = new JButton("Get block list");
            getBlockUserButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            getBlockUserButton.addActionListener(actionListener);

            westPanel.add(getFriendListButton);
            westPanel.add(resultCombo2);
            westPanel.add(getBlockUserButton);
            westPanel.add(resultCombo3);

            /*

            // Add mouse listener to the stringList for showing the popup menu
            stringList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        int index = stringList.locationToIndex(e.getPoint());
                        stringList.setSelectedIndex(index);
                        popupMenu.show(stringList, e.getX(), e.getY());
                    }
                }
            });

             */

            westPanel.setPreferredSize(new Dimension(150, getHeight()));  // Adjust width as needed
            userFrame.getContentPane().add(westPanel, BorderLayout.WEST);

            // Center panel
            centerPanel = new JPanel(new GridLayout(1,2));
            JPanel photoPanel = new JPanel(new BorderLayout());
            JLabel photoLabel = new JLabel();
            ImageIcon photo = new ImageIcon("/Users/xinxin/Documents/CS180-Team/images.jpeg");  // Adjust the path accordingly
            photoLabel.setIcon(photo);
            photoPanel.add(photoLabel, BorderLayout.CENTER);
            logOutButton = new JButton("Log out");
            logOutButton.addActionListener(actionListener);
            photoPanel.add(logOutButton, BorderLayout.SOUTH);
            centerPanel.add(photoPanel);
            JPanel formPanel = new JPanel(new GridLayout(8, 2));
            // Initializing all components
            usernameLabel3 = new JLabel("Username");
            usernameLabel4 = new JLabel("");
            passwordLabel3 = new JLabel("Password");
            passwordText3 = new JTextField(10);

            ageLabel3 = new JLabel("Age");
            ageText3 = new JTextField(10);
            genderLabel3 = new JLabel("Gender");
            genderType3 = new JComboBox<>(new String[]{"Male", "Female", "Other"});
            nationalityLabel3 = new JLabel("Nationality");
            nationalityText3 = new JTextField(10);
            jobLabel3 = new JLabel("Job");
            jobText3 = new JTextField(10);
            hobbyLabel3 = new JLabel("Hobby");
            hobbyText3 = new JTextField(10);
            saveButton = new JButton("Save");
            saveButton.setActionCommand("Edit profile");
            saveButton.addActionListener(actionListener);

            // Adding components to form panel
            formPanel.add(usernameLabel3);
            formPanel.add(usernameLabel4);
            formPanel.add(passwordLabel3);
            formPanel.add(passwordText3);
            formPanel.add(ageLabel3);
            formPanel.add(ageText3);
            formPanel.add(genderLabel3);
            formPanel.add(genderType3);
            formPanel.add(nationalityLabel3);
            formPanel.add(nationalityText3);
            formPanel.add(jobLabel3);
            formPanel.add(jobText3);
            formPanel.add(hobbyLabel3);
            formPanel.add(hobbyText3);
            formPanel.add(saveButton);
            centerPanel.add(formPanel);
            userFrame.getContentPane().add(centerPanel, BorderLayout.CENTER);

            // East side panel
            eastPanel = new JPanel();
            eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
            inputField = new JTextField("Search the user here", 20);
            inputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, inputField.getPreferredSize().height));
            inputField.setForeground(Color.GRAY);
            inputField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (inputField.getText().equals("Search the user here")) {
                        inputField.setText("");
                        inputField.setForeground(Color.black);

                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (inputField.getText().isEmpty()) {
                        inputField.setText("Search the user here");
                        inputField.setForeground(Color.GRAY);

                    }
                }
            });

            // Initialize the combo box
            resultCombo1 = new JComboBox<>();
            resultCombo1.setMaximumSize(new Dimension(Integer.MAX_VALUE, resultCombo1.getPreferredSize().height));
            resultCombo1.addActionListener(e -> {
                selectedUser = (String) resultCombo1.getSelectedItem();
            });

            // Initialize the search button
            searchButton = new JButton("Search");
            searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);  // Ensure the button is center-aligned
            searchButton.addActionListener(actionListener);

            // Initialize the action button
            actionButton = new JButton("Action");
            actionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            actionButton.addActionListener(actionListener);

            eastPanel.add(inputField);
            eastPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Add space between components
            eastPanel.add(resultCombo1);
            eastPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Add space between components
            eastPanel.add(searchButton);
            eastPanel.add(actionButton);

            eastPanel.setBackground(Color.WHITE);  // Set the background color to white
            eastPanel.setPreferredSize(new Dimension(150, getHeight()));  // Adjust width as needed
            userFrame.getContentPane().add(eastPanel, BorderLayout.EAST);
            userFrame.pack();

        }

        //Frame for the messages
        {
            messageFrame = new JFrame("Message");
            messageFrame.setTitle(receiver);
            messageFrame.setSize(600, 400);
            messageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            messageFrame.setLayout(new BorderLayout());

            // Message composition area
            JPanel composePanel = new JPanel(new BorderLayout());
            messageTextArea = new JTextArea();
            composePanel.add(new JScrollPane(messageTextArea), BorderLayout.CENTER);
            sendButton = new JButton("Send");
            composePanel.add(sendButton, BorderLayout.EAST);
            messageFrame.add(composePanel, BorderLayout.NORTH);


            // Recipient selection
            JPanel recipientPanel = new JPanel(new BorderLayout());
            recipientField = new JTextField();
            recipientPanel.add(new JLabel("Recipient:"), BorderLayout.WEST);
            recipientPanel.add(recipientField, BorderLayout.CENTER);
            messageFrame.add(recipientPanel, BorderLayout.CENTER);

            // Buttons
            JPanel buttonPanel = new JPanel(new BorderLayout());
            deleteButton = new JButton("Delete Selected Message"); // Initialize deleteButton here
            conversationID = new JTextField(conversationIDMessage);
            conversationID.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (conversationID.getText().equals(conversationIDMessage)) {
                        conversationID.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (conversationID.getText().isEmpty()) {
                        conversationID.setText(conversationIDMessage);
                    }
                }
            });
            conversationID.setForeground(Color.lightGray);

            buttonPanel.add(deleteButton, BorderLayout.WEST);
            buttonPanel.add(conversationID, BorderLayout.CENTER);
            messageFrame.add(buttonPanel, BorderLayout.SOUTH);

            // Message display area
            messageDisplayArea = new JTextArea();
            messageDisplayArea.setEditable(false);
            add(new JScrollPane(messageDisplayArea), BorderLayout.CENTER);
            highlighter = messageDisplayArea.getHighlighter();

            // Action Listeners
            sendButton.addActionListener(actionListener);
            //cancelButton.addActionListener(e -> cancelMessage());
            deleteButton.addActionListener(actionListener);


        }
    }

    private void addMenuItem(String title, ActionListener listener) {

    }


    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                /*
                if (e.getSource() == backButton) {
                    viewProfileFrame.setVisible(false);
                }
                if (e.getSource() == contactButton) {
                    messageFrame.setTitle(viewProfileFrame.getTitle());
                    viewProfileFrame.setVisible(false);
                    messageFrame.setVisible(true);

                }

                 */
                if (e.getSource() == searchButton) {
                    writer.writeObject("Search user");
                    writer.flush();
                    String searchText = inputField.getText();
                    writer.writeObject(searchText);
                    writer.flush();
                    allUsernames = (ArrayList<String>) reader.readObject();
                    resultCombo1.removeAllItems();
                    updateComboBox1(allUsernames);
                }
                if (e.getSource() == getFriendListButton) {
                    writer.writeObject("Get friend list");
                    writer.flush();
                    allFriendList = (ArrayList<String>) reader.readObject();
                    resultCombo2.removeAllItems();
                    updateComboBox2(allFriendList);
                }
                if (e.getSource() == getBlockUserButton) {
                    writer.writeObject("Get block list");
                    writer.flush();
                    allBlockList = (ArrayList<String>) reader.readObject();
                    resultCombo3.removeAllItems();
                    updateComboBox3(allBlockList);
                }
                if (e.getSource() == menuItem1) {

                }
                if (e.getSource() == menuItem2) {

                }
                //Buttons in main menu frame
                if (e.getSource() == createAccountButton) {
                    //Write Create account to server
                    writer.writeObject("Create account");
                    writer.flush();
                    mainMenuFrame.setVisible(false);
                    createAccountFrame.setVisible(true);
                }
                if (e.getSource() == loginButton) {
                    //Write Log in to the server
                    String command = "Log in";
                    writer.writeObject(command);
                    writer.flush();

                    mainMenuFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
                //Buttons in create account frame
                if (e.getSource() == enterButton1) {
                    writer.writeObject(usernameText1.getText());
                    writer.writeObject(passwordText1.getText());
                    writer.writeObject(ageText.getText());
                    writer.writeObject(genderType.getSelectedItem());
                    writer.writeObject(nationalityText.getText());
                    writer.writeObject(jobText.getText());
                    writer.writeObject(hobbyText.getText());
                    writer.flush();
                    String createAccountResult = (String) reader.readObject();
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
                    //Reset text
                    usernameText1.setText("");
                    passwordText1.setText("");
                    ageText.setText("");
                    nationalityText.setText("");
                    jobText.setText("");
                    hobbyText.setText("");
                }
                //Buttons in log in frame
                if (e.getSource() == enterButton2) {
                    String userName = usernameText2.getText();
                    String password = passwordText2.getText();
                    writer.writeObject(userName);
                    writer.writeObject(password);
                    writer.flush();
                    String loginResult =(String) reader.readObject();
                    if (loginResult.equals("Log in successfully")) {
                        String username = (String) reader.readObject();
                        String passWord = (String) reader.readObject();
                        int age = (int) reader.readObject();
                        String gender = (String) reader.readObject();
                        String nationality = (String) reader.readObject();
                        String job = (String) reader.readObject();
                        String hobby = (String) reader.readObject();
                        usernameLabel4.setText(username);
                        passwordText3.setText(passWord);
                        ageText3.setText(String.valueOf(age));
                        genderType.setSelectedItem(gender);
                        nationalityText3.setText(nationality);
                        jobText3.setText(job);
                        hobbyText3.setText(hobby);
                        loginFrame.setVisible(false);
                        userFrame.setVisible(true);
                        //MainFrame mainFrame = new MainFrame();
                    } else {
                        JOptionPane.showMessageDialog(null, loginResult,
                                "Log in", JOptionPane.ERROR_MESSAGE);
                        //return to the main menu frame
                        loginFrame.setVisible(false);
                        mainMenuFrame.setVisible(true);
                    }
                    usernameText2.setText("");
                    passwordText2.setText("");
                }
                if (e.getActionCommand().equals("Edit profile")) {
                    writer.writeObject("Edit profile");
                    writer.flush();
                    writer.writeObject(passwordText3.getText());
                    writer.writeObject(ageText3.getText());
                    writer.writeObject(genderType3.getSelectedItem());
                    writer.writeObject(nationalityText3.getText());
                    writer.writeObject(jobText3.getText());
                    writer.writeObject(hobbyText3.getText());
                    writer.flush();
                    if (reader.readObject().equals("success")) {
                        JOptionPane.showMessageDialog(null, "Edit Profile successful",
                                "Edit Profile", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Edit Profile failure",
                                "Edit Profile", JOptionPane.ERROR_MESSAGE);
                        //UserAccount currentUserAcc = (UserAccount) reader.readObject();
                        String password = (String) reader.readObject();
                        int age = (int) reader.readObject();
                        String gender = (String) reader.readObject();
                        String nationality = (String) reader.readObject();
                        String job = (String) reader.readObject();
                        String hobby = (String) reader.readObject();
                        passwordText3.setText(password);
                        ageText3.setText(String.valueOf(age));
                        genderType.setSelectedItem(gender);
                        nationalityText3.setText(nationality);
                        jobText3.setText(job);
                        hobbyText3.setText(hobby);
                    }
                }
                //Buttons after log in successfully
                if (e.getSource() == actionButton) {
                    writer.writeObject("Action");
                    writer.flush();
                    userFrame.setVisible(false);
                    actionFrame.setVisible(true);
                }
                if (e.getSource() == logOutButton) {
                    writer.writeObject("Log out");
                    writer.flush();
                    userFrame.setVisible(false);
                    mainMenuFrame.setVisible(true);
                }
                //go to messege frame later
//                if (e.getSource() == messageButton) {
//                    userFrame.setVisible(false);
//                    //.setVisible(true);
//                }
                //Buttons for specific action
                if (e.getSource() == addFriendButton) {
                    writer.writeObject("Add friend");
                    writer.writeObject(otherUsernameText.getText());
                    writer.flush();
                    String addFriendResult = (String) reader.readObject();
                    if (addFriendResult.equals("Add friend successfully")) {
                        JOptionPane.showMessageDialog(null, addFriendResult,
                                "Actions", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, addFriendResult,
                                "Actions", JOptionPane.ERROR_MESSAGE);
                    }
                    otherUsernameText.setText("");
                    actionFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    userFrame.setVisible(true);
                }
                if (e.getSource() == deleteFriendButton) {
                    writer.writeObject("Unfriend");
                    writer.writeObject(otherUsernameText.getText());
                    writer.flush();
                    String deleteFriendResult = (String) reader.readObject();
                    if (deleteFriendResult.equals("Unfriend successfully")) {
                        JOptionPane.showMessageDialog(null, deleteFriendResult,
                                "Actions", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, deleteFriendResult,
                                "Actions", JOptionPane.ERROR_MESSAGE);
                    }
                    otherUsernameText.setText("");
                    actionFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    userFrame.setVisible(true);
                }
                if (e.getSource() == blockUserButton) {
                    writer.writeObject("Block user");
                    writer.writeObject(otherUsernameText.getText());
                    writer.flush();
                    String blockUserResult = (String) reader.readObject();
                    if (blockUserResult.equals("Block successfully")) {
                        JOptionPane.showMessageDialog(null, blockUserResult,
                                "Actions", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, blockUserResult,
                                "Actions", JOptionPane.ERROR_MESSAGE);
                    }
                    otherUsernameText.setText("");
                    actionFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    userFrame.setVisible(true);
                }
                if (e.getSource() == unblockUserButton) {
                    writer.writeObject("Unblock user");
                    writer.writeObject(otherUsernameText.getText());
                    writer.flush();
                    String unblockUserResult = (String) reader.readObject();
                    if (unblockUserResult.equals("Unblock successfully")) {
                        JOptionPane.showMessageDialog(null, unblockUserResult,
                                "Actions", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, unblockUserResult,
                                "Actions", JOptionPane.ERROR_MESSAGE);
                    }
                    otherUsernameText.setText("");
                    actionFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    userFrame.setVisible(true);

                }
                if (e.getSource() == viewOtherProfileButton) {
                    writer.writeObject("View other user profile");
                    writer.writeObject(otherUsernameText.getText());
                    writer.flush();
                    String viewOtherProfileResult = (String) reader.readObject();
                    if (viewOtherProfileResult.equals("Can not view that user profile")) {
                        JOptionPane.showMessageDialog(null, viewOtherProfileResult,
                                "Actions", JOptionPane.ERROR_MESSAGE);
                        otherUsernameText.setText("");
                        actionFrame.setVisible(false);
                        userFrame.setVisible(true);
                    } else {
                        otherUsernameText.setText("");
                        actionFrame.setVisible(false);
                        viewOtherProfileFrame.setVisible(true);
                    }
                }
                //Buttons for view other profile
                if (e.getSource() == viewAgeButton) {
                    writer.writeObject("Age");
                    writer.flush();
                    String viewAgeResult = (String) reader.readObject();
                    JOptionPane.showMessageDialog(null, "The age of that user is " +
                                    viewAgeResult,
                            "View other profile", JOptionPane.INFORMATION_MESSAGE);
                    viewOtherProfileFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    userFrame.setVisible(true);
                }
                if (e.getSource() == viewGenderButton) {
                    writer.writeObject("Gender");
                    writer.flush();
                    String viewGenderResult = (String) reader.readObject();
                    JOptionPane.showMessageDialog(null, "The gender of that user is " +
                                    viewGenderResult,
                            "View other profile", JOptionPane.INFORMATION_MESSAGE);
                    viewOtherProfileFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    userFrame.setVisible(true);
                }
                if (e.getSource() == viewNationalityButton) {
                    writer.writeObject("Nationality");
                    writer.flush();
                    String viewNationalityResult = (String) reader.readObject();
                    JOptionPane.showMessageDialog(null, "The nationality of that user is " +
                                    viewNationalityResult,
                            "View other profile", JOptionPane.INFORMATION_MESSAGE);
                    viewOtherProfileFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    userFrame.setVisible(true);
                }
                if (e.getSource() == viewJobButton) {
                    writer.writeObject("Job");
                    writer.flush();
                    String viewJobResult = (String) reader.readObject();
                    JOptionPane.showMessageDialog(null, "The job of that user is " +
                                    viewJobResult,
                            "View other profile", JOptionPane.INFORMATION_MESSAGE);
                    viewOtherProfileFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    userFrame.setVisible(true);
                }
                if (e.getSource() == viewHobbyButton) {
                    writer.writeObject("Hobby");
                    writer.flush();
                    String viewHobbyResult = (String) reader.readObject();
                    JOptionPane.showMessageDialog(null, "The hobby of that user is " +
                                    viewHobbyResult,
                            "View other profile", JOptionPane.INFORMATION_MESSAGE);
                    viewOtherProfileFrame.setVisible(false);
                    //set back to the frame after log in successfully
                    userFrame.setVisible(true);
                }
                //Buttons for message
                if (e.getSource() == sendButton) {
                    writer.writeObject("Send Message");
                    writer.flush();
                    writer.writeObject(messageTextArea.getText());
                    writer.flush();
                    writer.writeObject(messageFrame.getTitle());
                    writer.flush();
                    messageDisplayArea.setText((String) reader.readObject());
                }
                if (e.getSource() == deleteButton) {
                    writer.writeObject("Delete Message");
                    //writer.println();
                    writer.flush();
                    String ID = conversationID.getText();
                    if (ID.isEmpty()) {
                        JOptionPane.showMessageDialog(Client.this,
                                "Error: ID cannot be empty. Please enter a valid ID.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    try {
                        int conversationID = Integer.parseInt(ID);
                        writer.writeObject(String.valueOf(conversationID));
                        writer.flush();
                        writer.writeObject(messageFrame.getTitle());
                        writer.flush();
                        messageDisplayArea.setText((String) reader.readObject());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Client.this,
                                "Error: ID must be number. Please enter a valid ID.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };

    private void updateComboBox1(List<String> usernames) {
        resultCombo1.removeAllItems();
        for (String username : usernames) {
            resultCombo1.addItem(username);
        }
        if (resultCombo1.getItemCount() > 0) {
            resultCombo1.setSelectedIndex(0);
        }
    }
    private void updateComboBox2(List<String> usernames) {
        resultCombo2.removeAllItems();
        for (String username : usernames) {
            resultCombo2.addItem(username);
        }
        if (resultCombo2.getItemCount() > 0) {
            resultCombo2.setSelectedIndex(0);
        }
    }
    private void updateComboBox3(List<String> usernames) {
        resultCombo3.removeAllItems();
        for (String username : usernames) {
            resultCombo3.addItem(username);
        }
        if (resultCombo3.getItemCount() > 0) {
            resultCombo3.setSelectedIndex(0);
        }
    }
}

