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
    private ArrayList<UserAccount> allUserAccount;
    private String databaseOutput;
    public Database (String allUserAccountFile, String databaseOutput) {
        this.allUserAccountFile = allUserAccountFile;
        this.allUserAccount = new ArrayList<UserAccount>();
        this.databaseOutput = databaseOutput;
    }
    public boolean readAllUserAccount(String allUserAccountFile) {}
    public boolean readAllUserProfile(String allUserAccountFile) {}
    public boolean userCreateAccount(UserAccount newUserAccount) {}
    public boolean userDeleteAccount(UserAccount deleteUserAccount) {}
    //If user edit username ->
    //(need to use updateFriendUserName & updateBlockUserName) cuz that user may be in another friendlist or blocklist


    //If the user edit any thing in the profile outside username
    public boolean userEditInformation(UserAccount userEditAccount)

    //Store back to the allUserAccount.txt
    public boolean output(String databaseOutput) {}


}
