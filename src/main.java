
import org.knowm.xchart.*;
import org.knowm.xchart.style.DialStyler;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.markers.SeriesMarkers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        /*System.out.println("Write the name of the driver you want to search: ");
        Scanner input1 = new Scanner(System.in);
        String name = input1.nextLine();
        System.out.println("Write the year of the race: ");
        int year = input1.nextInt();
        System.out.println(year);
        System.out.println("Write the number of the race you want to check: ");
        int number_race = input1.nextInt();
        System.out.println(number_race);*/

        double start = System.currentTimeMillis();

        GetData g = new GetData("hamilton",2012,3);
        String driver = g.getJsondata();
        //GetData g2 = new GetData("bottas",2020,12);
        //String driver2 = g2.getJsondata("http://ergast.com/api/f1/2020/12/results/1.json");
        double[] lap_time = g.getLapsTime(driver);
        //System.out.println(hhh[0]);
        //int ppp=g.getTotalLaps(driver);
        int record = g.getTotalRecords(driver);
        //int n_results = g2.getTotalLaps(driver2);
        int n_results = record;

        double[] xData2 = new double[record];
        for (int i = 0; i < record; i++){
            xData2[i]=i+1;
        }

        Chart d = new Chart();
         //d.createChart(xData2,lap_time,record,n_results);
         /*double[] yData2 = d.setYData(lap_time,83333);
         for (int i = 0; i < 66;i++){
             System.out.println(yData2[i]);
         }*/
        // Create Chart
        //XYChart chart = QuickChart.getChart("Time Table", "Laps", "Time", "laps", xData2, xxx);

        //chart.getStyler().setyAxisTickLabelsFormattingFunction(funny); //put label on tick axis
        //chart.getStyler().setYAxisMax(120000.0); //set max Y value
        //chart.getStyler().setYAxisMin(0000.0); //set min Y value

        double end = System.currentTimeMillis();
        double dura = end - start;
        System.out.println("The program need " + dura + " milliseconds to run");

        // Show it
        //new SwingWrapper(chart).displayChart();
        /*
        JFrame frame = new JFrame();
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        */
        //UrlGenerator prova = new UrlGenerator();
        //System.out.println(prova.getYearConstructor(2022));
        //g.getLapsTime(driver);
        //g.getQualifyingData(g.getJsondata("http://ergast.com/api/f1/2008/drivers.json"));

    }


}
