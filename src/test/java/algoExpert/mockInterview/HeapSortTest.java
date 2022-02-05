package algoExpert.mockInterview;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author alireza_bayat
 * created on 2/5/22
 */
public class HeapSortTest {

    @Test
    public void sort() {

        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }


    private void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}