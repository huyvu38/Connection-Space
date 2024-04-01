import java.util.ArrayList;
/**
 * Team Project
 *
 * LogInInterface.java
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public interface LogInInterface {
    boolean isValidUserName(ArrayList<Profile> allUserList, String userName);
    boolean checkPasswordLength(String password);
    boolean checkIfPasswordCorrect(Profile profile, String password);

    boolean createAccount(Database database, Profile newProfile);

    boolean deleteAccount(Database database, Profile profile, String enteredPassword);

    boolean loginAccount(Database database, Profile profile, String userName, String password);
}
