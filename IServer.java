import java.util.ArrayList;

public interface IServer {
    boolean checkIfPasswordCorrect(Profile profile, String userPassword);
    boolean checkPasswordLength(String password);
    boolean checkUserNameFormat(String userName);
    boolean usernameInDatabase(String userName);
    boolean inFriendList(String userNameOne, String userNameTwo);
    boolean inBlockList(String userNameOne, String userNameTwo);
    boolean createAccount(Database database, UserAccount userAccount, String username, String password);
    boolean deleteAccount(Database data, UserAccount userAccount, String enteredPassword);
    boolean loginAccount(String username, String userPassword);
    boolean addFriend(String userNameOne, String userNameTwo);
    boolean deleteFriend(String userNameOne, String userNameTwo);
    boolean blockUser(String userNameOne, String userNameTwo);
    boolean unblockUser(String userNameOne, String userNameTwo);
    ArrayList<String> searchUser(String userNameOne, String word);
    boolean sendMessage(String sendUserName, String receiverUserName, String content, boolean isBlocked);
    boolean deleteMessage(int messageID);
    String restrictMessage(String userName, ArrayList<String> friendListList, String content);
    boolean printHistoryMessage(String senderName, String receiverName);
}
