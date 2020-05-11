package wx.leetcode;

public class Leetcode134 {

    /**
     * 134. Gas Station
     * Medium
     *
     * 1418
     *
     * 365
     *
     * Add to List
     *
     * Share
     * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
     *
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
     *
     * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
     */



    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int total_gas=0;
            int cur_gas=0;
            int start_point=0;

            for(int i=0;i<gas.length;i++){
                total_gas=total_gas+gas[i]-cost[i];
                cur_gas=cur_gas+gas[i]-cost[i];

                if(cur_gas<0){   //if we couldn't get there
                    start_point=i+1; //Pick up the next station as the starting one.
                    cur_gas=0;   //start with an empty tank
                }


            }

            if(total_gas<0)return -1;   //check if we could get the circuit
            return start_point;


        }


    }
}
