package Controller;

import DataAcquisition.GetData;
import Model.Round;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RoundController {

    private Round round;
    public RoundController(){
        round = new Round();
    }

    public Round[] getRoundofYear(short year){

        String ergast_url="https://ergast.com/api/f1/"+year+".json";
        String data_json= GetData.getJsondata(ergast_url);
        int total = GetData.getTotalRecords(data_json);
        Round[] Rounds_array = new Round[total];

        try {

            JSONObject obj = new JSONObject(data_json);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objDriverTable = objMRData.getJSONObject("RaceTable");
            JSONArray arrayDriver = objDriverTable.getJSONArray("Races");
            for (int i = 0; i < arrayDriver.length(); i++) {
                Round single_round = new Round();
                JSONObject objDriver = arrayDriver.getJSONObject(i);
                single_round.setN_round(Byte.parseByte(objDriver.getString("round")));
                single_round.setYearRounds(Short.parseShort(objDriver.getString("season")));
                single_round.setUrl(objDriver.getString("url"));
                single_round.setRaceName(objDriver.getString("raceName"));

                Rounds_array[i]=single_round;
            }

        } catch (JSONException e){
            System.out.println("Not valid Json " + e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return Rounds_array;
    }


}
