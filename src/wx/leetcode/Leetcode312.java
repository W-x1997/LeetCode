package wx.leetcode;

public class Leetcode312 {
    class Solution {
        /**
         312. Burst Balloons
         Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

         戳气球
         i->i+j
         Find the maximum coins you can collect by bursting the balloons wisely.
         **/
        public int maxCoins(int[] nums) {
            //dp[i][j] 表示i->j最大乘积
            int[][] dp = new int[nums.length + 2][nums.length + 2];


            //左右+1方便操作 即nums[-1] == nums[n] == 1
            int[] newNums = new int[nums.length + 2];
            for(int i = 1; i < newNums.length - 1; i++){
                newNums[i] = nums[i-1];
            }

            newNums[0] = 1;
            newNums[newNums.length - 1] = 1;


            for(int j = 2; j < newNums.length; j++){  //j表示距离 即distance
                //遍历所有的可能 0-2  ... 0-n, 1-3,....
                for(int i = 0; i<newNums.length - j; i++){
                    for(int k = i + 1; k < i + j; k++){
                        dp[i][i + j] = Math.max(dp[i][i + j], dp[i][k] + dp[k][i + j] + newNums[i] * newNums[k] * newNums[i+j]);
                    }

                }

            }

            return dp[0][newNums.length - 1];

        }
    }
}
