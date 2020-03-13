package wx.leetcode;

import java.util.HashMap;

public class Leetcode169 {
    /**
     * 169. Majority Element
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     *
     * You may assume that the array is non-empty and the majority element always exist in the array.
     */
    class Solution {
        public int majorityElement(int[] nums) {
            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
            int len=nums.length/2;
            for(int i=0;i<nums.length;i++){
                if(map.containsKey(nums[i])){
                    if(map.get(nums[i])+1>len)
                        return nums[i];
                    map.put(nums[i],map.get(nums[i])+1);
                }else {
                    map.put(nums[i],1);
                    if(map.get(nums[i])>len)
                        return nums[i];
                }



            }

            return -1;
        }
    }
}
