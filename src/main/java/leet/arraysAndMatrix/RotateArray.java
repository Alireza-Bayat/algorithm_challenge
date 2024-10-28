package leet.arraysAndMatrix;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArray {


    private static void reverse(int[] nums, int start, int end) {
        while (end >= start) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }

    private static void rotate(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

        //brute force

//        while (k > 0) {
//            int pivotValue = nums[nums.length - 1];
//            for (int i = 0; i < nums.length; i++) {
//                int temp = nums[i];
//                nums[i] = pivotValue;
//                pivotValue = temp;
//            }
//            k--;
//        }
    }

    public static void main(String[] args) {
        int[] i = {1, 2, 3, 4, 5, 6};
        rotate(i, 3);
        System.out.println("DONE");
    }
}
