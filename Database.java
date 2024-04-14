import java.util.ArrayList;
import java.io.*;
import java.io.File;

/**
 * Team Project
 *
 * Database.java
 *
 * @author Gabe Turner, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class Database implements DatabaseInterface {
    private String allUserAccountFile; // file name of save file
    private ArrayList<UserAccount> allUserAccount;

    public Database(String allUserAccountFile) {
        this.allUserAccountFile = allUserAccountFile;
        this.allUserAccount = new ArrayList<>();
    }

    public boolean readAllUserAccount() {
        // read from file and make array of account objects
        try {
            File f = new File(allUserAccountFile);
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String firstline = bfr.readLine();
            String line = bfr.readLine();
            while (line != null) {
                String[] element = line.split(";");
                String[] userInfo = element[0].split(" ");
                Profile profile = new Profile(userInfo[0], userInfo[1], Integer.parseInt(userInfo[2]),
                        userInfo[3], userInfo[4], userInfo[5], userInfo[6]);
                String friendList = element[1].substring(12, element[1].length() - 1);
                ArrayList<String> friends = new ArrayList<>();
                String[] eachFriend = friendList.split(" ");
                for (String username : eachFriend) {
                    friends.add(username);
                }
                String blockList = element[2].substring(11, element[2].length() - 1);
                ArrayList<String> blockusers = new ArrayList<>();
                String[] eachBlockUser = blockList.split(" ");
                for (String username : eachBlockUser) {
                    blockusers.add(username);
                }
                UserAccount userAccount = new UserAccount(profile);
                userAccount.setFriendList(friends);
                userAccount.setBlockList(blockusers);
                allUserAccount.add(userAccount);
                line = bfr.readLine();
            }
            bfr.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean saveAllUserAccount() {
        try {
            FileOutputStream fos = new FileOutputStream(allUserAccountFile);
            PrintWriter pw = new PrintWriter(fos);
            pw.println("Database of User Account");
            for (int i = 0; i < allUserAccount.size(); i++) {
                pw.println(allUserAccount.get(i).toString());
            }
            pw.flush();
            pw.close();

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public ArrayList<UserAccount> getAllUserAccount() {
        return allUserAccount;
    }

    public void setAllUserAccount(ArrayList<UserAccount> allUserAccount) {
        this.allUserAccount = allUserAccount;
    }
}