import java.util.ArrayList;

public interface ServerInterface extends Runnable {
    boolean sendMessage(String sendUserName, String receiverUserName, String content, boolean isBlocked);
    boolean deleteMessage(int messageID);
    String restrictMessage(String userName, ArrayList<String> friendList, String content);
    boolean printHistoryMessage(String senderName, String receiverName);
}