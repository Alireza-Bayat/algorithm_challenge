package tabesh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

    private MergeSort mergeSort;

    @Before
    public void startup() {
        mergeSort = new MergeSort();
    }

    @Test
    public void mergeSort() {
        int[] initArr = new int[]{10, -3, 4, 0, 2, 5, -6, 45, -9};
        int[] ints = mergeSort.mergeSort(initArr);
        Assert.assertArrayEquals(new int[]{-9, -6, -3, 0, 2, 4, 5, 10, 45}, ints);
    }

    @Test
    public void mergeSort_oneIndex() {
        int[] initArr = new int[]{10};
        int[] ints = mergeSort.mergeSort(initArr);
        Assert.assertArrayEquals(new int[]{10}, ints);
    }

    @Test
    public void mergeSort_noIndex() {
        int[] initArr = new int[]{};
        int[] ints = mergeSort.mergeSort(initArr);
        Assert.assertArrayEquals(new int[]{}, ints);
    }
}