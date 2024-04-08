import java.util.ArrayList;

/**
 * Team Project
 *
 * UserAccountInterface.java
 *
 * @author Gabe Turner, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public interface UserAccountInterface {
    Profile getUserProfile();
    ArrayList<String> getFriendList();
    void setFriendList(ArrayList<String> friendList);
    ArrayList<String> getBlockList();
    void setBlockList(ArrayList<String> blockList);
    String toString();
}
