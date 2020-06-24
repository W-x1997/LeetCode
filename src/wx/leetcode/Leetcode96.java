package wx.leetcode;

public class Leetcode96 {
    class Solution {
        /**
         96. Unique Binary Search Trees

         Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
         **/
        public int numTrees(int n) {
            /**
             dp[i] 表示i个结点 一共有多少种方式
             **/
            int[] dp=new int[n+1];
            dp[0]=1;
            dp[1]=1;

            for(int i=2;i<=n;i++){ //表示i个结点
                for(int j=0;j<i;j++){ //表示左结点为j时  右结点则为i-1-j个  一共dp[j]*dp[i-1-j]种组合
                    dp[i]=dp[i]+(dp[j]*dp[i-1-j]);
                }

            }

            return dp[n];
        }
    }
}
