package wx.leetcode;

public class Leetcode263 {
    class Solution {
        public boolean isUgly(int num) {
/**
 263. Ugly Number

 Write a program to check whether a given number is an ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 **/

            if (num <= 0)
                return false;


            while(num % 5 == 0 )
                num = num / 5;

            while(num % 3 == 0)
                num = num / 3;

            while(num % 2 == 0)
                num = num / 2 ;



            if (num == 1)
                return true;

            return false;


        }
    }
}
