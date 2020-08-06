package wx.leetcode;
import java.util.*;
public class Leetcode442 {
    /**
     * 442. Find All Duplicates in an Array
     * Medium
     *
     * 2440
     *
     * 153
     *
     * Add to List
     *
     * Share
     * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     *
     * Find all the elements that appear twice in this array.
     *
     * Could you do it without extra space and in O(n) runtime?
     */
    class Solution {
        /**
         * 和448一模一样
         * @param nums
         * @return
         */
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> ans = new ArrayList<>();

            for (int num : nums) {
                if (nums[Math.abs(num) - 1] < 0) { // seen before
                    ans.add(Math.abs(num));
                }
                nums[Math.abs(num) - 1] *= -1;
            }

            return ans;

        }
    }
}
