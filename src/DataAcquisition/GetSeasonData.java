package DataAcquisition;

import org.json.JSONArray;
import org.json.JSONObject;

public class GetSeasonData {
    
    public void getSeasonData(String Season) {

        try {
            JSONObject obj = new JSONObject(Season);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objSeasonTable = objMRData.getJSONObject("SeasonTable");
            JSONArray arraySeason = objSeasonTable.getJSONArray("Seasons");
            for (int i = 0; i < arraySeason.length(); i++) {
                JSONObject objSeason = arraySeason.getJSONObject(i);
                String season = objSeason.getString("season");
                String url = objSeason.getString("url");
                System.out.println(season + ": " + url);
            }
            String xlm = objMRData.getString("xmlns");
            System.out.println(obj);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
