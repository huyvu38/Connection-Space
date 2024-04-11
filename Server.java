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
public class Server {
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
            ArrayList<Profile> allUserProfile = database.getAllUserProfile();
            ArrayList<UserAccount> allUserAccount= database.getAllUserAccount();
            while (true) {
                //When any user connect to the server
                Socket socket = serverSocket.accept();
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

                }
                //Command 2 is log in
                if (command.equals("2")) {

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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