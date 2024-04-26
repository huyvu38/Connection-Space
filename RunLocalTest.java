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
import java.util.ArrayList;
import java.util.Arrays;
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
        Result result4 = JUnitCore.runClasses(RunLocalTest.DatabaseTest.class);
        if (result4.wasSuccessful()) {
            System.out.println("Excellent - Database test ran successfully");
        } else {
            for (Failure failure : result4.getFailures()) {
                System.out.println(failure.toString());
            }
        }
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
            assertEquals("Username should be abaldocc", "abaldocc", profile.getUsername());
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
            assertTrue(server.loginAccount("Archie", "ArchieBaldo"));
        }

        @Test
        public void userNameInDataBaseTest() {
            Server.database = new Database("AllUserAccount.txt");
            Server.database.readAllUserAccount();
            Server.allUserAccount = Server.database.getAllUserAccount();
            assertTrue(server.usernameInDatabase("Archie"));
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
            assertTrue(server.addFriend("Archie", "Yanxin171"));
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
    }

    public static class DatabaseTest {
        @Test
        public void readAllUserAccountTest() {
            Database testdatabase = new Database("AllUserAccount.txt");
            boolean read = testdatabase.readAllUserAccount();
            assertTrue(read);
        }
    }


} // end of class