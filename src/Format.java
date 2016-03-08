import java.util.ArrayList;
import java.util.HashMap;

public class Format {
    ArrayList data;

    public Format(ArrayList data) {
        this.data = data;
    }

    public ArrayList<HashMap<String, String>> getData() {
        ArrayList<HashMap<String, String>> formatedData = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String personData = (String) data.get(i);
            String[] personInfo = personData.split(",");
            HashMap<String, String> eachPersonInfo = new HashMap<>();
            eachPersonInfo.put("firstName", personInfo[0]);
            eachPersonInfo.put("lastName", personInfo[1]);
            eachPersonInfo.put("gender", personInfo[2]);
            eachPersonInfo.put("age", personInfo[3]);
            eachPersonInfo.put("city", personInfo[4]);
            eachPersonInfo.put("state", personInfo[5]);
            eachPersonInfo.put("country", personInfo[6]);
            formatedData.add(eachPersonInfo);
        }
        return formatedData;
    }
}
