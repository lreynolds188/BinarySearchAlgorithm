import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tests extends BinarySearch{

    /**
     * Test 1: Checks that the correct index is returned
     */
    @Test
    public void FunctionalityTestValue1(){
        int value = BinarySearchValue(new int[]{1, 2, 3, 4, 5}, 5);
        assertEquals(value, 4);
    }

    @Test
    public void FunctionalityTestValue2(){
        int value = BinarySearchValue(new int[]{2, 4, 6, 8, 10}, 6);
        assertEquals(value, 2);
    }

    @Test
    public void FunctionalityTestValue3(){
        int value = BinarySearchValue(new int[]{1, 5, 10, 11, 13, 16, 19, 25, 100, 234}, 5);
        assertEquals(value, -1);
    }

    /**
     * Test 4: Checks that the correct number of operations were performed
     */
    @Test
    public void FunctionalityTestOperations1(){
        int value = BinarySearchBasicOperations(new int[]{1, 2, 3, 4, 5}, 5);
        assertEquals(value, 2);
    }

    @Test
    public void FunctionalityTestOperations2(){
        int value = BinarySearchBasicOperations(new int[]{2, 4, 6, 8, 10}, 6);
        assertEquals(value, 1);
    }

    @Test
    public void FunctionalityTestOperations3(){
        int value = BinarySearchBasicOperations(new int[]{1, 5, 10, 11, 13, 16, 19, 25, 100, 234}, 5);
        assertEquals(value, 3);
    }



}
