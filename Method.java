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

    public Method(ArrayList<Profile> allUserList, ArrayList<String> friendList,
                  ArrayList<String> blockList, Profile userProfile) {
        this.allUserList = allUserList;
        this.friendList = friendList;
        this.blockList = blockList;
        this.userProfile = userProfile;
    }

    public Method() {

    }
    //a method to extract the userProfile given the userName
    public UserAccount searchAccount(String userName) {
        UserAccount account = null;
        Database database = new Database("AllUserAccount.txt");
        for (UserAccount userAccount: database.getAllUserAccount()) {
            if (userAccount.getUserProfile().getUserName().equals(userName)) {
                account = userAccount;
            }
        }
        return account;
    }

    public boolean usernameInDatabase(ArrayList<Profile> allUsersList, String userName) {
        for (Profile eachProfile : allUsersList) {
            if (eachProfile.getUserName().equals(userName)) {
                return true; //User exist in the database
            }
        }
        return false; // User doesn't exist in the database
    }
    public boolean inFriendList(ArrayList<Profile> allUsersList, ArrayList<String> friendsList, String userName) {
        if (usernameInDatabase(allUsersList, userName)) {
            for (String eachFriend : friendsList) {
                if (eachFriend.equals(userName)) {
                    return true;
                }
            }
        }
        return false;
    }

    //
    public boolean inBlockList(ArrayList<Profile> allUsersList, ArrayList<String> blocksList,
                               String userNameWantBlock) {
        if (usernameInDatabase(allUsersList, userNameWantBlock)) {
            for (String eachBlockUser : blocksList) {
                if (eachBlockUser.equals(userNameWantBlock)) {
                    return true;
                }
            }
        }
        return false;
    }



    public boolean addFriend(ArrayList<Profile> allUsersList, ArrayList<String> friendsList,
                             ArrayList<String> blocksList, String userName) {
        if (usernameInDatabase(allUsersList, userName)) {
            if (inBlockList(allUsersList, blocksList, userName)) {
                return false; //Already block user
            }
            if (inFriendList(allUsersList, friendsList, userName)) {
                return false; // already in the friend list
            }
            return true;
        }
        return false;
    }
    public boolean removeFriend(ArrayList<Profile> allUsersList, ArrayList<String> friendsList,
                                ArrayList<String> blocksList, String userName) {
        if (usernameInDatabase(allUsersList, userName)) {
            if (inBlockList(allUsersList, blocksList, userName)) {
                return false; //Already in block list
            }
            if (inFriendList(allUsersList, friendsList, userName)) {
                return true; //That username in the list so can remove friend
            }
        }
        return false;
    }
    public boolean blockUser(ArrayList<Profile> allUsersList, ArrayList<String> blocksList, String userName) {
        if (usernameInDatabase(allUsersList, userName)) {
            if (!inBlockList(allUsersList, blocksList, userName)) {
                return true; //Already block
            }
        }
        return false;
    }
    public boolean unblockUser(ArrayList<Profile> allUsersList, ArrayList<String> blocksList, String userName) {
        if (usernameInDatabase(allUsersList, userName)) {
            if (inBlockList(allUsersList, blocksList, userName)) {
                return true;
            }
        }
        return false;
    }
    public boolean searchUser(ArrayList<Profile> allUsersList, ArrayList<String> blocksList, String username) {
        for (Profile eachProfile : allUsersList) {
            //Check all username
            if (eachProfile.getUserName().equals(username)) {
                //Do not display username in block list
                if (inBlockList(allUsersList, blocksList, username) == false) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIfPasswordCorrect(Profile profile, String password) {
        return profile.getPassword().equals(password);
    }
    public boolean deleteAccount(ArrayList<Profile> allUsersList, Profile profile, String enteredPassword) {
        // parameter String enteredPassword:
        // is for making sure if is the user itself to request deleting the account
        if ((usernameInDatabase(allUsersList , profile.getUserName()))
                && (checkIfPasswordCorrect(profile, enteredPassword))) {

            ArrayList<Profile> userList = allUsersList;
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
