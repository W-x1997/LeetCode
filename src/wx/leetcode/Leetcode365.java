package wx.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode365 {
    /**
     * 365. Water and Jug Problem
     * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
     *
     * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
     *
     * Operations allowed:
     *
     * Fill any of the jugs completely with water.
     * Empty any of the jugs.
     * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
     */
    class Solution {

        public boolean canMeasureWater(int x, int y, int z) {
            if (z > x + y)
                return false;
            if (z == 0)
                return true;
            int res = gcd(x, y);
            return z % res == 0;

        }
        public int gcd(int x, int y) {
            while (y != 0) {
                int temp = y;
                y = x % y;
                x = temp;
            }
            return x;
        }
        public boolean canMeasureWater2(int x, int y, int z) {
            if(x>y)
                return canMeasureWater(y,x,z);
            if(z > x+y)
                return false;
            Set<Integer> failSet = new HashSet<>();

            int resX = 0;
            int resY = 0;

            while(true){
                int res = resX * x + resY * y;
                if(failSet.contains(res))
                    return false;
                if(res == z){
                    return true;
                }else if(res < z){
                    resY++;
                }else{
                    resX--;
                }
                failSet.add(res);
            }
        }

    }
}
