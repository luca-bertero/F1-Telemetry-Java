import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;

public class Drivers {

    public String driverId;
    public String permanentNumber;
    public String code;
    public String url;
    public String givenName;
    public String familyName;
    public String dateOfBirth;
    public String nationality;

    public Drivers(){

    }

    public Drivers(int year){
        GetData data = GetData.get();

        String ergast_url="https://ergast.com/api/f1/"+year+"/drivers.json";
        String data_json=data.getJsondata(ergast_url);
        try {

            JSONObject obj = new JSONObject(data_json);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objDriverTable = objMRData.getJSONObject("DriverTable");
            JSONArray arrayDriver = objDriverTable.getJSONArray("Drivers");
            for (int i = 0; i < arrayDriver.length(); i++) {
                JSONObject objDriver = arrayDriver.getJSONObject(i);
                this.driverId = objDriver.getString("driverId");
                this.code = "";
                this.permanentNumber = "";
                if (!objDriver.isNull("code")) {
                    this.code = objDriver.getString("code");
                }
                if (!objDriver.isNull("permanentNumber")) {
                    this.permanentNumber = objDriver.getString("permanentNumber");

                }

                this.nationality = objDriver.getString("nationality");
                this.givenName = objDriver.getString("givenName");
                this.familyName = objDriver.getString("familyName");
                this.dateOfBirth = objDriver.getString("dateOfBirth");
                this.url = objDriver.getString("url");

                System.out.println("cioa ");

                System.out.println(this.driverId + ": " + this.permanentNumber + " " + this.code + " " + this.nationality + " " + this.givenName + " " + this.familyName + " " + this.dateOfBirth + " " + this.url);
            }
            String xlm = objMRData.getString("xmlns");
            //System.out.println(obj);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public HashMap<String, HashMap<String, String>> getDataDriver(String Json_data) {
        HashMap<String, HashMap<String,String>> driver_info = new HashMap<String, HashMap<String, String>>();
        HashMap<String, String> inner_driver_info = new HashMap<String, String>();
        try {

            JSONObject obj = new JSONObject(Json_data);
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

        } catch (Exception e) {
            System.out.println(e);
        }
        return driver_info;
    }

    public static Drivers[] getAllDriverfromYear(int year){
        GetData data = GetData.get();

        String ergast_url="https://ergast.com/api/f1/"+year+"/drivers.json";
        String data_json=data.getJsondata(ergast_url);
        int total = data.getTotalRecords(data_json);
        Drivers[] Driver_array = new Drivers[total];

        try {

            JSONObject obj = new JSONObject(data_json);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objDriverTable = objMRData.getJSONObject("DriverTable");
            JSONArray arrayDriver = objDriverTable.getJSONArray("Drivers");
            for (int i = 0; i < arrayDriver.length(); i++) {
                Drivers single_driver = new Drivers();
                JSONObject objDriver = arrayDriver.getJSONObject(i);
                single_driver.driverId = objDriver.getString("driverId");
                if (!objDriver.isNull("code")) {
                    single_driver.code = objDriver.getString("code");
                }
                else{
                    single_driver.code = "";
                }

                if (!objDriver.isNull("permanentNumber")) {
                    single_driver.permanentNumber = objDriver.getString("permanentNumber");

                }
                else{
                    single_driver.permanentNumber = "";
                }

                single_driver.nationality = objDriver.getString("nationality");
                single_driver.givenName = objDriver.getString("givenName");
                single_driver.familyName = objDriver.getString("familyName");
                single_driver.dateOfBirth = objDriver.getString("dateOfBirth");
                single_driver.url = objDriver.getString("url");

                //System.out.println(single_driver.driverId + ": " + single_driver.permanentNumber + " " + single_driver.code + " " + single_driver.nationality + " " + single_driver.givenName + " " + single_driver.familyName + " " + single_driver.dateOfBirth + " " + single_driver.url);
                Driver_array[i]=single_driver;
            }
            String xlm = objMRData.getString("xmlns");
            //System.out.println(obj);

        } catch (Exception e) {
            System.out.println(e);
        }
        return Driver_array;
    }

    public static Drivers[] getAllDriverfromYearandRound(int year,int round){
        GetData data = GetData.get();

        String ergast_url="https://ergast.com/api/f1/"+year+"/"+round+"/drivers.json";
        String data_json=data.getJsondata(ergast_url);
        int total = data.getTotalRecords(data_json);
        Drivers[] Driver_array = new Drivers[total];

        try {

            JSONObject obj = new JSONObject(data_json);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objDriverTable = objMRData.getJSONObject("DriverTable");
            JSONArray arrayDriver = objDriverTable.getJSONArray("Drivers");
            for (int i = 0; i < arrayDriver.length(); i++) {
                Drivers single_driver = new Drivers();
                JSONObject objDriver = arrayDriver.getJSONObject(i);
                single_driver.driverId = objDriver.getString("driverId");
                if (!objDriver.isNull("code")) {
                    single_driver.code = objDriver.getString("code");
                }
                else{
                    single_driver.code = "";
                }

                if (!objDriver.isNull("permanentNumber")) {
                    single_driver.permanentNumber = objDriver.getString("permanentNumber");

                }
                else{
                    single_driver.permanentNumber = "";
                }

                single_driver.nationality = objDriver.getString("nationality");
                single_driver.givenName = objDriver.getString("givenName");
                single_driver.familyName = objDriver.getString("familyName");
                single_driver.dateOfBirth = objDriver.getString("dateOfBirth");
                single_driver.url = objDriver.getString("url");

                //System.out.println(single_driver.driverId + ": " + single_driver.permanentNumber + " " + single_driver.code + " " + single_driver.nationality + " " + single_driver.givenName + " " + single_driver.familyName + " " + single_driver.dateOfBirth + " " + single_driver.url);
                Driver_array[i]=single_driver;
            }
            String xlm = objMRData.getString("xmlns");
            //System.out.println(obj);

        } catch (Exception e) {
            System.out.println(e);
        }
        return Driver_array;
    }

    public String getDriverId(){
        return driverId;
    }

    public String getPermanentNumber(){
        return permanentNumber;
    }

    public String getCode() {
        return code;
    }

    public String getUrl() {
        return url;
    }

    public String getGivenName(){
        return givenName;
    }

    public String getFamilyName(){
        return familyName;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public String getNationality(){
        return nationality;
    }

}
