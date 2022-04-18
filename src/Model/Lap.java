package Model;

import DataAcquisition.GetData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Lap {

    private byte lap_driven=0;
    private byte lap_number;
    private double[] lap_time_race;
    //public ArrayList<Integer> giro = new ArrayList<Integer>();

    public Lap(){

    }


    public void setLapDriven(byte lap_driven){
        this.lap_driven = lap_driven;
    }

    public void setLapTimeRace(double[] lap_time_race){
        this.lap_time_race = lap_time_race;
    }

    public void setLapTimeRace(double single_value,int index){
        this.lap_time_race[index] = single_value;
    }

    public void setLapNumber(byte lap_number){
        this.lap_number = lap_number;
    }

    public byte getLapDriven() {
        return lap_driven;
    }


    public byte getLapNumber(){
        return lap_number;
    }

    public double[] getLapTimeRace() { return lap_time_race;}

}