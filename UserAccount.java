import java.util.ArrayList;

/**
 * Team Project
 *
 * UserAccount.java
 *
 * @author Huy Vu, Yanxin Yu - CS180 - L22
 * @version 28 March 2024
 */
public class UserAccount implements UserAccountInterface {

    private Profile userProfile;
    private ArrayList<String> friendList;
    private ArrayList<String> blockList;

    public UserAccount(Profile userProfile) {
        this.userProfile = userProfile;
        this.friendList = new ArrayList<>();
        this.blockList = new ArrayList<>();
    }


    public Profile getUserProfile() {
        return userProfile;
    }

    public ArrayList<String> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<String> friendList) {
        this.friendList = friendList;
    }

    public ArrayList<String> getBlockList() {
        return blockList;
    }

    public void setBlockList(ArrayList<String> blockList) {
        this.blockList = blockList;
    }
    public String toString() {
        String friend = "";
        String blockUser = "";

        if (this.friendList.size() != 0) {
            for (int i = 0; i < this.friendList.size(); i++) {
                String friendName = this.friendList.get(i);
                if (friendName != null && !friendName.isEmpty()) {
                    friend += friendName;
                    if (i < (this.friendList.size() - 1)) {
                        friend += " ";
                    }
                }
            }
        }

        if (this.blockList.size() != 0) {
            for (int i = 0; i < this.blockList.size(); i++) {
                String blockedUser = this.blockList.get(i);
                if (blockedUser != null && !blockedUser.isEmpty()) {
                    blockUser += blockedUser;
                    if (i < (this.blockList.size() - 1)) {
                        blockUser += " ";
                    }
                }
            }
        }

        return this.userProfile.toString() + ";FriendList:[" + friend + "];BlockList:[" + blockUser + "]";
    }

}