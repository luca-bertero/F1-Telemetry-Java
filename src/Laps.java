import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Laps {

    private byte lap_driven=0;
    private byte lap_number;
    private double[] lap_time_race;
    //public ArrayList<Integer> giro = new ArrayList<Integer>();

    public Laps(){

    }

    public double[] getLapsTime(short year,byte round,String driver) {
        String time="";
        GetData data = GetData.get();

        String ergast_url="https://ergast.com/api/f1/"+year+"/"+round+"/drivers/"+driver+"/laps.json?limit=100";
        String data_json=data.getJsondata(ergast_url);
        int total = data.getTotalRecords(data_json);

        lap_time_race = new double[total];
        try {
            JSONObject obj = new JSONObject(data_json);
            JSONObject objMRData = obj.getJSONObject("MRData");
            lap_driven = Byte.parseByte(objMRData.getString("total"));
            JSONObject objRaceTable = objMRData.getJSONObject("RaceTable");
            JSONArray arrayLapsResults = objRaceTable.getJSONArray("Races");
            for (int i = 0; i < arrayLapsResults.length(); i++) {
                JSONObject objLapsResults = arrayLapsResults.getJSONObject(i);
                JSONArray laps = objLapsResults.getJSONArray("Laps");
                for (int j = 0; j < laps.length(); j++) {
                    JSONObject objLaps = laps.getJSONObject(j);
                    lap_number = Byte.parseByte(objLaps.getString("number"));
                    JSONArray Timings = objLaps.getJSONArray("Timings");
                    for (int k = 0; k < Timings.length(); k++){
                        JSONObject objTimingsResults = Timings.getJSONObject(k);
                        time = objTimingsResults.getString("time");
                        //System.out.println(time);
                        int int_lap = converterStringtoInt(time);

                        lap_time_race[j] = int_lap;
                        //giro.add(int_lap);
                    }
                }

            }

        } catch (JSONException e){
            System.out.println("Not valid Json " + e);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return lap_time_race;
    }

    private int converterStringtoInt(String LapTime){
        String[] min = LapTime.split(":");
        String[] sec = min[1].split("\\.");
        int minuts = Integer.parseInt(min[0]);
        int seconds = Integer.parseInt(sec[0]);
        int milliseconds = Integer.parseInt(sec[1]);

        return (minuts * 60 + seconds )*1000 + milliseconds;

    }

    public byte getTotalLaps(short year,byte race_number) {
        String url="http://ergast.com/api/f1/"+year+"/"+race_number+"/results/1.json";
        String json_data=GetData.getJsondata(url);
        byte n_results=0;
        String total_lap = "";
        try {

            JSONObject obj = new JSONObject(json_data);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objLapsTable = objMRData.getJSONObject("RaceTable");
            JSONArray arrayRace = objLapsTable.getJSONArray("Races");
            for (int i = 0; i < arrayRace.length(); i++) {
                JSONObject objRace = arrayRace.getJSONObject(i);
                JSONArray arrayResults = objRace.getJSONArray("Results");
                for (int j = 0; j < arrayResults.length(); j++){
                    JSONObject objLapsTotal = arrayResults.getJSONObject(i);
                    total_lap = objLapsTotal.getString("laps");
                }
            }
            n_results=Byte.parseByte(total_lap);

        } catch (Exception e) {
            System.out.println(e);
        }

        //System.out.println(total_lap);
        return n_results;
    }

    public byte getLapsDriven() {
        return lap_driven;
    }


    public byte getLapNumber(){
        return lap_number;
    }


}
