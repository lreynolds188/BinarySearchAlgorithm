import java.util.Random;

public class Search {

    /**
     *  Implements non-recursive binary search of an int array.
     *
     *  @param arr - an array containing values to be searched.
     *  @param key - the value to be searched for.
     *  @return
     */
    public static int BinarySearch(int[] arr, int key, boolean testIterations){
        int iterations = 0;
        int index = 0;
        int curIndex;
        int range = arr.length;

        while (index < range){
            iterations++;
            curIndex = (index + range)/2;
            if (key == arr[curIndex]){
                if (testIterations) {
                    return iterations;
                }
                return curIndex;
            } else if (key < arr[curIndex]){
                range = curIndex-1;
            } else {
                index = curIndex+1;
            }
        }
        if (testIterations) {
            return iterations;
        }
        return -1;
    }

    /**
     * Creates an int array of the designated size.
     *
     * @param size
     * @return
     */
    public static int[] CreateArray(int size){
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            arr[i] = rand.nextInt(size);
        }
        return SortArray(arr);
    }

    /**
     * Implements sorting algorithm to designated int array.
     *
     * @param arr - array containing values to be sorted.
     * @return
     */
    public static int[] SortArray(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++){
            for(int j = 1; j < (n-i); j++){
                if(arr[j - 1] > arr[j]){
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}
