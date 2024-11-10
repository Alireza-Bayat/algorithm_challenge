package leet.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        items(n, result, new ArrayList<>(), k, 1);
        return result;
    }

    private void items(int n, List<List<Integer>> result, List<Integer> path, int k, int start) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            items(n, result, path, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
