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
        class Solution2 {
            public int[][] merge(int[][] intervals) {

                if(intervals==null||intervals.length<2)
                    return intervals;

                Arrays.sort(intervals,new Comparator<int[]>(){
                    public int compare(int[] a,int[] b){
                        return a[0]-b[0];
                    }
                });



                List<int[]> list=new ArrayList();


                list.add(intervals[0]);
                for(int i=1;i<intervals.length;i++){
                    int[] former=list.get(list.size()-1);

                    if(former[1]<intervals[i][0]){
                        list.add(intervals[i]);
                    }else {
                        former[1]=Math.max(intervals[i][1],former[1]);//!!这里需要注意和former[1]比较
                        //   list.remove(list.size()-1);  指针引用传递 可直接修改
                        // list.add(former);


                    }


                }



                int[][] res=list.toArray(new int[list.size()][]);
                return  res;
            }
        }
    }
}
