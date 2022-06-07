package Controller;

public class MainController {
    
    private RoundController roundsController;
    private LapController lapsController;
    private DriverController driversController;
    private short year;
    private byte race_number;
    private String driver_list;

    public MainController(){
        this.roundsController = new RoundController();
        this.lapsController = new LapController();
        this.driversController = new DriverController();
    }

    public void setRoundYear(short year_round){
        this.roundsController.setRoundYear(year_round);
    }

    public void setRaceNumber(byte n_round){
        this.roundsController.setRaceNumber(n_round);
    }

    public void setDriver(String driverId){
        this.roundsController.setDriver(driverId);
    }

}
