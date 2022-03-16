import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.ArrayList;
import java.util.function.Function;

public class Chart {

    public void createChart(double[] xdata, double[] ydata,int n_elements,int total_lap) {

        double[] x_data = new double[n_elements];
        for (int i = 0; i < n_elements; i++){
            x_data[i]=i+1;
        }
        System.out.println(x_data.length);
        double[] y_data = setYData(ydata,100000,n_elements,total_lap);
        System.out.println(y_data.length);

        // Create Chart
        XYChart chart = QuickChart.getChart("Time Table", "Laps", "Time", "laps", x_data, y_data);

        chart.getStyler().setyAxisTickLabelsFormattingFunction(YaxisTicks2()); //put label on tick axis
        chart.getStyler().setYAxisMax(200000.0); //set max Y value
        chart.getStyler().setYAxisMin(-120000.0); //set min Y value


        // Show it
        new SwingWrapper(chart).displayChart();
    }

    private Function<Double,String> YaxisTicks2(){
        Function<Double,String> funny = (b) -> {

            if (b > 129999) {

                return "2:" + Math.round((b / 1000) - 120) + ".000";

            } else if (b > 119999) {

                return "2:0" + Math.round((b / 1000) - 120) + ".000";

            } else if (b > 69999) {

                return "1:" + Math.round((b / 1000) - 60) + ".000";

            } else if (b > 59999) {

                return "1:0" + Math.round((b / 1000) - 60) + ".000";

            } else if (b > 9999) {

                return "0:" + Math.round(b / 1000) + ".000";

            } else if (0 > b && b > -9999) {

                return "-0:0" + Math.round(Math.abs(b / 1000)) + ".000";

            } else if (-9999 > b && b > -59999) {

                return "-0:" + Math.round(Math.abs(b / 1000)) + ".000";

            } else if (-59999 > b && b > -69999) {

                return "-1:0" + Math.round(Math.abs(b / 1000) + 60) + ".000";

            } else if (-69999 > b) {

                return "-1:" + Math.round(Math.abs(b / 1000) + 60) + ".000";
            } else {

                return "0:0" + Math.round(Math.abs(b / 1000)) + ".000";
            }
        };
        return funny;
    }

    public double[] setYData(double[] lapTimes,int set_time,int laps_number,int total_laps){
        //int set_time = 83333;
        int n_element = 66;
        int total_element = 66;
        ArrayList<Double> Unit = new ArrayList<Double>();
        ArrayList<Double> Diff = new ArrayList<Double>();
        Unit.add(0.0);


        for (int i = 0; i < laps_number; i++){
            double dif = set_time - lapTimes[i];
            System.out.println("set_time: " + set_time +" lap: "+lapTimes[i]);
            System.out.println(dif);
            Diff.add(dif);
        }

        for (int i =0; i < laps_number-1; i++){
            Unit.add(Unit.get(i) + Diff.get(i+1));
        }

        double difference = 0.0;
        difference = total_laps - laps_number;
        if(difference > 0){
            for (int i = 0; i < difference;i++){
                Unit.add(Unit.get(laps_number-1));
            }
        }
        double[] xxx = new double[Unit.size()];

        for (int i = 0; i < Unit.size(); i++){
            System.out.println(Unit.get(i));
            xxx[i] = Unit.get(i);
        }

        return xxx;
    }
}
