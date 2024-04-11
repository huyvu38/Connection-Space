import java.util.ArrayList;

/**
 * Team Project
 *
 * LogIn.java
 *
 * @author Gabe Turner, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 30 March 2024
 */


public class LogIn implements LogInInterface {
    private Database database; // Our current database that contain all users' profile
    private Profile logInUserProfile;
    private String userName;
    private String password;

    public LogIn(Database database, Profile loginUserProfile, String usersName, String userPassword) {
        this.database = database;
        this.logInUserProfile = loginUserProfile;
        this.userName = usersName;
        this.password = userPassword;
    }

    public boolean isValidUserName(ArrayList<Profile> allUserList, String usersName) {

        for (Profile eachProfile : allUserList) {
            if (eachProfile.getUserName().equals(usersName)) {
                return false;
            }
        }
        return true;
    }


    public boolean checkPasswordLength(String userPassword) {
        return userPassword.length() >= 6;
    }

    public boolean checkIfPasswordCorrect(Profile profile, String userPassword) {
        return profile.getPassword().equals(userPassword);

    }


    public boolean createAccount(Database data, Profile newProfile) {
        boolean userNameFormateCorrect = true;
        if (newProfile.getUserName().length() < 4 ) {
            userNameFormateCorrect = false;
        }
        if (isValidUserName(data.getAllUserProfile(), newProfile.getUserName())
                && (checkPasswordLength(newProfile.getPassword())) && userNameFormateCorrect) {
            ArrayList<Profile> userList = data.getAllUserProfile();
            //ArrayList<UserAccount> userAccList = database.getAllUserAccount();

            userList.add(newProfile);
            //userAccList.add(new UserAccount(newProfile));

            data.setAllUserProfile(userList);
            //database.setAllUserAccount(userAccList);
            return true;

        }
        return false;

    }

    /**
     * Deletes a specific user account from the database, requiring confirmation with the user's password.
     *
     * @param data The database from which the account will be deleted.
     * @param userAccount The user account to be deleted.
     * @param enteredPassword The password entered by the user to confirm the deletion.
     * @return {@code true} if the account is successfully deleted, {@code false} if the password does not match.
     */

    public boolean deleteAccount(Database data, UserAccount userAccount, String enteredPassword) {
        if (checkIfPasswordCorrect(userAccount.getUserProfile(), enteredPassword)) {

            ArrayList<UserAccount> userList = data.getAllUserAccount();

            userList.remove(userAccount);

            data.setAllUserAccount(userList);
            return true;

        }
        return false;

    }

    public boolean loginAccount(Database data, Profile profile, String username, String userPassword) {
        return (!isValidUserName(data.getAllUserProfile(), username))
                && checkIfPasswordCorrect(profile, userPassword);
    }
}

