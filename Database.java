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
    private ArrayList<Profile> allUserProfile;
    private ArrayList<UserAccount> allUserAccount;
    private String databaseOutput;
    public Database (String allUserAccountFile, String allUserProfileFile, String databaseOutput) {
        this.allUserAccountFile = allUserAccountFile;
        this.allUserProfileFile = allUserProfileFile;
        this.databaseOutput = databaseOutput;
        this.allUserProfile = new ArrayList<Profile>();
        this.allUserAccount = new ArrayList<UserAccount>();
    }
    public boolean readAllUserAccount(String allUserAccountFile) {}
    public boolean readAllUserProfile(String allUserAccountFile) {}
    public boolean userCreateAccount(UserAccount newUserAccount) {}
    public boolean userDeleteAccount(UserAccount deleteUserAccount) {}
    public boolean userEditAccount(UserAccount userEditAccount)
    //What if the user create account
    //What if the user delete account
    //What if the user change anything in Profile.java or UserAccount.java
    public boolean output(String databaseOutput)


}
