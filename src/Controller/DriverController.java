package Controller;

import DataAcquisition.GetData;
import Model.Driver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DriverController {

    private Driver driver;
    public DriverController(){
        driver = new Driver();
    }

    public Driver[] getAllDriverfromYear(int year){

        GetData data = GetData.get();
        String ergast_url="https://ergast.com/api/f1/"+year+"/drivers.json";
        String data_json= data.getJsondata(ergast_url);
        int total = data.getTotalRecords(data_json);
        Driver[] Driver_array = new Driver[total];

        try {

            JSONObject obj = new JSONObject(data_json);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objDriverTable = objMRData.getJSONObject("DriverTable");
            JSONArray arrayDriver = objDriverTable.getJSONArray("Drivers");
            for (int i = 0; i < arrayDriver.length(); i++) {
                //Driver single_driver = new Driver();
                JSONObject objDriver = arrayDriver.getJSONObject(i);
                driver.setDriverId(objDriver.getString("driverId"));
                if (!objDriver.isNull("code")) {
                    driver.setCode(objDriver.getString("code"));
                }
                else{
                    driver.setCode("");
                }

                if (!objDriver.isNull("permanentNumber")) {
                    driver.setPermanentNumber(objDriver.getString("permanentNumber"));

                }
                else{
                    driver.setPermanentNumber("");
                }

                driver.setNationality(objDriver.getString("nationality"));
                driver.setGivenName(objDriver.getString("givenName"));
                driver.setFamilyName(objDriver.getString("familyName"));
                driver.setDateOfBirth(objDriver.getString("dateOfBirth"));
                driver.setUrl(objDriver.getString("url"));

                Driver_array[i]=driver;
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

    public Driver[] getAllDriverfromYearandRound(short year, byte round){

        GetData data = GetData.get();
        String ergast_url="https://ergast.com/api/f1/"+year+"/"+round+"/drivers.json";
        String data_json= data.getJsondata(ergast_url);
        int total = data.getTotalRecords(data_json);
        Driver[] Driver_array = new Driver[total];

        try {

            JSONObject obj = new JSONObject(data_json);
            JSONObject objMRData = obj.getJSONObject("MRData");
            JSONObject objDriverTable = objMRData.getJSONObject("DriverTable");
            JSONArray arrayDriver = objDriverTable.getJSONArray("Drivers");
            for (int i = 0; i < arrayDriver.length(); i++) {
                Driver single_driver = new Driver();
                JSONObject objDriver = arrayDriver.getJSONObject(i);
                single_driver.setDriverId(objDriver.getString("driverId"));
                if (!objDriver.isNull("code")) {
                    single_driver.setCode(objDriver.getString("code"));
                }
                else{
                    single_driver.setCode("");
                }

                if (!objDriver.isNull("permanentNumber")) {
                    single_driver.setPermanentNumber(objDriver.getString("permanentNumber"));

                }
                else{
                    single_driver.setPermanentNumber("");
                }

                single_driver.setNationality(objDriver.getString("nationality"));
                single_driver.setGivenName(objDriver.getString("givenName"));
                single_driver.setFamilyName(objDriver.getString("familyName"));
                single_driver.setDateOfBirth(objDriver.getString("dateOfBirth"));
                single_driver.setUrl(objDriver.getString("url"));

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

    public void SetDriverId(String driverId){
        this.driver.setDriverId(driverId);
    }
}
