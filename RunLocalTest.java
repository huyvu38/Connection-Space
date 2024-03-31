import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Team Project
 * <p>
 * RunLocalTest.java
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */

@RunWith(Enclosed.class)
public class RunLocalTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ProfileTestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Test ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    } // end of main

    @RunWith(Enclosed.class)
    public static class ProfileTestCase {
        private Profile profile;
        // Set profile for each test with @Before to run before each test
        @Before
        public void setProfile() {
            profile = new Profile("abaldocc", "whatsup", 20, "Male",
                    "Salvadorian", "Building Manager", "Soccer");
        } // end of setProfile

        /*Testing of constructors and getters*/
        @Test
        public void profileTestGettersAndConstructor() {
            assertEquals("Username should be abaldocc", "abaldocc", profile.getUserName());
            assertEquals("Password should be whatsup", "whatsup", profile.getPassword());
            assertEquals("Age should be 20", 20, profile.getAge());
            assertEquals("Gender should be Male", "Male", profile.getGender());
            assertEquals("Nationality should be Salvadorian", "Salvadorian", profile.getNationality());
            assertEquals("Job should be Building Manager", "Building Manager", profile.getJob());
            assertEquals("Hobby should be Soccer", "Soccer", profile.getHobby());
        }

        // testing setters
        @Test
        public void profileSetterTest() {
            profile.setPassword("whyynot");
            assertEquals("Password should now be whyynot", "whyynot", profile.getPassword());
            profile.setAge(18);
            assertEquals("Age should now be 18", 18, profile.getAge());
            profile.setGender("Female");
            assertEquals("Gender should now be Female", "Female", profile.getGender());
            profile.setNationality("American");
            assertEquals("Nationality should now be American", "American", profile.getNationality());
            profile.setJob("Student");
            assertEquals("Job should now be Student", "Student", profile.getJob());
            profile.setHobby("Poker");
            assertEquals("Hobby should now be Poker", "Poker", profile.getHobby());
        }
        // testing toString
        @Test
        public void toStringTest() {
            String input = "abaldocc,whatsup,20,Male,Salvadorian,Building Manager,Soccer";
            assertEquals("toString method should name,password,age,gender,nationality,job,hobby" +
                            " with a comma and no space after the comma.", input, profile.toString());
        }

    } // end of test case
    public static class UserAccountTest {
        private Profile profile;
        private UserAccount userAccount;
        private ArrayList<String> friendList;
        private ArrayList<String> blockList;

        // Set profile and userAcount for each test with @Before to run before each test
        @Before
        public void setUserPandU() {
            profile = new Profile("abaldocc", "whatsup", 20, "Male",
                    "Salvadorian", "Building Manager", "Soccer");
            userAccount = new UserAccount(profile);
            friendList = new ArrayList<>();
            blockList = new ArrayList<>();
            friendList.add("archie");
            blockList.add("Frigolet");
            userAccount.setFriendList(friendList);
            userAccount.setBlockList(blockList);
        }
        @Test
        public void getUserAccountTest() {
            assertEquals("Make sure UserAccount properly gets the profile information.",
                    profile, userAccount.getUserProfile());
            assertEquals("Make sure blockList is implemented correctly.",
                    blockList, userAccount.getBlockList());
            assertEquals("Make sure friendList is implemented correctly.",
                    friendList, userAccount.getFriendList());
        }

        @Test
        public void UserSetterTest() {
            friendList.add("Matt");
            userAccount.setFriendList(friendList);
            ArrayList<String> newFriendList = new ArrayList<>(Arrays.asList("archie", "Matt"));
            assertEquals("Friend list should now be [archie, Matt]", newFriendList, userAccount.getFriendList());
            blockList.add("Pablo");

            userAccount.setBlockList(blockList);
            ArrayList<String> newBlockList = new ArrayList<>(Arrays.asList("Frigolet", "Pablo"));
            assertEquals("Block list should now be [Frigolet, Pablo]", newBlockList, userAccount.getBlockList());
        }
        @Test
        public void toStringTest() {
            String a = String.format(";FriendList:[%s];BlockList:[%s]", userAccount.getFriendList(),
                    userAccount.getBlockList());
            String formatToString = profile.toString() + a;
            assertEquals("Make sure the toString method matches correctly outputs the data.", formatToString,
                    userAccount.toString());
        }

    } // end of UserAccountTest
} // end of class
