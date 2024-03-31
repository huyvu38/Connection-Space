/**
 * Team Project
 *
 * ProfileInterface.java
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */

public interface ProfileInterface {
    public String getUserName();
    public String getPassword();
    public void setPassword(String password);
    public int getAge();
    public void setAge(int age);
    public String getGender();
    public void setGender(String gender);
    public String getNationality();
    public void setNationality(String nationality);
    public String getJob();
    public void setJob(String job);
    public String getHobby();
    public void setHobby(String hobby);
    public String toString();
}
