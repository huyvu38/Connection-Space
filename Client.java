import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
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
            Socket socket = new Socket("localhost", 5050);
            //After connect to the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Hi, welcome to the social media platform.");
            while (true) {
                System.out.println("What would you like to do?");
                System.out.println("1. Create account.");
                System.out.println("2. Log In.");
                System.out.println("3. Exit the app");
                String userInput = scanner.nextLine();
                //User want to create account -> send 1 to the server
                //User want to log in -> send 2 to the server
                writer.write(userInput);
                writer.println();
                writer.flush();
                if (userInput.equals("1")) {
                    //Send username
                    System.out.println("Once you create an account, you can not change your username.");
                    System.out.println("User name should be at least 4 characters" +
                            " and not contain any spaces or semicolon.");
                    System.out.println("Enter your username:");
                    String username = scanner.nextLine();
                    writer.write(username);
                    writer.println();
                    writer.flush();
                    //Send password
                    System.out.println("Password should be at least 6 characters " +
                            "and do not contain any spaces or semicolon.");
                    System.out.println("Enter your password:");
                    String password = scanner.nextLine();
                    writer.write(password);
                    writer.println();
                    writer.flush();
                    //Send age
                    System.out.println("Age should be a positive number");
                    System.out.println("Enter your age");
                    String age = scanner.nextLine();
                    writer.write(age);
                    writer.println();
                    writer.flush();
                    //Send gender
                    System.out.println("Enter your gender from these options:");
                    System.out.println("Female");
                    System.out.println("Male");
                    System.out.println("Other");
                    String gender = scanner.nextLine();
                    writer.write(gender);
                    writer.println();
                    //Send nationality
                    System.out.println("Nationality should not contain any spaces or semicolon.");
                    System.out.println("Enter your nationality");
                    String nationality = scanner.nextLine();
                    writer.write(nationality);
                    writer.println();
                    writer.flush();
                    //Send job
                    System.out.println("Job should not contain any spaces or semicolon.");
                    System.out.println("Enter your job");
                    String job = scanner.nextLine();
                    writer.write(job);
                    writer.println();
                    writer.flush();
                    //Send hobby
                    System.out.println("Hobby should not contain any spaces or semicolon.");
                    System.out.println("Enter your hobby");
                    String hobby = scanner.nextLine();
                    writer.write(hobby);
                    writer.println();
                    writer.flush();

                    //Get the result from the server
                    String createAccountResult = reader.readLine();
                    System.out.println(createAccountResult);
                }
                if (userInput.equals("2")) {
                    System.out.println("Enter your username");
                    String username = scanner.nextLine();
                    writer.write(username);
                    writer.println();
                    writer.flush();

                    System.out.println("Enter your password");
                    String password = scanner.nextLine();
                    //Sent to the server
                    writer.write(password);
                    writer.println();
                    writer.flush();

                    //Receive the result from the server
                    String result = reader.readLine();
                    System.out.println(result);
                    if (result.equals("Log in successfully")) {
                        while (true) {
                            System.out.println("What would you like to do? ");
                            System.out.println("1. View your profile");
                            System.out.println("2. Edit your profile");
                            System.out.println("3. Add friend");
                            System.out.println("4. Delete friend");
                            System.out.println("5. Block user");
                            System.out.println("6. Unblock user");
                            System.out.println("7. Send message");
                            System.out.println("8. Search other user");
                            System.out.println("9. View other user profile");
                            System.out.println("10. Log out");
                            String choice = scanner.nextLine();
                            //Send choice to the server
                            writer.write(choice);
                            writer.println();
                            writer.flush();
                            if (choice.equals("1")) {
                                System.out.println("Which information do you want to see");
                                System.out.println("1. Age");
                                System.out.println("2. Gender");
                                System.out.println("3. Nationality");
                                System.out.println("4. Job");
                                System.out.println("5. Hobby");
                                //Send the information that want to view
                                String viewInformationChoice = scanner.nextLine();
                                writer.write(viewInformationChoice);
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

                                writer.write(editChoice);
                                writer.println();
                                writer.flush();

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
                                //Send information that want to edit to server
                                String editInformation = scanner.nextLine();
                                writer.write(editInformation);
                                writer.println();
                                writer.flush();
                                //Get the result from the server
                                String editResult = reader.readLine();
                                System.out.println(editResult);
                            }
                            if (choice.equals("3")) {
                                System.out.println("Enter the user that you want to add friend");
                                String addFriendUserName = scanner.nextLine();
                                //Send username that want to add friend to server
                                writer.write(addFriendUserName);
                                writer.println();
                                writer.flush();
                                String addFriendResult = reader.readLine();
                                System.out.println(addFriendResult);
                            }
                            if (choice.equals("4")) {
                                System.out.println("Enter the user that you want to unfriend");
                                String unfriendUserName = scanner.nextLine();
                                //Send username that want to unfriend to server
                                writer.write(unfriendUserName);
                                writer.println();
                                writer.flush();
                                String unfriendResult = reader.readLine();
                                System.out.println(unfriendResult);
                            }
                            if (choice.equals("5")) {
                                System.out.println("Enter the user that you want to block");
                                String blockUserName = scanner.nextLine();
                                //Send username that want to block to server
                                writer.write(blockUserName);
                                writer.println();
                                writer.flush();
                                String blockResult = reader.readLine();
                                System.out.println(blockResult);
                            }
                            if (choice.equals("6")) {
                                System.out.println("Enter the user that you want to unblock");
                                String unblockUserName = scanner.nextLine();
                                //Send username that want to unblock to server
                                writer.write(unblockUserName);
                                writer.println();
                                writer.flush();
                                String unblockResult = reader.readLine();
                                System.out.println(unblockResult);
                            }
                            if (choice.equals("7")) {
                                writer.write(username);
                                writer.println();
                                writer.flush();
                                int ans;
                                boolean hasFriends = Boolean.parseBoolean(reader.readLine());
                                if (hasFriends) {
                                    System.out.println("Select your choice:");
                                    System.out.println("1. Send Message to specific user");
                                    System.out.println("2. Send message only to friends");
                                    System.out.println("3. Print history message");
                                    ans = scanner.nextInt();
                                    scanner.nextLine();
                                    String converted = String.valueOf(ans);
                                    writer.write(converted);
                                    writer.println();
                                    writer.flush();
                                    if (ans == 1) {
                                        System.out.println("Who you want to send message to?");
                                        String receiver = scanner.nextLine();
                                        writer.write(receiver);
                                        writer.println();
                                        writer.flush();
                                        System.out.println("What message do you want to send?");
                                        String message = scanner.nextLine();
                                        writer.write(message);
                                        writer.println();
                                        writer.flush();
                                        System.out.println(reader.readLine());

                                    } else if (ans == 2) {
                                        System.out.println("What message do you want to send?");
                                        String message = scanner.nextLine();
                                        writer.write(message);
                                        writer.println();
                                        writer.flush();
                                        String result1 = reader.readLine();
                                        System.out.println(Objects.requireNonNullElse(result1,
                                                "Message sent successfully"));

                                    } else if (ans == 3) {
                                        String ans2;

                                        System.out.println("Who do you want to print the conversation with?");
                                        String name = scanner.nextLine();
                                        writer.write(name);
                                        writer.println();
                                        writer.flush();

                                        String sentMsg = reader.readLine();
                                        while (!sentMsg.equals("end")) {
                                            System.out.println(sentMsg); // Assuming that the response is a single line
                                            sentMsg = reader.readLine();
                                        }

                                        System.out.println("Do you want to delete any message?");
                                        System.out.println("1. Yes");
                                        System.out.println("2. No");
                                        String ans1 = scanner.nextLine();
                                        writer.write(ans1);
                                        writer.println();
                                        writer.flush();
                                        if (ans1.equals("1")) {
                                            System.out.println("Please enter the conversationID");
                                            String conversationID = scanner.nextLine();
                                            writer.write(conversationID);
                                            writer.println();
                                            writer.flush();
                                            System.out.println(reader.readLine());
                                        }


                                    } else {
                                        System.out.println("Please enter a valid input");
                                    }
                                } else {
                                    System.out.println("Please add friend first");
                                }

                            }
                            if (choice.equals("8")) {
                                System.out.println("Enter the word to search user");
                                //Send the word to server so server check if any username contains that word
                                String word = scanner.nextLine();
                                writer.write(word);
                                writer.println();
                                writer.flush();
                                //Get all the username that contain the word from the server
                                String searchResult = reader.readLine();
                                System.out.println(searchResult);
                            }
                            if (choice.equals("9")) {
                                System.out.println("Enter the user that you want to view their profile");
                                //The client only view user from the previous search result
                                String userNameToViewProfile = scanner.nextLine();
                                writer.write(userNameToViewProfile);
                                writer.println();
                                writer.flush();
                                String viewResult = reader.readLine();
                                System.out.println(viewResult);
                                if (viewResult.equals("Which information do you want to see?")) {
                                    System.out.println("1. Age");
                                    System.out.println("2. Gender");
                                    System.out.println("3. Nationality");
                                    System.out.println("4. Job");
                                    System.out.println("5. Hobby");

                                    String viewOtherProfileChoice = scanner.nextLine();
                                    writer.write(viewOtherProfileChoice);
                                    writer.println();
                                    writer.flush();

                                    String viewOtherProfileResult = reader.readLine();
                                    System.out.println(viewOtherProfileResult);
                                }
                            }
                            if (choice.equals("10")) {
                                break;
                            }
                        }
                    }
                }
                //Exit
                if (userInput.equals("3")) {
                    writer.close();
                    reader.close();
                    socket.close();
                    break;
                }
            }
        } catch (Exception e){
            System.out.println("Can not connect to the server");
        }
    }

}