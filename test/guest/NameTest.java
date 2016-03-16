import guest.Name;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by akshayks on 04/03/16.
 */
public class NameTest {

    @Test
    public void testOfFirstNameFirstShouldGiveMeFirstNameBeforeTheLastName() throws Exception {
        Name akshay = new Name("Akshay","Kumar");
        assertEquals(akshay.firstNameFirst(),"Akshay Kumar");
    }

    @Test
    public void testOfLastNameFirstShouldGiveMeLastNameBeforeTheFirstNameSeperatedByComma() throws Exception {
        Name akshay = new Name("Akshay","Kumar");
        assertEquals(akshay.lastNameFirst(),"Kumar, Akshay");
    }
}