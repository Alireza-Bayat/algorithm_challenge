package leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSeq {

    public int longestConsecutiveV1(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        int counter = 0;

        for (Integer i : numsSet) {
            if (numsSet.contains(i - 1)) {
                continue;
            }

            int currentNum = i;
            int currentCounter = 1;

            while (numsSet.contains(currentNum + 1)) {
                currentNum++;
                currentCounter++;
            }
            counter = Math.max(counter, currentCounter);
        }

        return counter;
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> numMap = new HashMap<>();
        int longestStreak = 0;

        for (int num : nums) {
            if (!numMap.containsKey(num)) {
                int leftStreak = numMap.getOrDefault(num - 1, 0);
                int rightStreak = numMap.getOrDefault(num + 1, 0);

                int currentStreak = leftStreak + 1 + rightStreak;

                longestStreak = Math.max(longestStreak, currentStreak);

                numMap.put(num, currentStreak);
                numMap.put(num - leftStreak, currentStreak);
                numMap.put(num + rightStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
