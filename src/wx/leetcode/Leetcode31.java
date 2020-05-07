package wx.leetcode;

import java.util.Arrays;

public class Leetcode31 {
    /**
     * 31. Next Permutation
     * Medium
     *
     * 2991
     *
     * 1060
     *
     * Add to List
     *
     * Share
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     *
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     *
     * The replacement must be in-place and use only constant extra memory.
     *
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     *
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     */

    class Solution {

        /**

         从右往左 首先找到第一个升序的起点坐标   因为如果都是降序 就不会存在next permuation

         要使得next permuation小，所以 下面 从后往前 找第一个比nums[i]大的元素nums[j] swap

         然后 从i+1到数组最后排序即可（！这里可以直接优化！！ reverse O（n） 即可 因为都是递减）
         **/
        public void nextPermutation(int[] nums) {
            if(nums==null||nums.length==0)
                return;

            int i=nums.length-2;
            while(i>=0&&nums[i]>=nums[i+1]){  //从后向前找第一个升序位置i
                i--;
            }
            if(i==-1){
                Arrays.sort(nums);
                return;
            }


            int j;
            for(j=nums.length-1;j>=0;j--){//从后向前找j
                if(nums[j]>nums[i]){
                    break;
                }
            }

            swap(nums,i,j);

            Arrays.sort(nums,i+1,nums.length);

        }




        public void swap(int[] n,int i,int j){
            int tmp=n[i];
            n[i]=n[j];
            n[j]=tmp;
        }
    }
}
