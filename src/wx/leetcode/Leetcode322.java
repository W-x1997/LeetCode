package wx.leetcode;

import java.util.Arrays;

public class Leetcode322 {
    class Solution {
        /**
         322. Coin Change

         You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
         **/
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            // dp[i] denotes the minimum amount of coins used to get i
            dp[0] = 0;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i >= coins[j]){
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }

            if (dp[dp.length - 1] == max)
                return -1;

            return dp[dp.length - 1];

        }
    }
}
