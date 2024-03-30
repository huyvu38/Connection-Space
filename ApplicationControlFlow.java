/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
import java.util.Scanner;
public class ApplicationControlFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, welcome to the social media platform");
        boolean input = true;
        while (input) {
            System.out.println("What would you like to do?");
            System.out.println("1. Create account");
            System.out.println("2. Log In");
            System.out.println("3. Exit the app");
            String userInput = scanner.nextLine();
            if (userInput.equals("1")) {
                System.out.println("Enter your username");
                String userName = scanner.nextLine();
                System.out.println("Enter your password");
                String password = scanner.nextLine();
                int newAge = 0;
                while (input) {
                    System.out.println("Enter your age");
                    String age = scanner.nextLine();
                    try {
                        newAge = Integer.parseInt(age);
                        if (newAge <= 0) {
                            System.out.println("Please enter a valid number");
                        } else {
                            if input = false;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number");
                    }
                }
                System.out.println("Enter your gender");
                String gender = scanner.nextLine();
                System.out.println("Enter your nationality");
                String nationality = scanner.nextLine();
                System.out.println("Enter your job");
                String job = scanner.nextLine();
                System.out.println("Enter your hobby");
                String hobby = scanner.nextLine();
                Profile newProfile = new Profile(userName, password, newAge, gender, nationality, job, hobby);
                UserAccount newUserAccount = new UserAccount(newProfile);
                System.out.println("Create account success");
                System.out.println("You have to log in again");
                input = true;
            } else if (userInput.equals("2")) {
                Database database = new Database("allUserAccount.txt", "allUserProfile.txt");
                System.out.println("Enter your username");
                String userName = scanner.nextLine();
                System.out.println("Enter your password");
                String password = scanner.nextLine();
                System.out.println("Log in success");
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
                    for (Profile userProfile : database.getAllUserProfile()) {
                        if (userProfile.getUserName().equals(userName)) {
                            System.out.println(userProfile);
                        }
                    }
                } else if (userInput.equals("2")) {
                    System.out.println("Which information do you want to edit");
                    System.out.println("1. Username");
                    System.out.println("2. Password");
                    System.out.println("3. Age");
                    System.out.println("4. Gender");
                    System.out.println("5. Nationality");
                    System.out.println("6. Job");
                    System.out.println("7. Hobby");
                    userInput = scanner.nextLine();
                    if (userInput.equals("1")) {
                        System.out.println("Enter your new username");
                        userInput = scanner.nextLine();
                        for (Profile userProfile : database.getAllUserProfile()) {
                            if (userProfile.getUserName().equals(userName)) {
                                userProfile.setUserName(userInput);
                            }
                        }
                    } else if (userInput.equals("2")) {
                        System.out.println("Enter your new password");
                        userInput = scanner.nextLine();
                        for (Profile userProfile : database.getAllUserProfile()) {
                            if (userProfile.getUserName().equals(userName)) {
                                userProfile.setPassword(userInput);
                            }
                        }
                    } else if (userInput.equals("3")) {
                        int newAge = 0;
                        while (input) {
                            System.out.println("Enter your age");
                            String age = scanner.nextLine();
                            try {
                                newAge = Integer.parseInt(age);
                                if (newAge <= 0) {
                                    System.out.println("Please enter a valid number");
                                } else {
                                    input = false;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid number");
                            }
                        }
                        for (Profile userProfile : database.getAllUserProfile()) {
                            if (userProfile.getUserName().equals(userName)) {
                                userProfile.setAge(newAge);
                            }
                        }
                    } else if (userInput.equals("4")) {
                        System.out.println("Enter your new password");
                        userInput = scanner.nextLine();
                        for (Profile userProfile : database.getAllUserProfile()) {
                            if (userProfile.getUserName().equals(userName)) {
                                userProfile.setPassword(userInput);
                            }
                        }
                    }
                } else if (userChoice.equals("3")) {
                    System.out.println("What information do you want to edit");
                    System.out.println("1. Username");
                    System.out.println("2. Password");
                    System.out.println("3. Age");
                    System.out.println("4. Gender");
                    System.out.println("5. Nationality");
                    System.out.println("6. Job");
                    System.out.println("7. Hobby");
                } else if (userChoice.equals("4")) {
                    System.out.println("Enter the username you want to see");
                } else if (userChoice.equals("5")) {
                    System.out.println("Enter the username you want to add");
                } else if (userChoice.equals("6")) {
                    System.out.println("Enter the username you want to delete");
                } else if (userChoice.equals("7")) {
                    System.out.println("Enter the username you want to block");
                } else if (userChoice.equals("8")) {
                    System.out.println("Enter the username you want to unblock");
                } else if (userChoice.equals("9")) {
                    System.out.println("Enter the username you want to send messages");
                } else if (userChoice.equals("10")) {
                    System.out.println("Log out success");
                } else {
                    System.out.println("Invalid input");
                }
            } else if (userChoice.equals("3")) {
                System.out.println("Exit successfully");
                choice = false;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}
