import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
    //Message message = new Message();

    // Create a message row including timeStamp, save to Message.txt at the bottom of the file
    public boolean sendMessage(String sendUserName, String receiverUserName, String content, boolean isBlocked) {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        //
        String lastLine = null;
        BufferedReader reader = null;
        boolean isGetId = false;
        int id = 0;
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
                id = Integer.parseInt(rowInfo[0]) + 1;
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
            String messageRow = id + ",1," + formattedDateTime + "," + sendUserName + "," + receiverUserName;
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


    public boolean deleteMessage(int messageID) {
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
                    line = String.join(",", row);
                }
                replaced.add(line);
            }

            // Write the lines back to the file
            Files.write(path, replaced);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    // Only send message to selected members in friendList
    // (before use this method, make sure all input should in Users friendList.
    // Only send message when otherUserName is in friendList
    // return empty string if all success, otherwirse indicate which one failed.
    public  String restrictMessage(String userName, ArrayList<String> groupMembersList, String content) {
        List<String> failedUser = new ArrayList<>();
        for (String friend: groupMembersList) {
            if (!this.sendMessage(userName, friend, content, false)) {
                failedUser.add(friend);
            }
        }

        if (failedUser.size() > 0) {
            return "Failed to send to " + failedUser.toString();

        } else {
            return null;
        }

    }

    // printHistoryMessage()
    // Take sender's name and receiver's name as parameters to filter the message in the Messages.txt
    // that should be print out
    // The message that already deleted will not be printed in this method, but it still exist in the database
    // For the blocked message, the sender still can see it, but on the receiver side, it won't be shown

    public boolean printHistoryMessage(String senderName, String receiverName) {
        String filePath = "Messages.txt";
        BufferedReader br = null;
        boolean isSuccessful = true;


        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            System.out.println("[conversationID] [ConversationTime] [Sender-Message] [if message blocked]");
            int counter = 0;
            while ((line = br.readLine()) != null) {
                String[] array = line.split(",");

                // Step1: Merge the message that contain ","
                ArrayList<String> temp = new ArrayList<String>();
                String mergeText = "";
                if (array.length > 7) {
                    for (int i = 0; i < array.length; i++) {
                        if (i >= 6) {
                            mergeText += array[i] + ",";
                        } else {
                            temp.add(array[i]);
                        }
                    }
                    mergeText = mergeText.substring(0, mergeText.length() - 1);
                    temp.add(mergeText);
                    temp.toArray(array);
                }

                // Step2: print the message by checking:
                //    1. if message has deleted
                //    2. if the message has been blocked
                //    3. sender and receiver matched
                // All message should follow the format:
                // [conversationID] [ConversationTime] [SenderName-MessageContent] [if message blocked]
                if ((array[1].equals("1")
                        && array[3].equals(senderName)
                        && array[4].equals(receiverName)) || (array[1].equals("1")
                        && array[3].equals(receiverName)
                        && array[4].equals(senderName))) {
                    counter++;
                    System.out.printf("%s %s %s: %s %s", array[0], array[2], array[3], array[6], array[5]);
                    System.out.println();
                }
            }
            if (senderName.equals(receiverName)) {
                System.out.println("Don't message yourself");
            }

            if (counter == 0) {

                System.out.println("No message yet");

            }
            //return true;
        } catch (IOException e) {
            isSuccessful = false;
            //e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                isSuccessful = false;
                //e.printStackTrace();

            }
        }
        return isSuccessful;

    }

}
