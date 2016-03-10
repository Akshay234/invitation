import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FormatTest {

    @Test
    public void testOfGetdataShouldGiveBackFormatedData() throws Exception {
        ArrayList<String> data = new ArrayList<>();
        data.add("A,B,Male,20,bangalore,karnataka,india");
        Format format = new Format(data);
        ArrayList<HashMap<String, String>> formatedData = format.getData();
        assertTrue(formatedData.get(0).get("firstName").equals("A"));
        assertTrue(formatedData.get(0).get("lastName").equals("B"));
        assertTrue(formatedData.get(0).get("gender").equals("Male"));
        assertTrue(formatedData.get(0).get("age").equals("20"));
        assertTrue(formatedData.get(0).get("city").equals("bangalore"));
        assertTrue(formatedData.get(0).get("state").equals("karnataka"));
        assertTrue(formatedData.get(0).get("country").equals("india"));
        assertEquals(formatedData.size(), 1);
        assertEquals(formatedData.get(0).size(), 7);
    }
}