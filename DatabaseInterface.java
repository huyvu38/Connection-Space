import java.util.ArrayList;

/**
 * Team Project
 *
 * DatabaseInterface.java
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public interface DatabaseInterface {
    boolean readAllUserAccount();
    boolean saveAllUserAccount();
    ArrayList<Profile> getAllUserProfile();
    void setAllUserProfile(ArrayList<Profile> allUserProfile);
    ArrayList<UserAccount> getAllUserAccount();
    void setAllUserAccount(ArrayList<UserAccount> allUserAccount);
}
