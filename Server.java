import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Team Project
 *
 * Server.java
 *
 * @author Gabe Turner, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class Server implements Runnable {
    Socket socket;
    public static Database database;
    public static ArrayList<UserAccount> allUserAccount;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4242);
        database = new Database("AllUserAccount.txt");
        database.readAllUserAccount();
        //Use these arraylist for any parameter
        allUserAccount = database.getAllUserAccount();
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("Connected");
                //make thread for client
                Thread client = new Thread(new Server(socket));
                client.start();
            } catch (Exception e) {
                socket.close();
                e.printStackTrace();
            }
        }
    }

    //Start whenever a user connect
    public void run () {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            while (true) {
                String command = reader.readLine();
                //Command 1 is create account
                if (command.equals("1")) {
                    boolean result = true;
                    String username = reader.readLine();
                    String password = reader.readLine();
                    String age = reader.readLine();
                    String gender = reader.readLine();
                    String nationality = reader.readLine();
                    String job = reader.readLine();
                    String hobby = reader.readLine();
                    if (username.contains(" ") || username.contains(";")) {
                        result = false;
                    }
                    if (password.contains(" ") || password.contains(";")) {
                        result = false;
                    }
                    if (nationality.contains(" ") || nationality.contains(";")) {
                        result = false;
                    }
                    if (job.contains(" ") || job.contains(";")) {
                        result = false;
                    }
                    if (hobby.contains(" ") || hobby.contains(";")) {
                        result = false;
                    }
                    int newAge = 0;
                    try {
                        newAge = Integer.parseInt(age);
                    } catch (NumberFormatException e) {
                        result = false;
                    }
                    if (newAge < 0) {
                        result = false;
                    }
                    //If the user enter all valid information -> the result still true
                    //Then check if the username is valid to create a new Profile
                    if (result) {

                        //After create account successfully
                        Profile newUserProfile = new Profile(username, password, newAge, gender, nationality, job, hobby);
                        UserAccount newUserAccount = new UserAccount(newUserProfile);

                    }
                    //if the result is still true -> send back to the client that account create successfully
                    if (result) {
                        writer.write("Create Account successfully. You have to log in again");
                        writer.println();
                        writer.flush();
                    } else {
                        writer.write("The account is already exist or you enter wrong information.");
                        writer.println();
                        writer.flush();
                    }
                }
                //Command 2 is log in
                if (command.equals("2")) {
                    String username = reader.readLine();
                    String password = reader.readLine();
                    //Log in success
                    if (database.loginAccount(username, password)) {
                        writer.write("Log in successfully");
                        writer.println();
                        writer.flush();
                        while (true) {
                            String choice = reader.readLine();
                            if (choice.equals("1")) {
                                String viewChoice = reader.readLine();
                                for (UserAccount userAccount : allUserAccount) {
                                    if (userAccount.getUserProfile().getUserName().equals(username)) {
                                        if (viewChoice.equals("1")) {
                                            writer.write(userAccount.getUserProfile().getUserName());
                                        }
                                        if (viewChoice.equals("2")) {
                                            writer.write(userAccount.getUserProfile().getPassword());
                                        }
                                        if (viewChoice.equals("3")) {
                                            writer.write(userAccount.getUserProfile().getAge());
                                        }
                                        if (viewChoice.equals("4")) {
                                            writer.write(userAccount.getUserProfile().getGender());
                                        }
                                        if (viewChoice.equals("5")) {
                                            writer.write(userAccount.getUserProfile().getNationality());
                                        }
                                        if (viewChoice.equals("6")) {
                                            writer.write(userAccount.getUserProfile().getJob());
                                        }
                                        if (viewChoice.equals("7")) {
                                            writer.write(userAccount.getUserProfile().getHobby());
                                        }
                                        writer.println();
                                        writer.flush();
                                    }
                                }
                            }
                            if (choice.equals("2")) {
                                String editChoice = reader.readLine();
                                String editInformation = reader.readLine();
                                for (UserAccount userAccount : allUserAccount) {
                                    if (userAccount.getUserProfile().getUserName().equals(username)) {
                                        if (editChoice.equals("1")) {
                                            if (editInformation.contains(" ") || editInformation.contains(";")) {
                                                writer.write("Can not edit your information");
                                            } else {
                                                if (editInformation.length() < 6) {
                                                    writer.write("Can not edit your information");
                                                } else {
                                                    userAccount.getUserProfile().setPassword(editInformation);
                                                    writer.write("Edit successfully");
                                                }
                                            }
                                        }
                                        if (editChoice.equals("2")) {
                                            try {
                                                int editAge = Integer.parseInt(editInformation);
                                                if (editAge > 0) {
                                                    userAccount.getUserProfile().setAge(editAge);
                                                    writer.write("Edit successfully");
                                                } else {
                                                    writer.write("Can not edit your information");
                                                }
                                            } catch (Exception e) {
                                                writer.write("Can not edit your information");
                                            }
                                        }
                                        if (editChoice.equals("3")) {
                                            userAccount.getUserProfile().setGender(editInformation);
                                            writer.write("Edit successfully");
                                        }
                                        if (editChoice.equals("4")) {
                                            if (editInformation.contains(" ") || editInformation.contains(";")) {
                                                writer.write("Can not edit your information");
                                            } else {
                                                userAccount.getUserProfile().setNationality(editInformation);
                                                writer.write("Edit successfully");
                                            }
                                        }
                                        if (editChoice.equals("5")) {
                                            if (editInformation.contains(" ") || editInformation.contains(";")) {
                                                writer.write("Can not edit your information");
                                            } else {
                                                userAccount.getUserProfile().setJob(editInformation);
                                                writer.write("Edit successfully");
                                            }
                                        }
                                        if (editChoice.equals("6")) {
                                            if (editInformation.contains(" ") || editInformation.contains(";")) {
                                                writer.write("Can not edit your information");
                                            } else {
                                                userAccount.getUserProfile().setHobby(editInformation);
                                                writer.write("Edit successfully");
                                            }
                                        }
                                    }
                                }
                                writer.println();
                                writer.flush();
                                database.saveAllUserAccount();
                            }
                            if (choice.equals("3")) {

                            }
                            if (choice.equals("4")) {

                            }
                            if (choice.equals("5")) {
                                String addFriendUserName = reader.readLine();
                                if (database.addFriend(username, addFriendUserName)) {
                                    writer.write("Add friend successfully");
                                    database.saveAllUserAccount();
                                } else {
                                    writer.write("You can not add that user");
                                }
                                writer.println();
                                writer.flush();
                            }
                            if (choice.equals("6")) {
                                String unfriendUserName = reader.readLine();
                                if (database.deleteFriend(username, unfriendUserName)) {
                                    writer.write("Unfriend successfully");
                                    database.saveAllUserAccount();
                                } else {
                                    writer.write("You can not unfriend that user");
                                }
                                writer.println();
                                writer.flush();
                            }
                            if (choice.equals("7")) {
                                String blockUserName = reader.readLine();
                                if (database.blockUser(username, blockUserName)) {
                                    writer.write("Block successfully");
                                    //If both users are friend then delete after block
                                    database.deleteFriend(username, blockUserName);
                                    database.saveAllUserAccount();
                                } else {
                                    writer.write("You can not block that user");
                                }
                                writer.println();
                                writer.flush();
                            }
                            if (choice.equals("8")) {
                                String unblockUserName = reader.readLine();
                                if (database.unblockUser(username, unblockUserName)) {
                                    writer.write("Unblock successfully");
                                    database.saveAllUserAccount();
                                } else {
                                    writer.write("You can not unblock that user");
                                }
                                writer.println();
                                writer.flush();

                            }
                            if (choice.equals("9")) {

                            }
                            if (choice.equals("10")) {

                            }
                            if (choice.equals("11")) {
                                break;
                            }
                        }
                    } else {
                        writer.write("Log in failure");
                        writer.println();
                        writer.flush();
                    }
                }
            }
        } catch (Exception f) {
            System.out.println("A User is disconnect");
            f.printStackTrace();
        }
    }




    synchronized boolean createAccount(Database database, UserAccount userAccount) {
        try {
            ArrayList<UserAccount> temp = database.getAllUserAccount();
            temp.add(userAccount);
            database.setAllUserAccount(temp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    synchronized boolean isValidUserName(ArrayList<UserAccount> allUserList, String usersName) {
        for (UserAccount eachProfile : allUserList) {
            if (eachProfile.getUserProfile().getUserName().equals(usersName)) {
                return false;
            }
        }
        return true;
    }

    synchronized boolean checkIfPasswordCorrect(Profile profile, String userPassword) {
        return profile.getPassword().equals(userPassword);
    }
    synchronized boolean checkPasswordLength(String password) {
        return password.length() >= 6 && !password.contains(" ") && !password.contains(";");
    }
    synchronized boolean checkUserNameFormat(String userName) {
        return userName.length() >= 4 && !userName.contains(" ") && !userName.contains(";");

    }


    synchronized boolean deleteAccount(Database data, UserAccount userAccount, String enteredPassword) {
        if (checkIfPasswordCorrect(userAccount.getUserProfile(), enteredPassword)) {

            ArrayList<UserAccount> userList = data.getAllUserAccount();

            userList.remove(userAccount);

            data.setAllUserAccount(userList);
            return true;

        }
        return false;
    }



    synchronized boolean loginAccount(Database database, String username, String userPassword) {
        if (isValidUserName(database.getAllUserAccount(), username)) {
            for (UserAccount eachUserAccount: database.getAllUserAccount()) {
                if (eachUserAccount.getUserProfile().getUserName().equals(username)) {
                    if (eachUserAccount.getUserProfile().getPassword().equals(userPassword)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }
}