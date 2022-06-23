package View;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import Model.Lap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Chart {

    public static int average_lap;
    public double max_y;
    public double max_x;
    private String[] seriesName;

    public Chart() {
        max_y = 0.0;
        max_x = 0.0;
    }

    public void createChart(double[] ydata, int laps_drived, int total_lap, double average_lap) {

        double med_lap;
        double[] x_data = new double[total_lap];
        for (int i = 0; i < total_lap; i++) {
            x_data[i] = i + 1;

        }
        // System.out.println(n_elements);
        // System.out.println(total_lap);
        if (average_lap != 0) {
            // in milliseconds
            med_lap = average_lap;

        } else {
            med_lap = average_lap_time(ydata);

        }

        int med_lap_int = (int) med_lap;

        double[] y_data = setYData(ydata, med_lap_int, laps_drived, total_lap);
        // System.out.println("ccc "+y_data.length);
        // System.out.println("ccc2 "+x_data.length);
        double max_y_value_double = maxYValue(y_data);
        double min_y_value_double = minYValue(y_data);
        double max_y_value_formatted = Math.round(max_y_value_double / 1000) * 1000;
        double min_y_value_formatted = Math.round(min_y_value_double / 1000) * 1000;

        // Create Chart
        XYChart chart = QuickChart.getChart("Time Table", "Laps", "Time", "laps", x_data, y_data);

        chart.getStyler().setyAxisTickLabelsFormattingFunction(YaxisTicks()); // put label on tick axis
        chart.getStyler().setYAxisMax(max_y_value_formatted); // set max Y value
        chart.getStyler().setYAxisMin(min_y_value_formatted); // set min Y value

        // Show it
        new SwingWrapper<XYChart>(chart).displayChart();
    }

    public void createChart(double[] ydata, int laps_drived, int total_lap) {
        createChart(ydata, laps_drived, total_lap, 0.0);
    }

    public void createChart(Lap laps) {
        createChart(laps, 0.0);

    }

    public void createChart(Lap laps, double average_lap) {
        createChart(laps.getLapTimeRace(), laps.getLapDriven(), laps.getTotalLapNumber(), average_lap);

    }

    public void MultipleChart(List<double[]> ydata, List<Integer> elem, int n_elements, int total_lap) {

        seriesName = new String[ydata.size()];
        for (int i = 0; i < ydata.size(); i++) {
            seriesName[i] = i + 1 + "° driver";
        }

        double[] x_data = new double[total_lap];
        for (int i = 0; i < total_lap; i++) {
            x_data[i] = i + 1;

        }
        // System.out.println(n_elements);
        // System.out.println(total_lap);
        List<double[]> y_formatted = new ArrayList<double[]>();
        double med_lap = average_lap_time(ydata.get(0));
        int med_lap_int = (int) med_lap;

        for (int i = 0; i < ydata.size(); i++) {
            System.out.println(ydata.get(i).length);
            y_formatted.add(setYData(ydata.get(i), med_lap_int, ydata.get(i).length, total_lap));
        }

        // double[] y_data_chart = setYData(ydata,med_lap_int,n_elements,total_lap);
        // System.out.println("ccc "+y_data.length);
        // System.out.println("ccc2 "+x_data.length);
        double y_max = 0;
        double y_min = 0;
        for (int i = 0; i < y_formatted.size(); i++) {
            if (y_max < maxYValue(y_formatted.get(i))) {
                y_max = maxYValue(y_formatted.get(i));

            }

            if (y_min > minYValue(y_formatted.get(i))) {
                y_min = minYValue(y_formatted.get(i));
            }
        }
        double max_y_value_double = y_max;
        double min_y_value_double = y_min;

        double max_y_value_formatted = Math.round(max_y_value_double / 1000) * 1000;
        double min_y_value_formatted = Math.round(min_y_value_double / 1000) * 1000;

        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(getClass().getSimpleName()).xAxisTitle("Laps")
                .yAxisTitle("Time").build();

        chart.getStyler().setyAxisTickLabelsFormattingFunction(YaxisTicks()); // put label on tick axis
        chart.getStyler().setYAxisMax(max_y_value_formatted); // set max Y value
        chart.getStyler().setYAxisMin(min_y_value_formatted); // set min Y value

        for (int i = 0; i < y_formatted.size(); i++) {
            chart.addSeries(seriesName[i], x_data, y_formatted.get(i));

        }
        // Show it
        new SwingWrapper<XYChart>(chart).displayChart();
    }

    private Function<Double, String> YaxisTicks() {
        Function<Double, String> funny = (b) -> {

            if (b > 189999) {

                return "-3:" + Math.round((b / 1000) - 180) + ".000";
            }

            if (b > 179999) {

                return "-3:0" + Math.round((b / 1000) - 180) + ".000";

            } else if (b > 129999) {

                return "-2:" + Math.round((b / 1000) - 120) + ".000";

            } else if (b > 119999) {

                return "-2:0" + Math.round((b / 1000) - 120) + ".000";

            } else if (b > 69999) {

                return "-1:" + Math.round((b / 1000) - 60) + ".000";

            } else if (b > 59999) {

                return "-1:0" + Math.round((b / 1000) - 60) + ".000";

            } else if (b > 9999) {

                return "-0:" + Math.round(b / 1000) + ".000";

            } else if (0 > b && b > -9999) {

                return "+0:0" + Math.round(Math.abs(b / 1000)) + ".000";

            } else if (-9999 > b && b > -59999) {

                return "+0:" + Math.round(Math.abs(b / 1000)) + ".000";

            } else if (-59999 > b && b > -69999) {

                return "+1:0" + Math.round(Math.abs(b / 1000) - 60) + ".000";

            } else if (-69999 > b && b > -119999) {

                return "+1:" + Math.round(Math.abs(b / 1000) - 60) + ".000";

            } else if (-119999 > b && b > -129999) {

                return "+2:0" + Math.round(Math.abs(b / 1000) - 120) + ".000";

            } else if (-129999 > b && b > -179999) {

                return "+2:" + Math.round(Math.abs(b / 1000) - 120) + ".000";

            } else if (-179999 > b && b > -189999) {

                return "+3:0" + Math.round(Math.abs(b / 1000) - 180) + ".000";

            } else if (b > -189999 && b < -239999) {

                return "+3:" + Math.round(Math.abs(b / 1000) - 180) + ".000";

            } else {

                return "0:0" + Math.round(Math.abs(b / 1000)) + ".000";

            }
        };
        return funny;
    }

    public double[] setYData(double[] lapTimes, int average_lap, int laps_number, int total_laps) {

        ArrayList<Double> Unit = new ArrayList<Double>();
        ArrayList<Double> Diff = new ArrayList<Double>();
        Unit.add(0.0);

        for (int i = 0; i < total_laps; i++) {
            double dif = average_lap - lapTimes[i];
            Diff.add(dif);
        }

        for (int i = 0; i < total_laps - 1; i++) {
            Unit.add(Unit.get(i) + Diff.get(i + 1));
        }

        // CAN'T DO THIS COMMENT BECAUSE ON MULTIPLE DRIVER CHAR X AND Y IS NOT THE SAME
        double difference = 0.0;
        difference = total_laps - laps_number;
        // System.out.println("er " + difference);
        if (difference > 0) {
            for (int i = 0; i < difference; i++) {
                Unit.add(Unit.get(laps_number - 1));
            }
        }

        double[] y_data = new double[Unit.size()];

        for (int i = 0; i < Unit.size(); i++) {
            y_data[i] = Unit.get(i);

        }

        return y_data;
    }

    private double maxYValue(double[] lap_array) {
        double max = -999999.0;
        for (int i = 0; i < lap_array.length; i++) {
            if (lap_array[i] > max) {
                max = lap_array[i];
            }
        }
        return max;
    }

    private double minYValue(double[] lap_array) {
        double min = 999999.0;
        for (int i = 0; i < lap_array.length; i++) {
            if (lap_array[i] < min) {
                min = lap_array[i];
            }
        }
        return min;
    }

    private double average_lap_time(double[] lap_array) {
        double medium = 0;

        for (int i = 0; i < lap_array.length; i++) {
            medium = medium + lap_array[i];
        }
        // System.out.println(medium/lap_array.length);
        return medium / lap_array.length;
    }
}
