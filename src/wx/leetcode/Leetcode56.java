package wx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode56 {
    /**
     * 56. Merge Intervals
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * Example 1:
     *
     * Input: [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     */


    class Solution {
        public int[][] merge(int[][] intervals) {
            int len = intervals.length;
            if (len < 2) {
                return intervals;
            }

            List<int[]> res=new ArrayList();
            //  if(intervals==null||intervals.length==0)
            //     return res.toArray(new int[res.size()][]);
            Arrays.sort(intervals,new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    return a[0]-b[0];
                }
            });

            res.add(intervals[0]);
            for(int i=1;i<intervals.length;i++){
                int[] cur=intervals[i];

                int[] tmp=res.get(res.size()-1);
                if(cur[0]>tmp[1]){
                    res.add(cur);
                }else{
                    tmp[1]=Math.max(tmp[1],cur[1]);
                }


            }




            return  res.toArray(new int[res.size()][]);
        }
    }
}
