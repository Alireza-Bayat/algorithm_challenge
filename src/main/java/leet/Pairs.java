package leet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find Pairs with Given Difference
 */
public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        Set<Integer> pairs = new HashSet<>(arr);
        int finalPairs = 0;

        for (Integer integer : arr) {
            if (pairs.contains(integer + k)) {
                finalPairs++;
            }
            if (pairs.contains(integer - k)) {
                finalPairs++;
            }

            pairs.remove(integer);
        }

        return finalPairs;
    }

    public static void main(String[] args) {
        System.out.println(pairs(3, List.of(1, 2, 3, 4, 5)));
    }

}
