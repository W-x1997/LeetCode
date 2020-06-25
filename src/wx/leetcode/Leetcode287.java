package wx.leetcode;

public class Leetcode287 {
    class Solution {
        public int findDuplicate(int[] nums) {
            /**
             287. Find the Duplicate Number

             Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
             这道题目要求在含有n+1个数字的数组中找出唯一一个出现多次的数字，而这些数字的范围是1-n，要求不改变数组本身以及常数空间。

             首先我想到的办法是用Bitmap，即一个整型的数字X来表示某个数字是否出现过，如果出现过，那么就在X中对应的位置1。但是这个前提即使n不能太大了，否则整型的数字存储不下。反正这道题用了long long也不行。

             这道题目看了别人的解答，可以说非常巧妙了。因为数组的范围是1-n，那么我们可以把数字之间的转移关系变成一个有向图。比如[2,1,2]，那么2->2, 1->1，2->2。

             这个问题就转换成了找图入口点的问题，可以把图看成链表，找链表入口点的问题就成了leetcode 142 了。利用快慢指针即可。
             **/
            int n = nums.length;
            // if(n == 1) return
            int slow = nums[0];
            int fast = nums[nums[0]];
            while(slow != fast){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while(slow != fast){
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
}
