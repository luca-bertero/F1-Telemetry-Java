package Model;

import DataAcquisition.GetData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Round {
    private byte n_round;
    private short year_round;
    private String url;
    private String RaceName;

    public Round(){

    }

    public static Round[] getRoundofYear(short year){

        String ergast_url="https://ergast.com/api/f1/"+year+".json";
        String data_json=GetData.getJsondata(ergast_url);
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
                single_round.n_round = Byte.parseByte(objDriver.getString("round"));
                single_round.year_round = Short.parseShort(objDriver.getString("season"));
                single_round.url = objDriver.getString("url");
                single_round.RaceName = objDriver.getString("raceName");

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


    public void setN_round(byte n_round) {
        this.n_round = n_round;
    }

    public void setYearRounds(short year_round) {
        this.year_round = year_round;
    }

    public void setRaceName(String RaceName) {
        this.RaceName = RaceName;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public byte getN_round(){return n_round;}
    public short getYearRound(){return year_round;}
    public String getRaceName() {
        return RaceName;
    }
    public String getUrl() {return url;}
}
