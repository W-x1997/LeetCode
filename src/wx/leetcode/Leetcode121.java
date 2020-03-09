package wx.leetcode;

public class Leetcode121 {
    /**
     *
     *
     * 121. Best Time to Buy and Sell Stock
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     *
     * Note that you cannot sell a stock before you buy one.
     */


    // use two variables to store the min price and the max profit we could get   and then loop each item in the prices array
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices==null||prices.length==0)
                return 0;
            int res=0;
            int min=Integer.MAX_VALUE;
            for(int i=0;i<prices.length;i++){
                min=Math.min(prices[i],min);
                res=Math.max(prices[i]-min,res);
            }


            return res;
        }
    }
}
