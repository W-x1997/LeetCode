package wx.leetcode;

import java.util.HashMap;

public class Leetcode202 {
    /**
     * 202. Happy Number
     * Easy
     *
     * 1911
     *
     * 406
     *
     * Add to List
     *
     * Share
     * Write an algorithm to determine if a number n is "happy".
     *
     * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
     *
     * Return True if n is a happy number, and False if not.
     */
    class Solution {
        public boolean isHappy(int n) {
            if(n<=0)
                return false;

            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
            while(n>0){
                if(n==1)return true;
                if(map.containsKey(n))
                    break;
                map.put(n,1);

                n=calculate(n);
            }


            return false;

        }


        public int calculate(int n){
            int res=0;

            while(n>0){
                int cur=n%10;
                res=res+cur*cur;
                n=n/10;

            }

            return res;

        }

    }


}
