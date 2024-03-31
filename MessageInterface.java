import java.util.ArrayList;

/**
 * Team Project
 *
 * MessageInterface.java
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public interface MessageInterface { //Because static there are issues. FIX!
    static boolean sendMessage(String sendUserName, String receiverUserName, String content, boolean isBlocked) {
        return false;
    }

    static boolean deleteMessage(int messageID) {
        return false;
    }

    static String restrictMessage(String userName, ArrayList<String> friendList, String content) {
        return null;
    }

    static boolean printHistoryMessage(String senderName, String receiverName) {
        return false;
    }
}

