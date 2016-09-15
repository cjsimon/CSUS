import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 * The student test class implemented with JUnit
 */
public class StudentTest {
    /**
     * Fixture initialization
     * Common for all tests
     */
    Student instance;
    @Before public void setUp() {
        instance = new Student("John Doe", 123, "123 Somewhere", "415-555-1212", "johndoe@somewhere.com");
    }

    // test getName
    @Test public void testGetName() {
        String expResult = "John Doe";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    // test getAddress
    @Test public void testGetAddress() {
        String expResult = "123 Somewhere";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    // test getPhone
    @Test public void testGetPhone() {
        String expResult = "415-555-1212";
        String result = instance.getPhone();
        assertEquals(expResult, result);
    }

    // test getEmail
    @Test public void testGetEmail() {
        String expResult = "johndoe@somewhere.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }
}