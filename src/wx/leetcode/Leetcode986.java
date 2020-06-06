package wx.leetcode;
import  java.util.*;

public class Leetcode986 {
    class Solution {
        /**
         986. Interval List Intersections

         Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

         Return the intersection of these two interval lists.

         (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
         **/
        public int[][] intervalIntersection(int[][] A, int[][] B) {

            /**
             双指针 一次比较便利
             每次取相交的部分

             **/
            List<int[]> list=new ArrayList();

            int i=0;
            int j=0;

            while(i<A.length&&j<B.length){

                int start=Math.max(A[i][0],B[j][0]); //！！
                int end=Math.min(A[i][1],B[j][1]);//！！

                if(start<=end)
                    list.add(new int[]{start,end});


                if(A[i][1]<B[j][1]){
                    i++;
                }else
                    j++;

            }

            return list.toArray(new int[list.size()][]);



        }
    }
}
