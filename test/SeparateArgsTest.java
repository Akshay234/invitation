import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;

public class SeparateArgsTest {

    @Test
    public void testOfFilesShouldGiveAllCommandsArgsPresentAfterFileSeparatorSymbol() throws Exception {
        String separatorSymbol = "--Files";
        String[] args = {"-l", separatorSymbol,"a.txt","b.txt","c"};
        SeparateArgs SeparateArgs = new SeparateArgs(args);
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("a.txt");
        expectedResult.add("b.txt");
        expectedResult.add("c");
        assertTrue(SeparateArgs.files().equals(expectedResult));
    }

    @Test
    public void testOfFilesShouldGiveAllCommandsArgsPresentAfterFileSeparatorSymbolWhenAdditionalCommandsAreAlsoPresent() throws Exception {
        String separatorSymbol = "--Files";
        String[] args = {"-l","Bangalore","14", separatorSymbol,"a.txt","b.cvv","c.txt"};
        SeparateArgs SeparateArgs = new SeparateArgs(args);
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("a.txt");
        expectedResult.add("b.cvv");
        expectedResult.add("c.txt");
        assertTrue(SeparateArgs.files().equals(expectedResult));
    }

    @Test
    public void testOfAdditionalCommandsShouldGiveAllExtraCommandsGivenBetweenFormatCommandAndFilesSeparator() throws Exception {
        String fileSeparatorSymbol = "--Files";
        String formatCommand = "-l";
        String[] args = {formatCommand,"Bangalore","14", fileSeparatorSymbol,"a.txt","b.cvv","c.txt"};
        SeparateArgs SeparateArgs = new SeparateArgs(args);
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("Bangalore");
        expectedResult.add("14");
        assertTrue(SeparateArgs.additionalCommands().equals(expectedResult));
    }
}