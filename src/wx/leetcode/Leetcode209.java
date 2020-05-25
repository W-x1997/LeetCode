package wx.leetcode;

public class Leetcode209 {
    class Solution {

        /**
         209. Minimum Size Subarray Sum
         Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

         Example:

         Input: s = 7, nums = [2,3,1,2,4,3]
         Output: 2
         Explanation: the subarray [4,3] has the minimal length under the problem constraint.
         **/
        public int minSubArrayLen(int s, int[] nums) {
            /**
             依然是双指针 滑动窗口的典型题
             需要注意的是left的移动 可能不止一次 需要一个while循环判断  因为加入的数字可能大于之前所有之和

             **/
            int min_len=Integer.MAX_VALUE;

            int cur_sum=0;
            int left=0;
            int right=0;

            while(left<nums.length&&right<nums.length){
                cur_sum=cur_sum+nums[right];
                right++;
                while(left<right&&cur_sum>=s){ //注意这里是while!  不是单次判断
                    min_len=Math.min(min_len,right-left);
                    cur_sum=cur_sum-nums[left];
                    left++;

                }


            }

            if(min_len==Integer.MAX_VALUE)  return 0;
            return min_len;


        }
    }
}
