package DataAcquisition;

import org.json.JSONArray;
import org.json.JSONObject;

public class GetQualifyingData {
    

    public void getQualifyingData(String RaceInfo) {
        
        try {

            JSONObject obj = new JSONObject(RaceInfo);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objRaceTable = objMRData.getJSONObject("RaceTable");
            JSONArray arrayQualifyingResults = objRaceTable.getJSONArray("QualifyingResults");
            for (int i = 0; i < arrayQualifyingResults.length(); i++) {
                JSONObject objQualifyingResults = arrayQualifyingResults.getJSONObject(i);
                String position = objQualifyingResults.getString("position");
                JSONObject Driver = objQualifyingResults.getJSONObject("Driver");
                String Drivername = Driver.getString("familyName");
                String Code = Driver.getString("code");
                String q1 = objQualifyingResults.getString("q1");
                String q2 = objQualifyingResults.getString("q2");
                String q3 = objQualifyingResults.getString("q3");
                String date = objRaceTable.getString("date");
                String time = objRaceTable.getString("time");
                System.out.println(position + ": " + Drivername + " " + date + " " + time + " " + Code + " " + q1 + " " + q2 + " " + q3);
            }
            String xlm = objMRData.getString("xmlns");

        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
