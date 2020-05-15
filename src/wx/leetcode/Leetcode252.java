package wx.leetcode;
import java.util.*;
public class Leetcode252 {
    /**
     *
     * 252. Meeting Rooms
     * Easy
     *
     * 542
     *
     * 34
     *
     * Add to List
     *
     * Share
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     * determine if a person could attend all meetings.
     */
    class Solution {
        /**
         * sort the meetings by starting time. Then, go through the meetings one by one
         * and make sure that each meeting ends before the next one starts.
         * @param intervals
         * @return
         */
        public boolean canAttendMeetings(int[][] intervals) {
            if(intervals==null||intervals.length==0){
                return true;
            }


            Arrays.sort(intervals,new Comparator<int[]>(){
                public int compare(int[] a,int[] b){
                    return a[0]-b[0];
                }
            });


            for(int i=1;i<intervals.length;i++){
                if(intervals[i][0]<intervals[i-1][1]){
                    return false;
                }
            }


            return true;
        }
    }

}
