package invite;

import format.record.DataParser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GuestListTest {
    GuestList guestList;
    @Before
    public void setUp() throws Exception {
        ArrayList<String> guestRecords = new ArrayList<>();
        guestRecords.add("narender,modi,Male,23,mahsana,gujarat,india");
        guestRecords.add("surender,sodi,Male,46,bangalore,karnataka,india");
        DataParser dataParser = new DataParser(guestRecords);
        ArrayList<HashMap<String, String>> parsedData = dataParser.parse();
        guestList = new GuestList();
        guestList.addAll(parsedData);
    }

    @Test
    public void testOfGetDetailsOfShouldGiveTheInfoOfGuest() throws Exception {
        GuestInfo modi = guestList.getDetailsOf(0);
        assertEquals(modi.getFirstNameFirst(),"Mr narender modi");
        assertEquals(modi.getLastNameFirst(),"Mr modi, narender");
        assertEquals(modi.getCountry(),"india");
        assertEquals(modi.getState(),"gujarat");
        assertEquals(modi.getCity(),"mahsana");
        assertEquals(modi.getAge(),23);

        GuestInfo sodi = guestList.getDetailsOf(1);
        assertEquals(sodi.getFirstNameFirst(),"Mr surender sodi");
        assertEquals(sodi.getLastNameFirst(),"Mr sodi, surender");
        assertEquals(sodi.getCountry(),"india");
        assertEquals(sodi.getState(),"karnataka");
        assertEquals(sodi.getCity(),"bangalore");
        assertEquals(sodi.getAge(),46);
    }
}