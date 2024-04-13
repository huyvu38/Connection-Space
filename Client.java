import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Team Project
 *
 * Client.java
 *
 * @author Gabe Turner, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 4242);
            //After connect to the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Hi, welcome to the social media platform.");
            while (true) {
                System.out.println("What would you like to do?");
                System.out.println("1. Create account.");
                System.out.println("2. Log In.");
                String userInput = scanner.nextLine();
                //User want to create account -> send 1 to the server
                //User want to logIn -> send 2 to the server
                if (userInput == null) {
                    writer.close();
                    reader.close();
                }
                if (userInput.equals("1")) {
                    System.out.println("Enter your username:");
                    String username = scanner.nextLine();
                    System.out.println("Enter your password");
                    String password = scanner.nextLine();
                    System.out.println("Enter your age");
                    String age = scanner.nextLine();
                    System.out.println("Enter your gender from these options:");
                    System.out.println("Female");
                    System.out.println("Male");
                    System.out.println("Other");
                    String gender = scanner.nextLine();
                    System.out.println("Enter your nationality");
                    String nationality = scanner.nextLine();
                    System.out.println("Enter your job");
                    String job = scanner.nextLine();
                    System.out.println("Enter your hobby");
                    String hobby = scanner.nextLine();
                    //Send all information to the server
                    writer.write("1");
                    writer.println();
                    writer.write(username);
                    writer.println();
                    writer.write(password);
                    writer.println();
                    writer.write(age);
                    writer.println();
                    writer.write(gender);
                    writer.println();
                    writer.write(nationality);
                    writer.println();
                    writer.write(job);
                    writer.println();
                    writer.write(hobby);
                    writer.println();
                    writer.flush(); // ensure data is sent to the server
                    //Get the result from the server
                    String result = reader.readLine();
                    System.out.println(result);
                }
                if (userInput.equals("2")) {
                    System.out.println("Enter your username");
                    String username = scanner.nextLine();
                    System.out.println("Enter your password");
                    String password = scanner.nextLine();
                    //Sent to the server
                    writer.write("2");
                    writer.println();
                    writer.write(username);
                    writer.println();
                    writer.write(password);
                    writer.println();
                    writer.flush(); // ensure data is sent to the server

                    //Receive the result from the server
                    String result = reader.readLine();
                    System.out.println(result);
                    if (result.equals("Log in successfully")) {
                        while (true) {
                            System.out.println("What would you like to do? ");
                            System.out.println("1. View your profile");
                            System.out.println("2. Edit your profile");
                            System.out.println("3. View other user profile");
                            System.out.println("4. Delete account");
                            System.out.println("5. Add friend");
                            System.out.println("6. Delete friend");
                            System.out.println("7. Block user");
                            System.out.println("8. Unblock user");
                            System.out.println("9. Send message");
                            System.out.println("10. Search other user");
                            System.out.println("11. Log out");
                            String choice = scanner.nextLine();
                            if (choice.equals("1")) {
                                System.out.println("Which information do you want to see");
                                System.out.println("1. Username");
                                System.out.println("2. Password");
                                System.out.println("3. Age");
                                System.out.println("4. Gender");
                                System.out.println("5. Nationality");
                                System.out.println("6. Job");
                                System.out.println("7. Hobby");
                                String viewChoice = scanner.nextLine();
                                writer.write(choice);
                                writer.println();
                                writer.write(viewChoice);
                                writer.println();
                                writer.flush();
                                String viewResult = reader.readLine();
                                System.out.println(viewResult);
                            }
                            if (choice.equals("2")) {
                                System.out.println("Which information do you want to edit");
                                System.out.println("1. Password");
                                System.out.println("2. Age");
                                System.out.println("3. Gender");
                                System.out.println("4. Nationality");
                                System.out.println("5. Job");
                                System.out.println("6. Hobby");
                                String editChoice = scanner.nextLine();
                                if (editChoice.equals("1")) {
                                    System.out.println("Enter new password");
                                }
                                if (editChoice.equals("2")) {
                                    System.out.println("Enter your age");
                                }
                                if (editChoice.equals("3")) {
                                    System.out.println("Enter your gender from these options:");
                                    System.out.println("Female");
                                    System.out.println("Male");
                                    System.out.println("Other");
                                }
                                if (editChoice.equals("4")) {
                                    System.out.println("Enter your nationality");
                                }
                                if (editChoice.equals("5")) {
                                    System.out.println("Enter your job");
                                }
                                if (editChoice.equals("6")) {
                                    System.out.println("Enter your hobby");
                                }
                                String editInformation = scanner.nextLine();
                                writer.write(choice);
                                writer.println();
                                writer.write(editChoice);
                                writer.println();
                                writer.write(editInformation);
                                writer.println();
                                writer.flush();
                                String editResult = reader.readLine();
                                System.out.println(editResult);
                            }
                            if (choice.equals("3")) {

                            }
                            if (choice.equals("4")) {

                            }
                            if (choice.equals("5")) {
                                System.out.println("Enter the user that you want to add friend");
                                String addFriendUserName = scanner.nextLine();
                                writer.write(choice);
                                writer.println();
                                writer.write(addFriendUserName);
                                writer.println();
                                writer.flush();
                                String addFriendResult = reader.readLine();
                                System.out.println(addFriendResult);
                            }
                            if (choice.equals("6")) {
                                System.out.println("Enter the user that you want to unfriend");
                                String unfriendUserName = scanner.nextLine();
                                writer.write(choice);
                                writer.println();
                                writer.write(unfriendUserName);
                                writer.println();
                                writer.flush();
                                String unfriendResult = reader.readLine();
                                System.out.println(unfriendResult);
                            }
                            if (choice.equals("7")) {
                                System.out.println("Enter the user that you want to block");
                                String blockUserName = scanner.nextLine();
                                writer.write(choice);
                                writer.println();
                                writer.write(blockUserName);
                                writer.println();
                                writer.flush();
                                String blockResult = reader.readLine();
                                System.out.println(blockResult);

                            }
                            if (choice.equals("8")) {
                                System.out.println("Enter the user that you want to unblock");
                                String unblockUserName = scanner.nextLine();
                                writer.write(choice);
                                writer.println();
                                writer.write(unblockUserName);
                                writer.println();
                                writer.flush();
                                String unblockResult = reader.readLine();
                                System.out.println(unblockResult);
                            }
                            if (choice.equals("9")) {

                            }
                            if (choice.equals("10")) {

                            }
                            if (choice.equals("11")) {
                                writer.write("11");
                                writer.println();
                                writer.flush();
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e){
            System.out.println("Can not connect to the server");
        }
    }
}