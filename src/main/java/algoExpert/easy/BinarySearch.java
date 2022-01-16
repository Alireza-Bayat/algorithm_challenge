package algoExpert.easy;

/**
 * @author alireza_bayat
 * created on 1/16/22
 */
public class BinarySearch {

    //time complexity O(log(n)) | space complexity O(log(n)) cause of stack calls
    public int binarySearchRecursive(int[] array, int target) {
        return binarySearchRecursiveHelper(array, target, 0, array.length - 1);
    }

    private int binarySearchRecursiveHelper(int[] array, int target, int leftPointer, int rightPointer) {
        if (leftPointer > rightPointer)
            return -1;
        int middlePointerIndex = (int) Math.floor((double) (leftPointer + rightPointer) / 2);
        int middlePointerValue = array[middlePointerIndex];
        if (middlePointerValue == target)
            return middlePointerIndex;
        else if (middlePointerValue > target)
            return binarySearchRecursiveHelper(array, target, leftPointer, middlePointerIndex - 1);
        else
            return binarySearchRecursiveHelper(array, target, middlePointerIndex + 1, rightPointer);
    }

    //time complexity O(log(n)) | space complexity O(1)
    public int binarySearchIterative(int[] array, int target) {
        int leftPointer = 0, rightPointer = array.length - 1;
        while (!(leftPointer > rightPointer)) {
            int middlePointerIndex = (int) Math.floor((double) (leftPointer + rightPointer) / 2);
            int middlePointerValue = array[middlePointerIndex];
            if (middlePointerValue == target)
                return middlePointerIndex;
            else if (middlePointerValue > target)
                rightPointer = middlePointerIndex - 1;
            else
                leftPointer = middlePointerIndex + 1;
        }
        return -1;
    }

}
