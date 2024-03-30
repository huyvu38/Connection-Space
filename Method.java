import java.util.ArrayList;

/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class Method implements MethodInterface{
    public boolean isValidUserName (ArrayList<Profile> allUserList, String userName) {
        for (Profile eachProfile : allUserList) {
            if (eachProfile.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }
    public boolean inFriendList (ArrayList<Profile> allUserList, ArrayList<String> friendList, String userName) {
        if (isValidUserName(allUserList, userName)) {
            for (String eachFriend : friendList) {
                if (eachFriend.equals(userName)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean inBlockList (ArrayList<Profile> allUserList, ArrayList<String> blockList, String userName) {
        if (isValidUserName(allUserList, userName)) {
            for (String eachBlockUser : blockList) {
                if (eachBlockUser.equals(userName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addFriend (ArrayList<Profile> allUserList, ArrayList<String> friendList, ArrayList<String> blockList, String userName) {
        if (isValidUserName(allUserList, userName)) {
            if (inBlockList(allUserList, blockList, userName)) {
                return false; //Already block user
            }
            if (inFriendList(allUserList, friendList, userName)) {
                return false; // already in the friend list
            } else {
                return true;
            }
        }
        return false;
    }
    public boolean removeFriend (ArrayList<Profile> allUserList, ArrayList<String> friendList, ArrayList<String> blockList, String userName) {
        if (isValidUserName(allUserList, userName)) {
            if (inBlockList(allUserList, blockList, userName)) {
                return false; //Already in block list
            }
            if (inFriendList(allUserList, friendList, userName)) {
                return true; //That userName in the list so can remove friend
            } else {
                return false;
            }
        }
        return false;
    }
    public boolean blockUser (ArrayList<Profile> allUserList, ArrayList<String> blockList, String userName) {
        if (isValidUserName(allUserList, userName)) {
            if (inBlockList(allUserList, blockList, userName)) {
                return false; //Already block
            } else {
                return true;
            }
        }
        return false;
    }
    public boolean unblockUser (ArrayList<Profile> allUserList, ArrayList<String> blockList, String userName) {
        if (isValidUserName(allUserList, userName)) {
            if (inBlockList(allUserList, blockList, userName)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    public boolean searchUser (ArrayList<Profile> allUserList, ArrayList<String> blockList, String word) {
        int count = 0;
        for (Profile eachProfile : allUserList) {
            //Check all username that contain the word
            if (eachProfile.getUserName().contains(word)) {
                //Do not display username in block list
                if (inBlockList(allUserList, blockList, word) == false) {
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
}
