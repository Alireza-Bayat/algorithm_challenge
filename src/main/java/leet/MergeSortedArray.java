package leet;


/**
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int[] nums2 = {1, 2, 2};
        merge(nums1, 6, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }


        ///sout the arr
        for (int value : nums1) {
            System.out.print(value + ", ");
        }
    }
}
