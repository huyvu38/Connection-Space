import java.util.ArrayList;

/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class Method {
    public boolean isValidUserName (ArrayList<Profile> allUserList, String userName) {
        for (Profile eachProfile : allUserList) {
            if (eachProfile.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
    public boolean createAccount (String userName, String password) {}

    public boolean deleteAccount (String userName, String password) {}
    public boolean inFriendList (ArrayList<Profile> friendList, String userName) {
        for (Profile eachProfile : friendList) {
            if (eachProfile.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
    public boolean inBlockList (ArrayList<Profile> blockList, String userName) {
        for (Profile eachProfile : blockList) {
            if (eachProfile.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public boolean addFriend (ArrayList<Profile> friendList, ArrayList<Profile> blockList, String userName) {
        if (inBlockList(blockList, userName)) {
            return false; //Already block user
        }
        if (inFriendList(friendList, userName)) {
            return false; // already in the list
        }
        return true;
    }
    public boolean removeFriend (ArrayList<Profile> friendList, ArrayList<Profile> blockList, String userName) {
        if (inBlockList(blockList, userName)) {
            return false;
        }
        if (inFriendList(friendList, userName)) {
            return true; //That userName in the list so can remove friend
        }
        return false;
    }
    public boolean blockUser (ArrayList<Profile> blockList, ArrayList<Profile> allUserList, String userName) {
        if (inBlockList(blockList, userName)) {
            return false; //Already block
        }
        if (isValidUserName(allUserList, userName)) {
            return true; //Can block that user
        }
        return false;
    }
    public boolean searchUser (ArrayList<Profile> blockList, ArrayList<Profile> allUserList, String word) {
        int count = 0;
        for (Profile eachProfile : allUserList) {
            //Check all username that contain the word
            if (eachProfile.getUserName().contains(word)) {
                //Do not display username in block list
                if (inBlockList(blockList, word) == false) {
                    count = count + 1;
                    System.out.println(count + ". " + eachProfile.getUserName());
                }
            }
        }
        if (count == 0) {
            return false; //cannot find any user
        }
        return true; //Find at least one user
    }
    public boolean viewUser (ArrayList<Profile> allUserList, ArrayList<Profile> blockList, String otherUserName) {

    }
}
