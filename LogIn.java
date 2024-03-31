
import java.util.ArrayList;

/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Yanxin Yu, L22
 * @version 30 March 2024
 */

public class LogIn {

    //Maybe we can check the username should be atleast 4 characters and do not contains any space
    //Maybe use contains(" ") to check
    public boolean isValidUserName (ArrayList<Profile> allUserList, String userName) {
        for (Profile eachProfile : allUserList) {
            if (eachProfile.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }


    public boolean checkPasswordLength (String password) {
        if (password.length() >= 6) {
            return true;
        }

        return false;
    }

    public boolean checkIfPasswordCorrect (Profile profile, String password) {
        if (profile.getPassword().equals(password)) {
            return true;
        }
        return false;
    }


    public boolean createAccount (Database database, Profile newProfile) {
        if (isValidUserName(database.getAllUserProfile(),newProfile.getUserName())
                && (checkPasswordLength(newProfile.getPassword()))) {
            ArrayList<Profile> userList = database.getAllUserProfile();
            //ArrayList<UserAccount> userAccList = database.getAllUserAccount();

            userList.add(newProfile);
            //userAccList.add(new UserAccount(newProfile));

            database.setAllUserProfile(userList);
            //database.setAllUserAccount(userAccList);
            return true;

        }
        return false;

    }

    public boolean deleteAccount (Database database, Profile profile, String enteredPassword) {
        if ((!isValidUserName(database.getAllUserProfile(),profile.getUserName()))
                && (checkIfPasswordCorrect(profile,enteredPassword))) {

            ArrayList<Profile> userList = database.getAllUserProfile();
            //ArrayList<UserAccount> userAccList = database.getAllUserAccount();

            userList.remove(profile);
            //userAccList.remove(new UserAccount(profile));

            database.setAllUserProfile(userList);
            //database.setAllUserAccount(userAccList);
            return true;

        }
        return false;

    }

    public boolean loginAccount (Database database,Profile profile,String userName, String password) {

       return (!isValidUserName(database.getAllUserProfile(), userName))
               && checkIfPasswordCorrect(profile,password);

    }
}

