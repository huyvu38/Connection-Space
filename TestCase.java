import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
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

    // Set profile for each test with @Before to run before each test
    @Before
    public void setProfile() {
        profile = new Profile("abaldocchi", "whatsup", 20, "Male",
                "Salvadorian","Building Manager", "Soccer");
    } // end of setProfile
    /*Testing of constructors*/
    public void profileTest() {

    }
} // end of class
