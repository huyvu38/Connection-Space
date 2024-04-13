import org.junit.Test;
import org.junit.*;
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
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    // start message tests
    @RunWith(JUnit4.class)
    public static class MessageTest {
        private Server server;
        private Socket mockSocket;
        private Database mockDatabase;
        private PrintWriter mockWriter;
        private BufferedReader mockReader;
        private ArrayList<UserAccount> mockUserAccounts;

        @Before
        public void setUp() throws Exception {
            mockSocket = mock(Socket.class);
            mockWriter = mock(PrintWriter.class);
            mockReader = mock(BufferedReader.class);
            mockDatabase = mock(Database.class);
            mockUserAccounts = new ArrayList<>();
            server = new Server(mockSocket);
            server.database = mockDatabase;
            server.allUserAccount = mockUserAccounts;

            when(mockSocket.getOutputStream()).thenReturn(new ByteArrayOutputStream());
            when(mockSocket.getInputStream()).thenReturn(new ByteArrayInputStream("".getBytes()));
            when(mockSocket.isClosed()).thenReturn(false);
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void testSendMessage() throws IOException {
            assertTrue("Message should be sent successfully",
                    server.sendMessage("Alice", "Bob", "Hello Bob!", false));
        }

        @Test
        public void testAddFriend() throws IOException {
            UserAccount alice = new UserAccount(new Profile("Alice", "pass123", 25, "Female", "Wonderland", "Explorer", "Adventuring"));
            UserAccount bob = new UserAccount(new Profile("Bob", "pass123", 30, "Male", "Builderland", "Builder", "Building"));
            mockUserAccounts.add(alice);
            mockUserAccounts.add(bob);
            assertTrue("Alice should be able to add Bob as a friend",
                    server.addFriend("Alice", "Bob"));
        }

        @Test
        public void testRestrictMessage() throws IOException {
            ArrayList<String> members = new ArrayList<>();
            members.add("Bob");
            assertNull("Message should be sent to all friends successfully",
                    server.restrictMessage("Alice", members, "Hello group!"));
        }

        @Test
        public void testPrintHistoryMessage() throws IOException {
            assertTrue("History messages should be printed successfully",
                    server.printHistoryMessage("Alice", "Bob"));
        }

        @After
        public void tearDown() {
            mockUserAccounts.clear();
        }
    }
    // end of test case for messages

    // Begin Server test
    @RunWith(JUnit4.class)
    public static class ServerTest {
        private Server server;
        private Socket mockSocket;
        private Database mockDatabase;
        private static ArrayList<UserAccount> mockUserAccounts;

        @Before
        public void setUp() {
            mockSocket = mock(Socket.class);
            mockDatabase = mock(Database.class);
            mockUserAccounts = new ArrayList<>();
            server = new Server(mockSocket);
            server.database = mockDatabase;
            server.allUserAccount = mockUserAccounts;
        }

        @Test
        public void testConstructor() {
            assertNotNull("Server instance should be created", server);
        }

        @Test
        public void testCreateAccountValid() {
            Profile profile = new Profile("user", "pass123", 25, "Male", "USA", "Engineer", "Reading");
            UserAccount userAccount = new UserAccount(profile);
            when(mockDatabase.getAllUserAccount()).thenReturn(mockUserAccounts);
            assertTrue("Account should be created successfully", server.createAccount(mockDatabase, userAccount, "user", "pass123"));
        }

        @Test
        public void testLoginAccountSuccess() {
            Profile profile = new Profile("user", "pass123", 25, "Male", "USA", "Engineer", "Reading");
            UserAccount userAccount = new UserAccount(profile);
            mockUserAccounts.add(userAccount);
            assertTrue("Login should succeed with correct username and password", server.loginAccount("user", "pass123"));
        }

        @Test
        public void testLoginAccountFailure() {
            Profile profile = new Profile("user", "pass123", 25, "Male", "USA", "Engineer", "Reading");
            UserAccount userAccount = new UserAccount(profile);
            mockUserAccounts.add(userAccount);
            assertFalse("Login should fail with incorrect password", server.loginAccount("user", "wrongpassword"));
        }

        @Test
        public void testAddFriend() {
            Profile profile1 = new Profile("user1", "pass123", 25, "Male", "USA", "Engineer", "Reading");
            Profile profile2 = new Profile("user2", "pass123", 26, "Female", "USA", "Doctor", "Music");
            UserAccount user1 = new UserAccount(profile1);
            UserAccount user2 = new UserAccount(profile2);
            mockUserAccounts.add(user1);
            mockUserAccounts.add(user2);
            assertTrue("Adding friend should succeed", server.addFriend("user1", "user2"));
        }

        @Test
        public void testDeleteFriend() {
            Profile profile1 = new Profile("user1", "pass123", 25, "Male", "USA", "Engineer", "Reading");
            Profile profile2 = new Profile("user2", "pass123", 26, "Female", "USA", "Doctor", "Music");
            UserAccount user1 = new UserAccount(profile1);
            UserAccount user2 = new UserAccount(profile2);
            user1.getFriendList().add("user2");
            user2.getFriendList().add("user1");
            mockUserAccounts.add(user1);
            mockUserAccounts.add(user2);
            assertTrue("Deleting friend should succeed", server.deleteFriend("user1", "user2"));
        }

        @After
        public void tearDown() {
            mockUserAccounts.clear();
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