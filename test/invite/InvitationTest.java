import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class InvitationTest {
//    Guest modi;
//    Name maleGuestName;
//    Place maleGuestAddress;
//    Age maleAge;
//    String firstNameFirstCommand = "-fl";
//    String lastNameFirstCommand = "-lf";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

//    @Before
//    public void setUp() throws Exception {
//        maleGuestName = new Name("narender","modi");
//        maleGuestAddress = new Place("mehsana","gujarat","India");
//        maleAge = new Age(66);
//        modi = new Guest(maleGuestName, maleGuestAddress, Gender.MALE, maleAge);
//    }

//    @Test
//    public void testOfPrintLabelFirstNameFirstShouldGiveARepresentationOfNameWhenNoAdditionalInfoIsNotGiven() throws Exception {
//        ArrayList<String> guestData = new ArrayList<>();
//        guestData.add("A,B,Male,20,bangalore,karnataka,india");
//        String[] args = {"-fl","-F","records.txt"};
//        Invitation invitation = new Invitation(args, guestData);
//        assertEquals(invitation.getPrinterFor(),"Mr narender modi");
//    }
//
//    @Test
//    public void testOfprintLabelLastNameFirstShouldGiveARepresentationOfNameWhenNoAdditionalInfoIsNotGiven() throws Exception {
//        ArrayList<String> additionalInfo = new ArrayList<>();
//        Invitation invitation = new Invitation(modi, additionalInfo);
//        assertEquals(invitation.getPrinterFor(lastNameFirstCommand),"Mr modi, narender");
//    }
//
//    @Test
//    public void testOfPrintLabelFirstNameFirstShouldGiveARepresentationOfNameWithPersonAge() throws Exception {
//        ArrayList<String> additionalInfo = new ArrayList<>();
//        additionalInfo.add("23");
//        Invitation invitation = new Invitation(modi, additionalInfo);
//        assertEquals(invitation.getPrinterFor(firstNameFirstCommand),"Mr narender modi, 66");
//    }
//
//    @Test
//    public void testOfprintLabelLastNameFirstShouldGiveARepresentationOfNameWithPersonAge() throws Exception {
//        ArrayList<String> additionalInfo = new ArrayList<>();
//        additionalInfo.add("23");
//        Invitation invitation = new Invitation(modi, additionalInfo);
//        assertEquals(invitation.getPrinterFor(lastNameFirstCommand),"Mr modi, narender, 66");
//    }
//
//    @Test
//    public void testOfPrintLabelFirstNameFirstShouldGiveARepresentationOfNameWithPersonNationality() throws Exception {
//        ArrayList<String> additionalInfo = new ArrayList<>();
//        additionalInfo.add("India");
//        Invitation invitation = new Invitation(modi, additionalInfo);
//        assertEquals(invitation.getPrinterFor(firstNameFirstCommand),"Mr narender modi, India");
//    }
//
//    @Test
//    public void testOfprintLabelLastNameFirstShouldGiveARepresentationOfNameWithPersonNationality() throws Exception {
//        ArrayList<String> additionalInfo = new ArrayList<>();
//        additionalInfo.add("India");
//        Invitation invitation = new Invitation(modi, additionalInfo);
//        assertEquals(invitation.getPrinterFor(lastNameFirstCommand),"Mr modi, narender, India");
//    }
//
//    @Test
//    public void testOfPrintLabelFirstNameFirstShouldGiveARepresentationOfNameWithPersonNationalityAndAge() throws Exception {
//        ArrayList<String> additionalInfo = new ArrayList<>();
//        additionalInfo.add("India");
//        additionalInfo.add("20");
//        Invitation invitation = new Invitation(modi, additionalInfo);
//        assertEquals(invitation.getPrinterFor(firstNameFirstCommand),"Mr narender modi, India, 66");
//    }
//
//    @Test
//    public void testOfprintLabelLastNameFirstShouldGiveARepresentationOfNameWithPersonNationalityAndAge() throws Exception {
//        ArrayList<String> additionalInfo = new ArrayList<>();
//        additionalInfo.add("India");
//        additionalInfo.add("25");
//        Invitation invitation = new Invitation(modi, additionalInfo);
//        assertEquals(invitation.getPrinterFor(lastNameFirstCommand),"Mr modi, narender, India, 66");
//    }
//
//    @Test
//    public void testOfPrintLabelFirstNameFirstShouldGiveARepresentationOfNameWhenInvalidAdditionalInfoIsGiven() throws Exception {
//        ArrayList<String> additionalInfo = new ArrayList<>();
//        additionalInfo.add("Japan");
//        Invitation invitation = new Invitation(modi, additionalInfo);
//        assertEquals(invitation.getPrinterFor(firstNameFirstCommand),"Mr narender modi");
//    }
//
//    @Test
//    public void testOfprintLabelLastNameFirstShouldGiveARepresentationOfNameWhenInvalidAdditionalInfoIsGiven() throws Exception {
//        ArrayList<String> additionalInfo = new ArrayList<>();
//        additionalInfo.add("Japan");
//        Invitation invitation = new Invitation(modi, additionalInfo);
//        assertEquals(invitation.getPrinterFor(lastNameFirstCommand),"Mr modi, narender");
//    }
//
//    @Test
//    public void testOfPrintLabelFirstNameFirstShouldGiveARepresentationOfNameWhenInvalidAdditionalInfoIsGivenWithOneCorrectInfo() throws Exception {
//        ArrayList<String> additionalInfo = new ArrayList<>();
//        additionalInfo.add("Japan");
//        additionalInfo.add("23");
//        Invitation invitation = new Invitation(modi, additionalInfo);
//        assertEquals(invitation.getPrinterFor(firstNameFirstCommand),"Mr narender modi, 66");
//    }
//
//    @Test
//    public void testOfprintLabelLastNameFirstShouldGiveARepresentationOfNameWhenInvalidAdditionalInfoIsGivenWithOneCorrectInfo() throws Exception {
//        ArrayList<String> additionalInfo = new ArrayList<>();
//        additionalInfo.add("Japan");
//        additionalInfo.add("23");
//        Invitation invitation = new Invitation(modi, additionalInfo);
//        assertEquals(invitation.getPrinterFor(lastNameFirstCommand),"Mr modi, narender, 66");
//    }
//
//    @Test
//    public void testOfprintLabelLastNameFirstShouldErrorWhenWrongFormatCommandIsGiven() throws Exception {
//        ArrayList<String> additionalInfo = new ArrayList<>();
//        String wrongCommand = "-a";
//        additionalInfo.add("Japan");
//        additionalInfo.add("23");
//        Invitation invitation = new Invitation(modi, additionalInfo);
//        thrown.expect(IllegalArgumentException.class);
//        thrown.expectMessage("there is not format like -a to represent name");
//        invitation.getPrinterFor(wrongCommand);
//    }
//
//    @Test
//    public void testOfPrintLabelFirstNameFirstShouldGiveARepresentationOfNameWithPersonAgeWhenFormatCommandIsGivenAsNameInsteadOfSymbol() throws Exception {
//        ArrayList<String> additionalInfo = new ArrayList<>();
//        additionalInfo.add("23");
//        Invitation invitation = new Invitation(modi, additionalInfo);
//        assertEquals(invitation.getPrinterFor("--firstLast"),"Mr narender modi, 66");
//    }
//
//    @Test
//    public void testOfprintLabelLastNameFirstShouldGiveARepresentationOfNameWithPersonAgehenFormatCommandIsGivenAsNameInsteadOfSymbol() throws Exception {
//        ArrayList<String> additionalInfo = new ArrayList<>();
//        additionalInfo.add("23");
//        Invitation invitation = new Invitation(modi, additionalInfo);
//        assertEquals(invitation.getPrinterFor("--lastFirst"),"Mr modi, narender, 66");
//    }
}
