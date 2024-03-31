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

    //public ArrayList<UserAccount> getAllUserAccount();

    //public void setAllUserAccount(ArrayList<UserAccount> allUserAccount);

    public ArrayList<Profile> getAllUserProfile();

    public void setAllUserProfile(ArrayList<Profile> allUserProfile);
}
