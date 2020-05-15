package wx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode57 {
    class Solution {
        /**
         *
         *
         * 57. Insert Interval
         * Hard
         *
         * 1432
         *
         * 168
         *
         * Add to List
         *
         * Share
         * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
         *
         * You may assume that the intervals were initially sorted according to their start times.
         * @param intervals
         * @param newInterval
         * @return
         */


        /**
         *
         * we need to use a list from start to end  add one interval to our res list.
         * use nstart and nend to denote the new intervals and to add .
         *
         *
         *
         * @param intervals
         * @param newInterval
         * @return
         */
        public int[][] insert(int[][] intervals, int[] newInterval) {

            List<int[]> res=new ArrayList();

            int i=0;
            int nstart=newInterval[0];
            int nend=newInterval[1];

            while(i<intervals.length&&intervals[i][1]<newInterval[0]){
                res.add(intervals[i]);
                i++;
            }

            if(i==intervals.length){
                res.add(newInterval);
                return res.toArray(new int[res.size()][]);
            }

            nstart=Math.min(intervals[i][0],nstart);


            while(i<intervals.length&&intervals[i][0]<=newInterval[1]){
                nend=Math.max(intervals[i][1],newInterval[1]);
                i++;
            }

            int[] tmp=new int[2];
            tmp[0]=nstart;
            tmp[1]=nend;
            res.add(tmp);

            while(i<intervals.length){
                res.add(intervals[i]);
                i++;
            }


            return res.toArray(new int[res.size()][]);
        }
    }
}
