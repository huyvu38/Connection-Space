import java.util.ArrayList;

/**
 * Team Project
 *
 * Method.java
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class Method implements MethodInterface {
    private ArrayList<Profile> allUserList;
    private ArrayList<String> friendList;
    private ArrayList<String> blockList;
    private Profile userProfile;

    public Method(ArrayList<Profile> allUserList, Profile userProfile) {
        this.allUserList = allUserList;
        this.friendList = null;
        this.blockList = null;
        this.userProfile = userProfile;
    }

    public Method() {
    }


    // Extract User profile from database given username
    public Profile searchProfile(String userName) {
        Database database = new Database("AllUserAccount.txt");
        Profile profile = null;
        for (Profile curProfile: database.getAllUserProfile()) {
            if (curProfile.getUserName().equals(userName)) {
                profile = curProfile;
            }
        }
        return profile;
    }

    public boolean isValidUserName (ArrayList<Profile> allUserList, String userName) {
        for (Profile eachProfile : allUserList) {
            if (eachProfile.getUserName().equals(userName)) {
                return false; //User exist in the database
            }
        }
        return true; // User doesn't exist in the database
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
    public boolean searchUser (ArrayList<Profile> allUserList, ArrayList<String> blockList, String username) {
        for (Profile eachProfile : allUserList) {
            //Check all username that contain the word
            if (eachProfile.getUserName().equals(username)) {
                //Do not display username in block list
                if (inBlockList(allUserList, blockList, username) == false) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIfPasswordCorrect (Profile profile, String password) {
        if (profile.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
    public boolean deleteAccount (ArrayList<Profile> allUserList, Profile profile, String enteredPassword) {
        // parameter String enteredPassword:
        // is for making sure if is the user itself to request deleting the account
        if ((!isValidUserName(allUserList ,profile.getUserName()))
                && (checkIfPasswordCorrect(profile,enteredPassword))) {

            ArrayList<Profile> userList = allUserList;
            //ArrayList<UserAccount> userAccList = database.getAllUserAccount();

            userList.remove(profile);
            //userAccList.remove(new UserAccount(profile));
            this.allUserList = userList;

            //database.setAllUserAccount(userAccList);
            return true;

        }
        return false;

    }


}
