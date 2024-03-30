/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
import java.util.ArrayList;

public class LogIn {


    public boolean createAccount (ArrayList<Profile> allUserList, String name, String password) {
        if (isValidUserName(allUserList,name)) {

            return true;

        }

        return false;
    }
    public boolean isValidUserName (ArrayList<Profile> allUserList, String userName) {
        for (Profile eachProfile : allUserList) {
            if (eachProfile.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }

    //Check if user name is already exist first
    //Check password is over than 6 character

    //public boolean deleteAccount (String userName, String password) {}
    //public boolean loginAccount (String userName, String password) {}
}
