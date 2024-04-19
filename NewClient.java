import javax.swing.*;
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

    //JFrame and JButton
    //Main menu


    //Create account
    JButton createAccountButton;


    //Log in


    //After log in successfully


    //Buttons in the frame of actions (Add, delete, block, remove, search?)


    //Buttons for the message frame


    //All of the frames in run()
    public void run() {

    }

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == createAccountButton) {
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };
}
