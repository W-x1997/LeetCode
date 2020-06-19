package wx.leetcode;
import java.util.*;
public class Leetcode532 {
    class Solution {
        /**

         * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

         * Input: [3, 1, 4, 1, 5], k = 2
         * Output: 2
         * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
         * Although we have two 1s in the input, we should only return the number of unique pairs.

         *
         * 从给定数组中，找出所有差的绝对值为k的元素值对（i, j），返回元素值对的数量。
         *

         * HashMap实现。
         *
         * 由题目可以知道，同LeetCode-1：Two Sum类似，题中在map中找到nums[i]+k，就相当于找到了一对符合题目的值对；
         * 首先给出没有值对，即符合条件的值对数量为0的情况；
         * 将nums中的所有元素以 (value：number) 的map对对象，存储在map中；
         * 遍历map中的元素，注意区分k为0和不为0的情况。

         */
        public int findPairs(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k < 0) return 0;

            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for (int i : nums){
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                if (k == 0){
                    if (entry.getValue() >= 2){
                        count++;
                    }
                }else{
                    if (map.containsKey(entry.getKey() + k)){
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
