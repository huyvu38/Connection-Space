/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public interface ProfileInterface {
    String getUserName();
    void setUserName(String userName);
    String getPassword();
    void setPassword(String password);
    int getAge();
    void setAge(int age);
    String getGender();
    void setGender(String gender);
    String getNationality();
    void setNationality(String nationality);
    String getJob();
    void setJob(String job);
    String getHobby();
    void setHobby(String hobby);
}
