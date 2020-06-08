package wx.leetcode;

import java.util.Arrays;
import java.util.*;
public class Leetcode621 {
    /**
     * 621. Task Scheduler
     * Medium
     *
     * 2762
     *
     * 604
     *
     * Add to List
     *
     * Share
     * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
     *
     * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
     *
     * You need to return the least number of intervals the CPU will take to finish all the given tasks.
     */


    class Solution {
        /**
         * If we are able to, somehow, determine the number of idle slots(idle\_slotsidle_slots),
         * we can find out the time required to execute all the tasks as idle\_slots + Total Number Of Tasksidle_slots+TotalNumberOfTasks.
         * Thus, the idea is to find out the idle time first.
         * @param tasks
         * @param n
         * @return
         */
        public int leastInterval(char[] tasks, int n) {

            int[] map=new int[26];

            for(int i=0;i<tasks.length;i++){
                map[tasks[i]-'A']++;
            }
            Arrays.sort(map);

            int max=map[25]-1;
            int idles=max*n;

            for(int i=24;i>=0;i--){

                idles=idles-Math.min(max,map[i]);
            }

            if(idles<=0)
                return tasks.length;
            return  idles+tasks.length;

        }
    }


    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        PriorityQueue < Integer > queue = new PriorityQueue < > (26, Collections.reverseOrder());
        for (int f: map) {
            if (f > 0)
                queue.add(f);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List < Integer > temp = new ArrayList < > ();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1)
                        temp.add(queue.poll() - 1);
                    else
                        queue.poll();
                }
                time++;
                if (queue.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            for (int l: temp)
                queue.add(l);
        }
        return time;
    }
}
