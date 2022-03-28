import java.lang.management.MemoryUsage;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        /*System.out.println("Write the name of the driver you want to search: ");
        Scanner input1 = new Scanner(System.in);
        String name = input1.nextLine();
        System.out.println("Write the year of the race: ");
        int year = input1.nextInt();
        System.out.println("Write the number of the race you want to check: ");
        int number_race = input1.nextInt();
        System.out.println("Set an average lap time: (time format in millisecond. Ex: 80000 for 1:20.000)");
        int average_lap_time = input1.nextInt();*/

        double start = System.currentTimeMillis();
        GetData data = GetData.get();
        String json_data = data.getJsondata("http://ergast.com/api/f1/2020/12/drivers/hamilton/laps.json?limit=100");

        //System.exit(0);
        /*Drivers[] ffff = Drivers.getAllDriverfromYearandRound(2022,1);
        Drivers[] eee = Drivers.getAllDriverfromYear(2022);
        System.out.println(ffff.length);
        for (int i = 0; i < ffff.length; i++) {
            System.out.println(ffff[i].getDriverId());

        }*/
        Laps laps = new Laps();
        double[] iii = laps.getLapsTime(2022,1,"leclerc");
        for(int i=0; i<iii.length;i++){
            System.out.println(iii[i]) ;
        }
        //GetData g2 = new GetData("bottas",2020,12);
        //String driver2 = g2.getJsondata("http://ergast.com/api/f1/2020/12/results/1.json");
        double[] lap_time = data.getLapsTime(json_data);
        //System.out.println(hhh[0]);
        //int ppp=g.getTotalLaps(driver);
        int record = data.getTotalRecords(json_data);
        //int n_results = g2.getTotalLaps(driver2);
        int n_results = record;

        double[] xData = new double[record];
        for (int i = 0; i < record; i++){
            xData[i]=i+1;
        }

        //Chart d = new Chart(105000);
        //d.createChart(xData,lap_time,record,n_results);


         /*
         double[] yData2 = d.setYData(lap_time,83333);
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
        System.gc();
        Runtime rt = Runtime.getRuntime();
        long usedMemory = (rt.totalMemory() - rt.freeMemory());
        System.out.println("The program toke " + usedMemory + " bytes of memory");
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
