import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by akshayks on 04/03/16.
 */
public class PlaceTest {

    @Test
    public void testOfGetAddressShouldGiveMefullAddressDetails() throws Exception {
        Place myPlace = new Place("Bangalore","Karnataka","India");
        assertEquals(myPlace.getAddress(), "city - Bangalore, state - Karnataka, country - India");
    }

    @Test
    public void testOfGetCountryShouldGiveMeOnlyCountry() throws Exception {
        Place myPlace = new Place("Bangalore","Karnataka","India");
        assertEquals(myPlace.getCountry(), "India");
    }
}