package wx.leetcode;

public class Leetcode17_16 {
    /**
     * 面试题 17.16. The Masseuse LCCI
     * A popular masseuse receives a sequence of back-to-back appointment requests and is debating which ones to accept. She needs a break between appointments and therefore she cannot accept any adjacent requests. Given a sequence of back-to-back appoint­ ment requests, find the optimal (highest total booked minutes) set the masseuse can honor. Return the number of minutes.
     *
     * Note: This problem is slightly different from the original one in the book.
     *
     *
     *
     * Example 1:
     *
     * Input:  [1,2,3,1]
     * Output:  4
     * Explanation:  Accept request 1 and 3, total minutes = 1 + 3 = 4
     */


    class Solution {
        public int massage(int[] nums) {
            if(nums==null||nums.length==0)
                return 0;
            int[] dp=new int[nums.length+1];
            dp[0]=0;
            dp[1]=nums[0];
            for(int i=2;i<dp.length;i++){
                dp[i]=Math.max(dp[i-2]+nums[i-1],dp[i-1]);
            }

            return dp[dp.length-1];
        }
    }
}
