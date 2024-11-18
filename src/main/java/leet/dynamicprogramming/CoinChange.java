package leet.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {

    private int len = Integer.MAX_VALUE;
    private boolean found = false;

    public int coinChangeBackTrackVersion(int[] coins, int amount) {
        Arrays.sort(coins);
        backTrack(coins, amount, new ArrayList<>());
        return found ? len : -1;
    }

    private void backTrack(int[] coins, int amount, List<Integer> path) {
        int currentSum = path.stream().mapToInt(Integer::intValue).sum();
        if (currentSum == amount) {
            len = Math.min(len, path.size());
            found = true;
            return;
        }
        if (currentSum > amount) {
            return;
        }

        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] > amount) {
                continue;
            }
            path.add(coins[i]);
            if (!found) {
                backTrack(coins, amount, path);
            }
            path.remove(path.size() - 1);
        }

    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
