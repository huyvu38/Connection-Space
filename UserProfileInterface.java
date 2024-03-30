import java.util.ArrayList;

public interface UserProfileInterface {
    void createOrUpdateProfile(int age, String gender, String nationality, String job, String hobby);

    void addFriend(User friend);

    void blockUser(User user);

    void unblockUser(User user);

    void removeFriend(User friend);

    String getProfileInformation();

    ArrayList<User> getFriendList();

    ArrayList<User> getBlockedList();
}
