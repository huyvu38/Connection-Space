import java.util.ArrayList;

/**
 * Team Project
 *
 * ServerInterface.java
 *
 * @author Gabe Turner, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */

public interface ServerInterface extends Runnable {
    boolean checkIfPasswordCorrect(Profile profile, String userPassword);
    boolean checkPasswordLength(String password);
    boolean checkUserNameFormat(String userName);
    boolean usernameInDatabase(String userName);
    boolean inFriendList(String userNameOne, String userNameTwo);
    boolean inBlockList(String userNameOne, String userNameTwo);
    boolean createAccount(Database database, UserAccount userAccount, String username, String password);
    boolean loginAccount(String username, String userPassword);
    boolean addFriend(String userNameOne, String userNameTwo);
    boolean deleteFriend(String userNameOne, String userNameTwo);
    boolean blockUser(String userNameOne, String userNameTwo);
    boolean unblockUser(String userNameOne, String userNameTwo);
    ArrayList<String> searchUser(String userNameOne, String word);
    boolean sendMessage(String sendUserName, String receiverUserName, String content, boolean isBlocked);
    boolean deleteMessage(int messageID);
    String restrictMessage(String userName, ArrayList<String> friendList, String content);
    boolean printHistoryMessage(String senderName, String receiverName);
}