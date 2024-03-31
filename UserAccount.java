import java.util.ArrayList;

/**
 * Team Project
 *
 * UserAccount.java
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
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
    public void setUserProfile(Profile userProfile) {
        this.userProfile = userProfile;
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
                if (i < (this.friendList.size() - 1)) {
                    friend = friend + this.friendList.get(i) + " ";
                } else {
                    friend = friend + this.friendList.get(i);
                }
            }
        }
        if (this.friendList.size() != 0) {
            for (int i = 0; i< this.blockList.size(); i++) {
                if (i < (this.blockList.size() - 1)) {
                    blockUser = blockUser + this.blockList.get(i) + " ";
                } else {
                    blockUser = blockUser + this.blockList.get(i);
                }
            }
        }
        return this.userProfile.toString() + ";FriendList:[" + friend + "];BlockList:[" + blockUser + "]";
    }

}