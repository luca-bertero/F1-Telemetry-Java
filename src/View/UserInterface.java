package View;

import Controller.DriverController;
import Controller.LapController;
import Controller.MainController;
import Controller.RoundController;
import Model.Driver;
import Model.Lap;
import Model.Round;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private DriverController drivers;
    private RoundController roundsController;
    private MainController mainController;

    public UserInterface() {
        drivers = new DriverController();
        roundsController = new RoundController();
        mainController = new MainController();
    }

    public void start() {
        Date date = new Date();// the date instance
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // System.out.println(calendar.get(Calendar.YEAR));
        Scanner input1 = new Scanner(System.in);
        // the possible year value are between 1950 and 2022
        short year = 0;
        // possible number_race is around 20
        byte number_race = 0;
        // possible name_number is around 22
        byte name_number = 0;
        try {

            System.out.println("Write the year of the race: ");
            year = input1.nextShort();

            // s= new Scanner(System.in);
            // int scelta = s.nextInt();
            while (year < 1950 || year > calendar.get(Calendar.YEAR)) {
                System.out
                        .println("Il numero selezionato non è nel range 1950 e " + calendar.get(Calendar.YEAR) + "\n" +
                                "inseriscine un altro:");
                year = input1.nextShort();
            }

        } catch (InputMismatchException e) {
            System.out.println("The input is not a number");
            System.out.println(e);
            input1.close();
            System.exit(1);

        } catch (Exception e) {
            System.out.println(e);
            input1.close();
            System.exit(1);
        }

        Round[] rounds_list = roundsController.getRoundsofYear(year);
        roundsController.setRoundYear(year);

        try {
            System.out.println("Write the number of the race you want to check: ");
            if (rounds_list.length != 0) {
                for (int i = 0; i < rounds_list.length; i++) {
                    System.out.println(i + 1 + ". " + rounds_list[i].getRaceName());
                }
            }
            number_race = input1.nextByte();
        } catch (InputMismatchException e) {
            System.out.println("The input is not a number");
            System.out.println(e);
            input1.close();
            System.exit(1);
        } catch (Exception e) {
            System.out.println(e);
            input1.close();
            System.exit(1);
        }

        mainController.setRaceNumber(number_race);
        Driver[] drivers_list = drivers.getAllDriverfromYearandRound(year, number_race);
        try {
            if (drivers_list.length != 0) {
                for (int i = 0; i < drivers_list.length; i++) {
                    System.out.println(i + 1 + ". " + drivers_list[i].getDriverId());
                }
            } else {
                input1.close();
                // throw if the array is empty
                throw new NullPointerException();
            }
        } catch (Exception e) {
            System.out.println(e);
            input1.close();
            System.exit(1);
        }
        /*
         * Drivers[] drivers = Drivers.getAllDriverfromYearandRound(year, number_race);
         * if(drivers.length != 0) {
         * for (int i = 0; i < drivers.length; i++) {
         * System.out.println(i + 1 + ". " + drivers[i].getDriverId());
         * }
         * }
         * else{
         * throw new NullPointerException();
         * }
         */

        try {
            System.out.println("Select the number of the driver you want to search: ");

            name_number = input1.nextByte();
        } catch (InputMismatchException e) {
            System.out.println("The input is not a number");
            System.out.println(e);
            input1.close();
            System.exit(1);
        } catch (Exception e) {
            System.out.println(e);
            input1.close();
            System.exit(1);
        }

        mainController.setDriver(drivers_list[name_number - 1].getDriverId());
        input1.close();

        double start = System.currentTimeMillis();

        LapController laps = new LapController();
        LapController laps1 = new LapController();
        LapController laps2 = new LapController();
        LapController laps3 = new LapController();
        LapController laps4 = new LapController();
        LapController laps5 = new LapController();
        LapController laps6 = new LapController();
        LapController laps7 = new LapController();
        LapController laps8 = new LapController();
        LapController laps9 = new LapController();
        LapController laps10 = new LapController();

        double[] lap_time_race = laps.getLapsTime(year, number_race, drivers_list[name_number - 1].getDriverId());
        double[] lap_time_race2 = laps1.getLapsTime(year, number_race, drivers_list[name_number].getDriverId());
        double[] lap_time_race3 = laps2.getLapsTime(year, number_race, drivers_list[name_number + 1].getDriverId());
        double[] lap_time_race4 = laps3.getLapsTime(year, number_race, drivers_list[name_number + 2].getDriverId());
        double[] lap_time_race5 = laps4.getLapsTime(year, number_race, drivers_list[name_number + 3].getDriverId());
        double[] lap_time_race6 = laps5.getLapsTime(year, number_race, drivers_list[name_number + 4].getDriverId());
        double[] lap_time_race7 = laps6.getLapsTime(year, number_race, drivers_list[name_number + 5].getDriverId());
        double[] lap_time_race8 = laps7.getLapsTime(year, number_race, drivers_list[name_number + 6].getDriverId());
        double[] lap_time_race9 = laps8.getLapsTime(year, number_race, drivers_list[name_number + 7].getDriverId());
        double[] lap_time_race10 = laps9.getLapsTime(year, number_race, drivers_list[name_number + 8].getDriverId());
        double[] lap_time_race11 = laps10.getLapsTime(year, number_race, drivers_list[name_number + 9].getDriverId());

        byte total_lap_race = laps.getTotalLaps(year, number_race);

        byte lap_driven = laps.getLapsDriven();
        byte lap_driven1 = laps1.getLapsDriven();
        byte lap_driven2 = laps2.getLapsDriven();
        byte lap_driven3 = laps3.getLapsDriven();
        byte lap_driven4 = laps4.getLapsDriven();
        byte lap_driven5 = laps5.getLapsDriven();
        byte lap_driven6 = laps6.getLapsDriven();
        byte lap_driven7 = laps7.getLapsDriven();
        byte lap_driven8 = laps8.getLapsDriven();
        byte lap_driven9 = laps9.getLapsDriven();
        byte lap_driven10 = laps10.getLapsDriven();

        List<Integer> dd = new ArrayList<Integer>();

        dd.add((int) lap_driven);
        dd.add((int) lap_driven1);
        dd.add((int) lap_driven2);
        dd.add((int) lap_driven3);
        dd.add((int) lap_driven4);
        dd.add((int) lap_driven5);
        dd.add((int) lap_driven6);
        dd.add((int) lap_driven7);
        dd.add((int) lap_driven8);
        dd.add((int) lap_driven9);
        dd.add((int) lap_driven10);

        Lap lll = new Lap(lap_driven, total_lap_race, lap_time_race);
        Chart d = new Chart();
        // d.createChart(lap_time_race, lap_driven, total_lap_race);
        // d.createChart(lll);
        List<double[]> pp = new ArrayList<double[]>();
        pp.add(lap_time_race);
        pp.add(lap_time_race2);
        pp.add(lap_time_race3);
        pp.add(lap_time_race4);
        pp.add(lap_time_race5);
        pp.add(lap_time_race6);
        pp.add(lap_time_race7);
        pp.add(lap_time_race8);
        pp.add(lap_time_race9);
        pp.add(lap_time_race10);
        pp.add(lap_time_race11);

        d.MultipleChart(pp, dd, 34, total_lap_race);

        double end = System.currentTimeMillis();
        double duration_time = end - start;
        System.out.println("The program need " + duration_time + " milliseconds to run");
    }

    public boolean CheckInputInt() {

        Scanner s = new Scanner(System.in);
        s.hasNextInt();
        int input = s.nextInt();
        if (s.hasNextInt()) {

        }
        s.close();
        return true;
    }
}
