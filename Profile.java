/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class Profile implements ProfileInterface{
    private String userName;
    private String password;
    private int age;
    private String gender;
    private String nationality;
    private String job;
    private String hobby;
    public Profile (String userName, String password, int age, String gender, String nationality, String job, String hobby) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.job = job;
        this.hobby = hobby;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    public String toString() {
        return this.userName + "," + this.password + "," + this.age + "," + this.gender
                + "," + this.nationality + "," + this.job + "," + this.hobby;
    }
}
