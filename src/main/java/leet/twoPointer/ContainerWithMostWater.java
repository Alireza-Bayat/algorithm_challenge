package leet.twoPointer;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int vertical = Math.min(height[left], height[right]);
            int horizontal = right - left;
            int container = vertical * horizontal;
            if (max < container) {
                max = container;
            }
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return max;
    }
}
