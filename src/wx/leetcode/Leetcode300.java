package wx.leetcode;

public class Leetcode300 {
    /**
     * 300. Longest Increasing Subsequence
     * Given an unsorted array of integers, find the length of longest increasing subsequence.
     *
     * Example:
     *
     * Input: [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
     *
     *
     *
     *
     * Solution:
     *  DP : we let dp[i] denote the longest increasing subsequence that starts from 0 to i.
     *
     *  dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
     *
     *    each time we use "temp" to denote the maximum subsequence from dp[0] to dp[j]
     *              if (nums[i]>nums[j])
     *              we compare with temp dp[j]
     *              to choose the maximum dp
     *              finally we choose the longest one +1   ===>     dp[i]=temp+1;
     *
     *
     */
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int max=1;
            if(nums==null||nums.length==0){
                return 0;
            }

            int dp[]=new int[nums.length];
            dp[0]=0;
            for(int i=0;i<nums.length;i++){
                int temp=0;

                for(int j=0;j<i;j++){
                    if(nums[i]>nums[j])
                        temp=Math.max(temp,dp[j]);

                }
                dp[i]=temp+1;

                max=Math.max(max,dp[i]);
            }

            return max;
        }
    }
}
