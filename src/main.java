import View.UserInterface;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class main {

    public static void main(String[] args) {
        /*
         * Date date = new Date();// the date instance
         * Calendar calendar = Calendar.getInstance();
         * calendar.setTime(date);
         * //System.out.println(calendar.get(Calendar.YEAR));
         * Scanner input1 = new Scanner(System.in);
         * // the possible year value are between 1950 and 2022
         * short year=0;
         * // possible number_race is around 20
         * byte number_race=0;
         * // possible name_number is around 22
         * byte name_number=0;
         * try {
         * 
         * System.out.println("Write the year of the race: ");
         * year = input1.nextShort();
         * 
         * //s= new Scanner(System.in);
         * //int scelta = s.nextInt();
         * while (year < 1950 || year > calendar.get(Calendar.YEAR))
         * {
         * System.out.println("Il numero selezionato non è nel range 1950 e " +
         * calendar.get(Calendar.YEAR)+"\n"+
         * "inseriscine un altro:");
         * year = input1.nextShort();
         * }
         * 
         * }catch(InputMismatchException e){
         * System.out.println("The input is not a number");
         * System.out.println(e);
         * input1.close();
         * System.exit(1);
         * 
         * }catch(Exception e){
         * System.out.println(e);
         * input1.close();
         * System.exit(1);
         * }
         * 
         * Rounds[] rounds = Rounds.getRoundofYear(year);
         * 
         * try {
         * System.out.println("Write the number of the race you want to check: ");
         * if(rounds.length != 0) {
         * for (int i = 0; i < rounds.length; i++) {
         * System.out.println(i + 1 + ". " + rounds[i].getRaceName());
         * }
         * }
         * number_race = input1.nextByte();
         * }catch(InputMismatchException e){
         * System.out.println("The input is not a number");
         * System.out.println(e);
         * input1.close();
         * System.exit(1);
         * }catch(Exception e){
         * System.out.println(e);
         * input1.close();
         * System.exit(1);
         * }
         * Drivers[] drivers = Drivers.getAllDriverfromYearandRound(year, number_race);
         * try {
         * if(drivers.length != 0) {
         * for (int i = 0; i < drivers.length; i++) {
         * System.out.println(i + 1 + ". " + drivers[i].getDriverId());
         * }
         * }
         * else{
         * input1.close();
         * throw new NullPointerException();
         * }
         * }catch(Exception e){
         * System.out.println(e);
         * input1.close();
         * System.exit(1);
         * }
         * /*Drivers[] drivers = Drivers.getAllDriverfromYearandRound(year,
         * number_race);
         * if(drivers.length != 0) {
         * for (int i = 0; i < drivers.length; i++) {
         * System.out.println(i + 1 + ". " + drivers[i].getDriverId());
         * }
         * }
         * else{
         * throw new NullPointerException();
         * }
         * 
         * try {
         * System.out.println("Select the number of the driver you want to search: ");
         * 
         * name_number = input1.nextByte();
         * }catch(InputMismatchException e){
         * System.out.println("The input is not a number");
         * System.out.println(e);
         * input1.close();
         * System.exit(1);
         * }catch(Exception e){
         * System.out.println(e);
         * input1.close();
         * System.exit(1);
         * }
         * 
         * 
         * input1.close();
         */
        UserInterface menu = new UserInterface();
        menu.start();

        /*
         * System.out.println("Write the year of the race: ");
         * int year = input1.nextInt();
         * System.out.println("Write the number of the race you want to check: ");
         * int number_race = input1.nextInt();
         */
        /*
         * Drivers[] drivers = Drivers.getAllDriverfromYearandRound(year,number_race);
         * for (int i = 0; i <drivers.length; i++) {
         * System.out.println(i+1 +". "+drivers[i].getDriverId());
         * }
         * 
         * System.out.println("Select the number of the driver you want to search: ");
         * 
         * int name_number = input1.nextInt();
         */

        // String json_data =
        // data.getJsondata("http://ergast.com/api/f1/2020/12/drivers/hamilton/laps.json?limit=100");

        // System.exit(0);
        /*
         * Drivers[] ffff = Drivers.getAllDriverfromYearandRound(2022,1);
         * Drivers[] eee = Drivers.getAllDriverfromYear(2022);
         * System.out.println(ffff.length);
         * for (int i = 0; i < ffff.length; i++) {
         * System.out.println(ffff[i].getDriverId());
         * 
         * }
         */
        /*
         * Laps laps = new Laps();
         * double[] lap_time_race =
         * laps.getLapsTime(year,number_race,drivers[name_number-1].getDriverId());
         * byte total_lap_race = laps.getTotalLaps(year,number_race);
         * // double[] www = laps.getLapsTime(1998,4,"hakkinen");
         * byte lap_driven = laps.getLapsDriven();
         * 
         * //for(int i=0; i<iii.length;i++){
         * // System.out.println(iii[i]) ;
         * //}
         * 
         * Chart d = new Chart();
         * d.createChart(lap_time_race,lap_driven,total_lap_race);
         */

        // Create Chart
        // XYChart chart = QuickChart.getChart("Time Table", "Laps", "Time", "laps",
        // xData2, xxx);

        // chart.getStyler().setyAxisTickLabelsFormattingFunction(funny); //put label on
        // tick axis
        // chart.getStyler().setYAxisMax(120000.0); //set max Y value
        // chart.getStyler().setYAxisMin(0000.0); //set min Y value

        System.gc();
        Runtime rt = Runtime.getRuntime();
        long usedMemory = (rt.totalMemory() - rt.freeMemory());
        System.out.println("The program toke " + usedMemory + " bytes of memory");
        // Show it
        // new SwingWrapper(chart).displayChart();
        /*
         * JFrame frame = new JFrame("F1 Chart Visualizer");
         * frame.setSize(420, 420);
         * frame.setLocation(300, 300);
         * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         * frame.setVisible(true);
         */
        // UrlGenerator prova = new UrlGenerator();
        // System.out.println(prova.getYearConstructor(2022));
        // g.getLapsTime(driver);
        // g.getQualifyingData(g.getJsondata("http://ergast.com/api/f1/2008/drivers.json"));

    }

}
