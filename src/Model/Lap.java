package Model;

public class Lap {

    private byte lap_driven=0;
    private byte total_lap_race;
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

    public void setTotalLapNumber(byte total_lap_race){
        this.total_lap_race = total_lap_race;
    }

    public byte getLapDriven() {
        return lap_driven;
    }


    public byte getTotalLapNumber(){
        return total_lap_race;
    }

    public double[] getLapTimeRace() { return lap_time_race;}

}
