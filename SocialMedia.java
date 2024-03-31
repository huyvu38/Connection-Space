import java.util.ArrayList;
import java.util.Scanner;
/**
 * Team Project
 *
 * SocialMedia.java
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */

public class SocialMedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, welcome to the social media platform.");
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Create account.");
            System.out.println("2. Log In.");
            System.out.println("3. Exit the app.");
            String userInput = scanner.nextLine();
            if (userInput.equals("1")) {
                while (true) {
                    Database databaseSocialMedia = new Database("AllUserAccount.txt");
                    databaseSocialMedia.readAllUserAccount();
                    ArrayList<Profile> allUserProfile = databaseSocialMedia.getAllUserProfile();
                    System.out.println("Once you create an account, you can not change your username.");
                    System.out.println("User name should be at least 4 characters and do not contain any spaces.");
                    System.out.println("Enter your username:");
                    String userName = scanner.nextLine();
                    System.out.println("Password should be at least 6 characters.");
                    System.out.println("Enter your password:");
                    String password = scanner.nextLine();
                    int newAge = 0;
                    while (true) {
                        System.out.println("Age should be a number greater than 0.");
                        System.out.println("Enter your age:");
                        String age = scanner.nextLine();
                        try {
                            newAge = Integer.parseInt(age);
                            if (newAge <= 0) {
                                System.out.println("Please enter a valid number.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                    }
                    String gender = "";
                    while (true) {
                        System.out.println("Enter your gender from these options:");
                        System.out.println("Female");
                        System.out.println("Male");
                        System.out.println("Other");
                        gender = scanner.nextLine();
                        if (gender.equals("Female") || gender.equals("Male") || gender.equals("Other")) {
                            break;
                        } else {
                            System.out.println("Please enter the right command.");
                        }
                    }
                    System.out.println("Enter your nationality:");
                    String nationality = scanner.nextLine();
                    System.out.println("Enter your job:");
                    String job = scanner.nextLine();
                    System.out.println("Enter your hobby:");
                    String hobby = scanner.nextLine();
                    // Assuming Profile and UserAccount classes are defined
                    Profile newProfile = new Profile(userName, password, newAge, gender, nationality, job, hobby);
                    UserAccount newUserAccount = new UserAccount(newProfile);
                    LogIn newCreateAccount = new LogIn(databaseSocialMedia, newProfile, userName, password);
                    if (newCreateAccount.createAccount(databaseSocialMedia, newProfile)) {
                        databaseSocialMedia.getAllUserAccount().add(newUserAccount);
                        databaseSocialMedia.getAllUserProfile().add(newProfile);
                        databaseSocialMedia.saveAllUserAccount();
                        System.out.println("Create account success.");
                        System.out.println("You have to log in again.");
                        break;
                    } else {
                        System.out.println("Fail to create account.");
                    }
                }
            } else if (userInput.equals("2")) {
                // Assuming Database class is defined
                Database databaseSocialMedia = new Database("AllUserAccount.txt");
                databaseSocialMedia.readAllUserAccount();
                ArrayList<Profile> allUserProfile = databaseSocialMedia.getAllUserProfile();
                ArrayList<UserAccount> allUserAccount = databaseSocialMedia.getAllUserAccount();
                System.out.println("Enter your username");
                String userName = scanner.nextLine();
                System.out.println("Enter your password");
                String password = scanner.nextLine();
                //If the username exists
                for (Profile eachProfile : allUserProfile) {
                    if (eachProfile.getUserName().equals(userName)) {
                        LogIn newLogInAccount = new LogIn(databaseSocialMedia, eachProfile, userName, password);
                        if (newLogInAccount.loginAccount(databaseSocialMedia, eachProfile, userName, password)) {
                            System.out.println("Log In successfully.");
                            //After user log in
                            while (true) {
                                System.out.println("What would you like to do?");
                                System.out.println("1. View your profile");
                                System.out.println("2. Edit your profile");
                                System.out.println("3. Delete account");
                                System.out.println("4. Add friend");
                                System.out.println("5. Delete friend");
                                System.out.println("6. Block friend");
                                System.out.println("7. Unblock friend");
                                System.out.println("8. Send message");
                                System.out.println("9. Log out");
                                userInput = scanner.nextLine();
                                if (userInput.equals("1")) {
                                    System.out.println("Which information do you want to see");
                                    System.out.println("1. Username");
                                    System.out.println("2. Password");
                                    System.out.println("3. Age");
                                    System.out.println("4. Gender");
                                    System.out.println("5. Nationality");
                                    System.out.println("6. Job");
                                    System.out.println("7. Hobby");
                                    while (true) {
                                        userInput = scanner.nextLine();
                                        if (userInput.equals("1")) {
                                            System.out.println();
                                            break;
                                        } else if (userInput.equals("2")) {
                                            System.out.println();
                                            break;
                                        } else if (userInput.equals("3")) {
                                            System.out.println();
                                            break;
                                        } else if (userInput.equals("4")) {
                                            System.out.println();
                                            break;
                                        } else if (userInput.equals("5")) {
                                            System.out.println();
                                            break;
                                        } else if (userInput.equals("6")) {
                                            System.out.println();
                                            break;
                                        } else if (userInput.equals("7")) {
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println("Please enter the right command.");
                                        }
                                    }
                        /*
                        for (Profile userProfile : database.getAllUserProfile()) {
                            if (userProfile.getUserName().equals(userName)) {
                                System.out.println(userProfile);
                            }
                        }
                         */
                                    //Maybe return every information of user
                                } else if (userInput.equals("2")) {
                                    while (true) {
                                        System.out.println("Which information do you want to edit");
                                        System.out.println("1. Password");
                                        System.out.println("2. Age");
                                        System.out.println("3. Gender");
                                        System.out.println("4. Nationality");
                                        System.out.println("5. Job");
                                        System.out.println("6. Hobby");
                                        userInput = scanner.nextLine();
                                        if (userInput.equals("1")) {
                                            System.out.println("Enter new password");
                                            userInput = scanner.nextLine();
                                /*
                                for (Profile userProfile : database.getAllUserProfile()) {
                                    if (userProfile.getUserName().equals(userInput)) {
                                        userProfile.setUserName(userInput);
                                    }
                                }
                                System.out.println("Edit password successfully");
                                 */
                                            break;
                                        } else if (userInput.equals("2")) {
                                            int newAge = 0;
                                            while (true) {
                                                System.out.println("Enter your age");
                                                String age = scanner.nextLine();
                                                try {
                                                    newAge = Integer.parseInt(age);
                                                    if (newAge <= 0) {
                                                        System.out.println("Please enter a valid number");
                                                    } else {
                                                        break;
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Please enter a valid number");
                                                }
                                            }
                                            break;
                                /*
                                for (Profile userProfile : database.getAllUserProfile()) {
                                    if (userProfile.getUserName().equals(userName)) {
                                        userProfile.setAge(newAge);
                                    }
                                }

                                 */
                                        } else if (userInput.equals("4")) {
                                            while (true) {
                                                System.out.println("Enter your gender");
                                                System.out.println("Female");
                                                System.out.println("Male");
                                                System.out.println("Other");
                                                userInput = scanner.nextLine();
                                                break;
                                    /*
                                    if (userInput.equals("Female")) {
                                        for (Profile userProfile : database.getAllUserProfile()) {
                                            if (userProfile.getUserName().equals(userName)) {
                                                userProfile.setGender(userInput);
                                            }
                                        }
                                        break;
                                    } else if (userInput.equals("Male")) {
                                        for (Profile userProfile : database.getAllUserProfile()) {
                                            if (userProfile.getUserName().equals(userName)) {
                                                userProfile.setGender(userInput);
                                            }
                                        }
                                        break;
                                    } else if (userInput.equals("Other")) {
                                        for (Profile userProfile : database.getAllUserProfile()) {
                                            if (userProfile.getUserName().equals(userName)) {
                                                userProfile.setGender(userInput);
                                            }
                                        }
                                        break;
                                    } else {
                                        System.out.println("Please enter the right command");
                                    }
                                     */
                                            }
                                            break;
                                        } else if (userInput.equals("5")) {
                                            System.out.println("Enter your nationality");
                                            userInput = scanner.nextLine();
                                /*
                                for (Profile userProfile : database.getAllUserProfile()) {
                                    if (userProfile.getUserName().equals(userName)) {
                                        userProfile.setNationality(userInput);
                                    }
                                }
                                */
                                            break;
                                        } else if (userInput.equals("6")) {
                                            System.out.println("Enter your job");
                                            userInput = scanner.nextLine();
                                /*
                                for (Profile userProfile : database.getAllUserProfile()) {
                                    if (userProfile.getUserName().equals(userName)) {
                                        userProfile.setJob(userInput);
                                    }
                                }
                                */
                                            break;
                                        } else if (userInput.equals("7")) {
                                            System.out.println("Enter your hobby");
                                            userInput = scanner.nextLine();
                                /*
                                for (Profile userProfile : database.getAllUserProfile()) {
                                    if (userProfile.getUserName().equals(userName)) {
                                        userProfile.setHobby(userInput);
                                    }
                                }

                                 */
                                            break;
                                        } else {
                                            System.out.println("Please enter the right command");
                                        }
                                    }
                                } else if (userInput.equals("3")) {
                                    System.out.println("Enter your username");
                                    userInput = scanner.nextLine();
                        /*
                        for (Profile userProfile : database.getAllUserProfile()) {
                            if (userProfile.getUserName().equals(userName)) {
                                database.getAllUserProfile().remove(userProfile);
                            }
                        }
                        for (UserAccount userAccount : database.getAllUserAccount()) {
                            if (userAccount.getUserProfile().getUserName().equals(userName)) {
                                database.getAllUserAccount().remove(userAccount);
                            }
                        }
                         */
                        System.out.println("Delete account successfully");
                        System.out.println("Log out from the app");
                        break;
                    } else if (userInput.equals("4")) {
                        System.out.println("Search for the username");
                        userInput = scanner.nextLine();
                        System.out.println("Add friend successfully");
                    } else if (userInput.equals("5")) {
                        System.out.println("Search for the username");
                        userInput = scanner.nextLine();
                        System.out.println("Delete friend successfully");
                    } else if (userInput.equals("6")) {
                        System.out.println("Search for the username");
                        userInput = scanner.nextLine();
                        System.out.println("Block user successfully");
                    } else if (userInput.equals("7")) {
                        System.out.println("Search for the username");
                        userInput = scanner.nextLine();
                        System.out.println("Unblock user successfully");
                    } else if (userInput.equals("8")) {
                        //get sender name and receiver name
                        //System.out.println("Who you want to send message to?");
                        boolean keepgoing = true;
                        boolean hasFriend =
                        do {
                            System.out.println("1. Send Group Message");
                            System.out.println("2. Send message to specific friend");
                            System.out.println("3. Print history message");
                            System.out.println("4. Exit");
                            int input = scanner.nextInt();
                            scanner.nextLine();

                            if (input == 1) {
                                boolean groupMessageKeepGoing;
                                do {
                                    System.out.println("How many members in the group?");
                                    int num = scanner.nextInt();
                                    scanner.nextLine();
                                    ArrayList<String> groupMemberList = new ArrayList<String>();
                                    for (int i = 0; i < num; i++) {
                                        System.out.println("Who you want to send message to?");
                                        groupMemberList.add(scanner.nextLine());
                                    }
                                    System.out.println("what is your Username?");
                                    String senderName = scanner.nextLine();


                                    System.out.println("Type in message:");
                                    String message = scanner.nextLine();
                                    Message message1 = new Message();
                                    message1.restrictMessage(senderName, groupMemberList, message);
                                    for (String member : groupMemberList) {
                                        message1.printHistoryMessage(senderName, member);
                                    }

                                    System.out.println("Keep sending message?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");
                                    String ans = scanner.nextLine();
                                    if (ans.equals(1)) {
                                        groupMessageKeepGoing = true;
                                    } else {
                                        groupMessageKeepGoing = false;
                                    }
                                } while (groupMessageKeepGoing);

                            } else if (input == 2) {
                                boolean friendMessageKeepGoing;
                                do {
                                    System.out.println("Who you want to send message to?");
                                    String receiverName = scanner.nextLine();
                                    System.out.println("what is your Username?");
                                    String senderName = scanner.nextLine();

                                    System.out.println("Keep sending message?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");
                                    String ans = scanner.nextLine();
                                    if (ans.equals(1)) {
                                        friendMessageKeepGoing = true;
                                    } else {
                                        friendMessageKeepGoing = false;
                                    }
                                } while (friendMessageKeepGoing);

                            } else if (input == 3) {
                                boolean printKeepGoing;
                                do {
                                    System.out.println("Keep printing message?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");
                                    String ans = scanner.nextLine();
                                    if (ans.equals(1)) {
                                        printKeepGoing = true;
                                    } else {
                                        printKeepGoing = false;
                                    }
                                } while (printKeepGoing);
                            } else if (input == 4) {
                                keepgoing = false;
                            } else {
                                System.out.println("Invalid Input! Try Again");
                            }
                        } while (keepgoing);



                        //extract the profiles
                        Method method = new Method();
                        Profile senderProfile = method.searchProfile(senderName);
                        Profile receiverProfile = method.searchProfile(receiverName);
                        Database database = new Database("AllUserAccount.txt");

                        //Check if sender is blocked by receiver
                        boolean isInBlockList = receiverProfile.;
                        ArrayList<String> blockList = new ArrayList<String>();
                        for (UserAccount userAccount: database.getAllUserAccount()) {
                            if (userAccount.getUserProfile().getUserName().equals(receiverName) {
                                blockList = userAccount.getBlockList();
                            }
                        }
                        for (String string: blockList) {
                            if (string.equals(senderName)) {
                                isInBlockList = true;
                            }
                        }

                        //SendMessage
                        System.out.println("Please enter the message");
                        String message = scanner.nextLine();
                        Message messages = new Message();
                        if (messages.sendMessage(senderName,receiverName,message,isInBlockList)) {
                            System.out.println("Send message successfully");
                        } else {
                            System.out.println("Your account does not exist.");
                        }
                    }
                }
            } else if (userInput.equals("3")) {
                System.out.println("Exiting the app");
                break;
            } else {
                System.out.println("Please enter the right command");
            }
        }
    }
}