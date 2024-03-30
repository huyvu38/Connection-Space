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
    public boolean checkPasswordLength (String password) {
        if (password.length() == 6) {
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

    public boolean createAccount (Database database, Profile newProfile) {
        if (isValidUserName(database.getAllUserProfile(),newProfile.getUserName())
                && (checkPasswordLength(newProfile.getPassword()))) {
            ArrayList<Profile> userList = database.getAllUserProfile();
            ArrayList<UserAccount> userAccList = database.getAllUserAccount();

            userList.add(newProfile);
            userAccList.add(new UserAccount(newProfile));

            database.setAllUserProfile(userList);
            database.setAllUserAccount(userAccList);

        }
        return false;

    }


    //Check if user name is already exist first
    //Check password is over than 6 character

    public boolean deleteAccount (ArrayList<Profile> allUserList, String userName, String password) {
        if (isValidUserName(database.getAllUserProfile(),newProfile.getUserName())
                && (checkPasswordLength(newProfile.getPassword()))) {
            ArrayList<Profile> userList = database.getAllUserProfile();
            ArrayList<UserAccount> userAccList = database.getAllUserAccount();

            userList.add(newProfile);
            userAccList.add(new UserAccount(newProfile));

            database.setAllUserProfile(userList);
            database.setAllUserAccount(userAccList);

        }
        return false;

    }
        return isValidUserName(allUserList,userName) && checkPasswordLength(password);
    }
    //public boolean loginAccount (String userName, String password) {}
}
