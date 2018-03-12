import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import java.util.Random;

public class Main extends Search{

    static int[] arr;
    static Random rand = new Random();
    static long startTimeNano, endTimeNano, totalTimeNano;
    static long startTime, endTime, totalTime;
    static DefaultCategoryDataset execTimeDataSet = new DefaultCategoryDataset( );

    public static void main(String[] args){
        ArraySearchTest();
        PlotGraph("Exectuion Time", "Execution Time vs Dataset Size", "Dataset Size", "Execution Time (ns)", execTimeDataSet);
    }

    public static void ArraySearchTest(){
        for (int size = 1000; size <= 20000; size += 1000){
            long[] timeArr = new long[20];
            long[] timeArrNano = new long[20];
            for (int i = 0; i < 20; i++) {
                arr = CreateArray(size);
                arr = SortArray(arr);
                int key = rand.nextInt(size);
                startTime = System.currentTimeMillis();
                startTimeNano = System.nanoTime();
                BinarySearch(arr, key);
                endTime = System.currentTimeMillis();
                endTimeNano = System.nanoTime();
                timeArrNano[i] = endTimeNano - startTimeNano;
                timeArr[i] = endTime - startTime;
            }
            for (int i = 0; i < timeArr.length; i++){
                totalTime += timeArr[i];
                totalTimeNano += timeArrNano[i];
            }
            execTimeDataSet.addValue((totalTimeNano / 20), "Search Algorithm", Integer.toString(size));
        }
    }

    public static void PlotGraph(String appTitle, String title, String xAxisLabel, String yAxisLabel, DefaultCategoryDataset dataSet){
        Plot chart = new Plot(appTitle, title, xAxisLabel, yAxisLabel, dataSet);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}
