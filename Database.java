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
    private ArrayList<Profile> allUserProfile;
    private ArrayList<UserInformation> allUserInformation;
    private String allUserProfileFile;
    private String allUserInformationFile;
    public Database (String allUserInformationFile, String allUserProfileFile, String databaseOutput) {
        this.allUserInformationFile = allUserInformationFile;
        this.allUserProfileFile = allUserProfileFile;
        this.databaseOutput = databaseOutput;
        this.allUserProfile = new ArrayList<>();
        this.allUserInformation = new ArrayList<>();
    }
    public boolean readAllUserInformation(String allUserInformationFile) {}
    public boolean readAllUserProfile(String allUserProfileFile) {}
    public boolean updateAllUserInformation(){}
    public boolean updateAllUserProfile(){}
    public boolean output(String databaseOutput)


}
