package leet;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * <p>
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * <p>
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 */
public class RemoveElement {

    private static int removeElement(int[] nums, int val) {
        int occurance = 0;
        int startingPoint = 0;
        int endingPoint = nums.length - 1;
        while (startingPoint <= endingPoint) {
            if (val == nums[startingPoint]) {
                int temp = nums[startingPoint];
                nums[startingPoint] = nums[endingPoint];
                nums[endingPoint] = temp;
                occurance++;
                endingPoint--;
            } else {
                startingPoint++;
            }
        }

        return nums.length - occurance;
    }

    public static void main(String[] args) {
        int[] i = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(i, 2));
    }
}
