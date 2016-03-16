import guestDetails.Age;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AgeTest {

    @Test
    public void testOfIsAdultShouldGiveTrueWhenTheAgeQualifyTheEligibility() throws Exception {
        Age AdultAge = new Age(20);
        assertTrue(AdultAge.isGreaterThanOrEqualTo(18));
    }

    @Test
    public void testOfIsAdultShouldGiveFalseWhenTheAgeDoesntQualifyTheEligibility() throws Exception {
        Age AdultAge = new Age(16);
        assertFalse(AdultAge.isGreaterThanOrEqualTo(18));
    }
}