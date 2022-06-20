package Model;

import DataAcquisition.GetData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Round {
    private byte n_round;
    private short year_round;
    private Driver[] drivers;
    private String url;
    private String RaceName;

    public Round() {

    }

    public void setN_round(byte n_round) {
        this.n_round = n_round;
    }

    public void setYearRounds(short year_round) {
        this.year_round = year_round;
    }

    public void setRaceName(String RaceName) {
        this.RaceName = RaceName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDriver(String... driverId) {
        drivers = new Driver[driverId.length];
        System.out.println(driverId.length);
        for (int i = 0; i < driverId.length; i++) {
            drivers[i] = new Driver(driverId[i]);
            System.out.println(drivers[i].getDriverId());

        }
    }

    public byte getN_round() {
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

    public Driver[] getDriver() {
        return drivers;
    }
}
