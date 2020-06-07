package wx.leetcode;

public class Leetcode7 {
    class Solution {
        public int reverse(int x) {
            double r=0;
            while(x!=0) {
                r*=10;
                r+=x%10;
                x=x/10;
            }
            if(r>=Integer.MAX_VALUE||r<=Integer.MIN_VALUE)
                return 0;
            return (int)r;
        }
    }
}
