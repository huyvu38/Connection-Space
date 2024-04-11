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
    private Profile UserProfile;
    private String userName;
    private String password;

    public LogIn(Database database, Profile loginUserProfile, String usersName, String userPassword) {
        this.database = database;
        this.UserProfile = loginUserProfile;
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


    public boolean checkPasswordLength() {
        return password.length() >= 6 && !password.contains(" ") && !password.contains(";");
    }

    public boolean checkIfPasswordCorrect(Profile profile, String userPassword) {
        return profile.getPassword().equals(userPassword);

    }
    public boolean checkUserNameFormat() {
        return userName.length() >= 4 && !userName.contains(" ") && !userName.contains(";");
    }

    /**
     * Deletes a specific user account from the database, requiring confirmation with the user's password.
     *
     * @return {@code true} if the account is successfully deleted, {@code false} if the password does not match.
     */
    public boolean createAccount(Database database) {
        // 1) check if the username already exist in the database
        // 2) check if the password satisfy the requirements
        // 2) check if the username satisfy the requirements

        if (isValidUserName(database.getAllUserProfile(), userName)
                && (checkPasswordLength())
                && checkUserNameFormat()) {
            //ArrayList<Profile> userList = data.getAllUserProfile();
            ArrayList<UserAccount> userAccList = database.getAllUserAccount();

            //userList.add(newProfile);
            UserAccount userAccount = new UserAccount(UserProfile);
            userAccList.add(userAccount);


            database.setAllUserAccount(userAccList);
            return true;

        }
        return false;

    }


    public boolean deleteAccount(Database data, UserAccount userAccount, String enteredPassword) {
        if (checkIfPasswordCorrect(userAccount.getUserProfile(), enteredPassword)) {

            ArrayList<UserAccount> userList = data.getAllUserAccount();

            userList.remove(userAccount);

            data.setAllUserAccount(userList);
            return true;

        }
        return false;

    }

    public boolean loginAccount(String username, String userPassword) {
        if (isValidUserName(database.getAllUserProfile(), username)) {
            for (UserAccount eachUserAccount: database.getAllUserAccount()) {
                if (eachUserAccount.getUserProfile().getUserName().equals(username)) {
                    if (eachUserAccount.getUserProfile().getPassword().equals(userPassword)) {
                        System.out.println("Login in Successful");
                        return true;
                    } else {
                        System.out.println("Password is not correct! Try again.");
                    }
                }
            }

        } else {
            System.out.println("Username not exist!");
            System.out.println("Try Again or create a new account.");
        }
        return false;
    }
}

