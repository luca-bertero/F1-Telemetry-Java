import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;


public class GetData {

    private String ergast_url = "";
    private static GetData instance;


    private GetData() {

    }


    public static GetData get(){
        if(GetData.instance == null){
            GetData.instance = new GetData();
        }
        return GetData.instance;
    }

    public String getJsondata(String url){

        StringBuilder sb = new StringBuilder();
        String result = "";
        //StringBuilder sbt = new StringBuilder();
        InputStream is = null;
        BufferedReader rd = null;
        try {

            //URL connection = new URL(url);
            is = new URL(url).openStream();
            rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            //System.out.print(is.available());

            //metodo alternativo
            int b = is.available();
            //System.out.print(rd.readLine());
            int a = 0;
            result = rd.readLine();
            //System.out.println(result);
            //System.out.println("miao");
            //char c =(char)rd.read();
            /*while (rd.read() != 0) {
                 //c =rd.read();
                sb.append((char)rd.read());

                //System.out.print((char) rd.read());
                a++;
            }
            rd.close();*/
            return result;


        } catch(UnknownHostException e){
            System.out.println("Connection failure: " + e);
            System.exit(1);
        }
        catch(IOException e){
            System.out.println("Bad Request " + e);
            System.exit(1);
        }
        catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
        finally{
            if (is != null && rd != null) {
                try {
                    rd.close();
                    is.close();
                } catch (IOException err) {
                    System.out.println(err);
                }
            }

        }

        //String b = sb.toString();
        //System.out.println(b);
        return null;

    }





    public int getTotalLaps(String json_data) {
        //String prov_url="http://ergast.com/api/f1/"+this.year+"/"+this.race_number+"/results/1.json";
        //String prov_json=getJsondata(prov_url);
        int n_results=0;
        String total_lap = "";
        try {

            JSONObject obj = new JSONObject(json_data);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objLapsTable = objMRData.getJSONObject("RaceTable");
            JSONArray arrayRace = objLapsTable.getJSONArray("Races");
            for (int i = 0; i < arrayRace.length(); i++) {
                JSONObject objRace = arrayRace.getJSONObject(i);
                JSONArray arrayResults = objRace.getJSONArray("Results");
                System.out.println(arrayResults);
                for (int j = 0; j < arrayResults.length(); j++){
                    JSONObject objLapsTotal = arrayResults.getJSONObject(i);
                    total_lap = objLapsTotal.getString("laps");
                }
            }
            n_results=Integer.parseInt(total_lap);

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(total_lap);
        return n_results;
    }

    public int getTotalRecords(String data_json) {
        int n_results=0;
        try {

            JSONObject obj = new JSONObject(data_json);
            JSONObject objMRData = obj.getJSONObject("MRData");
            String total_result = objMRData.getString("total");
            n_results=Integer.parseInt(total_result);

        } catch (JSONException e) {
            System.out.println("No valid Json "+e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return n_results;
    }

    public HashMap<String, HashMap<String, String>> getDataDriver(String Driver) {
        HashMap<String, HashMap<String,String>> driver_info = new HashMap<String, HashMap<String, String>>();
        HashMap<String, String> inner_driver_info = new HashMap<String, String>();
        try {

            JSONObject obj = new JSONObject(Driver);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objDriverTable = objMRData.getJSONObject("DriverTable");
            JSONArray arrayDriver = objDriverTable.getJSONArray("Drivers");
            for (int i = 0; i < arrayDriver.length(); i++) {
                JSONObject objDriver = arrayDriver.getJSONObject(i);
                String driverId = objDriver.getString("driverId");
                String code = "";
                String permanentNumber = "";
                if (!objDriver.isNull("code")) {
                    code = objDriver.getString("code");
                }
                if (!objDriver.isNull("permanentNumber")) {
                    permanentNumber = objDriver.getString("permanentNumber");

                }

                String nationality = objDriver.getString("nationality");
                String givenName = objDriver.getString("givenName");
                String familyName = objDriver.getString("familyName");
                String dateOfBirth = objDriver.getString("dateOfBirth");
                String url = objDriver.getString("url");
                inner_driver_info.put("nationality",nationality);
                inner_driver_info.put("givenName",givenName);
                inner_driver_info.put("familyName",familyName);
                inner_driver_info.put("dateOfBirth",dateOfBirth);
                inner_driver_info.put("url",url);
                driver_info.put(driverId,inner_driver_info);
                System.out.println("cioa "+ driver_info);

                System.out.println(driverId + ": " + permanentNumber + " " + code + " " + nationality + " " + givenName + " " + familyName + " " + dateOfBirth + " " + url);
            }
            String xlm = objMRData.getString("xmlns");
            //System.out.println(obj);

        } catch (JSONException e){
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return driver_info;
    }

    public void getConstructorData(String Constructor) {

        try {
            JSONObject obj = new JSONObject(Constructor);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objDriverTable = objMRData.getJSONObject("ConstructorTable");
            JSONArray arrayConstructors = objDriverTable.getJSONArray("Constructors");
            for (int i = 0; i < arrayConstructors.length(); i++) {
                JSONObject objConstructors = arrayConstructors.getJSONObject(i);
                String constructorId = objConstructors.getString("constructorId");
                String name = objConstructors.getString("name");
                String nationality = objConstructors.getString("nationality");
                String url = objConstructors.getString("url");
                System.out.println(constructorId + ": " + name + " " + nationality + " " + url);
            }
            String xlm = objMRData.getString("xmlns");
            System.out.println(obj);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

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

    public void getDataCircuits(String Driver) {
        try {
            JSONObject obj = new JSONObject(Driver);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objCircuitTable = objMRData.getJSONObject("CircuitTable");
            JSONArray arrayCircuits = objCircuitTable.getJSONArray("Circuits");
            for (int i = 0; i < arrayCircuits.length(); i++) {
                JSONObject objCircuit = arrayCircuits.getJSONObject(i);
                String circuitId = objCircuit.getString("circuitId");
                String circuitName = objCircuit.getString("circuitName");
                JSONObject objLocation = objCircuit.getJSONObject("location");
                String lat = objLocation.getString("lat");
                String lon = objLocation.getString("long");
                String locality = objLocation.getString("locality");
                String country = objLocation.getString("country");
                String url = objCircuit.getString("url");
                System.out.println(circuitId + ": " + circuitName + " " + lat + " " + lon + " " + locality + " " + country + " " + url);
            }
            String xlm = objMRData.getString("xmlns");
            System.out.println(obj);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getRaceInfo(String RaceInfo) {
        try {

            JSONObject obj = new JSONObject(RaceInfo);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objRaceTable = objMRData.getJSONObject("RaceTable");
            JSONArray arrayRace = objRaceTable.getJSONArray("Races");
            for (int i = 0; i < arrayRace.length(); i++) {
                JSONObject objRace = arrayRace.getJSONObject(i);
                String season = objRace.getString("season");
                String round = objRace.getString("round");
                String raceName = objRace.getString("raceName");

                String url = objRace.getString("url");
                String date = objRace.getString("date");
                String time = objRace.getString("time");
                System.out.println(season + ": " + round + " " + date + " " + time + " " + url + " " + raceName);
            }
            String xlm = objMRData.getString("xmlns");
            System.out.println(obj);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

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


    public double[] getLapsTime(String Laps) {
        String time="";
        double[] bbb = new double[100];
        try {
            JSONObject obj = new JSONObject(Laps);
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
                        int ggg = converter(time);
                        bbb[j] = ggg;
                    }
                }

                //System.out.println( position +": " + Drivername +" "+ date +" "+time+" "+Code+" "+q1+" "+q2+" "+q3);
            }
            String xlm = objMRData.getString("xmlns");
            //System.out.println(obj);


        } catch (Exception e) {
            System.out.println(e);
        }

        return bbb;
    }


    public int converter(String LapTime){
        String[] min = LapTime.split(":");
        String minf = min[1];
        String[] sec = min[1].split("\\.");
        int minuto = Integer.parseInt(min[0]);
        int secondi = Integer.parseInt(sec[0]);
        int millisecond = Integer.parseInt(sec[1]);

        return (minuto*60 + secondi )*1000 + millisecond;

    }

    public int[] storeData(int data){
        int[] data22 = new int[70];
        for(int i=0; i<data22.length; i++){
            data22[i]=data;
        }
        return data22;
    }
}

