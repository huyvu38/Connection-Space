import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        System.out.println(searchUser("vu28", "a"));
    }
    public static ArrayList<String> searchUser(String userNameOne, String word) {
        ArrayList<String> findUserName = new ArrayList<>();
        //Check if no account block user1
        for (UserAccount userAccount : Server.allUserAccount) {
            if (userAccount.getUserProfile().getUserName().contains(word)) {
                boolean userOneIsBlocked = false;
                for (String blockListOfUserTwo : userAccount.getBlockList()) {
                    //That user not block user1
                    if (blockListOfUserTwo.equals(userNameOne) == true) {
                        userOneIsBlocked = true;
                        break;
                    }
                }
                if (userOneIsBlocked == false) {
                    findUserName.add(userAccount.getUserProfile().getUserName());
                }
            }
        }
        //Check if user 1 block any one in the findUserName
        for (UserAccount userAccount : Server.allUserAccount) {
            if (userAccount.getUserProfile().getUserName().equals(userNameOne)) {
                for (String eachBlockUserOfUserOne : userAccount.getBlockList()) {
                    for (String eachUser : findUserName) {
                        if (eachUser.equals(eachBlockUserOfUserOne)) {
                            findUserName.remove(eachUser);
                        }
                    }
                }
            }
        }
        return findUserName;
    }
}
