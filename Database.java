import java.util.ArrayList;
import java.io.*;
import java.io.File;

/**
 * Team Project
 *
 * Database.java
 *
 * @author Gabe Turner, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class Database implements DatabaseInterface {
    private String allUserAccountFile; // file name of save file
    private ArrayList<Profile> allUserProfile;
    private ArrayList<UserAccount> allUserAccount;

    public Database(String allUserAccountFile) {
        this.allUserAccountFile = allUserAccountFile;
        this.allUserAccount = new ArrayList<>();
        this.allUserProfile = new ArrayList<>();
    }
    public boolean readAllUserAccount() {
        // read from file and make array of account objects
        try {
            File f = new File(allUserAccountFile);
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String firstline = bfr.readLine();
            String line = bfr.readLine();
            while (line != null) {
                String[] element = line.split(";");
                String[] userInfo = element[0].split(" ");
                Profile profile = new Profile(userInfo[0], userInfo[1], Integer.parseInt(userInfo[2]),
                        userInfo[3], userInfo[4], userInfo[5], userInfo[6]);
                allUserProfile.add(profile);
                String friendList = element[1].substring(12, element[1].length() - 1);
                ArrayList<String> friends = new ArrayList<>();
                String[] eachFriend = friendList.split(" ");
                for (String username : eachFriend) {
                    friends.add(username);
                }
                String blockList = element[2].substring(11, element[2].length() - 1);
                ArrayList<String> blockusers = new ArrayList<>();
                String[] eachBlockUser = blockList.split(" ");
                for (String username : blockusers) {
                    blockusers.add(username);
                }
                UserAccount userAccount = new UserAccount(profile);
                userAccount.setFriendList(friends);
                userAccount.setBlockList(blockusers);
                allUserAccount.add(userAccount);
                line = bfr.readLine();
            }
            bfr.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean saveAllUserAccount() {
        try {
            FileOutputStream fos = new FileOutputStream(allUserAccountFile);
            PrintWriter pw = new PrintWriter(fos);
            pw.println("Database of User Account");
            for (int i = 0; i < allUserAccount.size(); i++) {
                pw.println(allUserAccount.get(i).toString());
            }
            pw.flush();
            pw.close();

        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    public ArrayList<Profile> getAllUserProfile() {
        return allUserProfile;
    }

    public void setAllUserProfile(ArrayList<Profile> allUserProfile) {
        this.allUserProfile = allUserProfile;
    }

    public ArrayList<UserAccount> getAllUserAccount() {
        return allUserAccount;
    }

    public void setAllUserAccount(ArrayList<UserAccount> allUserAccount) {
        this.allUserAccount = allUserAccount;
    }
    public boolean usernameInDatabase(String userName) {
        //From a list of user profile, find the specific username
        for (Profile eachProfile : this.allUserProfile) {
            if (eachProfile.getUserName().equals(userName)) {
                return true; //User exist in the database
            }
        }
        return false; // User doesn't exist in the database
    }
    public boolean inFriendList(String userNameOne, String userNameTwo) {
        //Check if the two usernames is in the SocialMedia database
        if (usernameInDatabase(userNameOne) && usernameInDatabase(userNameTwo)) {
            for (UserAccount userAccount : this.allUserAccount) {
                //Find the account of user1
                //If we find username2 in friend list of username1,
                // we don't have to check username1 in friendlist of username2
                if (userAccount.getUserProfile().getUserName().equals(userNameOne)) {
                    //Check the friend list of user1
                    for (String friend : userAccount.getFriendList()) {
                        if (friend.equals(userNameTwo)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean inBlockList(String userNameOne, String userNameTwo) {
        //Check if the two usernames is in the SocialMedia database
        if (usernameInDatabase(userNameOne) && usernameInDatabase(userNameTwo)) {
            for (UserAccount userAccount : this.allUserAccount) {
                //Find the account of user1 and check if the user1 block user2
                if (userAccount.getUserProfile().getUserName().equals(userNameOne)) {
                    //Check the block list of user1
                    for (String blockUser : userAccount.getBlockList()) {
                        if (blockUser.equals(userNameTwo)) {
                            return true; //Return true if username2 in blocklsit of username1
                        }
                    }
                }
            }
        }
        return false;
        //The method return false if user1 do not block user2
    }
    public boolean addFriend(String userNameOne, String userNameTwo) {
        //Check if the two usernames is in the SocialMedia database
        if (usernameInDatabase(userNameOne) && usernameInDatabase(userNameTwo)) {
            if (inBlockList(userNameOne, userNameTwo)) {
                return false; //User1 block user2
            }
            if (inBlockList(userNameTwo, userNameOne)) {
                return false; //User2 block user1
            }
            if (inFriendList(userNameOne, userNameTwo)) {
                return false; // two users already in the friend list so cannot add friend
            } else {
                //If both users not in friendlist
                for (UserAccount userAccount : this.allUserAccount) {
                    //Find the friendlist of user1
                    if (userAccount.getUserProfile().getUserName().equals(userNameOne)) {
                        ArrayList<String> friendListUserOne = userAccount.getFriendList();
                        //Add the user2 to friend list of user1
                        friendListUserOne.add(userNameTwo);
                        userAccount.setFriendList(friendListUserOne);
                    }
                    //Find the friendlist of user2
                    if (userAccount.getUserProfile().getUserName().equals(userNameTwo)) {
                        ArrayList<String> friendListUserTwo = userAccount.getFriendList();
                        //Add the user1 to friend list of user2
                        friendListUserTwo.add(userNameOne);
                        userAccount.setFriendList(friendListUserTwo);
                    }
                }
                return true; //add friend success
            }
        }
        return false; //If one of two username not in the database
    }
    public boolean deleteFriend(String userNameOne, String userNameTwo) {
        if (usernameInDatabase(userNameOne) && usernameInDatabase(userNameTwo)) {
            if (inFriendList(userNameOne, userNameTwo)) { //both users are friend
                for (UserAccount userAccount : this.allUserAccount) {
                    //Find the friendlist of user1
                    if (userAccount.getUserProfile().getUserName().equals(userNameOne)) {
                        ArrayList<String> friendListUserOne = userAccount.getFriendList();
                        //remove the user2 to friend list of user1
                        friendListUserOne.remove(userNameTwo);
                        userAccount.setFriendList(friendListUserOne);
                    }
                    //Find the friendlist of user2
                    if (userAccount.getUserProfile().getUserName().equals(userNameTwo)) {
                        ArrayList<String> friendListUserTwo = userAccount.getFriendList();
                        //remove the user1 to friend list of user2
                        friendListUserTwo.remove(userNameOne);
                        userAccount.setFriendList(friendListUserTwo);
                    }
                }
                return true; // remove friend successfully
            }
        }
        return false; //If one of two username not in the database or not in the friendlist of each other
    }
    public boolean blockUser(String userNameOne, String userNameTwo) {
        //Check if the two usernames is in the SocialMedia database
        if (usernameInDatabase(userNameOne) && usernameInDatabase(userNameTwo)) {
            if (inBlockList(userNameOne, userNameTwo)) {
                return false; //User1 already block user2
            }
            if (inBlockList(userNameTwo, userNameOne)) {
                return false; //User2 block user1 so user1 cannot block user2
            }
            for (UserAccount userAccount : this.allUserAccount) {
                //Find the blocklist of user1
                if (userAccount.getUserProfile().getUserName().equals(userNameOne)) {
                    ArrayList<String> blockListUserOne = userAccount.getBlockList();
                    //add the user2 to block list of user1
                    blockListUserOne.add(userNameTwo);
                    userAccount.setBlockList(blockListUserOne);
                    if (inFriendList(userNameOne, userNameTwo)) {
                        ArrayList<String> friendListUserOne = userAccount.getFriendList();
                        //Remove the user2 from friendlist of the user1 if they are friends
                        friendListUserOne.remove(userNameTwo);
                        userAccount.setFriendList(friendListUserOne);
                    }
                }
                //Find the account of user2 and remove friend of user1 if user1 block user2
                if (userAccount.getUserProfile().getUserName().equals(userNameTwo)) {
                    if (inFriendList(userNameOne, userNameTwo)) {
                        ArrayList<String> friendListUserTwo = userAccount.getFriendList();
                        //Remove the user1 from friendlist of the user2 if they are friends
                        friendListUserTwo.remove(userNameOne);
                        userAccount.setFriendList(friendListUserTwo);
                    }
                }
            }
            return true; //user1 block user2 successfully
        }
        return false;
    }
    public boolean unblockUser(String userNameOne, String userNameTwo) {
        //Check if the two usernames is in the SocialMedia database
        if (usernameInDatabase(userNameOne) && usernameInDatabase(userNameTwo)) {
            if (inBlockList(userNameOne, userNameTwo)) {
                //User1 block user2 and want to remove user2 from blocklist
                for (UserAccount userAccount : this.allUserAccount) {
                    //Find the blocklist of user1
                    if (userAccount.getUserProfile().getUserName().equals(userNameOne)) {
                        ArrayList<String> blockListUserOne = userAccount.getBlockList();
                        //remove the user2 from the block list of user1
                        blockListUserOne.remove(userNameTwo);
                        userAccount.setBlockList(blockListUserOne);
                        return true;
                    }
                }
            }
        }
        return false;//if one of the username not valid or user2 not in block list of user1
    }
}