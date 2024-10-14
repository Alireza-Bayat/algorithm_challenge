package leet;

public class JumpGame {

    private static boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 0, 4}; //false
        int[] b = {2, 3, 1, 1, 4}; //true
        int[] c = {3, 0, 8, 2, 0, 0, 1}; //true
        int[] d = {1};//true
        System.out.println(canJump(a));
        System.out.println(canJump(b));
        System.out.println(canJump(c));
        System.out.println(canJump(d));
    }
}
