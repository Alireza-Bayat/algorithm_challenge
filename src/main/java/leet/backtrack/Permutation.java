package leet.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutations(nums, result, new ArrayList<>());
        return result;
    }

    private void permutations(int[] nums, List<List<Integer>> result, List<Integer> perm) {
        if (perm.size() == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (perm.contains(nums[i])) {
                continue;
            }

            perm.add(nums[i]);
            permutations(nums, result, perm);
            perm.remove(perm.size() - 1);
        }
    }

//    private static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    private static void solve(int[] nums, int index, List<List<Integer>> result) {
//        //base condition
//        if (index >= nums.length) {
//            //add nums to result]
//            List<Integer> copy = new ArrayList<>();
//            for (int n : nums) {
//                copy.add(n);
//            }
//            result.add(copy);
//        }
//
//        for (int j = index; j < nums.length; j++) {
//            //swap
//            swap(nums, j, index);
//            solve(nums, index + 1, result);
//            swap(nums, index, j);
//        }
//
//    }
//
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        solve(nums, 0, result);
//        return result;
//    }

}



