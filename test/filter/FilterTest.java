import filter.Filter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FilterTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testOfFilesShouldGiveAllCommandsArgsPresentAfterFileSeparatorSymbol() throws Exception {
        String fileSeparatorSymbol = "-F";
        String[] args = {"-lf", fileSeparatorSymbol,"a.txt","b.txt","c"};
        Filter Filter = new Filter(args);
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("a.txt");
        expectedResult.add("b.txt");
        expectedResult.add("c");
        assertTrue(Filter.files().equals(expectedResult));
    }

    @Test
    public void testOfFilesShouldGiveExceptionWhenNoSeparatorCommandIsPresent() throws Exception {
        String nameFormatCommand = "-lf";
        String[] args = {nameFormatCommand,"Bangalore","14","a.txt","b.cvv","c.txt"};
        Filter Filter = new Filter(args);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("No file separator command detected");
        Filter.files();
    }
//
    @Test
    public void testOfFilesShouldGiveExceptionWhenWrongSeparatorCommandIsPresent() throws Exception {
        String nameFormatCommand = "-lf";
        String fileSeparatorSymbol = "-Files";
        String[] args = {nameFormatCommand,"Bangalore","14",fileSeparatorSymbol,"a.txt","b.cvv","c.txt"};
        Filter Filter = new Filter(args);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("No file separator command detected");
        Filter.files();
    }

    @Test
    public void testOfGetCountriesShouldGiveAllValuesPresentBetweenCountrySeparatorCommandAndAnyNextCommand() throws Exception {
        String countrySeparatorCommand = "-c";
        String fileSeparatorSymbol = "-F";
        String[] args = {"-lf", countrySeparatorCommand,"bangladesh",fileSeparatorSymbol,"a.txt","b.txt","c"};
        Filter filter = new Filter(args);
        String[] expectedResult = new String[1];
        expectedResult[0] = "bangladesh";
        assertArrayEquals(filter.getCountries(),expectedResult);
    }

    @Test
    public void testOfGetCountriesShouldGiveAllValuesPresentAfterCountrySeparatorCommandWhenNoOtherSeparatorCommandIsPresent() throws Exception {
        String countrySeparatorCommand = "-c";
        String[] args = {"-lf", countrySeparatorCommand,"bangladesh","a.txt","b.txt"};
        Filter filter = new Filter(args);
        String[] expectedResult = new String[3];
        expectedResult[0] = "bangladesh";
        expectedResult[1] = "a.txt";
        expectedResult[2] = "b.txt";
        assertArrayEquals(filter.getCountries(),expectedResult);
    }

    @Test
    public void testOfGetCountriesShouldGiveZeroCountryWhenAnyOtherCommandIsPresentJustAfterTheCountrySeparatorCommand() throws Exception {
        String countrySeparatorCommand = "-c";
        String fileSeparatorSymbol = "-F";
        String[] args = {"-lf", countrySeparatorCommand,fileSeparatorSymbol,"a.txt","b.txt","c"};
        Filter filter = new Filter(args);
        String[] expectedResult = new String[0];
        assertArrayEquals(filter.getCountries(),expectedResult);
    }

    @Test
    public void testOfGetCountriesShouldGiveZeroCountryWhenCountrySeparatorCommandIsNotPresent() throws Exception {
        String fileSeparatorSymbol = "-F";
        String[] args = {"-lf","Bangladesh",fileSeparatorSymbol,"a.txt","b.txt","c"};
        Filter filter = new Filter(args);
        String[] expectedResult = new String[0];
        assertArrayEquals(filter.getCountries(),expectedResult);
    }

//    ---------------------

    @Test
    public void testOfGetAgeShouldGiveFirstValuePresentBetweenAgeSeparatorCommandAndAnyNextCommand() throws Exception {
        String ageSeparatorCommand = "-a";
        String separatorSymbol = "-F";
        String[] args = {"-lf", ageSeparatorCommand,"23",separatorSymbol,"a.txt","b.txt","c"};
        Filter filter = new Filter(args);
        String expectedResult= "23";
        assertEquals(filter.getAge(),expectedResult);
    }

    @Test
    public void testOfGetAgeShouldGiveFirstPresentAfterAgeSeparatorCommandWhenNoOtherSeparatorCommandIsPresent() throws Exception {
        String ageSeparatorCommand = "-a";
        String[] args = {"-lf", ageSeparatorCommand,"13","bangladesh","a.txt","b.txt"};
        Filter filter = new Filter(args);
        String expectedResult = "13";
        assertEquals(filter.getAge(),expectedResult);
    }

    @Test
    public void testOfGetAgeShouldGiveNoAgeWhenAnyOtherCommandIsPresentJustAfterTheAgeSeparatorCommand() throws Exception {
        String ageSeparatorCommand = "-a";
        String separatorSymbol = "-F";
        String[] args = {"-lf", ageSeparatorCommand,separatorSymbol,"a.txt","b.txt","c"};
        Filter filter = new Filter(args);
        String expectedResult = "";
        assertEquals(filter.getAge(),expectedResult);
    }

    @Test
    public void testOfGetAgeShouldGiveNoAgeWhenAgeSeparatorCommandIsNotPresent() throws Exception {
        String fileSeparatorSymbol = "-F";
        String[] args = {"-lf","Bangladesh",fileSeparatorSymbol,"a.txt","b.txt","c"};
        Filter filter = new Filter(args);
        String expectedResult = "";
        assertEquals(filter.getAge(),expectedResult);
    }

    @Test
    public void testOfNameFormatShouldGiveFirstArgumentWhenMoreThanOneArgumentIsPresentInArgumentList() throws Exception {
        String[] args = {"-lf","a.txt","b.txt","c"};
        Filter filter = new Filter(args);
        String expectedResult = "-lf";
        assertEquals(filter.nameFormat(),expectedResult);
    }

    @Test
    public void testOfNameFormatShouldNothingWhenNoArgumentIsPresentInArgumentList() throws Exception {
        String[] args = {};
        Filter filter = new Filter(args);
        String expectedResult = "";
        assertEquals(filter.nameFormat(),expectedResult);
    }

    @Test
    public void testOfGetLabelPatternCommandShouldGiveTheBorderCommandWhenWhenBorderCommandIsPresentInBetweenNameFormatCommandAndFileSeparatorCommand() throws Exception {
        String fileSeparatorSymbol = "-F";
        String borderCommand = "-b";
        String[] args = {"-lf","Bangladesh",borderCommand,fileSeparatorSymbol,"a.txt","b.txt","c"};
        Filter filter = new Filter(args);
        assertEquals(filter.getLabelDesignCommand(),borderCommand);
    }

    @Test
    public void testOfGetLabelPatternCommandShouldGiveTheNoBorderCommandWhenWhenNoBorderCommandIsPresentInBetweenNameFormatCommandAndFileSeparatorCommand() throws Exception {
        String fileSeparatorSymbol = "-F";
        String noBorderCommand = "-nb";
        String[] args = {"-lf","Bangladesh",noBorderCommand,fileSeparatorSymbol,"a.txt","b.txt","c"};
        Filter filter = new Filter(args);
        assertEquals(filter.getLabelDesignCommand(),noBorderCommand);
    }
}