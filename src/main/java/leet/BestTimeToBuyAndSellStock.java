package leet;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {2, 4, 5, 9, 1, 10};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int minPriceSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {

            if (price < minPriceSoFar) {
                minPriceSoFar = price;
            }

            int profit = price - minPriceSoFar;

            if (profit > maxProfit) {
                maxProfit = profit;
            }

        }

        return maxProfit;
    }
}
