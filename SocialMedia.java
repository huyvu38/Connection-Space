
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Team Project
 *
 * SocialMedia.java
 *
 * @author Gabe Turner, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */

/*
public class SocialMedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, welcome to the social media platform.");
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Create account.");
            System.out.println("2. Log In.");
            System.out.println("3. Exit the app.");
            Database databaseSocialMedia = new Database("AllUserAccount.txt");
            databaseSocialMedia.readAllUserAccount();
            String userInput = scanner.nextLine();
            if (userInput.equals("1")) {
                while (true) {
                    System.out.println("Once you create an account, you can not change your username.");
                    System.out.println("User name should be at least 4 characters and do not contain any spaces or semicolon.");
                    System.out.println("Enter your username:");
                    String userName = scanner.nextLine();
                    System.out.println("Password should be at least 6 characters and do not contain any spaces or semicolon.");
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
                    System.out.println("Enter your nationality without any space or semicolon");
                    String nationality = scanner.nextLine();
                    System.out.println("Enter your job without any space or semicolon");
                    String job = scanner.nextLine();
                    System.out.println("Enter your hobby without any space or semicolon");
                    String hobby = scanner.nextLine();
                    // Assuming Profile and UserAccount classes are defined
                    Profile newProfile = new Profile(userName, password, newAge, gender, nationality, job, hobby);
                    UserAccount newUserAccount = new UserAccount(newProfile);
                    LogIn newCreateAccount = new LogIn(databaseSocialMedia, newProfile, userName, password);
                    if (newCreateAccount.createAccount(databaseSocialMedia, newProfile)) {
                        databaseSocialMedia.getAllUserAccount().add(newUserAccount);
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
                ArrayList<Profile> allUserProfile = databaseSocialMedia.getAllUserProfile();
                ArrayList<UserAccount> allUserAccount = databaseSocialMedia.getAllUserAccount();
                System.out.println("Enter your username");
                String userName = scanner.nextLine();
                System.out.println("Enter your password");
                String password = scanner.nextLine();
                //If the username exists, loop through all userAccount
                int count = 0;
                for (UserAccount eachUserAccount : allUserAccount) {
                    if (eachUserAccount.getUserProfile().getUserName().equals(userName)) {
                        Profile eachProfile = eachUserAccount.getUserProfile();
                        LogIn newLogInAccount = new LogIn(databaseSocialMedia, eachProfile, userName, password);
                        if (newLogInAccount.loginAccount(databaseSocialMedia, eachProfile, userName, password)) {
                            System.out.println("Log In successfully.");
                            count = 1;
                            Method actions = new Method(allUserProfile, eachUserAccount.getFriendList(),
                                    eachUserAccount.getBlockList(), eachProfile);
                            //After user log in
                            while (true) {
                                System.out.println("What would you like to do?");
                                System.out.println("1. View your profile");
                                System.out.println("2. Edit your profile");
                                System.out.println("3. View other user profile");
                                System.out.println("4. Delete account");
                                System.out.println("5. Add friend");
                                System.out.println("6. Delete friend");
                                System.out.println("7. Block user");
                                System.out.println("8. Unblock user");
                                System.out.println("9. Send message");
                                System.out.println("10. Log out");
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
                                            System.out.println(eachProfile.getUserName());
                                            break;
                                        } else if (userInput.equals("2")) {
                                            System.out.println(eachProfile.getPassword());
                                            break;
                                        } else if (userInput.equals("3")) {
                                            System.out.println(eachProfile.getAge());
                                            break;
                                        } else if (userInput.equals("4")) {
                                            System.out.println(eachProfile.getGender());
                                            break;
                                        } else if (userInput.equals("5")) {
                                            System.out.println(eachProfile.getNationality());
                                            break;
                                        } else if (userInput.equals("6")) {
                                            System.out.println(eachProfile.getJob());
                                            break;
                                        } else if (userInput.equals("7")) {
                                            System.out.println(eachProfile.getHobby());
                                            break;
                                        } else {
                                            System.out.println("Please enter the right command.");
                                        }
                                    }
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
                                            eachProfile.setPassword(userInput);
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
                                            eachProfile.setAge(newAge);
                                            break;
                                        } else if (userInput.equals("3")) {
                                            String gender = "";
                                            while (true) {
                                                System.out.println("Enter your gender from these options:");
                                                System.out.println("Female");
                                                System.out.println("Male");
                                                System.out.println("Other");
                                                gender = scanner.nextLine();
                                                if (gender.equals("Female") || gender.equals("Male")
                                                        || gender.equals("Other")) {
                                                    break;
                                                } else {
                                                    System.out.println("Please enter the right command.");
                                                }
                                            }
                                            eachProfile.setGender(gender);
                                            break;
                                        } else if (userInput.equals("4")) {
                                            System.out.println("Enter your nationality");
                                            userInput = scanner.nextLine();
                                            eachProfile.setNationality(userInput);
                                            break;
                                        } else if (userInput.equals("5")) {
                                            System.out.println("Enter your job");
                                            userInput = scanner.nextLine();
                                            eachProfile.setJob(userInput);
                                            break;
                                        } else if (userInput.equals("6")) {
                                            System.out.println("Enter your hobby");
                                            userInput = scanner.nextLine();
                                            eachProfile.setHobby(userInput);
                                            break;
                                        } else {
                                            System.out.println("Please enter the right command");
                                        }
                                    }
                                } else if (userInput.equals("3")) {
                                    System.out.println("Search the user name that you want to view profile");
                                    userInput = scanner.nextLine();
                                    if (actions.searchUser(allUserProfile, eachUserAccount.getBlockList(), userInput)) {
                                        System.out.println("Which information do you want to see");
                                        System.out.println("1. Age");
                                        System.out.println("2. Gender");
                                        System.out.println("3. Nationality");
                                        System.out.println("4. Job");
                                        System.out.println("5. Hobby");
                                        for (Profile friendProfile : allUserProfile) {
                                            if (friendProfile.getUserName().equals(userInput)) {
                                                while (true) {
                                                    userInput = scanner.nextLine();
                                                    if (userInput.equals("1")) {
                                                        System.out.println(friendProfile.getAge());
                                                        break;
                                                    } else if (userInput.equals("2")) {
                                                        System.out.println(eachProfile.getGender());
                                                        break;
                                                    } else if (userInput.equals("3")) {
                                                        System.out.println(eachProfile.getNationality());
                                                        break;
                                                    } else if (userInput.equals("4")) {
                                                        System.out.println(eachProfile.getJob());
                                                        break;
                                                    } else if (userInput.equals("5")) {
                                                        System.out.println(eachProfile.getHobby());
                                                        break;
                                                    } else {
                                                        System.out.println("Please enter the right command.");
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        System.out.println("Can not find that user");
                                    }
                                } else if (userInput.equals("4")) {
                                    System.out.println("Enter again your password to confirm");
                                    userInput = scanner.nextLine();
                                    if (newLogInAccount.deleteAccount(databaseSocialMedia, eachUserAccount, userInput)) {
                                        System.out.println("Delete account successfully");
                                        System.out.println("Log out from the app");
                                        databaseSocialMedia.saveAllUserAccount();
                                        break;
                                    } else {
                                        System.out.println("Can not delete the account");
                                    }
                                } else if (userInput.equals("5")) {
                                    System.out.println("Search the username that you want to add friend");
                                    userInput = scanner.nextLine();
                                    //userinput equals to userNameTwo
                                    if (databaseSocialMedia.addFriend(userName, userInput)) {
                                        System.out.println("Add friend successfully");
                                        databaseSocialMedia.saveAllUserAccount();
                                    } else {
                                        System.out.println("You can not add that user");
                                    }
                                } else if (userInput.equals("6")) {
                                    System.out.println("Search for the username that you want to delete friend");
                                    userInput = scanner.nextLine();
                                    //userinput equals to userNameTwo
                                    if (databaseSocialMedia.deleteFriend(userName, userInput)) {
                                        System.out.println("Delete friend successfully");
                                        databaseSocialMedia.saveAllUserAccount();
                                    } else {
                                        System.out.println("You can not delete that user");
                                    }
                                } else if (userInput.equals("7")) {
                                    System.out.println("Search for the username that you want to block");
                                    userInput = scanner.nextLine();
                                    //userinput equals to userNameTwo
                                    if (databaseSocialMedia.blockUser(userName, userInput)) {
                                        if (databaseSocialMedia.deleteFriend(userName, userInput)) {
                                            System.out.println("Delete the user from the friendlist");
                                        }
                                        System.out.println("Block user successfully");
                                        databaseSocialMedia.saveAllUserAccount();
                                    } else {
                                        System.out.println("You can not block that user");
                                    }
                                } else if (userInput.equals("8")) {
                                    System.out.println("Search for the username that you want to unblock");
                                    userInput = scanner.nextLine();
                                    //userinput equals to userNameTwo
                                    if (databaseSocialMedia.unblockUser(userName, userInput)) {
                                        System.out.println("Unblock friend successfully");
                                        databaseSocialMedia.saveAllUserAccount();
                                    } else {
                                        System.out.println("You can not unblock that user");
                                    }
                                } else if (userInput.equals("9")) {
                                    //get sender name and receiver name
                                    //System.out.println("Who you want to send message to?");
                                    boolean hasFriends = false;
                                    boolean hasMoreThanOneFriends = false;
                                    //Get the account for the current user
                                    UserAccount currentUserAcc = null;
                                    for (UserAccount userAccount: allUserAccount) {
                                        if (userAccount.getUserProfile().getUserName().equals(userName)) {
                                            currentUserAcc = userAccount;
                                            if (!userAccount.getFriendList().isEmpty()) {
                                                hasFriends = true;
                                                if (userAccount.getFriendList().size() > 1) {
                                                    hasMoreThanOneFriends = true;
                                                }
                                            }
                                        }
                                    }
                                    if (hasFriends) {
                                        boolean keepgoing = true;
                                        do {
                                            System.out.println("1. Send Group Message");
                                            System.out.println("2. Send message to specific friend");
                                            System.out.println("3. Print history message");
                                            System.out.println("4. Exit");
                                            int input = scanner.nextInt();
                                            scanner.nextLine();

                                            if (input == 1) {
                                                //UserAccount userAccount = actions.searchAccount(userName);
                                                //boolean hasMoreThanOneFriends =
                                                // userAccount.getFriendList().size() > 1;
                                                if (hasMoreThanOneFriends) {
                                                    boolean groupMessageKeepGoing = true;
                                                    do {
                                                        System.out.println("How many members do " +
                                                                "you want in this group?");
                                                        int num = scanner.nextInt();
                                                        scanner.nextLine();
                                                        ArrayList<String> groupMemberList = new ArrayList<String>();
                                                        for (int i = 0; i < num; i++) {
                                                            System.out.println("Group member " + (i + 1) +
                                                                    " you want to send message to");
                                                            groupMemberList.add(scanner.nextLine());
                                                        }

                                                        System.out.println("Type in message:");
                                                        String message = scanner.nextLine();
                                                        Message message1 = new Message();
                                                        message1.restrictMessage(userName, groupMemberList, message);


                                                        if (groupMessageKeepGoing) {

                                                            System.out.println("Keep sending message?");
                                                            System.out.println("1. Yes");
                                                            System.out.println("2. No");
                                                            String ans = scanner.nextLine();
                                                            if (ans.equals(1)) {
                                                                groupMessageKeepGoing = true;
                                                            } else if (ans.equals(2)) {
                                                                groupMessageKeepGoing = false;
                                                            } else {
                                                                System.out.println("Invalid Input! Assuming NO");
                                                                groupMessageKeepGoing = false;
                                                            }

                                                        }
                                                    } while (groupMessageKeepGoing);
                                                } else {
                                                    System.out.println("Please add more friends");
                                                }
                                            } else if (input == 2) {
                                                boolean friendMessageKeepGoing = true;
                                                do {
                                                    System.out.println("Who you want to send message to?");
                                                    String receiverName = scanner.nextLine();
                                                    // check if the receiver is in the friendList
                                                    if (currentUserAcc.getFriendList().contains(receiverName)) {
                                                        // Variable for checking if the user is blocked by the receiver
                                                        boolean isBlocked = false;
                                                        UserAccount receiverAcc = null;
                                                        for (UserAccount account : allUserAccount) {
                                                            // Assuming allUserAccounts holds all user accounts
                                                            if (account.getUserProfile().getUserName().equals(receiverName)) {
                                                                receiverAcc = account;
                                                                if (account.getBlockList().contains(currentUserAcc.getUserProfile().getUserName())) {
                                                                    isBlocked = true;
                                                                    break;
                                                                    // Stop searching once the receiver account is found and block status is determined
                                                                }

                                                            }
                                                        }

                                                        // Proceed if receiver account is found and user is not blocked
                                                        if (receiverAcc != null && !isBlocked) {
                                                            System.out.println("What message do you want to send?");
                                                            String message = scanner.nextLine();
                                                            Message messageObj = new Message();
                                                            // Assuming this is how you create a message
                                                            if (messageObj.sendMessage(userName, receiverName, message, isBlocked)) {
                                                                System.out.println("Message sent successfully.");
                                                            } else {
                                                                System.out.println("Failed to send message.");
                                                            }
                                                        } else if (isBlocked) {
                                                            System.out.println("You are blocked by this user.");
                                                            friendMessageKeepGoing = false;
                                                            // Assuming you want to exit the loop if blocked
                                                        } else {
                                                            System.out.println("Receiver not found.");
                                                        }
                                                    } else {
                                                        System.out.println("Friend Not Exist! Try Again");
                                                        friendMessageKeepGoing = false;
                                                    }

                                                    // Asking user if they want to continue sending messages
                                                    if (friendMessageKeepGoing) {
                                                        // Only prompt if still eligible to send messages
                                                        System.out.println("Do you want to keep sending messages? (1 for Yes, 2 for No)");
                                                        String ans = scanner.nextLine();
                                                        if (ans.equals("1")) {
                                                            friendMessageKeepGoing = true;
                                                        } else if (ans.equals("2")) {
                                                            friendMessageKeepGoing = false;
                                                        } else {
                                                            System.out.println("Invalid input! Assuming No.");
                                                            friendMessageKeepGoing = false;
                                                        }
                                                    }
                                                } while (friendMessageKeepGoing);

                                            } else if (input == 3) {
                                                boolean keepPrintMess = true;
                                                while (keepPrintMess) {
                                                    System.out.println("Who do you want to print the conversation with?");
                                                    String name = scanner.nextLine();
                                                    Message message = new Message();
                                                    message.printHistoryMessage(userName, name);

                                                    boolean keepDeleting = true;
                                                    while (keepDeleting) {
                                                        System.out.println("Do you want to delete any message?");
                                                        System.out.println("1. Yes");
                                                        System.out.println("2. No");
                                                        String ans = scanner.nextLine();

                                                        // Correct the comparison to use string values
                                                        if (ans.equals("1")) {
                                                            // Change from ans.equals(1) to ans.equals("1")
                                                            System.out.println("Please enter the conversation ID:");
                                                            String ID = scanner.nextLine();
                                                            try {
                                                                if (message.deleteMessage(Integer.parseInt(ID))) {
                                                                    System.out.println("Message deleted successfully.");
                                                                } else {
                                                                    System.out.println("Message deletion failed. Try another ID.");
                                                                }
                                                                // No need to set keepDeleting = true here, as it's already true by default
                                                            } catch (NumberFormatException e) {
                                                                System.out.println("Invalid ID format. Please enter a valid number.");
                                                            }
                                                        } else if (ans.equals("2")) {
                                                            keepDeleting = false; // Will exit the loop
                                                        } else {
                                                            System.out.println("Invalid input! Try again.");
                                                            // keepDeleting remains true, so the loop continues

                                                        }
                                                    }


                                                    boolean printKeepGoing = true;
                                                    do {
                                                        System.out.println("Keep printing message?");
                                                        System.out.println("1. Yes");
                                                        System.out.println("2. No");
                                                        String ans = scanner.nextLine();
                                                        if (ans.equals("1")) {
                                                            keepPrintMess = true;
                                                            printKeepGoing = false;
                                                        } else if (ans.equals("2")) {
                                                            keepPrintMess = false;
                                                            printKeepGoing = false;
                                                        } else {
                                                            System.out.println("Invalid input! Try again.");
                                                            printKeepGoing = true;
                                                        }
                                                    } while (printKeepGoing);
                                                }
                                            } else if (input == 4) {
                                                keepgoing = false;
                                            } else {
                                                System.out.println("Invalid Input! Try Again");
                                            }
                                        } while (keepgoing);
                                    } else {
                                        System.out.println("Please add friend first");
                                    }
                                } else if (userInput.equals("10")) {
                                    break;
                                    //Log out
                                } else {
                                    System.out.println("Please enter the right command");
                                }
                            }
                        }
                    }
                }
                if (count == 0) {
                    System.out.println("Log in failure");
                }
            } else if (userInput.equals("3")) {
                System.out.println("Exiting the app");
                databaseSocialMedia.saveAllUserAccount();
                break;
            } else {
                System.out.println("Please enter the right command");
            }
        }
    }
}


 */