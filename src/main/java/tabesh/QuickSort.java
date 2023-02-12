package tabesh;

public class QuickSort {

    // CLRS sudo code
    //QUICKSORT.A; p; r/
    //1 if p<r
    //2 q D PARTITION.A; p; r/
    //3 QUICKSORT.A; p; q  1/
    //4 QUICKSORT.A; q C 1; r/
    public int[] quicksort(int[] arr, int lowestIndex, int highestIndex) {
        if (lowestIndex < highestIndex) { //mean if lowest and highest are not pointing at same array index or passed each other
            int partition = partition(arr, lowestIndex, highestIndex);
            quicksort(arr, lowestIndex, partition - 1);
            quicksort(arr, partition + 1, highestIndex);
        }
        return arr;
    }

    // CLRS sudo code
    //PARTITION.A; p; r/
    //1 x D AŒr
    //2 i D p  1
    //3 for j D p to r  1
    //4 if AŒj   x
    //5 i D i C 1
    //6 exchange AŒi with AŒj
    //7 exchange AŒi C 1 with AŒr
    //8 return i C 1
    private int partition(int[] arr, int lowestIndex, int highestIndex) {
        int pivot = arr[highestIndex];
        int i = lowestIndex - 1;
        for (int j = lowestIndex; j <= highestIndex - 1; j++) {
            if (arr[j] < pivot) {
                i = i + 1;
                exchangeValue(arr, i, j);
            }
        }
        exchangeValue(arr, i + 1, highestIndex);
        return i + 1;
    }

    private void exchangeValue(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
