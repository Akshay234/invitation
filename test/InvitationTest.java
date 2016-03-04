import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by akshayks on 03/03/16.
 */
public class InvitationTest {

    @Test
    public void testOfInviteByFirstNameFirstShouldGenerateARepresentationOfInvitationLabelWhenSpecificCountryIsProvided() throws Exception {
        Name name = new Name("narender","modi");
        Place address = new Place("mehsana","gujarat","japan");
        Guest modi = new Guest(name, address, Gender.MALE, 66);
        Invitation invitation = new Invitation(modi,"japan");
        assertEquals(invitation.inviteByFirstNameFirst(),"Mr narender modi, japan");
    }

    @Test
    public void testOfInviteByLastNameFirstShouldGenerateARepresentationOfInvitationLabelWhenSpecificCountryIsProvided() throws Exception {
        Name name = new Name("narender","modi");
        Place address = new Place("mehsana","gujarat","japan");
        Guest modi = new Guest(name, address, Gender.MALE, 66);
        Invitation invitation = new Invitation(modi,"japan");
        assertEquals(invitation.inviteByLastNameFirst(),"Mr modi, narender, japan");
    }

    @Test
    public void testOfInviteByFirstNameFirstShouldGenerateARepresentationOfInvitationLabelWhenSpecificCountryIsNotProvided() throws Exception {
        Name name = new Name("narender","modi");
        Place address = new Place("mehsana","gujarat","japan");
        Guest modi = new Guest(name, address, Gender.MALE, 66);
        Invitation invitation = new Invitation(modi);
        assertEquals(invitation.inviteByFirstNameFirst(),"Mr narender modi");
    }

    @Test
    public void testOfInviteByLastNameFirstShouldGenerateARepresentationOfInvitationLabelWhenSpecificCountryIsNotProvided() throws Exception {
        Name name = new Name("narender","modi");
        Place address = new Place("mehsana","gujarat","japan");
        Guest modi = new Guest(name, address, Gender.MALE, 66);
        Invitation invitation = new Invitation(modi);
        assertEquals(invitation.inviteByLastNameFirst(),"Mr modi, narender");
    }
}
