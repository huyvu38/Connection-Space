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
    private Socket socket;
    public Server(Socket socket) {
        this.socket = socket;
    }
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            Database database = new Database("AllUserAccount.txt");
            database.readAllUserAccount();
            //Use these arraylist for any parameter
            ArrayList<UserAccount> allUserAccount= database.getAllUserAccount();
            while (true) {
                //When any user connect to the server
                Socket socket = serverSocket.accept();
                //make thread for client
                Thread client = new Thread(new Server(socket));
                client.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //have to make thread for each user

    //Start whenever a user connect
    public void run () {
        try {
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String command = reader.readLine();
                //Command 1 is create account
                if (command.equals("1")) {
                    boolean result = true;
                    String username = reader.readLine();
                    System.out.println(username);
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
                        Profile newUserProfile = new Profile(username, password, newAge, gender, nationality, job, hobby);
                        UserAccount newUserAccount = new UserAccount(newUserProfile);
                        //LogIn createAccount =
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

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
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
                        //System.out.println("Login in Successful");
                        return true;
                    }
                }
            }

        }
        return false;
    }
}


/*
//Main menu will have options create acc, log in, exit
                String userInputMainMenu;
                while ((userInputMainMenu = reader.readLine()) != null) {
                    if (userInputMainMenu.equals("1")) {

                    } else {

                    }
                }










 */