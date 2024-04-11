import java.util.ArrayList;

/**
 * Team Project
 *
 * MethodInterface.java
 *
 * @author Gabe Turner, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public interface MethodInterface {
    boolean usernameInDatabase(String userName);
    boolean inFriendList(String userNameOne, String userNameTwo);
    boolean inBlockList(String userNameOne, String userNameTwo);
    boolean addFriend(String userNameOne, String userNameTwo);
    boolean deleteFriend(String userNameOne, String userNameTwo);
    boolean blockUser(String userNameOne, String userNameTwo);
    boolean unblockUser(String userNameOne, String userNameTwo);
    boolean searchUser(String userNameOne, String userNameTwo);

}