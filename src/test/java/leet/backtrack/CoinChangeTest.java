package leet.backtrack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import leet.dynamicprogramming.CoinChange;

public class CoinChangeTest {

    private CoinChange coinChange;

    @Before
    public void prepare() {
        coinChange = new CoinChange();
    }

    @Test
    public void coinChange() {
        int[] coins = {2};
        Assert.assertEquals(-1, coinChange.coinChange(coins, 3));
    }

    @Test
    public void coinChangeSecondTest() {
        int[] coins = {1, 2, 5};
        Assert.assertEquals(20, coinChange.coinChange(coins, 100));
    }

    @Test
    public void coinChangeThirdTest() {
        int[] coins = {1, 2147483647};
        Assert.assertEquals(2, coinChange.coinChange(coins, 2));
    }

    @Test
    public void coinChangeForthTest() {
        int[] coins = {2,5,10,1};
        Assert.assertEquals(4, coinChange.coinChange(coins, 27));
    }

    @Test
    public void coinChangeFifthTest() {
        int[] coins = {186,419,83,408};
        Assert.assertEquals(20, coinChange.coinChange(coins, 6249));
    }

}