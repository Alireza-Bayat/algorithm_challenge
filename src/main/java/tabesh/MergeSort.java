package tabesh;

public class MergeSort {

    public int[] mergeSort(int[] arr) {
        if (arr.length == 0)
            return arr;
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int[] mergeSort(int[] arr, int startPointer, int lastPointer) {
        if (startPointer == lastPointer) {
            int[] sorted = new int[1];
            sorted[0] = arr[startPointer];
            return sorted;
        }

        int midPointer = (startPointer + lastPointer) / 2;
        int[] firstPartArr = mergeSort(arr, midPointer + 1, lastPointer);
        int[] secondPartArr = mergeSort(arr, startPointer, midPointer);

        return conquer(firstPartArr, secondPartArr);

    }

    private int[] conquer(int[] arr1, int[] arr2) {
        int[] sortedArr = new int[arr2.length + arr1.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                sortedArr[k] = arr2[j];
                k++;
                j++;
            } else {
                sortedArr[k] = arr1[i];
                k++;
                i++;
            }
        }

        if (i == arr1.length) {
            while (j < arr2.length) {
                sortedArr[k] = arr2[j];
                k++;
                j++;
            }
        }

        if (j == arr2.length) {
            while (i < arr1.length) {
                sortedArr[k] = arr1[i];
                k++;
                i++;
            }
        }

        return sortedArr;
    }

}
