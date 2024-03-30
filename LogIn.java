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
                return true;
            }
        }
        return false;
    }

    //Check if user name is already exist first
    //Check password is over than 6 character

    //public boolean deleteAccount (String userName, String password) {}
    //public boolean loginAccount (String userName, String password) {}
}
