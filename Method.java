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
    public boolean isFriend (ArrayList<Profile> friendList, String userName) {
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
        if (isFriend(friendList, userName)) {
            return false; // already in the list
        }
        return true;
    }
    public boolean removeFriend (ArrayList<Profile> friendList, ArrayList<Profile> blockList, String userName) {
        if (inBlockList(blockList, userName)) {
            return false;
        }
        if (isFriend(friendList, userName)) {
            return true; //That userName in the list so can remove friend
        }
        return false;
    }
    //User have to type the exactly username
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
}
