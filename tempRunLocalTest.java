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
            System.out.println("Excellent - Test ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        Result result1 = JUnitCore.runClasses(MessageTest.class);
        if (result1.wasSuccessful()) {
            System.out.println("Excellent - Test ran successfully");
        } else {
            for (Failure failure : result1.getFailures()) {
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
            profile.setUserName("alexia");
            assertEquals("Username should now be alexia", "alexia", profile.getUserName());
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
    public class MessageTest {
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
                // Send a test
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

                // Attempt to delete the message
                message.deleteMessage(1);

                // check if message status was changed to 'deleted'
                List<String> lines = Files.readAllLines(Paths.get(TEST_FILE_PATH));
                assertTrue("Deleted message should have status changed", lines.get(0).contains("0"));
            } catch (Exception e) {
                System.out.println("Message failed to delete.");
            }
        }
    }// end of test case for
} // end of class
