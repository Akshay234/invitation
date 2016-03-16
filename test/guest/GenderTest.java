import guest.Gender;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GenderTest {

    @Test
    public void testOfGetHonerificForMaleGuest() throws Exception {
        Gender male = Gender.MALE;
        assertTrue(male.getHonorific().equals("Mr"));
    }

    @Test
    public void testOfGetHonerificForFemaleGuest() throws Exception {
        Gender female = Gender.FEMALE;
        assertTrue(female.getHonorific().equals("Ms"));
    }
}