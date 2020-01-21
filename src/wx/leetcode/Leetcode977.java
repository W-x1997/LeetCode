package wx.leetcode;

import java.util.Arrays;

public class Leetcode977 {

    /**
     *
     *  输入一个数组， 本身是排序的， 要求输出一个数组， 里面的每个元素是原来的数组的每个元素的平方， 同时要对输出数组进行排序
     *
     * 解题思路分析
     * 朴素的思路就是先计算每个数的平方， 然后排序（我就是这么干的）， 但是显然时间复杂度是O(N*lgN)
     * 更好的做法是O(N)的， 因为原数组已经排序， 所以取平方以后， 要么是原来最大的数的平方值是最大的， 要么是原来最小的负数的平方值（也就是绝对值更大）是最大的。 所以，每次都取一个放到结果里面就好。
     * 这里的小trick是说如果考虑结果的最小值，是没有办法处理的。 但是如果考虑最大值，就是可以处理的。
     */


    public int[] sortedSquares(int[] A) {
        int[] ret = new int[A.length];
        for(int i = 0; i < A.length; ++i) {
            ret[i] = A[i] * A[i];
        }
        Arrays.sort(ret);
        return ret;
    }



    public int[] sortedSquares2(int[] A) {
        int left = 0, right = A.length-1;
        int[] ret = new int[A.length];
        for(int i = ret.length-1; i >= 0; --i) {
            if(Math.abs(A[left]) > Math.abs(A[right])) {
                ret[i] = A[left] * A[left];
                left++;
            }
            else {
                ret[i] = A[right] * A[right];
                right--;
            }
        }
        return ret;
    }



}
