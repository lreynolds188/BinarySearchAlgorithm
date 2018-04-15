import java.util.Random;

public class BinarySearch {

    /**
     *  Implements non-recursive binary search of an int array.
     *
     *  @param arr - an array containing values to be searched.
     *  @param key - the value to be searched for.
     *  @return
     */
    public static int BinarySearchValue(int[] arr, int key){
        int lower = 0;
        int middle;
        int upper = arr.length;

        while (lower < upper){
            middle = (lower + upper)/2;
            if (key == arr[middle]){
                return middle;
            } else if (key < arr[middle]){
                upper = middle-1;
            } else {
                lower = middle+1;
            }
        }
        return -1;
    }

    /**
     *  Implements non-recursive binary search of an int array and return the number of basic operation implemented
     *  throughout the process.
     *
     *  @param arr - an array containing values to be searched.
     *  @param key - the value to be searched for.
     *  @return
     */
    public static int BinarySearchBasicOperations(int[] arr, int key){
        int iterations = 0;
        int lower = 0;
        int middle;
        int upper = arr.length;

        while (lower < upper){
            iterations++;
            middle = (lower + upper)/2;
            if (key == arr[middle]){
                return iterations;
            } else if (key < arr[middle]){
                upper = middle-1;
            } else {
                lower = middle+1;
            }
        }
        return iterations;
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

    public static long[] SortArray(long[] arr) {
        long n = arr.length;
        long temp;
        for (long i = 0; i < n; i++){
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
