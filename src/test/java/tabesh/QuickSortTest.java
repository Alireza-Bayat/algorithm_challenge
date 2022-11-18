package tabesh;

import org.junit.Test;


public class QuickSortTest {

    @Test
    public void quicksortCaller(){
        int[] arr = {3, 4, 6, 2, 4, 56, 23, 4, 234, 2, 34, 2, 3, 4, 2345, 23, 45, 23, 5, 23, 45, 23, 45, 23, 45, 23, 45, 234, 0, 523, 45, 23, 45, 234, 5, 234, 5, 234, 5, 234, 5, 234, 5, 234, 5, 234, 5, 236, 4, 67, -8, 45678, 567, 8, 6, 7, 54, 6, 45, 4, 345, 1};
        QuickSort quickSort = new QuickSort();
        int[] quicksort = quickSort.quicksort(arr, 0, arr.length - 1);
        for (int i : quicksort) {
            System.out.print(i + " ");
        }
    }
}