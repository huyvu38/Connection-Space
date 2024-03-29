import java.util.ArrayList;

/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class UserInformation {

    private Profile userProfile;
    private ArrayList<Profile> friendList;
    private ArrayList<Profile> blockList;

    public UserInformation(Profile userProfile) {
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

    public ArrayList<Profile> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<Profile> friendList) {
        this.friendList = friendList;
    }

    public ArrayList<Profile> getBlockList() {
        return blockList;
    }

    public void setBlockList(ArrayList<Profile> blockList) {
        this.blockList = blockList;
    }
}