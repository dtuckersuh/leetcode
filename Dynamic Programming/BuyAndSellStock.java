
/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ 
 * Say you have an array for which the ith element is the price of a given stock on day i. 
 * If you were only permitted to complete at most one transaction (i.e., buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit. Note that you cannot sell a stock before you buy one.
 */

public class BuyAndSellStock {
    /**
     * Brute Force Approach
     * 
     * max(prices[j] - prices[i]) for every i and j such that j > i Time Complexity:
     * O(n^2). Loop runs (n(n - 1))/2 times Space Complexity: O(1). Only two
     * variables - maxProfit and profit used
     */
    public int maxProfitBruteForce(int prices[]) {
        int maxProfit = 0;
        // Init: maxProfit = 0; i = 0; j = 1; i, j < prices.length
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) { // Maintenance: maxProfit = max(i,j)
                int profit = prices[j] - prices[i]; // profit = j - i
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        } // Termination: maxProfit = max(prices)
        return maxProfit;
    }

    /**
     * One Pass Approach
     * 
     * Find largest peak following smallest valley.
     * Maintain two variables - minprice and maxprofit corresponding to valley and peak
     * 
     * Time Complexity: O(n). Single pass
     * Space Complexity: O(1). Two variables
     */
    public int maxProfitOnePass(int prices[]){
        int minPrice = Integer.MAX_VALUE;   // Largest value stored in Integer
        int maxProfit = 0;
        // Init: maxProfit = 0; minPrice = Integer.MAX; i < prices.length
        for (int i = 0; i < prices.length; i++){
            // Maintenance: minPrice = smallest so far; maxProfit = max(sell - buy) so far
            if (prices[i] < minPrice){
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        // Termination: maxProfit = max(sell - buy)
        return maxProfit;
    }
}