import java.util.Scanner;
public class ApplicationControlFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, welcome to the social media platform");
        System.out.println("What would you like to do?");
        System.out.println("1. Log In");
        System.out.println("2. Create Account");
        String userChoice = scanner.nextLine();
        if (userChoice.equals("1")) {
            System.out.println("Enter your username");
            String userName = scanner.nextLine();
            System.out.println("Enter your password");
            String password = scanner.nextLine();
        } else if (userChoice.equals("2")) {
            System.out.println("Enter your username");
            String userName = scanner.nextLine();
            System.out.println("Enter your password");
            String password = scanner.nextLine();
        } else {
            System.out.println("Invalid choice");
        }
    }
}
