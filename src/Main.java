import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import java.util.Random;

public class Main extends Search{

    static int[] arr;
    static Random rand = new Random();
    static long startTimeNano, endTimeNano, totalTimeNano;
    static int totalOperations;
    static DefaultCategoryDataset execTimeDataSet = new DefaultCategoryDataset( );
    static DefaultCategoryDataset operationsDataSet = new DefaultCategoryDataset( );


    public static void main(String[] args){
        ArraySearchTest();
        PlotGraph("Exectuion Time", "Execution Time vs Dataset Size", "Dataset Size", "Execution Time (ns)", execTimeDataSet);
        PlotGraph("Basic Operations", "Basic Operations vs Dataset Size", "Dataset Size", "Number of Basic Operations", operationsDataSet);
    }

    /**
     *  The bulk of the code is called here to run the array creation, search function, dataset building, execution timing, and operation count.
     */
    public static void ArraySearchTest(){
        for (int size = 1000; size <= 20000; size += 1000){
            long[] timeArrNano = new long[20];
            int[] operationArr = new int[20];
            totalTimeNano = 0;
            totalOperations = 0;
            for (int i = 0; i < 20; i++) {
                arr = CreateArray(size);
                int key = rand.nextInt(size);
                startTimeNano = System.nanoTime();
                operationArr[i] = BinarySearch(arr, key, true);
                endTimeNano = System.nanoTime();
                timeArrNano[i] = endTimeNano - startTimeNano;
                System.out.println(size + "\t" + operationArr[i] + "\t" + timeArrNano[i]);
            }
            for (int i = 0; i < timeArrNano.length; i++){
                totalTimeNano += timeArrNano[i];
                totalOperations += operationArr[i];
            }
            operationsDataSet.addValue((totalOperations / 20), "Search Algorithm Average", Integer.toString(size));
            execTimeDataSet.addValue((totalTimeNano / 20), "Search Algorithm Average", Integer.toString(size));
        }
    }

    /**
     * Creates a new plot class and sends it the required variables to plot the graph.
     *
     * @param appTitle
     * @param title
     * @param xAxisLabel
     * @param yAxisLabel
     * @param dataSet
     */
    public static void PlotGraph(String appTitle, String title, String xAxisLabel, String yAxisLabel, DefaultCategoryDataset dataSet){
        Plot chart = new Plot(appTitle, title, xAxisLabel, yAxisLabel, dataSet);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}
