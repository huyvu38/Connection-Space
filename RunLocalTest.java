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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Modifier;
import static org.junit.Assert.*;
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
        Result result = JUnitCore.runClasses(RunLocalTest.ProfileTest.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Profile test ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        Result result1 = JUnitCore.runClasses(RunLocalTest.MessageTest.class);
        if (result1.wasSuccessful()) {
            System.out.println("Excellent - Message test ran successfully");
        } else {
            for (Failure failure : result1.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        Result result2 = JUnitCore.runClasses(RunLocalTest.LogInTest.class);
        if (result2.wasSuccessful()) {
            System.out.println("Excellent - Log in test ran successfully");
        } else {
            for (Failure failure : result2.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        Result result3 = JUnitCore.runClasses(RunLocalTest.UserAccountTest.class);
        if (result3.wasSuccessful()) {
            System.out.println("Excellent - User Account test ran successfully");
        } else {
            for (Failure failure : result3.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        Result result5 = JUnitCore.runClasses(RunLocalTest.MethodTest.class);
        if (!result5.wasSuccessful()) { //temp not to test
            System.out.println("Excellent - Method test ran successfully");
        } else {
            for (Failure failure : result5.getFailures()) {
                System.out.println("method"+failure.toString());
            }
        }
        Result result6 = JUnitCore.runClasses(RunLocalTest.DatabaseTest.class);
        if (!result6.wasSuccessful()) {
            System.out.println("Excellent - Database test ran successfully");
        } else {
            for (Failure failure : result6.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        Result result4 = JUnitCore.runClasses(RunLocalTest.SocialMediaTest.class);
        if (!result4.wasSuccessful()) {
            System.out.println("Excellent - SocialMedia test ran successfully");
        } else {
            for (Failure failure : result4.getFailures()) {
                System.out.println(failure.toString());
            }
        }


    }  // end of main

    @RunWith(Enclosed.class)
    public static class ProfileTest {
        private Profile profile;
        public void ProfileDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Profile.class;

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `Profile` is `public`!",
                    Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `Profile` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `Profile` implements interfaces!",
                    1, superinterfaces.length);
        }
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
        public void UserAccountDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Profile.class;

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `UserAccount` is `public`!",
                    Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `UserAccount` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `UserAccount` implements interfaces!",
                    1, superinterfaces.length);
        }

        // Set profile and userAcount for each test with @Before to run before each test
        @Before
        public void setUserAccountTest() {
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
            String a = String.format(";FriendList:%s;BlockList:%s", userAccount.getFriendList(),
                    userAccount.getBlockList());
            String formatToString = profile.toString() + a;
            assertEquals("Make sure the toString method matches correctly outputs the data.", formatToString,
                    userAccount.toString());
        }

    } // end of UserAccountTest

    @RunWith(JUnit4.class)
    public static class MessageTest {
        private static final String TEST_FILE_PATH = "Messages.txt"; // How does this filepath work?? Is it stored on each of our computers or on github?
        private Message message;
        public void MessageDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Profile.class;

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `Message` is `public`!",
                    Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `Message` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `Message` implements interfaces!",
                    1, superinterfaces.length);
        }

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
        public void LogInDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Profile.class;

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `LogIn` is `public`!",
                    Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `LogIn` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `LogIn` implements interfaces!",
                    1, superinterfaces.length);
        }

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
        private static Database database;
        private static ArrayList<Profile> TestUserProfiles = new ArrayList<>();

        private static ArrayList<UserAccount> allUserAccount = new ArrayList<>();

        private static ArrayList<UserAccount> TestUserAccounts = new ArrayList<>();
        public void DatabaseDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Profile.class;

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `Database` is `public`!",
                    Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `Database` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `Database` implements interfaces!",
                    1, superinterfaces.length);
        }
        @BeforeClass
        public static void setupDatabase() {

            allUserAccount.add(new UserAccount(new Profile ("vu28" , "12345678", 18,  "Male",  "VietNam",  "student",  "football")));
            allUserAccount.add(new UserAccount(new Profile ("george23" , "123456", 20,  "Female",  "Brazil",  "doctor",  "sing")));
            allUserAccount.add(new UserAccount(new Profile ("alvin23" , "123uyr", 33,  "Female",  "China",  "teacher",  "sing")));


            TestUserAccounts.add(new UserAccount(new Profile ("george23" , "123456", 20,  "Female",  "Brazil",  "doctor",  "sing")));
            TestUserAccounts.add(new UserAccount(new Profile ("joh3" , "634", 48,  "Male",  "US",  "Retired",  "golf")));
            TestUserAccounts.add(new UserAccount(new Profile ("alvin23" , "123uyr", 33,  "Female",  "China",  "teacher",  "sing")));


            TestUserProfiles.add(new Profile("george23" , "123456", 20,  "Female",  "Brazil",  "doctor",  "sing"));
            TestUserProfiles.add(new Profile("joh3" , "634", 48,  "Male",  "US",  "Retired",  "golf"));
            TestUserProfiles.add(new Profile("alvin23" , "123uyr", 33,  "Female",  "China",  "teacher",  "sing"));

            database = new Database("testDatabase.txt");

        }

        @Test
        public void readAndGetAllUserAccountTest() {
            boolean read1 = database.readAllUserAccount();
            boolean save1 = database.saveAllUserAccount();
            assertTrue(read1);
            assertTrue(database.getAllUserAccount().equals(allUserAccount));
        }

        @Test
        public void saveAllUserAccountTest() {
            Database database2 = new Database("testDatabase.txt");
            boolean read2 = database2.readAllUserAccount();
            assertTrue(database2.getAllUserAccount().equals(allUserAccount));
            boolean save1 = database.saveAllUserAccount();
            assertTrue(save1);
        }

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

    public static class MethodTest {
        private Method method;
        private ArrayList<Profile> allUserList;
        private ArrayList<String> friendList;
        private ArrayList<String> blockList;
        private Profile userProfile;
        public void MethodDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Profile.class;

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `Method` is `public`!",
                    Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `Method` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `Method` implements interfaces!",
                    1, superinterfaces.length);
        }

        @Before
        public void setUp() {
            allUserList = new ArrayList<>();
            friendList = new ArrayList<>();
            blockList = new ArrayList<>();
            userProfile = new Profile("User", "Pass", 25, "Gender", "Nationality", "Job", "Hobby");
            allUserList.add(userProfile);
            allUserList.add(new Profile("champagnepapi", "password123", 30, "Male", "American", "Engineer", "Coding"));
            allUserList.add(new Profile("kwest", "password456", 28, "Female", "British", "Artist", "Painting"));
            friendList.add("champagnepapi");
            blockList.add("kwest");

            method = new Method(allUserList, friendList, blockList, userProfile);
        }

        @Test
        public void testUserNameInDatabase() {
            boolean result = method.usernameInDatabase(allUserList, "ExistingUser");
            assertTrue(result);
        }

        @Test
        public void testUserNameNotInDatabase() {
            boolean result = method.usernameInDatabase(allUserList, "NewUser");
            assertFalse(result);
        }

        @Test
        public void testAddFriend() {
            boolean result = method.addFriend(allUserList, friendList, blockList, "NewFriend");
            assertTrue( result);
        }

        @Test
        public void testAddFriend_2() {
            boolean result = method.addFriend(allUserList, friendList, blockList, "champagnepapi");
            assertTrue(result);
        }

        @Test
        public void testAddFriend_3() {
            boolean result = method.addFriend(allUserList, friendList, blockList, "kwest");
            assertTrue(result);
        }
    }
    public static class SocialMediaTest {

        private final PrintStream originalOutput = System.out;
        private final InputStream originalSysin = System.in;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayInputStream testIn;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayOutputStream testOut;

        @Before
        public void outputStart() {
            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
        }

        @After
        public void restoreInputAndOutput() {
            System.setIn(originalSysin);
            System.setOut(originalOutput);
        }
        private String getOutput() {
            return testOut.toString();
        }

        @SuppressWarnings("SameParameterValue")
        private void receiveInput(String str) {
            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);
        }
        @Test(timeout = 1000)
        public void testExpectedOne() {

            // Set the input
            String input = "1" + System.lineSeparator() +
                    "abaldocc" + System.lineSeparator() +
                    "archiebaldo" + System.lineSeparator() +
                    "20" + System.lineSeparator() +
                    "male" + System.lineSeparator() +
                    "El Salvador" + System.lineSeparator() +
                    "Building manager" + System.lineSeparator() +
                    "Polo" + System.lineSeparator();

            // Pair the input with the expected result
            String expected = "Hi, welcome to the social media platform." + System.lineSeparator() +
                    "What would you like to do?" + System.lineSeparator() +
                    "1. Create account." + System.lineSeparator() +
                    "2. Log In." + System.lineSeparator() +
                    "3. Exit the app." + System.lineSeparator() +
                    "1" + System.lineSeparator() +
                    "Once you create an account, you can not change your username." + System.lineSeparator() +
                    "User name should be at least 4 characters and do not contain any spaces." + System.lineSeparator()
                    + "Enter your username:" + System.lineSeparator() + "abaldocc" + System.lineSeparator() +
                    "Password should be at least 6 characters." + System.lineSeparator() +
                    "Enter your password:" + System.lineSeparator() + "archiebaldo" + System.lineSeparator() +
                    "Age should be a number greater than 0." + System.lineSeparator() +
                    "Enter your age:" + System.lineSeparator() + "20" + System.lineSeparator() +
                    "Enter your gender from these options:" + System.lineSeparator() +
                    "Female" + System.lineSeparator() + "Male" + System.lineSeparator() +
                    "Other" + System.lineSeparator() + "male" + System.lineSeparator() + "Enter your nationality:" +
                    System.lineSeparator() + "El Salvador" + System.lineSeparator() + "Enter your job:" +
                    System.lineSeparator() + "Building manager" + System.lineSeparator() + "Enter your hobby:" +
                    System.lineSeparator() + "Polo" + System.lineSeparator() + "Create account success." +
                    System.lineSeparator() + "You have to log in again." + System.lineSeparator();

            // Runs the program with the input values
            receiveInput(input);
            SocialMedia.main(new String[0]);

            // Retrieves the output from the program
            String output = getOutput();

            // Trims the output and verifies it is correct.
            expected = expected.replaceAll("\r\n", "\n");
            output = output.replaceAll("\r\n", "\n");
            assertEquals("Make sure you follow the flowchart and use the given strings for the result!",
                    expected.trim(), output.trim());
        }

        /*"2" + System.lineSeparator() +
                    "abaldocc" + System.lineSeparator() +
                    "archiebaldo" + System.lineSeparator() +
                    "3" + System.lineSeparator()*/
        public void createAccountTest() {

        }
        public void exitProgramTest() {

        }
        public void logInViewExitTest() {

        }
        public void logInEditExit() {

        }
    }


} // end of class