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
                System.out.println("3. Exit the app.");
                String userInput = scanner.nextLine();
                //User want to create account -> send 1 to the server
                //User want to logIn -> send 2 to the server
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
                    if (result.equals("Log in failure")) {
                        System.out.println("What would you like to do? ");
                        String choice = scanner.nextLine();
                    }
                }
                if (userInput.equals("3")) {
                    System.out.println("Exiting the app");
                    break;
                }
            }
            writer.close();
            reader.close();
        } catch(Exception e){
            System.out.println("Can not connect to the server");
        }
    }
}
