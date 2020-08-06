package wx.leetcode;
import java.util.*;
public class Leetcode448 {
    /**
     * 448. Find All Numbers Disappeared in an Array
     * Easy
     *
     * 2991
     *
     * 253
     *
     * Add to List
     *
     * Share
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     *
     * Find all the elements of [1, n] inclusive that do not appear in this array.
     *
     * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
     */

    /**
     * 和446 几乎相同的思路
     *
     * 重点是 without extra space and in O(n) runtime
     *
     * 利用数组 值 为1-n的正数 我们采用负数的形式 访问过即反转 为 负
     *
     */

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (nums[Math.abs(nums[i]) - 1] > 0) {
                    nums[Math.abs(nums[i]) - 1] = -1 * nums[Math.abs(nums[i]) - 1];
                }

            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    res.add(i + 1);
                }
            }

            return res;

        }
    }
}
