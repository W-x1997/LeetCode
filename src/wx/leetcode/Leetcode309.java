package wx.leetcode;

public class Leetcode309 {
    class Solution {
        public int maxProfit(int[] prices) {
            /**
             309. Best Time to Buy and Sell Stock with Cooldown

             Say you have an array for which the ith element is the price of a given stock on day i.

             Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

             You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
             After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
             **/


            /**
         # 好难
  sell[i]表示截至第i天，最后一个操作是卖时的最大收益；   ！！！这里的最后一个操作 不是指前一天的操作，而是 到这一天位置 所有天内的最后一次操作
  buy[i]表示截至第i天，最后一个操作是买时的最大收益；
  cool[i]表示截至第i天，最后一个操作是冷冻期时的最大收益；
  递推公式：
  sell[i] = max(buy[i-1]+prices[i], sell[i-1]) (第一项表示第i天卖出，第二项表示第i天冷冻)
  buy[i] = max(cool[i-1]-prices[i], buy[i-1]) （第一项表示第i天买进，第二项表示第i天冷冻）
  cool[i] = max(sell[i-1], buy[i-1], cool[i-1])
                    **/


            if (prices == null || prices.length == 0)
                return 0;

            int[] sell = new int[prices.length];
            int[] buy = new int[prices.length];
            int[] cool = new int[prices.length];

            buy[0] = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
                buy[i] = Math.max(buy[i-1], cool[i-1] - prices[i]);
                cool[i] = Math.max(buy[i-1], Math.max(cool[i-1], sell[i-1]));
            }

            return sell[prices.length - 1];
        }
    }

}
