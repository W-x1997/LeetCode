package wx.leetcode;

public class Leetcode540 {
    class Solution {
        //540. Single Element in a Sorted Array
        public int singleNonDuplicate(int[] nums) {
            if(nums==null||nums.length==0)
                return 0;

            return binarysearch(nums);
        }


        public int binarysearch(int[] nums){
            int left=0;
            int right=nums.length-1;

            while(left<right){
                int mid=left+(right-left)/2;
                if (mid%2==1)
                    mid--;

                if(nums[mid]==nums[mid+1]){
                    left=mid+2;
                }else {
                    right=mid;
                }


            }

            return nums[left];
        }


    }
}
