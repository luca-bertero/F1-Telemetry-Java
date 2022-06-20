package Controller;

import DataAcquisition.GetLapData;
import Model.Lap;

public class LapController {

    private GetLapData data_lap;
    private Lap laps;

    public LapController() {
        data_lap = new GetLapData();
    }

    public double[] getLapsTime(short year, byte round, String driver) {

        return data_lap.getLapsTime(year, round, driver);

    }

    public byte getTotalLaps(short year, byte race_number) {
        return data_lap.getTotalLaps(year, race_number);

    }

    public byte getLapsDriven() {
        return data_lap.getLapsDriven();
    }
}
