public class User {
    private int age;
    private String bio;
    private String nationality;
    private String job;
    private String hobby;
    private String username;

    public User(int age, String bio, String nationality, String job, String hobby, String username) {
        if(age <= 0) {
            throw new IllegalArgumentException("Age must be a positive number.");
        }
        if(username.contains(" ")) {
            throw new IllegalArgumentException("Username should not contain any spaces.");
        }

        this.age = age;
        this.bio = bio;
        this.nationality = nationality;
        this.job = job;
        this.hobby = hobby;
        this.username = username;
    }


    @Override
    public String toString() {
        return age + "," + bio + "," + nationality + "," + job + "," + hobby;
    }

}
