package wx.leetcode;

public class Leetcode75 {

    /**
     Sort Colors

     Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

     Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

     Note: You are not suppose to use the library's sort function for this problem.

     Example:

     Input: [2,0,2,1,1,0]
     Output: [0,0,1,1,2,2]

     **/

    /**
     * 讲数组分成3部分即可
     * 三个指针 分别指向 0 1 2
     *
     * 需要注意的是每次都要进行两次判断 所以需要一个continue
     */

    class Solution {
        public void sortColors(int[] nums) {
            int left=0;
            int right=nums.length-1;
            int cur=0;
            while(cur<=right){//这里是等于 需要注意！
                if(nums[cur]==0){
                    swap(nums,left,cur);
                    left++;
                }
                if(nums[cur]==2){ //这里需要注意 因为我们此时不能确定换过来的是否为0 所有此时直接continue 确保cur保持原值
                    swap(nums,cur,right);
                    right--;
                    continue;
                }

                cur++;

            }


        }


        public void swap(int[] nums,int i,int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}
