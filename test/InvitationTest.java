import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class InvitationTest {
    Guest modi;
    Name maleGuestName;
    Place maleGuestAddress;
    Age maleAge;
    String firstNameFirstCommand = "-fl";
    String lastNameFirstCommand = "-lf";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        maleGuestName = new Name("narender","modi");
        maleGuestAddress = new Place("mehsana","gujarat","India");
        maleAge = new Age(66);
        modi = new Guest(maleGuestName, maleGuestAddress, Gender.MALE, maleAge);
    }

    @Test
    public void testOfGetNameRepresentationByFirstNameFirstShouldGiveARepresenationOfNameWhenNoAdditiionalInfoIsNotGiven() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        Invitation invitation = new Invitation(modi, additionalInfo);
        assertEquals(invitation.getNameRepresentationBy(firstNameFirstCommand),"Mr narender modi");
    }

    @Test
    public void testOfGetNameRepresentationByLastNameFirstShouldGiveARepresenationOfNameWhenNoAdditiionalInfoIsNotGiven() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        Invitation invitation = new Invitation(modi, additionalInfo);
        assertEquals(invitation.getNameRepresentationBy(lastNameFirstCommand),"Mr modi, narender");
    }

    @Test
    public void testOfGetNameRepresentationByFirstNameFirstShouldGiveARepresenationOfNameWithPersonAge() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        additionalInfo.add("23");
        Invitation invitation = new Invitation(modi, additionalInfo);
        assertEquals(invitation.getNameRepresentationBy(firstNameFirstCommand),"Mr narender modi, 66");
    }

    @Test
    public void testOfGetNameRepresentationByLastNameFirstShouldGiveARepresenationOfNameWithPersonAge() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        additionalInfo.add("23");
        Invitation invitation = new Invitation(modi, additionalInfo);
        assertEquals(invitation.getNameRepresentationBy(lastNameFirstCommand),"Mr modi, narender, 66");
    }

    @Test
    public void testOfGetNameRepresentationByFirstNameFirstShouldGiveARepresenationOfNameWithPersonNationality() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        additionalInfo.add("India");
        Invitation invitation = new Invitation(modi, additionalInfo);
        assertEquals(invitation.getNameRepresentationBy(firstNameFirstCommand),"Mr narender modi, India");
    }

    @Test
    public void testOfGetNameRepresentationByLastNameFirstShouldGiveARepresenationOfNameWithPersonNationality() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        additionalInfo.add("India");
        Invitation invitation = new Invitation(modi, additionalInfo);
        assertEquals(invitation.getNameRepresentationBy(lastNameFirstCommand),"Mr modi, narender, India");
    }

    @Test
    public void testOfGetNameRepresentationByFirstNameFirstShouldGiveARepresenationOfNameWithPersonNationalityAndAge() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        additionalInfo.add("India");
        additionalInfo.add("20");
        Invitation invitation = new Invitation(modi, additionalInfo);
        assertEquals(invitation.getNameRepresentationBy(firstNameFirstCommand),"Mr narender modi, India, 66");
    }

    @Test
    public void testOfGetNameRepresentationByLastNameFirstShouldGiveARepresenationOfNameWithPersonNationalityAndAge() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        additionalInfo.add("India");
        additionalInfo.add("25");
        Invitation invitation = new Invitation(modi, additionalInfo);
        assertEquals(invitation.getNameRepresentationBy(lastNameFirstCommand),"Mr modi, narender, India, 66");
    }

    @Test
    public void testOfGetNameRepresentationByFirstNameFirstShouldGiveARepresenationOfNameWhenInvalidAdditionalInfoIsGiven() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        additionalInfo.add("Japan");
        Invitation invitation = new Invitation(modi, additionalInfo);
        assertEquals(invitation.getNameRepresentationBy(firstNameFirstCommand),"Mr narender modi");
    }

    @Test
    public void testOfGetNameRepresentationByLastNameFirstShouldGiveARepresenationOfNameWhenInvalidAdditionalInfoIsGiven() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        additionalInfo.add("Japan");
        Invitation invitation = new Invitation(modi, additionalInfo);
        assertEquals(invitation.getNameRepresentationBy(lastNameFirstCommand),"Mr modi, narender");
    }

    @Test
    public void testOfGetNameRepresentationByFirstNameFirstShouldGiveARepresenationOfNameWhenInvalidAdditionalInfoIsGivenWithOneCorrectInfo() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        additionalInfo.add("Japan");
        additionalInfo.add("23");
        Invitation invitation = new Invitation(modi, additionalInfo);
        assertEquals(invitation.getNameRepresentationBy(firstNameFirstCommand),"Mr narender modi, 66");
    }

    @Test
    public void testOfGetNameRepresentationByLastNameFirstShouldGiveARepresenationOfNameWhenInvalidAdditionalInfoIsGivenWithOneCorrectInfo() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        additionalInfo.add("Japan");
        additionalInfo.add("23");
        Invitation invitation = new Invitation(modi, additionalInfo);
        assertEquals(invitation.getNameRepresentationBy(lastNameFirstCommand),"Mr modi, narender, 66");
    }

    @Test
    public void testOfGetNameRepresentationByLastNameFirstShouldErrorWhenWrongFormatCommandIsGiven() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        String wrongCommand = "-a";
        additionalInfo.add("Japan");
        additionalInfo.add("23");
        Invitation invitation = new Invitation(modi, additionalInfo);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("there is not format like -a to represent name");
        invitation.getNameRepresentationBy(wrongCommand);
    }

    @Test
    public void testOfGetNameRepresentationByFirstNameFirstShouldGiveARepresenationOfNameWithPersonAgeWhenFormatCommandIsGivenAsNameInsteadOfSymbol() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        additionalInfo.add("23");
        Invitation invitation = new Invitation(modi, additionalInfo);
        assertEquals(invitation.getNameRepresentationBy("--firstLast"),"Mr narender modi, 66");
    }

    @Test
    public void testOfGetNameRepresentationByLastNameFirstShouldGiveARepresenationOfNameWithPersonAgehenFormatCommandIsGivenAsNameInsteadOfSymbol() throws Exception {
        ArrayList<String> additionalInfo = new ArrayList<>();
        additionalInfo.add("23");
        Invitation invitation = new Invitation(modi, additionalInfo);
        assertEquals(invitation.getNameRepresentationBy("--lastFirst"),"Mr modi, narender, 66");
    }
}
