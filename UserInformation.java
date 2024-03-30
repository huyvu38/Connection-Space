import java.util.ArrayList;

public class UserInformation {
    private String username;
    private String password;
    private User profile;
    private ArrayList<User> friendList;
    private ArrayList<User> blockList;
    private ArrayList<User> allUserInSocialMedia;

    public UserInformation(String username, String password, int age, String nationality, String job, String hobby, String bio, ArrayList<User> allUserInSocialMedia) {
        this.username = username;
        this.password = password;
        this.profile = new User(age, bio, nationality, job, hobby, username);
        this.friendList = new ArrayList<>();
        this.blockList = new ArrayList<>();
        this.allUserInSocialMedia = new ArrayList<>(allUserInSocialMedia);

    }

    //add  get/set methods
}
