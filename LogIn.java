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
                return true;
            }
        }
        return false;
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
