package invite;

import guestDetails.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GuestInfoTest {
    Guest modi;
    Name guestName;
    Place guestAddress;
    Age guestAge;
    GuestInfo guestInfo;

    @Before
    public void setUp() throws Exception {
        guestName = new Name("narender","modi");
        guestAddress = new Place("mehsana","gujarat","india");
        guestAge = new Age(34);
        modi = new Guest(guestName, guestAddress, Gender.MALE, guestAge);
        guestInfo = new GuestInfo(modi);
    }

    @Test
    public void testOfGetIsEligibleForDrinkingShouldGiveCheckResultWhenThresholdLimitIsHigherThanGuestAge() throws Exception {
        assertTrue(guestInfo.isAbove(21));
    }

    @Test
    public void testOfGetIsEligibleForDrinkingShouldGiveCheckResultWhenThresholdLimitIsLowerThanGuestAge() throws Exception {
        assertFalse(guestInfo.isAbove(36));
    }

    @Test
    public void testOfIsNationalityOfShouldGiveCheckResultWhenSameCountryIsGiven() throws Exception {
        assertTrue(guestInfo.isNationalityOf("india"));
    }

    @Test
    public void testOfIsNationalityOfShouldGiveCheckResultWhenDifferentCountryIsGiven() throws Exception {
        assertFalse(guestInfo.isNationalityOf("japan"));
    }

    @Test
    public void testOfGetAgeShouldGiveAgeOfGuest() throws Exception {
        assertEquals(guestInfo.getAge(),34);
    }

    @Test
    public void testOfGetFirstNameFirstShouldGiveFirstNameBeforeSurnameWithPrefix() throws Exception {
        assertTrue(guestInfo.getFirstName().equals("narender"));
    }

    @Test
    public void testOfGetLastNameFirstShouldGiveSurnameBeforeFirstNameWithPrefix() throws Exception {
        assertTrue(guestInfo.getLastName().equals("modi"));
    }

    @Test
    public void testOfGetCityShouldGiveCityNameOfGuest() throws Exception {
        assertTrue(guestInfo.getCity().equals("mehsana"));
    }

    @Test
    public void testOfGetStateShouldGiveStateNameOfGuest() throws Exception {
        assertTrue(guestInfo.getState().equals("gujarat"));
    }

    @Test
    public void testOfGetCountryShouldGiveCountryNameOfGuest() throws Exception {
        assertTrue(guestInfo.getCountry().equals("india"));
    }
}