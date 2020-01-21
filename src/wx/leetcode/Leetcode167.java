package wx.leetcode;

public class Leetcode167 {

    /**
     *
     * 给定升序排序数组，找到两个和为给定数字的元素，返回二者位置。注意index1 < index2，且不使用重复元素。
     *
     *
     *
     * Solution 1：
     * 左右两指针相加靠近。
     *
     * 注意题目与LeetCode-1：Two Sum存在不同的地方，本题要求index1 < index2，可以使用除与LeetCode-1相同的HashMap之外其他的方法。
     * 题中要求index1 < index2，那么我们可以利用这样的性质，设置左右两个指针，从两端向中间逼近，每次都用两个数判断是否等于目标值，等于则返回，不等则判断大小，增减左右指针。
     *
     * 时间复杂度：O(n)；空间复杂度：O(1)
     *
     */
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i=0, j=numbers.length-1;

            while(i<j) {

                if(numbers[i]+numbers[j] == target) {
                    break;
                }else if(numbers[i]+numbers[j] < target) {
                    i++;
                }else {
                    j--;
                }

            }

            return new int[]{i+1, j+1};
        }
    }
}
