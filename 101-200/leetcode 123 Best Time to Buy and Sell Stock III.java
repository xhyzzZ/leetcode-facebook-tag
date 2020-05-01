//leetcode 123 Best Time to Buy and Sell Stock III

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit1 = 0; 
        int maxProfit2 = 0; 
        int lowestBuyPrice1 = Integer.MAX_VALUE;
        int lowestBuyPrice2 = Integer.MAX_VALUE;

        for (int p : prices) {
            maxProfit2 = Math.max(maxProfit2, p - lowestBuyPrice2);
            lowestBuyPrice2 = Math.min(lowestBuyPrice2, p - maxProfit1);
            maxProfit1 = Math.max(maxProfit1, p - lowestBuyPrice1);
            lowestBuyPrice1 = Math.min(lowestBuyPrice1, p);
        }
        return maxProfit2;
    }
}