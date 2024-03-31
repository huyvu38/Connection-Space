import java.util.ArrayList;
import java.io.*;
import java.io.File;

/**
 * Team Project
 *
 * Database.java
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class Database implements DatabaseInterface {
    //Maybe we should store every data in AllUserAccount.txt
    //jay89,abcdef32,32,Female,USA,teacher,volleyball;FriendList:[vu28 abaldocc];BlockList:[george333 george23 alvin333]
    //Split by ;
    //Profile is jay89,abcdef32,32,Female,USA,teacher,volleyball
    //FriendList is FriendList:[vu28 abaldocc]
    //BlockList is BlockList:[george333 george23 alvin333]
    //FriendList and BlockList then split by the space between users
    private String allUserProfileFile; // file name of save file
    private ArrayList<Profile> allUserProfile;
    private ArrayList<UserAccount> allUserAccount;

    private String[] userInfo = {null,null,null,null,null,null,null};

    public Database (String allUserProfileFile) {
        this.allUserProfileFile = allUserProfileFile;
        //this.allUserProfile = new ArrayList<>();

        // read from file and make array of profile objects
        try {
            File f = new File(allUserProfileFile);
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);

            String line = bfr.readLine();

            while(line != null) {

                if (line.equals("----- END OF SAVE -----")) {
                        line = bfr.readLine();
                    if (line != null) {
                        allUserProfile.clear();
                    } else {
                        break;
                    }
                }
            }


                // create user from line
                //name,password,age,gender,nationality,job,hobby
                userInfo = line.split(",", 7);
                Profile profile = new Profile(userInfo[0],userInfo[1],Integer.parseInt(userInfo[2]),userInfo[3],userInfo[4],userInfo[5],userInfo[6]);
                allUserProfile.add(profile);
                line = bfr.readLine();

            bfr.close();


        } catch (FileNotFoundException e) {
            System.out.println("allUserProfileFile not found");
            //e.printStackTrace(); printStack will crash the program
        } catch (IOException e) {
            System.out.println("IOException");
            //e.printStackTrace();
        }

    }

    public ArrayList<Profile> getAllUserProfile() {
        return allUserProfile;
    }

    public void setAllUserProfile(ArrayList<Profile> allUserProfile) {
        this.allUserProfile = allUserProfile;
    }

    // take a profile name as an inout and returns that profile obejct or null if the object does not exist
    public Profile searchProfile(String profileName) {
        for(int i = 0; i < allUserProfile.size(); i++) {
            if (allUserProfile.get(i).getUserName().equals(profileName)) {
                return allUserProfile.get(i);
            }

        }
        return null;

    }

    public boolean saveAllUserProfile() {
        try {
            FileOutputStream fos = new FileOutputStream(allUserProfileFile, true);
            PrintWriter pw = new PrintWriter(fos);

            for (int i = 0; i < allUserProfile.size(); i++) {
                pw.println(allUserProfile.get(i).toString());
            }
            pw.println("----- END OF SAVE -----");
            pw.flush();
            pw.close();

        } catch (FileNotFoundException e) {
            System.out.println("file to save to not found");
            return false;
        }
        return true;

    }
    //public boolean readAllUserAccount(String allUserAccountFile) {}
    //public boolean readAllUserProfile(String allUserProfileFile)

    //Store back to the allUserAccount.txt
    //public boolean outputAllUserAccount() {}

    //Store back to the allUserProfile.txt
    //public boolean outputAllUserProfile() {}


    //If user edit username -> this.allUserProfile & this.allUserAccount
    //(need to use updateFriendUserName & updateBlockUserName) cuz that user may be in another friendlist or blocklist
    //public boolean userEditUserName(UserAccount user)

    //If the user edit any thing in the profile outside username
    //Update both this.allUserProfile & this.allUserAccount
    //public boolean userEditInformation(UserAccount user)



}
