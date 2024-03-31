import java.util.ArrayList;

/**
 * Team Project
 *
 * LogIn.java
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 30 March 2024
 */


public class LogIn implements LogInInterface {
    private Database database; // Our current database that contain all users' profile
    private Profile logInUserProfile;
    private String userName;
    private String password;

    public LogIn(Database database, Profile logInUserProfile, String userName, String password) {
        this.database = database;
        this.logInUserProfile = logInUserProfile;
        this.userName = userName;
        this.password = password;
    }

    public boolean isValidUserName(ArrayList<Profile> allUserList, String userName) {

        for (Profile eachProfile : allUserList) {
            if (eachProfile.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }


    public boolean checkPasswordLength(String password) {
        if (password.length() >= 6) {
            return true;
        }

        return false;
    }

    public boolean checkIfPasswordCorrect(Profile profile, String password) {
        if (profile.getPassword().equals(password)) {
            return true;
        }
        return false;
    }


    public boolean createAccount(Database database, Profile newProfile) {
        boolean userNameFormateCorrect = true;
        if (newProfile.getUserName().length() < 4 || newProfile.getUserName().contains(" ")) {
            userNameFormateCorrect = false;
        }
        if (isValidUserName(database.getAllUserProfile(), newProfile.getUserName())
                && (checkPasswordLength(newProfile.getPassword())) && userNameFormateCorrect) {
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

    public boolean deleteAccount(Database database, Profile profile, String enteredPassword) {
        if ((!isValidUserName(database.getAllUserProfile(), profile.getUserName()))
                && (checkIfPasswordCorrect(profile, enteredPassword))) {

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

    public boolean loginAccount(Database database,Profile profile, String userName, String password) {

       return (!isValidUserName(database.getAllUserProfile(), userName))
               && checkIfPasswordCorrect(profile, password);

    }
}

