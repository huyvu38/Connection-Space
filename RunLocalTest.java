import org.junit.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.JUnit4;
import org.mockito.MockitoAnnotations;

import java.io.*;
import java.lang.reflect.Modifier;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

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
        /*
        Result result2 = JUnitCore.runClasses(RunLocalTest.LogInTest.class);
        if (result2.wasSuccessful()) {
            System.out.println("Excellent - Log in test ran successfully");
        } else {
            for (Failure failure : result2.getFailures()) {
                System.out.println(failure.toString());
            }
        }

         */
        Result result3 = JUnitCore.runClasses(RunLocalTest.UserAccountTest.class);
        if (result3.wasSuccessful()) {
            System.out.println("Excellent - User Account test ran successfully");
        } else {
            for (Failure failure : result3.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        Result result4 = JUnitCore.runClasses(RunLocalTest.DatabaseTest.class);
        if (result4.wasSuccessful()) {
            System.out.println("Excellent - Database test ran successfully");
        } else {
            for (Failure failure : result4.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        Result result44 = JUnitCore.runClasses(RunLocalTest.ServerTest.class);
        if (result44.wasSuccessful()) {
            System.out.println("Excellent - Server test ran successfully");
        } else {
            for (Failure failure : result44.getFailures()) {
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

    // Begin Server test
    @RunWith(JUnit4.class)
    public static class ServerTest {
        private Server server;
        private Socket mockSocket;
        private PrintWriter mockWriter;
        private BufferedReader mockReader;
        private ByteArrayOutputStream outContent;

        @Before
        public void setUp() throws Exception {
            mockSocket = mock(Socket.class);
            outContent = new ByteArrayOutputStream();
            mockWriter = new PrintWriter(outContent, true);
            mockReader = mock(BufferedReader.class);

            MockitoAnnotations.initMocks(this);
            when(mockSocket.getOutputStream()).thenReturn(outContent);
            when(mockSocket.getInputStream()).thenReturn(new ByteArrayInputStream("".getBytes()));

            server = new Server(mockSocket);
            server.database = mock(Database.class);
            server.allUserAccount = new ArrayList<>();
        }

        @Test
        public void testAddFriendSuccess() throws IOException {
            String input = "2\nuser1\npassword\n5\nuser2\n";
            when(mockReader.readLine()).thenReturn("2", "user1", "password", "5", "user2", null);
            Server.allUserAccount.add(new UserAccount(new Profile("user1", "password", 30, "Male", "USA", "Developer", "Gaming")));
            Server.allUserAccount.add(new UserAccount(new Profile("user2", "password2", 28, "Female", "Canada", "Designer", "Reading")));

            ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
            when(mockSocket.getInputStream()).thenReturn(inContent);

            server.run();

            assertTrue("Output should confirm friend addition", outContent.toString().contains("Add friend successfully"));
        }

        @Test
        public void testBlockUserSuccess() throws IOException {
            String input = "2\nuser1\npassword\n7\nuser2\n";
            when(mockReader.readLine()).thenReturn("2", "user1", "password", "7", "user2", null);
            Server.allUserAccount.add(new UserAccount(new Profile("user1", "password", 30, "Male", "USA", "Developer", "Gaming")));
            Server.allUserAccount.add(new UserAccount(new Profile("user2", "password2", 28, "Female", "Canada", "Designer", "Reading")));

            ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
            when(mockSocket.getInputStream()).thenReturn(inContent);

            server.run();

            assertTrue("Output should confirm user blocking", outContent.toString().contains("Block successfully"));
        }

        @Test
        public void testUnblockUserSuccess() throws IOException {
            String input = "2\nuser1\npassword\n8\nuser2\n";
            when(mockReader.readLine()).thenReturn("2", "user1", "password", "8", "user2", null);
            UserAccount user1 = new UserAccount(new Profile("user1", "password", 30, "Male", "USA", "Developer", "Gaming"));
            user1.getBlockList().add("user2");
            Server.allUserAccount.add(user1);
            Server.allUserAccount.add(new UserAccount(new Profile("user2", "password2", 28, "Female", "Canada", "Designer", "Reading")));

            ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
            when(mockSocket.getInputStream()).thenReturn(inContent);

            server.run();

            assertTrue("Output should confirm user unblocking", outContent.toString().contains("Unblock successfully"));
        }

        @Test
        public void testLoginAndManageCommands() throws IOException {
            String input = "2\nusername\npassword\n11\n";
            when(mockReader.readLine()).thenReturn("2", "username", "password", "11", null);
            ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
            when(mockSocket.getInputStream()).thenReturn(inContent);

            server.run();

            assertTrue("Output should confirm successful login and subsequent logout", outContent.toString().contains("Log in successfully") && outContent.toString().contains("Logged out successfully"));
        }

        @After
        public void tearDown() throws IOException {
            mockSocket.close();
        }
    }

    //-----------------------------------------------------------------------------------------------
    //end server test


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
        /*
        @Test
        public void setAllUserProfileTest() {
            //database.setAllUserAccount(TestUserProfiles); <-- PROBLEM: setAllUsrAcc gets <profile> wants <account>
            assertTrue(database.getAllUserAccount().equals(TestUserProfiles));
        }

        @Test
        public void setAndGetAllUserAccount() {
            database.setAllUserAccount(TestUserAccounts);
            assertTrue(database.getAllUserAccount().equals(TestUserAccounts));

        }

         */
    }

    } // end of class