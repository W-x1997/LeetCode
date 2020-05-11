package wx.leetcode;

public class Leetcode238 {
    /**
     * 238. Product of Array Except Self
     * Medium
     *
     * 4402
     *
     * 384
     *
     * Add to List
     *
     * Share
     * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to
     * the product of all the elements of nums except nums[i].
     */


    class Solution {
        /**
         *
         * 构建两个数组 前缀数组 和 后缀数组
         * @param nums
         * @return
         */
        public int[] productExceptSelf(int[] nums) {
            int[] res=new int[nums.length];

            int prefix[]=new int[nums.length];
            int suffix[]=new int[nums.length];


            prefix[0]=nums[0];
            for(int i=1;i<nums.length;i++){
                prefix[i]=prefix[i-1]*nums[i];
            }

            suffix[nums.length-1]=nums[nums.length-1];
            for(int i=nums.length-2;i>=0;i--){
                suffix[i]=suffix[i+1]*nums[i];
            }


            res[0]=suffix[1];
            res[nums.length-1]=prefix[nums.length-2];
            for(int i=1;i<nums.length-1;i++){
                res[i]=prefix[i-1]*suffix[i+1];
            }

            return res;
        }
    }
}
