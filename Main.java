import java.io.*;
import java.util.ArrayList;

public boolean readAllUserAccount() {
    try {
        FileReader fr = new FileReader(this.allUserAccountFile);
        BufferedReader bfr = new BufferedReader(fr);
        String line = "";
        while ((line = bfr.readLine()) != null) {
            String[] smallData = line.split(";");
            String[] info = smallData[0].split(",");
            int abdec = Integer.parseInt(info[2]);
            Profile eachProfile = new Profile(info[0], info[1], abdec, info[3], info[4], info[5], info[6]);
            allUserProfile.add(eachProfile);
            String ok = smallData[1].substring(13 ,smallData[1].length()-1);
            ArrayList<String> allFriendList = new ArrayList<>();
            String[] abc = ok.split(",");
            for (String def : abc) {
                allFriendList.add(def);
            }
            String aha = smallData[2].substring(12, smallData[2].length()-1);
            ArrayList<String> allBlockList = new ArrayList<>();
            String[] abcd = aha.split(",");
            for (String nope : abcd) {
                allBlockList.add(nope);
            }
            UserAccount eachUserAccount = new UserAccount(eachProfile);
            eachUserAccount.setFriendList(allFriendList);
            eachUserAccount.setBlockList(allBlockList);
            allUserAccount.add(eachUserAccount);
        }
        bfr.close();
    } catch (IOException e) {
        return false;
    }
    return true;
}
public void change (String username, String newuser) {
    for (UserAccount yolo : this.allUserAccount) {
        if (yolo.getFriendList().equals(username)) {
            yolo.getFriendList().remove(username);
            yolo.getFriendList().add(newuser);
        }
        if (yolo.getBlockList().equals(username)) {
            yolo.getBlockList().remove(username);
            yolo.getBlockList().add(newuser);
        }
    }
}
public boolean output() {
    try {
        PrintWriter pw = new PrintWriter(new FileOutputStream(this.allUserAccountFile));
        for (UserAccount yeh : allUserAccount) {
            pw.println(yeh);
        }
        pw.flush();
        pw.close();
    } catch (IOException e) {
        return false;
    }
    return true;
}