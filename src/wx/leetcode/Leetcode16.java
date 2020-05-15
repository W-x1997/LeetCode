package wx.leetcode;

import java.util.Arrays;

public class Leetcode16 {
    /**
     * 16. 3Sum Closest
     * Medium
     *
     * 1874
     *
     * 133
     *
     * Add to List
     *
     * Share
     * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
     * Return the sum of the three integers. You may assume that each input would have exactly one solution.
     */

    class Solution {
        /**
         *
         * Similar to 3sum(use 2 pointers) we just need to add a new variable to record our cur_sum, and update it everytime if
         * our cur_sum is closer to our target.
         *
         *
         *
         * @param nums
         * @param target
         * @return
         */
        public int threeSumClosest(int[] nums, int target) {
            if(nums==null||nums.length<3)
                return 0;


            Arrays.sort(nums);
            int closest=nums[0]+nums[1]+nums[2];

            for(int i=0;i<nums.length-2;i++){
                int left=i+1;
                int right=nums.length-1;

                while(left<right){
                    int cur_sum=nums[i]+nums[left]+nums[right];
                    if(cur_sum==target)return target;

                    if(Math.abs(cur_sum-target)<Math.abs(closest-target)){
                        closest=cur_sum;
                    }

                    if(cur_sum<target){
                        left++;
                    }else {
                        right--;
                    }


                }

            }

            return closest;


        }
    }
}
