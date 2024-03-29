import java.util.ArrayList;

/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class UserInformation extends Profile {

    private String password;
    private ArrayList<Profile> friendList;
    private ArrayList<Profile> blockList;
    private ArrayList<Profile> displayAllUserList;


    public UserInformation(String password, String userName, int age, String gender, String nationality, String job, String hobby) {
        super(userName, age, gender, nationality, job, hobby);
        this.friendList = new ArrayList<>();
        this.blockList = new ArrayList<>();
        //this.displayAllUserList
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    /*
    public ArrayList<Profile> getDisplayAllUserList() {
        return displayAllUserList;
    }

    public void setDisplayAllUserList(ArrayList<Profile> displayAllUserList) {
        this.displayAllUserList = displayAllUserList;
    }
     */
}