package algoExpert.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

    private BinarySearch binarySearch;
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

    @Before
    public void setup() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void binarySearchRecursive_firstIndex() {
        Assert.assertEquals(0, binarySearch.binarySearchRecursive(array, 1));
    }

    @Test
    public void binarySearchRecursive_lastIndex() {
        Assert.assertEquals(7, binarySearch.binarySearchRecursive(array, 8));
    }

    @Test
    public void binarySearchRecursive_middle() {
        Assert.assertEquals(3, binarySearch.binarySearchRecursive(array, 4));
    }

    @Test
    public void binarySearchRecursive_notExist() {
        Assert.assertEquals(-1, binarySearch.binarySearchRecursive(array, 20));
    }


    @Test
    public void binarySearchIterative_firstIndex() {
        Assert.assertEquals(0, binarySearch.binarySearchIterative(array, 1));
    }

    @Test
    public void binarySearchIterative_lastIndex() {
        Assert.assertEquals(7, binarySearch.binarySearchIterative(array, 8));
    }

    @Test
    public void binarySearchIterative_middle() {
        Assert.assertEquals(3, binarySearch.binarySearchIterative(array, 4));
    }

    @Test
    public void binarySearchIterative_notExist() {
        Assert.assertEquals(-1, binarySearch.binarySearchIterative(array, 20));
    }

}