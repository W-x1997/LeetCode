package wx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {
    /**
     * 18. 4Sum
     * Medium
     *
     * 1671
     *
     * 306
     *
     * Add to List
     *
     * Share
     * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums
     * such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
     */

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res=new ArrayList();
            Arrays.sort(nums);

            for(int i=0;i<nums.length-3;i++){
                if(i>0&&nums[i-1]==nums[i]) //去重
                    continue;
                for(int j=i+1;j<nums.length-2;j++){
                    if(j>i+1&&nums[j]==nums[j-1]) //去重
                        continue;

                    int left=j+1;
                    int right=nums.length-1;
                    int rest=target-nums[i]-nums[j];
                    while(left<right){
                        if(nums[left]+nums[right]==rest){
                            List<Integer> list=new ArrayList();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[left]);
                            list.add(nums[right]);
                            res.add(list);
                            //去重
                            while(left<right&&nums[left]==nums[left+1])left++;
                            while(left<right&&nums[right]==nums[right-1])right--;
                            left++;
                            right--;


                        } else if(nums[left]+nums[right]<rest){
                            left++;

                        }else {
                            right--;
                        }

                    }

                }
            }




            return res;
        }
    }
}
