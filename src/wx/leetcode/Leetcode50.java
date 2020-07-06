package wx.leetcode;

public class Leetcode50 {
    class Solution {
        /**
         50. Pow(x, n)
         Implement pow(x, n), which calculates x raised to the power n (xn).
         **/
        public double myPow(double x, int n) {
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            double ans = 1;
            double current_product = x;
            for (long i = N; i > 0; i /= 2) {
                if ((i % 2) == 1) {
                    ans = ans * current_product;
                }
                current_product = current_product * current_product;
            }
            return ans;


        }
    }


}
