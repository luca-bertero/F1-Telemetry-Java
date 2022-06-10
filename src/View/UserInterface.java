package View;

import Controller.DriverController;
import Controller.LapController;
import Controller.MainController;
import Controller.RoundController;
import Model.Driver;
import Model.Round;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private DriverController drivers;
    private RoundController roundsController;
    private MainController mainController;
    public UserInterface(){
        drivers = new DriverController();
        roundsController = new RoundController();
        mainController = new MainController();
    }

    public void start(){
        Date date = new Date();// the date instance
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //System.out.println(calendar.get(Calendar.YEAR));
        Scanner input1 = new Scanner(System.in);
        // the possible year value are between 1950 and 2022
        short year=0;
        // possible number_race is around 20
        byte number_race=0;
        // possible name_number is around 22
        byte name_number=0;
        try {

            System.out.println("Write the year of the race: ");
            year = input1.nextShort();

            //s= new Scanner(System.in);
            //int scelta = s.nextInt();
            while (year < 1950 || year > calendar.get(Calendar.YEAR))
            {
                System.out.println("Il numero selezionato non è nel range 1950 e "  + calendar.get(Calendar.YEAR)+"\n"+
                        "inseriscine un altro:");
                year = input1.nextShort();
            }

        }catch(InputMismatchException e){
            System.out.println("The input is not a number");
            System.out.println(e);
            input1.close();
            System.exit(1);

        }catch(Exception e){
            System.out.println(e);
            input1.close();
            System.exit(1);
        }

        Round[] rounds_list = roundsController.getRoundsofYear(year);
        roundsController.setRoundYear(year);

        try {
            System.out.println("Write the number of the race you want to check: ");
            if(rounds_list.length != 0) {
                for (int i = 0; i < rounds_list.length; i++) {
                    System.out.println(i + 1 + ". " + rounds_list[i].getRaceName());
                }
            }
            number_race = input1.nextByte();
        }catch(InputMismatchException e){
            System.out.println("The input is not a number");
            System.out.println(e);
            input1.close();
            System.exit(1);
        }catch(Exception e){
            System.out.println(e);
            input1.close();
            System.exit(1);
        }

        mainController.setRaceNumber(number_race);
        Driver[] drivers_list = drivers.getAllDriverfromYearandRound(year, number_race);
        try {
            if(drivers_list.length != 0) {
                for (int i = 0; i < drivers_list.length; i++) {
                    System.out.println(i + 1 + ". " + drivers_list[i].getDriverId());
                }
            }
            else{
                input1.close();
                //throw if the array is empty
                throw new NullPointerException();
            }
        }catch(Exception e){
            System.out.println(e);
            input1.close();
            System.exit(1);
        }
        /*Drivers[] drivers = Drivers.getAllDriverfromYearandRound(year, number_race);
        if(drivers.length != 0) {
            for (int i = 0; i < drivers.length; i++) {
                System.out.println(i + 1 + ". " + drivers[i].getDriverId());
            }
        }
        else{
            throw new NullPointerException();
        }*/

        try {
            System.out.println("Select the number of the driver you want to search: ");

            name_number = input1.nextByte();
        }catch(InputMismatchException e){
            System.out.println("The input is not a number");
            System.out.println(e);
            input1.close();
            System.exit(1);
        }catch(Exception e){
            System.out.println(e);
            input1.close();
            System.exit(1);
        }

        mainController.setDriver(drivers_list[name_number-1].getDriverId());
        input1.close();
        

        double start = System.currentTimeMillis();

        LapController laps = new LapController();
        double[] lap_time_race = laps.getLapsTime(year,number_race,drivers_list[name_number-1].getDriverId());
        byte total_lap_race = laps.getTotalLaps(year,number_race);
        byte lap_driven = laps.getLapsDriven();

       
        Chart d = new Chart();
        d.createChart(lap_time_race,lap_driven,total_lap_race);

        double end = System.currentTimeMillis();
        double duration_time = end - start;
        System.out.println("The program need " + duration_time + " milliseconds to run");
    }


    public boolean CheckInputInt(){

        Scanner s = new Scanner(System.in);
        s.hasNextInt();
        int input = s.nextInt();
        if(s.hasNextInt()){

        }
        return true;
    }
}
