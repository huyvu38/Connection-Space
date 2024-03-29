import java.util.ArrayList;

/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class Method {
    public boolean isFriend (ArrayList<Profile> friendList, String userName) {
        for (Profile eachProfile : friendList) {
            if (eachProfile.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
    public boolean inBlockList (ArrayList<Profile> blockList, String userName) {
        for (Profile eachProfile : blockList) {
            if (eachProfile.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
}
