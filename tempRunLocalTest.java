import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.JUnit4;
import java.nio.file.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Team Project
 * <p>
 * Test case class.
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */

@RunWith(Enclosed.class)
public class tempRunLocalTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Profile test ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        Result result1 = JUnitCore.runClasses(MessageTest.class);
        if (result1.wasSuccessful()) {
            System.out.println("Excellent - Message test ran successfully");
        } else {
            for (Failure failure : result1.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        Result result2 = JUnitCore.runClasses(LogInTest.class);
        if (result2.wasSuccessful()) {
            System.out.println("Excellent - Log in test ran successfully");
        } else {
            for (Failure failure : result2.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        Result result3 = JUnitCore.runClasses(DatabaseTest.class);
        if (result3.wasSuccessful()) {
            System.out.println("Excellent - Database test ran successfully");
        } else {
            for (Failure failure : result3.getFailures()) {
                System.out.println(failure.toString());
            }
        }


    } // end of main

    @RunWith(Enclosed.class)
    public static class TestCase {
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
            profile.setPassword("whyy");
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

    } // end of test case for profile


    @RunWith(JUnit4.class)
    public static class MessageTest {
        private static final String TEST_FILE_PATH = "Messages.txt"; // How does this filepath work?? Is it stored on each of our computers or on github?
        private Message message;

        @Before
        public void setUp() {
            message = new Message();
            try {
                Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
                Files.createFile(Paths.get(TEST_FILE_PATH));
            } catch (Exception e) {
                System.out.println("File path can't be created.");
            }
        }

        @After
        public void tearDown() {
            try {
                Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
            } catch (Exception e) {
                System.out.println("File path can't be created.");
            }
        }

        @Test
        public void messageSuccessful() {
            try {
                message.sendMessage("sender", "receiver", "Test message", false);
                List<String> lines = Files.readAllLines(Paths.get(TEST_FILE_PATH));
                assertTrue("File should contain the sent message", lines.get(0).contains("Test message"));
            } catch (Exception e) {
                System.out.println("Message failed to send.");

            }
        }

        @Test
        public void RemovesMessage() {
            try {
                Files.write(Paths.get(TEST_FILE_PATH), "1,1,2024-03-31 12:00:00,sender,receiver,notBlocked,Test message".getBytes());
                //Message.deleteMessage(1); this has an error
                List<String> lines = Files.readAllLines(Paths.get(TEST_FILE_PATH));
                assertTrue("Deleted message should have status changed", lines.get(0).contains("0"));
            } catch (Exception e) {
                System.out.println("Message failed to delete.");
            }
        }
    }// end of test case for messages


    public static class LogInTest {
        private Database database;
        private LogIn logIn;
        private Profile validProfile;
        private Profile invalidProfile;

        @Before
        public void setUp() {
            database = new Database("testDatabase.txt");
            validProfile = new Profile("ValidPerson", "!Starbucks123", 25, "Gender", "Nationality", "Job", "Hobby");
            invalidProfile = new Profile("Bad", "123", 25, "Gender", "Nationality", "Job", "Hobby");

            ArrayList<Profile> allProfiles = new ArrayList<>();
            allProfiles.add(validProfile);
            database.setAllUserProfile(allProfiles);

            logIn = new LogIn(database, validProfile, validProfile.getUserName(), validProfile.getPassword());
        }

        @Test
        public void testIsValidUserName() {
            assertTrue(logIn.isValidUserName(database.getAllUserProfile(), "NewUser"));
            assertFalse(logIn.isValidUserName(database.getAllUserProfile(), "ValidPerson"));
        }

        @Test
        public void testCheckPasswordLength() {
            assertTrue(logIn.checkPasswordLength("!Starbucks123"));
            assertFalse(logIn.checkPasswordLength("123"));
        }

        @Test
        public void testCheckIfPasswordCorrect() {
            assertTrue(logIn.checkIfPasswordCorrect(validProfile, "!Starbucks123"));
            assertFalse(logIn.checkIfPasswordCorrect(validProfile, "WrongPass"));
        }

        @Test
        public void testCreateAccount() {
            Profile newValidProfile = new Profile("NewValidUser", "New!Starbucks123", 30, "Gender", "Nationality", "Job", "Hobby");
            assertTrue(logIn.createAccount(database, newValidProfile));
            assertFalse(logIn.createAccount(database, invalidProfile));
            assertEquals(2, database.getAllUserProfile().size());
        }

        @Test
        public void testDeleteAccount() {
            assertTrue(logIn.deleteAccount(database, validProfile, "!Starbucks123"));
            assertFalse(logIn.deleteAccount(database, invalidProfile, "123"));
            // Check if the valid profile is indeed removed
            assertEquals(0, database.getAllUserProfile().size());
        }

        @Test
        public void testLoginAccount() {
            assertTrue(logIn.loginAccount(database, validProfile, "ValidPerson", "!Starbucks123"));
            assertFalse(logIn.loginAccount(database, invalidProfile, "Bad", "123"));
        }
    }// for login

    public static class DatabaseTest {
        private Database database;

        @BeforeClass
        public void setupDatabase() {
            ArrayList<UserAccount> allUserAccount = null;
            allUserAccount.add(new UserAccount(new Profile ("vu28" , "12345678", 18,  "Male",  "VietNam",  "student",  "football")));
            allUserAccount.add(new UserAccount(new Profile ("george23" , "123456", 20,  "Female",  "Brazil",  "doctor",  "sing")));
            allUserAccount.add(new UserAccount(new Profile ("alvin23" , "123uyr", 33,  "Female",  "China",  "teacher",  "sing")));

            ArrayList<UserAccount> TestUserAccounts = null;
            TestUserAccounts.add(new UserAccount(new Profile ("george23" , "123456", 20,  "Female",  "Brazil",  "doctor",  "sing")));
            TestUserAccounts.add(new UserAccount(new Profile ("joh3" , "634", 48,  "Male",  "US",  "Retired",  "golf")));
            TestUserAccounts.add(new UserAccount(new Profile ("alvin23" , "123uyr", 33,  "Female",  "China",  "teacher",  "sing")));

            ArrayList<Profile> TestUserProfiles = null;
            TestUserProfiles.add(new Profile("george23" , "123456", 20,  "Female",  "Brazil",  "doctor",  "sing"));
            TestUserProfiles.add(new Profile("joh3" , "634", 48,  "Male",  "US",  "Retired",  "golf"));
            TestUserProfiles.add(new Profile("alvin23" , "123uyr", 33,  "Female",  "China",  "teacher",  "sing"));

            database = new Database("testDatabase.txt");
            boolean read1 = database.readAllUserAccount();
            boolean save1 = database.saveAllUserAccount();
        }

        @Test
        public void readAndGetAllUserAccountTest() {
            assertTrue(read1);
            assertTrue(database.getAllUserAccount().equals(allUserAccount));
        }

        @Test
        public void saveAllUserAccountTest() {
            Database database2 = new Database("testDatabase.txt");
            boolean read2 = database2.readAllUserAccount();
            assertTrue(save1);
            assertTrue(database2.getAllUserAccount().equals(allUserAccount));
        }

        //public void setAllUserProfile(ArrayList<Profile> allUserProfile)
        //        this.allUserProfile = allUserProfile;
        //

        @Test
        public void setAllUserProfileTest() {
            database.setAllUserProfile(TestUserProfiles);
            assertTrue(database.getAllUserProfile().equals(TestUserProfiles));
        }

        @Test
        public void setAndGetAllUserAccount() {
            database.setAllUserAccount(TestUserAccounts);
            assertTrue(database.getAllUserAccount().equals(TestUserAccounts));

        }
    }

} // end of class
