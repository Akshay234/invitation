package guestDetails;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuestTest {
    Guest modi;
    Name maleGuestName;
    Place maleGuestAddress;
    Age maleAge;

    Guest kaley;
    Name femaleGuestName;
    Place femaleGuestAddress;
    Age femaleAge;

    @Before
    public void setUp() throws Exception {
        maleGuestName = new Name("narender","modi");
        maleGuestAddress = new Place("mehsana","gujarat","India");
        maleAge = new Age(66);
        modi = new Guest(maleGuestName, maleGuestAddress, Gender.MALE, maleAge);

        femaleGuestName = new Name("kaley","cuco");
        femaleGuestAddress = new Place("san francisco","california","USA");
        femaleAge = new Age(23);
        kaley = new Guest(femaleGuestName, femaleGuestAddress, Gender.FEMALE, femaleAge);
    }

    @Test
    public void testOfGetFirstNameFirstShouldGiveFormalNameRepresentationOfMaleGuest() throws Exception {
        assertEquals(modi.getFirstName(),"narender");
    }

    @Test
    public void testOfGetLastNameFirstShouldGiveInformalNameRepresentationOfMaleGuest() throws Exception {
        assertEquals(modi.getLastName(),"modi");
    }

    @Test
    public void testOfGetCountryShouldGiveCountryNameOfMaleGuest() throws Exception {
        assertEquals(modi.getCountry(),"India");
    }

    @Test
    public void testOfGetFirstNameFirstShouldGiveFormalNameRepresentationOfFemaleGuest() throws Exception {
        assertEquals(kaley.getFirstName(),"kaley");
    }

    @Test
    public void testOfGetLastNameFirstShouldGiveInformalNameRepresentationOfFemaleGuest() throws Exception {
        assertEquals(kaley.getLastName(),"cuco");
    }

    @Test
    public void testOfGetCountryShouldGiveCountryNameOfFemaleGuest() throws Exception {
        assertEquals(kaley.getCountry(),"USA");
    }

    @Test
    public void testOfIsEligibleForDrinkShouldReturnTrueWhenAgeOfGuestIsAboveOrEqualToLimit() throws Exception {
        assertTrue(kaley.isAboveTheAgeOf(20));
    }

    @Test
    public void testOfIsEligibleForDrinkShouldReturnFalseWhenAgeOfGuestIsABelowLimit() throws Exception {
        assertFalse(kaley.isAboveTheAgeOf(25));
    }
}