package wx.leetcode;

public class Leetcode410 {
    /**
     *
     * 410. Split Array Largest Sum
     * Hard
     *
     * 1527
     *
     * 78
     *
     * Add to List
     *
     * Share
     * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
     *
     * Note:
     * If n is the length of array, assume the following constraints are satisfied:
     *
     * 1 ≤ n ≤ 1000
     * 1 ≤ m ≤ min(50, n)
     */

    class Solution {


        /**
         * 首先我们把 f[i][j] 定义为将 nums[0..i] 分成 j 份时能得到的最小的分割子数组最大值。
         *
         * 对于第 j 个子数组，它为数组中下标 k + 1 到 i 的这一段。因此，f[i][j] 可以从 max(f[k][j - 1], nums[k + 1] + ... + nums[i])
         * 这个公式中得到。遍历所有可能的 k，会得到 f[i][j] 的最小值。
         *
         * 整个算法那的最终答案为 f[n][m]，其中 n 为数组大小。

         * @param nums
         * @param m
         * @return
         */
        //Solution 1: dp
        public int splitArray(int[] nums, int m) {
            if(nums==null||m<=0)
                return -1;

            int n=nums.length;
            int[][] dp=new int[n+1][m+1];   // dp[i][j]means the minmus largest sum from                                         //  nums[0]~nums[i] we
            // split into j subarrays

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }



            int[] sum=new int[n+1];//subtotal
            for(int i=0;i<n;i++){
                sum[i+1]=nums[i]+sum[i];
            }




            dp[0][0]=0;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    for(int k=0;k<i;k++){

                        dp[i][j]=Math.min(dp[i][j], Math.max(dp[k][j-1],sum[i]-sum[k]));
                    }
                }
            }

            return dp[n][m];

        }
    }
}
