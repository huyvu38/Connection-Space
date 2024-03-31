import java.util.ArrayList;

/**
 * Team Project
 *
 * MessageInterface.java
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public interface MessageInterface {
    boolean sendMessage(String sendUserName, String receiverUserName, String content, boolean isBlocked);
    boolean deleteMessage(int messageID);
    String restrictMessage(String userName, ArrayList<String> friendList, String content);
    boolean printHistoryMessage(String senderName, String receiverName);

}

