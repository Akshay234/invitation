import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;

public class GenerateLabelTest {

    @Test
    public void testOfGenerateShouldGenerateLabelOfNameOfGivenRecordWhenNoAdditionalInfoIsNotPresent() throws Exception {
        GenerateLabel labelGenerator = new GenerateLabel();
        ArrayList<String> additionalInfo = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();
        data.add("A,B,Male,20,bangalore,karnataka,india");
        Format dataFormatter = new Format(data);
        ArrayList<HashMap<String, String>> formattedData = dataFormatter.getData();
        String nameFormat = "-fl";
        String[] dataToTest = labelGenerator.generate(nameFormat,formattedData,additionalInfo);
        String[] expectedData = {"Mr A B"};
        assertArrayEquals(dataToTest,expectedData);
    }
}