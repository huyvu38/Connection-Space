import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Team Project
 *
 * Client.java
 *
 * @author Gabe Turner, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class NewClient extends JComponent implements Runnable {
    public NewClient() throws IOException {

    }

    //Connect to the server
    Socket socket = new Socket("localhost", 5050);
    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter writer = new PrintWriter(socket.getOutputStream());

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new NewClient());
    }

    //JFrame and JButton for main menu
    JFrame mainMenuFrame;
    JButton createAccountButton;
    JButton loginButton;
    JButton exitAppButton;

    //JFrame and JButton for create account

    //JFrame and JButton for Log in

    //JFrame and JButton after log in successfully

    //JFrame and JButton in the frame of actions (Add, delete, block, remove, search?)

    //JFrame and JButton for the message frame


    //All of the frames in run()
    public void run() {
        //First frame is the main menu after the client connect to the server
        {
            mainMenuFrame = new JFrame("Main Menu");
            Container content = mainMenuFrame.getContentPane();
            content.setLayout(new BorderLayout());

            mainMenuFrame.setSize(600, 400);
            mainMenuFrame.setLocationRelativeTo(null);
            mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainMenuFrame.setVisible(true);

            loginButton = new JButton("Login");
            createAccountButton = new JButton("Create account");
            exitAppButton = new JButton("Exit the app");

            JPanel mainMenuPanel = new JPanel();
            mainMenuPanel.add(createAccountButton);
            mainMenuPanel.add(loginButton);
            mainMenuPanel.add(exitAppButton);

            createAccountButton.addActionListener(actionListener);
            loginButton.addActionListener(actionListener);
            exitAppButton.addActionListener(actionListener);

            content.add(mainMenuPanel, BorderLayout.CENTER);
        }
    }

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == createAccountButton) {
                }
                if (e.getSource() == loginButton) {
                }
                if (e.getSource() == exitAppButton) {
                    //close
                    mainMenuFrame.dispose();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };
}
