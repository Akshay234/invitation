import filter.Filter;
import guestDetails.*;
import invite.GenerateLabel;
import invite.GuestInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GenerateLabelTest {
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
        maleGuestAddress = new Place("mehsana","gujarat","india");
        maleAge = new Age(66);
        modi = new Guest(maleGuestName, maleGuestAddress, Gender.MALE, maleAge);

        femaleGuestName = new Name("kaley","cuco");
        femaleGuestAddress = new Place("san francisco","california","USA");
        femaleAge = new Age(23);
        kaley = new Guest(femaleGuestName, femaleGuestAddress, Gender.FEMALE, femaleAge);
    }

    @Test
    public void testOfGenerateShouldGiveRepresentationOfLabelWhenAskedInFirstNameFirstFormat() throws Exception {
        String[] args = {"-fl","-F","a.txt"};
        GuestInfo guestInfo = new GuestInfo(modi);
        Filter filter = new Filter(args);
        GenerateLabel labelGenerator = new GenerateLabel(guestInfo,filter);
        assertEquals(labelGenerator.generate(),"Mr narender modi");
    }

    @Test
    public void testOfGenerateShouldGiveRepresentationOfLabelWhenAskedInLastNameFirstFormat() throws Exception {
        String[] args = {"-lf","-F","a.txt"};
        GuestInfo guestInfo = new GuestInfo(modi);
        Filter filter = new Filter(args);
        GenerateLabel labelGenerator = new GenerateLabel(guestInfo,filter);
        assertEquals(labelGenerator.generate(),"Mr modi, narender");
    }

    @Test
    public void testOfGenerateShouldGiveRepresentationOfLabelWithCountryName() throws Exception {
        String[] args = {"-fl","-c","india","-F","a.txt"};
        GuestInfo guestInfo = new GuestInfo(modi);
        Filter filter = new Filter(args);
        GenerateLabel labelGenerator = new GenerateLabel(guestInfo,filter);
        assertEquals(labelGenerator.generate(),"Mr narender modi, india");
    }

    @Test
    public void testOfGenerateShouldGiveRepresentationOfLabelWithoutCountryNameWhenDifferentCountryIsSpecified() throws Exception {
        String[] args = {"-fl","-c","japan","-F","a.txt"};
        GuestInfo guestInfo = new GuestInfo(modi);
        Filter filter = new Filter(args);
        GenerateLabel labelGenerator = new GenerateLabel(guestInfo,filter);
        assertEquals(labelGenerator.generate(),"Mr narender modi");
    }

    @Test
    public void testOfGenerateShouldGiveRepresentationOfLabelWithAge() throws Exception {
        String[] args = {"-fl","-a","21","-F","a.txt"};
        GuestInfo guestInfo = new GuestInfo(modi);
        Filter filter = new Filter(args);
        GenerateLabel labelGenerator = new GenerateLabel(guestInfo,filter);
        assertEquals(labelGenerator.generate(),"Mr narender modi, 66");
    }

    @Test
    public void testOfGenerateShouldGiveRepresentationOfLabelWithoutAgeWhenSpecifiedAgeInArgsIsHigherThanGuestAge() throws Exception {
        String[] args = {"-fl","-a","67","-F","a.txt"};
        GuestInfo guestInfo = new GuestInfo(modi);
        Filter filter = new Filter(args);
        GenerateLabel labelGenerator = new GenerateLabel(guestInfo,filter);
        assertEquals(labelGenerator.generate(),"Mr narender modi");
    }

    @Test
    public void testOfGenerateShouldGiveRepresentationOfLabelWithBothCountryAndAge() throws Exception {
        String[] args = {"-fl","-c","india","-a","21","-F","a.txt"};
        GuestInfo guestInfo = new GuestInfo(modi);
        Filter filter = new Filter(args);
        GenerateLabel labelGenerator = new GenerateLabel(guestInfo,filter);
        assertEquals(labelGenerator.generate(),"Mr narender modi, india, 66");
    }

    @Test
    public void testOfGenerateShouldGiveRepresentationOfLabelForFemaleGuest() throws Exception {
        String[] args = {"-fl","-c","USA","-a","21","-F","a.txt"};
        GuestInfo guestInfo = new GuestInfo(kaley);
        Filter filter = new Filter(args);
        GenerateLabel labelGenerator = new GenerateLabel(guestInfo,filter);
        assertEquals(labelGenerator.generate(),"Ms kaley cuco, USA, 23");
    }
}