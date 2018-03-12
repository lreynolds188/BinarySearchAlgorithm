import org.jfree.ui.RefineryUtilities;

import java.util.Random;

public class Main extends Search{

    static int[] arr;
    static Random rand = new Random();
    static long startTimeNano, endTimeNano, totalTimeNano;
    static long startTime, endTime, totalTime;

    public static void main(String[] args){
        ArraySearchTest();
        PlotGraph();
    }

    public static void ArraySearchTest(){
        for (int size = 1000; size <= 20000; size += 1000){
            long[] timeArr = new long[20];
            long[] timeArrNano = new long[20];
            for (int i = 0; i < 20; i++) {
                arr = CreateArray(size);
                arr = SortArray(arr);
                System.out.print("Array search size: " + size);

                int key = rand.nextInt(size);
                startTime = System.currentTimeMillis();
                startTimeNano = System.nanoTime();
                int searchRes = BinarySearch(arr, key);
                endTime = System.currentTimeMillis();
                endTimeNano = System.nanoTime();

                System.out.print("\tSearched for " + key + "... ");
                if (searchRes != -1) {
                    System.out.print("Found match at index " + searchRes + "\n");
                } else {
                    System.out.print("Did not find a match.\n");
                }
                timeArrNano[i] = endTimeNano - startTimeNano;
                timeArr[i] = endTime - startTime;

            }
            for (int i = 0; i < timeArr.length; i++){
                totalTime += timeArr[i];
                totalTimeNano += timeArrNano[i];
            }
            System.out.print("Average test time was: " + (totalTime / 20) + "ms / " + (totalTimeNano / 20) + "ns\n");
        }
    }

    public static void PlotGraph(){
        Plot chart = new Plot(
                "School Vs Years" ,
                "Numer of Schools vs years");

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}
