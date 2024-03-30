import java.util.ArrayList;

/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public interface UserAccountInterface {
    Profile getUserProfile();
    void setUserProfile(Profile userProfile);
    ArrayList<String> getFriendList();
    void setFriendList(ArrayList<String> friendList);
    ArrayList<String> getBlockList();
    void setBlockList(ArrayList<String> blockList);
    void updateFriendUserName (String oldUserName, String newUserName);
    void updateBlockUserName (String oldUserName, String newUserName);
    String toString();
}
