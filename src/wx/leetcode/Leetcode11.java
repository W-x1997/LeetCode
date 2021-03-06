package wx.leetcode;

public class Leetcode11 {
    /**
     *
     *
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     *
     * Note: You may not slant the container and nis at least 2.
     *
     *
     *
     *
     *
     * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
     * In this case, the max area of water (blue section) the container can contain is 49.
     *
     *
     *
     * Example:
     *
     * Input: [1,8,6,2,5,4,8,3,7]
     * Output: 49
     *
     *
     * 这道求装最多水的容器的题和那道 Trapping Rain Water 很类似，但又有些不同，那道题让求整个能收集雨水的量，
     * 这道只是让求最大的一个的装水量，而且还有一点不同的是，那道题容器边缘不能算在里面，而这道题却可以算，相比较来说还是这道题容易一些，
     * 这里需要定义i和j两个指针分别指向数组的左右两端，然后两个指针向中间搜索，每移动一次算一个值和结果比较取较大的，
     * 容器装水量的算法是找出左右两个边缘中较小的那个乘以两边缘的距离
     */
    class Solution {
        public int maxArea(int[] height) {
            int size=height.length;
            int res=0;
            int left=0,right=size-1;
            while(left<right){
                res=Math.max((right-left)*Math.min(height[left],height[right]),res);
                if(height[right]>height[left])
                    left++;
                else
                    right--;
            }



            return res;
        }
    }
}
