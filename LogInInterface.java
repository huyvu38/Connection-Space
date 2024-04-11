import java.util.ArrayList;

public interface LogInInterface {

    /**
     * Checks if the provided username is valid and not already taken.
     *
     * @param allUserList The list of all user profiles.
     * @param usersName The username to check.
     * @return true if the username is valid, false otherwise.
     */
    boolean isValidUserName(ArrayList<Profile> allUserList, String usersName);

    /**
     * Checks if the provided password meets the system's length requirements and does not contain prohibited characters.
     *
     * @return true if the password meets the requirements, false otherwise.
     */
    boolean checkPasswordLength();

    /**
     * Verifies if the provided password matches the user's password.
     *
     * @param profile The user's profile.
     * @param userPassword The password to check.
     * @return true if the password matches, false otherwise.
     */
    boolean checkIfPasswordCorrect(Profile profile, String userPassword);

    /**
     * Checks if the username format meets the system's requirements.
     *
     * @return true if the username format is valid, false otherwise.
     */
    boolean checkUserNameFormat();

    /**
     * Attempts to create a new user account with the specified details.
     *
     * @param database The database to add the new user account to.
     * @return true if the account is successfully created, false otherwise.
     */
    boolean createAccount(Database database);

    /**
     * Deletes a user account from the database after verifying the entered password.
     *
     * @param data The database from which to delete the account.
     * @param userAccount The user account to delete.
     * @param enteredPassword The password entered for verification.
     * @return true if the account is successfully deleted, false if the password does not match.
     */
    boolean deleteAccount(Database data, UserAccount userAccount, String enteredPassword);

    /**
     * Attempts to log a user into their account using their username and password.
     *
     * @param username The user's username.
     * @param userPassword The user's password.
     * @return true if login is successful, false otherwise.
     */
    boolean loginAccount(String username, String userPassword);
}
