import java.util.ArrayList;
/**
 * Team Project
 *
 * LogInInterface.java
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */

import java.util.ArrayList;

public interface LogInInterface { //Fix this!! "No usages" for each method because of static
    private static boolean isValidUserName(ArrayList<Profile> allUserList, String userName) {
        return false;
    }

    static boolean checkPasswordLength(String password) {
        return false;
    }

    static boolean checkIfPasswordCorrect(Profile profile, String password) {
        return false;
    }

    static boolean createAccount(Database database, Profile newProfile) {
        return false;
    }

    static boolean deleteAccount(Database database, Profile profile, String enteredPassword) {
        return false;
    }

    static boolean loginAccount(Database database, Profile profile, String userName, String password) {
        return false;
    }
}



