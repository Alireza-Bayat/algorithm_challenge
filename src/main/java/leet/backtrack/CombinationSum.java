package leet.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 * of at least one of the chosen numbers is different.
 * <p>
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combine(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void combine(int[] candidates, int target, List<List<Integer>> result, List<Integer> path, int index) {
        int sum = path.stream().mapToInt(Integer::intValue).sum();
        if (target == sum) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < sum) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            combine(candidates, target, result, path, i);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        int[] i = {2, 3, 6, 7};
        List<List<Integer>> lists = sum.combinationSum(i, 7);
        System.out.println(lists);
    }
}
