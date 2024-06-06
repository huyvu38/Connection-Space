import java.util.ArrayList;

/**
 * Team Project
 *
 * DatabaseInterface.java
 *
 * @author Huy Vu, Yanxin Yu - CS180 - L22
 * @version 28 March 2024
 */
public interface DatabaseInterface {
    boolean readAllUserAccount();
    boolean saveAllUserAccount();
    ArrayList<UserAccount> getAllUserAccount();
    void setAllUserAccount(ArrayList<UserAccount> allUserAccount);
}
