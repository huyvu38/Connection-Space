import java.util.ArrayList;

/**
 * Team Project
 *
 * MethodInterface.java
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public interface MethodInterface {
    boolean usernameInDatabase(ArrayList<Profile> allUsersList, String userName);
    boolean inFriendList(ArrayList<Profile> allUserList, ArrayList<String> friendList, String userName);
    boolean inBlockList(ArrayList<Profile> allUserList, ArrayList<String> blockList, String userName);
    boolean addFriend(ArrayList<Profile> allUserList, ArrayList<String> friendList,
                      ArrayList<String> blockList, String userName);
    boolean removeFriend(ArrayList<Profile> allUserList, ArrayList<String> friendList,
                         ArrayList<String> blockList, String userName);
    boolean blockUser(ArrayList<Profile> allUserList, ArrayList<String> blockList, String userName);
    boolean unblockUser(ArrayList<Profile> allUserList, ArrayList<String> blockList, String userName);
    boolean searchUser(ArrayList<Profile> allUserList, ArrayList<String> blockList, String word);
    boolean deleteAccount(ArrayList<Profile> allUsersList, Profile profile, String enteredPassword);

}