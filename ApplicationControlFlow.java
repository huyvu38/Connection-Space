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
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number");
                    }
                }
                String gender = "";
                while (input) {
                    System.out.println("Enter your gender from these options");
                    System.out.println("Female");
                    System.out.println("Male");
                    System.out.println("Other");
                    gender = scanner.nextLine();
                    if (gender.equals("Female") || gender.equals("Male") || gender.equals("Female")) {
                        break;
                    } else {
                        System.out.println("Please enter the right command");
                    }
                }
                System.out.println("Enter your nationality");
                String nationality = scanner.nextLine();
                System.out.println("Enter your job");
                String job = scanner.nextLine();
                System.out.println("Enter your hobby");
                String hobby = scanner.nextLine();
                // Assuming Profile and UserAccount classes are defined
                Profile newProfile = new Profile(userName, password, newAge, gender, nationality, job, hobby);
                UserAccount newUserAccount = new UserAccount(newProfile);
                System.out.println("Create account success");
                System.out.println("You have to log in again");
            } else if (userInput.equals("2")) {
                // Assuming Database class is defined
                Database database = new Database("allUserAccount.txt", "allUserProfile.txt");
                System.out.println("Enter your username");
                String userName = scanner.nextLine();
                System.out.println("Enter your password");
                String password = scanner.nextLine();
                System.out.println("Log in success");
                while (input) {
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
                        while (input) {
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
                                System.out.println("Enter new username");
                                userInput = scanner.nextLine();
                                for (Profile userProfile : database.getAllUserProfile()) {
                                    if (userProfile.getUserName().equals(userName)) {
                                        userProfile.setUserName(userInput);
                                    }
                                }
                                System.out.println("Edit name successfully");
                                break;
                            } else if (userInput.equals("2")) {
                                System.out.println("Enter new password");
                                userInput = scanner.nextLine();
                                for (Profile userProfile : database.getAllUserProfile()) {
                                    if (userProfile.getUserName().equals(userName)) {
                                        userProfile.setPassword(userInput);
                                    }
                                }
                                System.out.println("Edit password successfully");
                                break;
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
                                            break;
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
                                break;
                            } else if (userInput.equals("4")) {
                                while (input) {
                                    System.out.println("Enter your gender");
                                    System.out.println("Female");
                                    System.out.println("Male");
                                    System.out.println("Other");
                                    userInput = scanner.nextLine();
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
                                }
                                break;
                            } else if (userInput.equals("5")) {
                                System.out.println("Enter your nationality");
                                userInput = scanner.nextLine();
                                for (Profile userProfile : database.getAllUserProfile()) {
                                    if (userProfile.getUserName().equals(userName)) {
                                        userProfile.setNationality(userInput);
                                    }
                                }
                                break;
                            } else if (userInput.equals("6")) {
                                System.out.println("Enter your job");
                                userInput = scanner.nextLine();
                                for (Profile userProfile : database.getAllUserProfile()) {
                                    if (userProfile.getUserName().equals(userName)) {
                                        userProfile.setJob(userInput);
                                    }
                                }
                                break;
                            } else if (userInput.equals("7")) {
                                System.out.println("Enter your hobby");
                                userInput = scanner.nextLine();
                                for (Profile userProfile : database.getAllUserProfile()) {
                                    if (userProfile.getUserName().equals(userName)) {
                                        userProfile.setHobby(userInput);
                                    }
                                }
                                break;
                            } else {
                                System.out.println("Please enter the right command");
                            }
                        }
                    } else if (userInput.equals("3")) {
                        System.out.println("Enter your username");
                        userInput = scanner.nextLine();
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
                        System.out.println("Delete account successfully");
                        System.out.println("Log out from the app");
                        break;
                    } else if (userInput.equals("4")) {
                        System.out.println("Search for the username");
                        System.out.println("Add friend successfully");
                    } else if (userInput.equals("5")) {
                        System.out.println("Search for the username");
                        System.out.println("Delete friend successfully");
                    } else if (userInput.equals("6")) {
                        System.out.println("Search for the username");
                        System.out.println("Block user successfully");
                    } else if (userInput.equals("7")) {
                        System.out.println("Search for the username");
                        System.out.println("Unblock user successfully");
                    } else if (userInput.equals("8")) {
                        System.out.println("Search for the username");
                        String content = scanner.nextLine();
                        System.out.println("Send message successfully");
                    } else if (userInput.equals("9")) {
                        System.out.println("Log out successfully");
                        break;
                    } else {
                        System.out.println("Please enter the right command");
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