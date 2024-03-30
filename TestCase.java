import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.*;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Team Project
 *
 * Test case class.
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class TestCase {
    private Profile profile;
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

        Assert.assertTrue("Ensure that `Profile` is `public`!", Modifier.isPublic(modifiers));
        Assert.assertFalse("Ensure that `Profile` is NOT `abstract`!", Modifier.isAbstract(modifiers));
        Assert.assertEquals("Ensure that `Profile` extends no `Classes`!", Object.class, superclass);
        // Need help with the interface check.
        /*Assert.assertEquals("Ensure that `Profile` implements 'ProfileInterface'!",
                0, superinterfaces.length);*/
    }
    @Test
    public void testNull() {
        // check to see if profile is null
        assertNull(profile);
    }

    // Set profile for each test with @Before to run before each test
    @Before
    public void setProfile() {
        profile = new Profile("abaldocc", "whatsup", 20, "Male",
                "Salvadorian","Building Manager", "Soccer");
    } // end of setProfile

    /*Testing of constructors and getters*/
    @Test
    public void profileTestGettersAndConstructor() {
        assertEquals("Username should be abaldocc", "abaldocc", profile.getUserName()); // is username requiered firt
        // letter capital? Is it case sensitive?
        assertEquals("Password should be whatsup", "whatsup", profile.getPassword());
        assertEquals("Age should be 20", 20, profile.getAge());
        assertEquals("Gender should be Male", "Male", profile.getGender());
        assertEquals("Nationality should be Salvadorian", "Salvadorian", profile.getNationality());
        assertEquals("Job should be Building Manager", "Building Manager", profile.getJob());
        assertEquals("Hobby should be Soccer", "Soccer", profile.getHobby());
    }

    @Test
    public void profileSetterTest() {
        profile.setUserName("alexia");
        assertEquals("Username should now be alexia", "alexia", profile.getUserName());
        profile.setPassword("whyy");
        assertEquals("Password should now be whyy", "whyy", profile.getPassword());
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
} // end of class
