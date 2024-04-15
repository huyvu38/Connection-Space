import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.*;

/**
 * Team Project
 * <p>
 * RunLocalTest.java
 *
 * @author Gabe Turner, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */

@RunWith(Enclosed.class)
public class RunLocalTest {
    public static void main(String[] args) {
        Result result1 = JUnitCore.runClasses(RunLocalTest.DeclarationTest.class);
        if (result1.wasSuccessful()) {
            System.out.println("Excellent - Declaration test ran successfully");
        } else {
            for (Failure failure : result1.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        Result result2 = JUnitCore.runClasses(RunLocalTest.ProfileTest.class);
        if (result2.wasSuccessful()) {
            System.out.println("Excellent - Profile test ran successfully");
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
        /*
        Result result4 = JUnitCore.runClasses(RunLocalTest.DatabaseTest.class);
        if (result4.wasSuccessful()) {
            System.out.println("Excellent - Database test ran successfully");
        } else {
            for (Failure failure : result4.getFailures()) {
                System.out.println(failure.toString());
            }
        }

         */
        Result result5 = JUnitCore.runClasses(RunLocalTest.ServerTest.class);
        if (result5.wasSuccessful()) {
            System.out.println("Excellent - FunctionServer test ran successfully");
        } else {
            for (Failure failure : result5.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }  // end of main

    public static class DeclarationTest {
        @Test(timeout = 1000)
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
            assertFalse("Ensure that `Profile` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `Profile` extends `Object`!",
                    Object.class, superclass);
            Assert.assertEquals("Ensure that `Profile` implements interfaces!",
                    1, superinterfaces.length);
        }
        @Test(timeout = 1000)

        public void UserAccountDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = UserAccount.class;

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `UserAccount` is `public`!",
                    Modifier.isPublic(modifiers));
            assertFalse("Ensure that `UserAccount` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `UserAccount` extends `Object`!",
                    Object.class, superclass);
            Assert.assertEquals("Ensure that `UserAccount` implements interfaces!",
                    1, superinterfaces.length);
        }
        @Test(timeout = 1000)

        public void ServerDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Server.class;

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `Server` is `public`!",
                    Modifier.isPublic(modifiers));
            assertFalse("Ensure that `Server` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `Server` extends `Object`!",
                    Object.class, superclass);
            Assert.assertEquals("Ensure that `Server` implements interfaces!",
                    1, superinterfaces.length);
        }
        @Test(timeout = 1000)
        public void DatabaseDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Database.class;

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `Database` is `public`!",
                    Modifier.isPublic(modifiers));
            assertFalse("Ensure that `Database` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `Database` extends `Object`!",
                    Object.class, superclass);
            Assert.assertEquals("Ensure that `Database` implements interfaces!",
                    1, superinterfaces.length);
        }

    }

    public static class ProfileTest {
        private Profile profile;

        // Set profile for each test with @Before to run before each test
        @Before
        public void setProfile() {
            profile = new Profile("abaldocc", "whatsup", 20, "Male",
                    "Salvadorian", "Manager", "Soccer");
        } // end of setProfile

        /*Testing of constructors and getters*/
        @Test
        public void profileTestGettersAndConstructor() {
            assertEquals("Username should be abaldocc", "abaldocc", profile.getUserName());
            assertEquals("Password should be whatsup", "whatsup", profile.getPassword());
            assertEquals("Age should be 20", 20, profile.getAge());
            assertEquals("Gender should be Male", "Male", profile.getGender());
            assertEquals("Nationality should be Salvadorian", "Salvadorian", profile.getNationality());
            assertEquals("Job should be Building Manager", "Manager", profile.getJob());
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
            String input = "abaldocc whatsup 20 Male Salvadorian Manager Soccer";
            assertEquals("toString method should name password age gender nationality job hobby" +
                    " with a space.", input, profile.toString());
        }

    } // end of test case

    //@RunWith(Enclosed.class)
    public static class UserAccountTest {
        private Profile profile;
        private UserAccount userAccount;
        private ArrayList<String> friendList;
        private ArrayList<String> blockList;

        // Set profile and userAccount for each test with @Before to run before each test
        @Before
        public void setUserAccountTest() {
            profile = new Profile("abaldocc", "whatsup", 20, "Male",
                    "Salvadorian", "Manager", "Soccer");
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
            assertEquals("Friend list should now be [archie Matt]", newFriendList, userAccount.getFriendList());
            blockList.add("Pablo");

            userAccount.setBlockList(blockList);
            ArrayList<String> newBlockList = new ArrayList<>(Arrays.asList("Frigolet", "Pablo"));
            assertEquals("Block list should now be [Frigolet Pablo]", newBlockList, userAccount.getBlockList());
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
    public static class ServerTest {
        public ServerTest() throws IOException {
        }

        Socket socket = new Socket("example.com", 80);
        Server server = new Server(socket);

        @Test
        public void logInAccountTest() {
            Server.database = new Database("AllUserAccount.txt");
            Server.database.readAllUserAccount();
            Server.allUserAccount = Server.database.getAllUserAccount();
            assertTrue(server.loginAccount("vu28", "12345678"));
        }

        @Test
        public void userNameInDataBaseTest() {
            Server.database = new Database("AllUserAccount.txt");
            Server.database.readAllUserAccount();
            Server.allUserAccount = Server.database.getAllUserAccount();
            assertTrue(server.usernameInDatabase("vu28"));
        }

        @Test
        public void inFriendListTest() {
            Server.database = new Database("AllUserAccount.txt");
            Server.database.readAllUserAccount();
            Server.allUserAccount = Server.database.getAllUserAccount();
            assertTrue(server.inFriendList("vu28", "george23"));
        }

        @Test
        public void inBlockListTest() {
            Server.database = new Database("AllUserAccount.txt");
            Server.database.readAllUserAccount();
            Server.allUserAccount = Server.database.getAllUserAccount();
            assertFalse(server.inBlockList("Archie", "Yanxin171"));
        }

        @Test
        public void addFriendTest() {
            Server.database = new Database("AllUserAccount.txt");
            Server.database.readAllUserAccount();
            Server.allUserAccount = Server.database.getAllUserAccount();
            assertTrue(server.addFriend("george333", "alvin23"));
        }

        @Test
        public void deleteFriendTest() {
            Server.database = new Database("AllUserAccount.txt");
            Server.database.readAllUserAccount();
            Server.allUserAccount = Server.database.getAllUserAccount();
            assertTrue(server.deleteFriend("george23", "vu28"));
        }

        @Test
        public void blockUserTest() {
            Server.database = new Database("AllUserAccount.txt");
            Server.database.readAllUserAccount();
            Server.allUserAccount = Server.database.getAllUserAccount();
            assertTrue(server.blockUser("george23", "vu28"));
        }

        @Test
        public void unblockUserTest() {
            Server.database = new Database("AllUserAccount.txt");
            Server.database.readAllUserAccount();
            Server.allUserAccount = Server.database.getAllUserAccount();
            assertFalse(server.unblockUser("george23", "vu28"));
        }
        private static final String TEST_FILE_PATH = "Messages.txt"; // How does this filepath work?? Is it stored on each of our computers or on github?
        @Before
        public void setUp() {
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
        /*
        @Test
        public void messageSuccessful() {
            try {
                message.sendMessage("sender", "receiver", "Test message", false);
                List<String> lines = Files.readAllLines(Paths.get(TEST_FILE_PATH));
                assertTrue("File should contain the send message", lines.get(0).contains("Test message"));
            } catch (Exception e) {
                System.out.println("Message failed to send.");

            }
        }

         */
        /*
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

         */
    }
    /*
    public static class DatabaseTest {
        private static Database database;
        private static ArrayList<Profile> TestUserProfiles = new ArrayList<>();

        private static ArrayList<UserAccount> allUserAccount = new ArrayList<>();

        private static ArrayList<UserAccount> TestUserAccounts = new ArrayList<>();

        @BeforeClass
        public static void setupDatabase() {

            allUserAccount.add(new UserAccount(new Profile("vu28", "12345678", 18, "Male", "VietNam", "student", "football")));
            allUserAccount.add(new UserAccount(new Profile("george23", "123456", 20, "Female", "Brazil", "doctor", "sing")));
            allUserAccount.add(new UserAccount(new Profile("alvin23", "123uyr", 33, "Female", "China", "teacher", "sing")));


            TestUserAccounts.add(new UserAccount(new Profile("george23", "123456", 20, "Female", "Brazil", "doctor", "sing")));
            TestUserAccounts.add(new UserAccount(new Profile("joh3", "634", 48, "Male", "US", "Retired", "golf")));
            TestUserAccounts.add(new UserAccount(new Profile("alvin23", "123uyr", 33, "Female", "China", "teacher", "sing")));


            TestUserProfiles.add(new Profile("george23", "123456", 20, "Female", "Brazil", "doctor", "sing"));
            TestUserProfiles.add(new Profile("joh3", "634", 48, "Male", "US", "Retired", "golf"));
            TestUserProfiles.add(new Profile("alvin23", "123uyr", 33, "Female", "China", "teacher", "sing"));

            database = new Database("testDatabase.txt");

        }
        /*

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
            //database.setAllUserAccount(TestUserProfiles); <-- PROBLEM: setAllUsrAcc gets <profile> wants <account>
            assertTrue(database.getAllUserAccount().equals(TestUserProfiles));
        }

        @Test
        public void setAndGetAllUserAccount() {
            database.setAllUserAccount(TestUserAccounts);
            assertTrue(database.getAllUserAccount().equals(TestUserAccounts));

        }



     */
} // end of class