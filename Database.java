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
    private String databaseOutput;
    private ArrayList<UserInformation> allUserInformation;
    private String allUserInformationFile;
    public Database (String allUserInformationFile, String allUserProfileFile, String databaseOutput) {
        this.allUserInformationFile = allUserInformationFile;
        this.databaseOutput = databaseOutput;
        this.allUserInformation = new ArrayList<>();
    }
    public boolean readAllUserInformation(String allUserInformationFile) {}
    public boolean updateAllUserInformation(){}
    public boolean output(String databaseOutput)


}
