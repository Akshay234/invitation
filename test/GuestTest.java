import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by akshayks on 04/03/16.
 */
public class GuestTest {

    @Test
    public void testOfGetFirstNameFirstShouldGiveMeFirstNameFirst() throws Exception {
        Name name = new Name("narender","modi");
        Place address = new Place("mehsana","gujarat","japan");
        Guest modi = new Guest(name, address, Gender.MALE, 66);
        assertEquals(modi.getFirstNameFirst(),"Mr narender modi");
    }
}