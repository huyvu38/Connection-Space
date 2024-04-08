import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        Database database = new Database("AllUserAccount.txt");
        database.readAllUserAccount();
        ArrayList<Profile> allUserProfile = database.getAllUserProfile();
        ArrayList<UserAccount> allUserAccount = database.getAllUserAccount();
        ArrayList<String> friendlist = allUserAccount.get(0).getFriendList();
        ArrayList<String> blocklist = allUserAccount.get(0).getBlockList();
        System.out.println(friendlist.toString());

    }
}
