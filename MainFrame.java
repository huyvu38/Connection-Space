//import javax.swing.*;
//import javax.swing.border.TitledBorder;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class MainFrame extends JFrame {
//    private CreateAccountFrame createAccountFrame;
//    private UserAccount currentUserAcc;
//    public MainFrame(UserAccount userAcc) {
//        this.currentUserAcc = userAcc;
//        setTitle("User Management");
//        setSize(800, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setLayout(new BorderLayout());
//
//        // West side panel
//        ListPanel listPanel = new ListPanel(currentUserAcc.getFriendList(), currentUserAcc.getBlockList());
//        JPanel westPanel = listPanel.getPanel();
//        westPanel.setPreferredSize(new Dimension(150, getHeight()));  // Adjust width as needed
//        getContentPane().add(westPanel, BorderLayout.WEST);
//
//        // Center panel
//        CreateAccountFrame createAccountFrame = new CreateAccountFrame();
//        getContentPane().add(createAccountFrame.getProfile(), BorderLayout.CENTER);
//
//        // East side panel
//        DynamicSearchUI dynamicSearchUI = new DynamicSearchUI(this::updateUserProfile);
//        JPanel eastPanel = dynamicSearchUI.getPanel();
//        eastPanel.setBackground(Color.WHITE);  // Set the background color to white
//        eastPanel.setPreferredSize(new Dimension(150, getHeight()));  // Adjust width as needed
//        getContentPane().add(eastPanel, BorderLayout.EAST);
//    }
//
//    public void updateUserProfile(String username) {
//        // Update the center panel with user details
//        createAccountFrame.updateUserProfile(username);
//    }
//
//
//
//    private List<String> getSampleFriends() {
//        return new ArrayList<>(List.of("Apple", "Banana", "Cherry", "Date", "Elderberry"));
//    }
//
//    private List<String> getBlockedFriends() {
//        return new ArrayList<>(List.of("Fig", "Grape"));
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            MainFrame frame = new MainFrame();
//            frame.setVisible(true);
//        });
//    }
//}
//
//// Utility class to handle list panel creation
//class ListPanel {
//    private JPanel panel;
//    private JList<String> stringList; // JList to hold the strings for friends
//    private JList<String> blockList; // JList to hold the blocked users
//    private DefaultListModel<String> friendsModel; // Model to manage friends list elements
//    private DefaultListModel<String> blockModel; // Model to manage blocked list elements
//    private JPopupMenu popupMenu; // Popup menu for additional options
//
//    public ListPanel(List<String> friendsData, List<String> blockData) {
//        panel = new JPanel(new GridLayout(2, 1));
//
//        // Initialize the models
//        friendsModel = new DefaultListModel<>();
//        friendsData.forEach(friendsModel::addElement);
//
//        blockModel = new DefaultListModel<>();
//        blockData.forEach(blockModel::addElement);
//
//        // Set up the friends JList
//        stringList = new JList<>(friendsModel);
//        stringList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        JScrollPane friendScrollPane = new JScrollPane(stringList);
//        friendScrollPane.setBorder(new TitledBorder("Friends List"));
//        panel.add(friendScrollPane);
//
//        // Set up the block JList
//        blockList = new JList<>(blockModel);
//        blockList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        JScrollPane blockScrollPane = new JScrollPane(blockList);
//        blockScrollPane.setBorder(new TitledBorder("Blocked Users"));
//        panel.add(blockScrollPane);
//
//        // Create and configure the popup menu
//        popupMenu = new JPopupMenu();
//        addMenuItem("Delete Friend", this::deleteFriend);
//        addMenuItem("Block Friend", this::blockFriend);
//        addMenuItem("Contact Friend", this::contactFriend);
//
//        // Add mouse listener to the stringList for showing the popup menu
//        stringList.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (SwingUtilities.isRightMouseButton(e)) {
//                    int index = stringList.locationToIndex(e.getPoint());
//                    stringList.setSelectedIndex(index);
//                    popupMenu.show(stringList, e.getX(), e.getY());
//                }
//            }
//        });
//    }
//
//    private void addMenuItem(String title, ActionListener listener) {
//        JMenuItem menuItem = new JMenuItem(title);
//        menuItem.addActionListener(listener);
//        popupMenu.add(menuItem);
//    }
//
//    private void deleteFriend(ActionEvent e) {
//        String selectedValue = stringList.getSelectedValue();
//        JOptionPane.showMessageDialog(panel,
//                "Delete Friend: " + selectedValue,
//                "Delete Action",
//                JOptionPane.INFORMATION_MESSAGE);
//        friendsModel.removeElement(selectedValue);
//    }
//
//    private void blockFriend(ActionEvent e) {
//        String selectedValue = stringList.getSelectedValue();
//        JOptionPane.showMessageDialog(panel,
//                "Block Friend: " + selectedValue,
//                "Block Action",
//                JOptionPane.INFORMATION_MESSAGE);
//        blockModel.addElement(selectedValue);
//        friendsModel.removeElement(selectedValue);
//    }
//
//    private void contactFriend(ActionEvent e) {
//        String selectedValue = stringList.getSelectedValue();
//        JOptionPane.showMessageDialog(panel,
//                "Contact Friend: " + selectedValue,
//                "Contact Action",
//                JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    public JPanel getPanel() {
//        return panel;
//    }
//}
//
//class CreateAccountFrame extends JFrame {
//    private JPanel profile;
//    private JTextField usernameText, passwordText, ageText, gendertype, nationalityText, jobText, hobbyText;
//
//    private JButton enterButton, addfriendButton, blockButton, backButton, contactButton;
//    private JComboBox genderType;
//    private JLabel usernameLabel, passwordLabel, ageLabel, genderLabel, nationalityLabel, jobLabel, hobbyLabel;
//
//    public CreateAccountFrame(Profile userprofile, String name) {
//        profile = new JPanel(new GridLayout(1, 2));
//
//        // Left panel for photo
//        JPanel photoPanel = new JPanel();
//        JLabel photoLabel = new JLabel();
//        ImageIcon photo = new ImageIcon("/Users/xinxin/Documents/CS180-project/test/src/images copy.jpeg");  // Adjust the path accordingly
//        photoLabel.setIcon(photo);
//        photoPanel.add(photoLabel);
//        profile.add(photoPanel);
//
//        // Right panel for form fields
//        JPanel formPanel = new JPanel(new GridLayout(8, 2));  // Adjust grid layout rows and columns as needed
//
//        // Initializing all components
//        usernameLabel = new JLabel("Username");
//        usernameText = new JTextField(10);
//        usernameText.setText(userprofile.getUsername());
//        passwordLabel = new JLabel("Password");
//        passwordText = new JTextField(10);
//        passwordText.setText(userprofile.getPassword());
//
//        ageLabel = new JLabel("Age");
//        ageText = new JTextField(10);
//        ageText.setText(String.valueOf(userprofile.getAge()));
//        genderLabel = new JLabel("Gender");
//        genderType = new JComboBox<>(new String[]{"Male", "Female", "Other"});
//        genderType.setSelectedItem(userprofile.getGender());
//        nationalityLabel = new JLabel("Nationality");
//        nationalityText = new JTextField(10);
//        nationalityText.setText(userprofile.getNationality());
//        jobLabel = new JLabel("Job");
//        jobText = new JTextField(10);
//        jobText.setText(userprofile.getJob());
//        hobbyLabel = new JLabel("Hobby");
//        hobbyText = new JTextField(10);
//        hobbyText.setText(userprofile.getHobby());
//        enterButton = new JButton("Enter");
//
//        // Adding components to form panel
//        formPanel.add(usernameLabel);
//        formPanel.add(usernameText);
//        formPanel.add(passwordLabel);
//        formPanel.add(passwordText);
//        formPanel.add(ageLabel);
//        formPanel.add(ageText);
//        formPanel.add(genderLabel);
//        formPanel.add(genderType);
//        formPanel.add(nationalityLabel);
//        formPanel.add(nationalityText);
//        formPanel.add(jobLabel);
//        formPanel.add(jobText);
//        formPanel.add(hobbyLabel);
//        formPanel.add(hobbyText);
//        formPanel.add(enterButton);
//
//        profile.add(formPanel);
//    }
//    public CreateAccountFrame(Profile userProfile) {
//        profile = new JPanel(new GridLayout(1, 2));
//
//        // Left panel for photo
//        JPanel photoPanel = new JPanel();
//        JLabel photoLabel = new JLabel();
//        ImageIcon photo = new ImageIcon("/Users/xinxin/Documents/CS180-project/test/src/images copy.jpeg");  // Adjust the path accordingly
//        photoLabel.setIcon(photo);
//        photoPanel.add(photoLabel);
//        profile.add(photoPanel);
//
//        // Right panel for form fields
//        JPanel formPanel = new JPanel(new GridLayout(9, 2));  // Adjust grid layout rows and columns as needed
//
//        // Initializing all components
//        usernameLabel = new JLabel("Username");
//        usernameText = new JTextField(10);
//        usernameText.setText(userProfile.getUsername());
//
//        ageLabel = new JLabel("Age");
//        ageText = new JTextField(10);
//        ageText.setText(String.valueOf(userProfile.getAge()));
//
//        genderLabel = new JLabel("Gender");
//        gendertype = new JTextField(10);
//        gendertype.setText(userProfile.getGender());
//
//        nationalityLabel = new JLabel("Nationality");
//        nationalityText = new JTextField(10);
//        nationalityText.setText(userProfile.getNationality());
//
//        jobLabel = new JLabel("Job");
//        jobText = new JTextField(10);
//        jobText.setText(userProfile.getJob());
//        hobbyLabel = new JLabel("Hobby");
//        hobbyText = new JTextField(10);
//        hobbyText.setText(userProfile.getHobby());
//
//        addfriendButton = new JButton("Add Friend");
//        blockButton = new JButton("Block");
//        backButton = new JButton("Back");
//        contactButton = new JButton("Contact");
//
//
//        // Adding components to form panel
//        formPanel.add(usernameLabel);
//        formPanel.add(usernameText);
//        formPanel.add(passwordLabel);
//        formPanel.add(passwordText);
//        formPanel.add(ageLabel);
//        formPanel.add(ageText);
//        formPanel.add(genderLabel);
//        formPanel.add(gendertype);
//        formPanel.add(nationalityLabel);
//        formPanel.add(nationalityText);
//        formPanel.add(jobLabel);
//        formPanel.add(jobText);
//        formPanel.add(hobbyLabel);
//        formPanel.add(hobbyText);
//        formPanel.add(addfriendButton);
//        formPanel.add(blockButton);
//        formPanel.add(backButton);
//        formPanel.add(contactButton);
//
//        profile.add(formPanel);
//    }
//    public void updateUserProfile(String username) {
//        // Assume you have a method to fetch user details based on username
//        // Update the components in `profile` with the fetched details
//    }
//
//    public JPanel getProfile() {
//        return profile;
//    }
//}
//
//class DynamicSearchUI {
//    private JPanel panel;
//    private JTextField inputField;
//    private JButton searchButton;
//    private JButton viewProfileButton;
//
//    private JComboBox<String> resultCombo;
//    private List<String> allUsernames;  // This would be fetched from your database
//    private UserProfileUpdater updater;
//
//    public DynamicSearchUI(UserProfileUpdater updater, List<String> searchedUsernames ) {
//        this.updater = updater;
//        panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  // Use BoxLayout for vertical stacking
//
//        // Initialize the input text field
//        inputField = new JTextField("Search the user here", 20);
//        inputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, inputField.getPreferredSize().height));
//        inputField.setForeground(Color.GRAY);
//        inputField.addFocusListener(new FocusAdapter() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                if (inputField.getText().equals("Search the user here")) {
//                    inputField.setText("");
//                    inputField.setForeground(Color.black);
//
//                }
//            }
//            @Override
//            public void focusLost(FocusEvent e) {
//                if (inputField.getText().isEmpty()) {
//                    inputField.setText("Search the user here");
//                    inputField.setForeground(Color.GRAY);
//
//                }
//            }
//        });
//
//
//        // Initialize the combo box
//        resultCombo = new JComboBox<>();
//        resultCombo.setMaximumSize(new Dimension(Integer.MAX_VALUE, resultCombo.getPreferredSize().height));
//        allUsernames = searchedUsernames;  // Simulate fetching all usernames
//        resultCombo.addActionListener(e -> {
//            String selectedUser = (String) resultCombo.getSelectedItem();
//            updater.updateUserProfile(selectedUser);
//        });
//
//
//        // Initialize the search button
//        searchButton = new JButton("Search");
//        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);  // Ensure the button is center-aligned
//        //searchButton.addActionListener(e -> performSearch());
//        searchButton.addActionListener(e -> {
//            String searchText = inputField.getText().toLowerCase();
//            List<String> filtered = allUsernames.stream()
//                    .filter(name -> name.toLowerCase().contains(searchText))
//                    .collect(Collectors.toList());
//            updateComboBox(filtered);
//        });
//
//        // Initialize the view profile button
//        viewProfileButton = new JButton("View Profile");
//
//
//
//
//
//        // Add components to the panel
//        panel.add(inputField);
//        panel.add(Box.createRigidArea(new Dimension(0, 5))); // Add space between components
//        panel.add(resultCombo);
//        panel.add(Box.createRigidArea(new Dimension(0, 5))); // Add space between components
//        panel.add(searchButton);
//    }
//
//    private void performSearch() {
//        String searchText = inputField.getText().toLowerCase();
//        List<String> filtered = allUsernames.stream()
//                .filter(name -> name.toLowerCase().contains(searchText))
//                .collect(Collectors.toList());
//        updateComboBox(filtered);
//    }
//
//    private void updateComboBox(List<String> usernames) {
//        resultCombo.removeAllItems();
//        for (String username : usernames) {
//            resultCombo.addItem(username);
//        }
//        if (resultCombo.getItemCount() > 0) {
//            resultCombo.setSelectedIndex(0);
//        }
//    }
//    private void displayUserDetailsWindow(String username) {
//        JFrame userDetailsFrame = new JFrame(username);
//        userDetailsFrame.setSize(300, 200);
//        userDetailsFrame.setLocationRelativeTo(null);
//        userDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//        CreateAccountFrame selectedProfile = new CreateAccountFrame();
//
//        JTextArea userDetailsArea = new JTextArea();
//        userDetailsArea.setText("Details for: " + username);
//        userDetailsArea.setEditable(false);
//
//        userDetailsFrame.add(new JScrollPane(userDetailsArea));
//        userDetailsFrame.setVisible(true);
//    }
//
//    private List<String> fetchAllUsernames() {
//        // Simulated data fetch. Replace this with actual database query
//        return new ArrayList<>(List.of("Alice", "Bob", "Charlie", "David", "Evelyn"));
//    }
//
//
//    public JPanel getPanel() {
//        return panel;
//    }
//}
