import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Rounds {
    private byte n_round;
    private short year_round;
    private String url;
    private String RaceName;

    public Rounds() {

    }

    public static Rounds[] getRoundofYear(short year) {
        GetData data = GetData.get();

        String ergast_url = "https://ergast.com/api/f1/" + year + ".json";
        String data_json = data.getJsondata(ergast_url);
        int total = data.getTotalRecords(data_json);
        Rounds[] Rounds_array = new Rounds[total];

        try {

            JSONObject obj = new JSONObject(data_json);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objDriverTable = objMRData.getJSONObject("RaceTable");
            JSONArray arrayDriver = objDriverTable.getJSONArray("Races");
            for (int i = 0; i < arrayDriver.length(); i++) {
                Rounds single_round = new Rounds();
                JSONObject objDriver = arrayDriver.getJSONObject(i);
                single_round.n_round = Byte.parseByte(objDriver.getString("round"));
                single_round.year_round = Short.parseShort(objDriver.getString("season"));
                single_round.url = objDriver.getString("url");
                single_round.RaceName = objDriver.getString("raceName");

                Rounds_array[i] = single_round;
            }

        } catch (JSONException e) {
            System.out.println("Not valid Json " + e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Rounds_array;
    }

    public int getN_round() {
        return n_round;
    }

    public short getYearRound() {
        return year_round;
    }

    public String getRaceName() {
        return RaceName;
    }

    public String getUrl() {
        return url;
    }
}
