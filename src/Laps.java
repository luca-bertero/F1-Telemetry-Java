import org.json.JSONArray;
import org.json.JSONObject;

public class Laps {

    public int lap_time;

    public Laps(){

    }

    public double[] getLapsTime(int year,int round,String driver) {
        String time="";
        GetData data = GetData.get();

        String ergast_url="https://ergast.com/api/f1/"+year+"/"+round+"/drivers/+"+driver+"/laps.json?limit=100";
        String data_json=data.getJsondata(ergast_url);
        int total = data.getTotalRecords(data_json);

        double[] array_lap = new double[total];
        try {
            JSONObject obj = new JSONObject(data_json);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objRaceTable = objMRData.getJSONObject("RaceTable");
            JSONArray arrayLapsResults = objRaceTable.getJSONArray("Races");
            for (int i = 0; i < arrayLapsResults.length(); i++) {
                JSONObject objLapsResults = arrayLapsResults.getJSONObject(i);
                JSONArray laps = objLapsResults.getJSONArray("Laps");
                for (int j = 0; j < laps.length(); j++) {
                    JSONObject objLaps = laps.getJSONObject(j);
                    JSONArray Timings = objLaps.getJSONArray("Timings");
                    for (int k = 0; k < Timings.length(); k++){
                        JSONObject objTimingsResults = Timings.getJSONObject(k);
                        time = objTimingsResults.getString("time");
                        //System.out.println(time);
                        int int_lap = converterStringtoInt(time);
                        array_lap[j] = int_lap;
                    }
                }

                //System.out.println( position +": " + Drivername +" "+ date +" "+time+" "+Code+" "+q1+" "+q2+" "+q3);
            }
            String xlm = objMRData.getString("xmlns");
            //System.out.println(obj);


        } catch (Exception e) {
            System.out.println(e);
        }

        return array_lap;
    }

    private int converterStringtoInt(String LapTime){
        String[] min = LapTime.split(":");
        String[] sec = min[1].split("\\.");
        int minuts = Integer.parseInt(min[0]);
        int seconds = Integer.parseInt(sec[0]);
        int milliseconds = Integer.parseInt(sec[1]);

        return (minuts * 60 + seconds )*1000 + milliseconds;

    }
}
