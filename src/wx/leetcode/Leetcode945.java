package wx.leetcode;

import java.util.Arrays;

public class Leetcode945 {
    /**
     * 945. Minimum Increment to Make Array Unique
     * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
     *
     * Return the least number of moves to make every value in A unique.
     *
     *
     *
     * Example 1:
     *
     * Input: [1,2,2]
     * Output: 1
     * Explanation:  After 1 move, the array could be [1, 2, 3].
     * Example 2:
     *
     * Input: [3,2,1,2,1,7]
     * Output: 6
     * Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
     * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
     *
     *
     *
     * First, sort the array. The loop the array from A[1] . Compare it with its previous, if its value smaller than or euqal to the previous
     * one, change its value to its previous+1. Then calculate the differences.
     *
     */
    class Solution {
        public int minIncrementForUnique(int[] A) {
            if(A==null||A.length==0)
                return 0;
            int res=0;
            Arrays.sort(A);

            for(int i=1;i<A.length;i++){
                if(A[i]<=A[i-1]){
                    res=res+A[i-1]-A[i]+1;
                    A[i]=A[i-1]+1;
                }
            }


            return res;
        }
    }
}
