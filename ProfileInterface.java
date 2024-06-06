/**
 * Team Project
 *
 * ProfileInterface.java
 *
 * @author Huy Vu, Yanxin Yu - CS180 - L22
 * @version 28 March 2024
 */

public interface ProfileInterface {
    String getUsername();
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
    String toString();
}
