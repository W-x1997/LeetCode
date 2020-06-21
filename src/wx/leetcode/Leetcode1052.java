package wx.leetcode;

public class Leetcode1052 {
    class Solution {
        /**
         1052. Grumpy Bookstore Owner
         Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.

         On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.

         The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.

         Return the maximum number of customers that can be satisfied throughout the day.


         **/


        /**

         Sliding window
         首先把所有为0的直接相加
         之后 滑动窗口 如果为grumpy为1 则加上 否则跳过
         注意 判断删除 如果坐标为i-X的grumpy为0 则移动时要删除
         **/
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {
            int res=0;
            int sum=0;



            for(int i=0;i<customers.length;i++){
                if(grumpy[i]==0){
                    sum=sum+customers[i];
                }

            }

            for(int i=0;i<customers.length;i++){
                if(grumpy[i]==1){
                    sum=sum+customers[i];

                }

                if(i>=X&&grumpy[i-X]==1){
                    sum=sum-customers[i-X];
                }

                res=Math.max(res,sum);
            }

            return res;
        }
    }
}
