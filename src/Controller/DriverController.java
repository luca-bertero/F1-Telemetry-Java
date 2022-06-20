package Controller;

import DataAcquisition.GetDriverData;
import Model.Driver;

public class DriverController {

    private GetDriverData data_driver;
    private Driver driver;

    public DriverController() {
        data_driver = new GetDriverData();
    }

    public Driver[] getAllDriverfromYear(int year) {

        return data_driver.getAllDriverfromYear(year);
    }

    public Driver[] getAllDriverfromYearandRound(short year, byte round) {

        return data_driver.getAllDriverfromYearandRound(year, round);
    }

    public void SetDriverId(String driverId) {
        this.driver.setDriverId(driverId);
    }
}
