import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.*;

/**
 * Team Project
 *
 * Message.java
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */


public class Message implements MessageInterface {
    // Create a message row including timeStamp, save to Message.txt at the bottom of the file
    public boolean sendMessage (String sendUserName, String receiverUserName, String content, boolean isBlocked) {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        //
        String lastLine = null;
        BufferedReader reader = null;
        boolean isGetId = false;
        int ID = 0;
        try {
            // Create a BufferedReader to read from a file
            reader = new BufferedReader(new FileReader("Messages.txt"));

            // Read each line from the file
            String line;
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }

            // Print the last line

            if (lastLine != null) {
                String[] rowInfo = lastLine.split(",");
                ID = Integer.parseInt(rowInfo[0]) + 1;
            }
            isGetId = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the BufferedReader
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (isGetId) {
            // Create a message row
            String messageRow = ID + ",1," + formattedDateTime + "," + sendUserName + "," + receiverUserName ;
            if (isBlocked) {
                messageRow += ",blocked," + content;

            } else {
                messageRow += ",notBlocked," + content;
            }

            //Write the message to the bottom of the Message.txt
            BufferedWriter wr = null;
            try {
                wr = new BufferedWriter(new FileWriter("Messages.txt", true));
                wr.write(messageRow);
                wr.newLine();

                // Flush the data to the file
                wr.flush();
                return true;

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    // Close the BufferedWriter
                    if (wr != null) {
                        wr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return false;
    }


    public boolean deleteMessage (int messageID) {
        Path path = Paths.get("Messages.txt");


        try {
            // Read all lines into a List
            List<String> lines = Files.readAllLines(path);

            // Stream through the lines, replace the string, and collect the results
            List<String> replaced = new ArrayList<>();
            for (String line : lines) {
                if (line.startsWith(messageID + ",1,")) {
                    String[] row = line.split(",");
                    row[1] = String.valueOf(0);
                    line = String.join(",",row);
                }
                replaced.add(line);
            }

            // Write the lines back to the file
            Files.write(path, replaced);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }


    // Only send message to all friends in friendList
    // Only send message when otherUserName is in friendList
    // return empty string if all success, otherwirse indicate which one failed.
    public String restrictMessage (String userName, ArrayList<String> friendList, String content) {
        List<String> failedUser = new ArrayList<>();
        for (String friend: friendList) {
            if(!this.sendMessage(userName, friend, content, false)) {
                failedUser.add(friend);
            }
        }

        if (failedUser.size() > 0) {
            return "Failed to send to "+ failedUser.toString();

        } else {
            return null;
        }

    }

    public static void main(String[] args) {
        Message text = new Message();
       //text.sendMessage("Eliza", "Lingling", "What is for dinner?");
        //text.sendMessage("Lingling", "Eliza", "Dumplings");
        text.deleteMessage(1 );


    }

}