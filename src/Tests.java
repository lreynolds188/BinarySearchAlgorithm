import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tests extends BinarySearch{

    @Test
    public void FunctionalityTest1(){
        int value = BinarySearchValue(new int[]{1, 2, 3, 4, 5}, 5);
        assertEquals(value, 4);
    }

    @Test
    public void FunctionalityTest2(){
        int value = BinarySearchValue(new int[]{2, 4, 6, 8, 10}, 6);
        assertEquals(value, 2);
    }

    @Test
    public void FunctionalityTest3(){
        int value = BinarySearchValue(new int[]{1, 5, 10, 11, 13, 16, 19, 25, 100, 234}, 5);
        assertEquals(value, -1);
    }

}
