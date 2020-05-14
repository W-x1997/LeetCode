package wx.leetcode;

import java.util.Stack;


/**
 *
 * 456. 132 Pattern
 * Medium
 *
 * 1227
 *
 * 81
 *
 * Add to List
 *
 * Share
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k
 * and  ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern
 * in the list.
 */
public class Leetcode456 {

    public boolean find132pattern(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int temp = nums[0];
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>temp){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]>nums[j] && nums[j]>temp)
                        return true;
                }
            }else{
                temp = nums[i]; // 左边最小
            }
        }

        return false;
    }
    class Solution {
        public boolean find132pattern(int[] nums) {
            /**

             从后往前遍历找到符合条件的次大值（注意只用找次大值）
             之后只需要和次大数值比较即可，如果当前元素<次大值则返回true

             寻找右面符合条件的最大值和次大值的方法如下：

             如果当前元素小于栈顶元素，则入栈
             如果当前元素大于栈顶元素，则先出栈，出到当前元素小于栈顶元素（之前的一个局部最大值），出的同时让second和出栈元素比较，
             取较大的那个（临界条件）
             **/
            if(nums.length<3)
                return false;

            int second = Integer.MIN_VALUE;
            Stack<Integer> stack =new Stack<>();
            stack.add(nums[nums.length-1]);
            for(int i=nums.length-2;i>=0;i--){

                if(nums[i]<second){
                    return true;
                }else {
                    while (!stack.isEmpty()&&nums[i]>stack.peek()){
                        second=Math.max(stack.pop(),second);
                    }
                    stack.push(nums[i]);
                }


            }



            return false;

        }
    }
}
