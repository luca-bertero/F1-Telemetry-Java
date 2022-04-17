import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;

public class Drivers {

    private String driverId;
    private String permanentNumber;
    private String code;
    private String url;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String nationality;

    public Drivers(){

    }


    public static Drivers[] getAllDriverfromYear(int year){

        String ergast_url="https://ergast.com/api/f1/"+year+"/drivers.json";
        String data_json=GetData.getJsondata(ergast_url);
        int total = GetData.getTotalRecords(data_json);
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

                Driver_array[i]=single_driver;
            }

            return Driver_array;

        } catch (JSONException e){
            System.out.println("Not valid Json " + e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static Drivers[] getAllDriverfromYearandRound(short year,byte round){

        String ergast_url="https://ergast.com/api/f1/"+year+"/"+round+"/drivers.json";
        String data_json=GetData.getJsondata(ergast_url);
        int total = GetData.getTotalRecords(data_json);
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

                Driver_array[i]=single_driver;
            }

        } catch (JSONException e){
            System.out.println("Not valid Json " + e);
        }
        catch (Exception e) {
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
