import java.util.ArrayList;

/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class Database {
    private String allUserAccountFile;
    private String allUserProfileFile;
    private ArrayList<UserAccount> allUserAccount;
    private ArrayList<Profile> allUserProfile;
    public Database (String allUserAccountFile, String allUserProfileFile) {
        this.allUserAccountFile = allUserAccountFile;
        this.allUserAccount = new ArrayList<>();
        this.allUserProfileFile = allUserProfileFile;
        this.allUserProfile = new ArrayList<>();
    }

    public ArrayList<UserAccount> getAllUserAccount() {
        return allUserAccount;
    }

    public void setAllUserAccount(ArrayList<UserAccount> allUserAccount) {
        this.allUserAccount = allUserAccount;
    }

    public ArrayList<Profile> getAllUserProfile() {
        return allUserProfile;
    }

    public void setAllUserProfile(ArrayList<Profile> allUserProfile) {
        this.allUserProfile = allUserProfile;
    }
    //public boolean readAllUserAccount(String allUserAccountFile) {}
    //public boolean readAllUserProfile(String allUserProfileFile)


    //Update both this.allUserProfile & this.allUserAccount
    //public boolean userCreateAccount(UserAccount newUserAccount) {}

    //Update both this.allUserProfile & this.allUserAccount
    //public boolean userDeleteAccount(UserAccount deleteUserAccount) {}

    //If user edit username -> this.allUserProfile & this.allUserAccount
    //(need to use updateFriendUserName & updateBlockUserName) cuz that user may be in another friendlist or blocklist
    //public boolean userEditUserName(UserAccount user)

    //If the user edit any thing in the profile outside username
    //Update both this.allUserProfile & this.allUserAccount
    //public boolean userEditInformation(UserAccount user)

    //Store back to the allUserAccount.txt
    //public boolean outputAllUserAccount() {}

    //Store back to the allUserProfile.txt
    //public boolean outputAllUserProfile() {}


}
