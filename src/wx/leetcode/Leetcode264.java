package wx.leetcode;
import java.util.*
public class Leetcode264 {
    class Solution {
        /**
         Ugly Number II


         Write a program to find the n-th ugly number.
         Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

         Example:
         Input: n = 10
         Output: 12
         Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.


         严格来说 是一道dp 用三个指针分别标记三个位置 每次分别乘以2，3，5 每次取最小值

         **/
        public int nthUglyNumber(int n) {
            List<Integer> list = new ArrayList();
            int p2 = 0;
            int p3 = 0;
            int p5 = 0;

            list.add(1);
            for(int i=1;i<n;i++){
                int target = Math.min(list.get(p2)*2, Math.min(list.get(p3)*3, list.get(p5)*5));
                if(target == list.get(p2)*2)
                    p2++;
                if (target == list.get(p3)*3)
                    p3++;
                if (target == list.get(p5)*5)
                    p5++;

                list.add(target);


            }

            return list.get(list.size()-1);

        }
    }

}
