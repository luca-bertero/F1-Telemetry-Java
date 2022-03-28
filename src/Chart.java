import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.ArrayList;
import java.util.function.Function;

public class Chart {

    public static int average_lap;
    public double max_y=0.0;
    public double max_x=0.0;

    public Chart(int average_lap){
        this.average_lap=average_lap;
    }

    public void createChart(double[] xdata, double[] ydata,int n_elements,int total_lap) {

        double[] x_data = new double[n_elements];
        for (int i = 0; i < n_elements; i++){
            x_data[i]=i+1;
        }
        System.out.println(x_data.length);
        double[] y_data = setYData(ydata,average_lap,n_elements,total_lap);
        System.out.println(y_data.length);

        // Create Chart
        XYChart chart = QuickChart.getChart("Time Table", "Laps", "Time", "laps", x_data, y_data);

        chart.getStyler().setyAxisTickLabelsFormattingFunction(YaxisTicks()); //put label on tick axis
        chart.getStyler().setYAxisMax(120000.0); //set max Y value
        chart.getStyler().setYAxisMin(-100000.0); //set min Y value

        // Show it
        new SwingWrapper(chart).displayChart();
    }

    private Function<Double,String> YaxisTicks(){
        Function<Double,String> funny = (b) -> {

            if(b > 189999){

                return "3:" + Math.round((b / 1000) - 180) + ".000";
            }

            if(b > 179999){

                return "3:0" + Math.round((b / 1000) - 180) + ".000";

            }
            else if (b > 129999) {

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

                return "-1:0" + Math.round(Math.abs(b / 1000 ) - 60) + ".000";

            } else if (-69999 > b && b > -119999) {

                return "-1:" + Math.round(Math.abs(b / 1000) - 60) + ".000";

            } else if (-119999 > b && b > -129999){

                return "-2:0" + Math.round(Math.abs(b / 1000) - 120) + ".000";

            } else if (-129999 > b && b > -179999){

                return "-2:" + Math.round(Math.abs(b / 1000) - 120) + ".000";

            } else if (-179999 > b && b > -189999){

                return "-3:0" + Math.round(Math.abs(b / 1000) - 180) + ".000";

            } else if (b > -189999){

                return "-3:" + Math.round(Math.abs(b / 1000) - 180) + ".000";

            }
            else {

                return "0:0" + Math.round(Math.abs(b / 1000)) + ".000";

            }
        };
        return funny;
    }

    public double[] setYData(double[] lapTimes,int average_lap,int laps_number,int total_laps){

        ArrayList<Double> Unit = new ArrayList<Double>();
        ArrayList<Double> Diff = new ArrayList<Double>();
        Unit.add(0.0);


        for (int i = 0; i < laps_number; i++){
            double dif = average_lap - lapTimes[i];
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
            xxx[i] = Unit.get(i);
        }

        return xxx;
    }
}
