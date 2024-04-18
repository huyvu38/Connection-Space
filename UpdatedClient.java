import javax.swing.*;
import java.io.*;
import java.net.Socket;

//VIEW PROFILE NON-FUNCTIONAL IDK WHY - Gabe
public class UpdatedClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5050);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            JOptionPane.showMessageDialog(null, "Hi, welcome to the social media platform.");

            while (true) {
                String[] options = {"Create account", "Log In", "Exit the app"};
                String userInput = (String) JOptionPane.showInputDialog(null, "What would you like to do?",
                        "Options", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if (userInput == null || "Exit the app".equals(userInput)) {
                    break;
                }

                switch (userInput) {
                    case "Create account":
                        createAccount(writer, reader);
                        break;
                    case "Log In":
                        if (logIn(writer, reader)) {
                            manageAccount(writer, reader);
                        }
                        break;
                }
            }

            writer.close();
            reader.close();
            socket.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to the server.",
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void createAccount(PrintWriter writer, BufferedReader reader) throws IOException {
        String username = JOptionPane.showInputDialog("Enter your username (at least 4 characters, no spaces/semicolons):");
        String password = JOptionPane.showInputDialog("Enter your password (at least 6 characters, no spaces/semicolons):");
        String age = JOptionPane.showInputDialog("Enter your age (must be a positive number):");
        String[] genders = {"Female", "Male", "Other"};
        String gender = (String) JOptionPane.showInputDialog(null, "Select your gender:",
                "Gender", JOptionPane.QUESTION_MESSAGE, null, genders, genders[0]);
        String nationality = JOptionPane.showInputDialog("Enter your nationality (no spaces/semicolons):");
        String job = JOptionPane.showInputDialog("Enter your job (no spaces/semicolons):");
        String hobby = JOptionPane.showInputDialog("Enter your hobby (no spaces/semicolons):");

        writer.println("1");
        writer.println(username);
        writer.println(password);
        writer.println(age);
        writer.println(gender);
        writer.println(nationality);
        writer.println(job);
        writer.println(hobby);

        String result = reader.readLine();
        JOptionPane.showMessageDialog(null, result);
    }

    private static boolean logIn(PrintWriter writer, BufferedReader reader) throws IOException {
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");

        writer.println("2");
        writer.println(username);
        writer.println(password);

        String result = reader.readLine();
        JOptionPane.showMessageDialog(null, result);

        return "Log in successfully".equals(result);
    }

    private static void manageAccount(PrintWriter writer, BufferedReader reader) throws IOException {
        String[] choices = {"View your profile", "Edit your profile", "Add friend", "Delete friend", "Block user",
                "Unblock user", "Send message", "Search other user", "View other user profile", "Log out"};
        boolean continueSession = true;

        while (continueSession) {
            String choice = (String) JOptionPane.showInputDialog(null, "What would you like to do?", "User Actions",
                    JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
            if ("Log out".equals(choice)) {
                break;
            }

            int actionIndex = java.util.Arrays.asList(choices).indexOf(choice) + 1;
            writer.println(actionIndex);

            handleUserAction(actionIndex, writer, reader);
        }
    }

    private static void handleUserAction(int actionIndex, PrintWriter writer, BufferedReader reader) throws IOException {
        // Direct mapping of user actions to handling methods using GUI
        switch (actionIndex) {
            case 1: // View
                viewProfile(writer, reader);
                break;
            case 2: // Edit <-- nonfunctional
                editProfile(writer, reader);
                break;
            case 3: // Add
                addFriend(writer, reader);
                break;
            case 4: // Delete
                deleteFriend(writer, reader);
                break;
            case 5: // Block
                blockUser(writer, reader);
                break;
            case 6: // Unblock
                unblockUser(writer, reader);
                break;
            case 7: // Send
                sendMessage(writer, reader);
                break;
            case 8: // Search
                searchUser(writer, reader);
                break;
            case 9: // View other
                viewOtherUserProfile(writer, reader);
                break;
            case 10: // Log out
                JOptionPane.showMessageDialog(null, "Logging out...");
                break;
        }
    }

    private static void addFriend(PrintWriter writer, BufferedReader reader) throws IOException {
        String friendUsername = JOptionPane.showInputDialog("Enter the username of the user you want to add as a friend:");
        if (friendUsername != null && !friendUsername.isEmpty()) {
            writer.println("3");
            writer.println(friendUsername);
            writer.flush();

            String response = reader.readLine();
            JOptionPane.showMessageDialog(null, response);
        }
    }

    private static void deleteFriend(PrintWriter writer, BufferedReader reader) throws IOException {
        String friendUsername = JOptionPane.showInputDialog("Enter the username of the friend you want to remove:");
        if (friendUsername != null && !friendUsername.isEmpty()) {
            writer.println("4");
            writer.println(friendUsername);
            writer.flush();

            String response = reader.readLine();
            JOptionPane.showMessageDialog(null, response);
        }
    }

    private static void blockUser(PrintWriter writer, BufferedReader reader) throws IOException {
        String blockUsername = JOptionPane.showInputDialog("Enter the username of the user you want to block:");
        if (blockUsername != null && !blockUsername.isEmpty()) {
            writer.println("5");
            writer.println(blockUsername);
            writer.flush();

            String response = reader.readLine();
            JOptionPane.showMessageDialog(null, response);
        }
    }

    private static void unblockUser(PrintWriter writer, BufferedReader reader) throws IOException {
        String unblockUsername = JOptionPane.showInputDialog("Enter the username of the user you want to unblock:");
        if (unblockUsername != null && !unblockUsername.isEmpty()) {
            writer.println("6");
            writer.println(unblockUsername);
            writer.flush();

            String response = reader.readLine();
            JOptionPane.showMessageDialog(null, response);
        }
    }

    private static void sendMessage(PrintWriter writer, BufferedReader reader) throws IOException {
        String recipientUsername = JOptionPane.showInputDialog("Enter the username of the user you want to send a message to:");
        String message = JOptionPane.showInputDialog("Enter the message:");
        if (recipientUsername != null && !recipientUsername.isEmpty() && message != null) {
            writer.println("7");
            writer.println(recipientUsername);
            writer.println(message);
            writer.flush();

            String response = reader.readLine();
            JOptionPane.showMessageDialog(null, response);
        }
    }

    private static void searchUser(PrintWriter writer, BufferedReader reader) throws IOException {
        String query = JOptionPane.showInputDialog("Enter the username or part of it to search:");
        if (query != null && !query.isEmpty()) {
            writer.println("8");
            writer.println(query);
            writer.flush();

            String response = reader.readLine();
            JOptionPane.showMessageDialog(null, response);
        }
    }

    private static void viewOtherUserProfile(PrintWriter writer, BufferedReader reader) throws IOException {
        String username = JOptionPane.showInputDialog("Enter the username whose profile you want to view:");
        if (username != null && !username.isEmpty()) {
            writer.println("9");
            writer.println(username);
            writer.flush();

            String response = reader.readLine();
            JOptionPane.showMessageDialog(null, response);
        }
    }

    private static void viewProfile(PrintWriter writer, BufferedReader reader) throws IOException {
        writer.println("1");
        writer.flush();

        String response = reader.readLine();
        JOptionPane.showMessageDialog(null, response);
    }

    private static void editProfile(PrintWriter writer, BufferedReader reader) throws IOException { //Not working
        String[] profileOptions = {"Password", "Age", "Gender", "Nationality", "Job", "Hobby"};
        String choice = (String) JOptionPane.showInputDialog(null, "Which information do you want to edit?",
                "Edit Profile", JOptionPane.QUESTION_MESSAGE, null, profileOptions, profileOptions[0]);
        if (choice != null) {
            String newValue = JOptionPane.showInputDialog("Enter new " + choice + ":");
            if (newValue != null && !newValue.isEmpty()) {
                writer.println("2");
                writer.println(choice);
                writer.println(newValue);
                writer.flush();

                String response = reader.readLine();
                JOptionPane.showMessageDialog(null, response);
            }
        }
    }



}
