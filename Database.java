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
    public Database (String allUserAccountFile, String allUserAccount, String databaseOutput) {
        this.allUserAccountFile = allUserAccountFile;
        this.allUserAccount = new ArrayList<>();
        this.databaseOutput = databaseOutput;
    }
    public boolean readAllUserAccount(String allUserAccountFile) {}
    public boolean updateAllUserAccount(){}
    public boolean output(String databaseOutput)


}
