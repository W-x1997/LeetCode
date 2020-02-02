package wx.cn.swordpointingtooffer;

public class 整数中1出现的个数 {

    public class Solution {
        public int NumberOf1Between1AndN_Solution(int n) {
            if(n<=0)
                return 0;
            int count=0;
            for(int i=1;i<=n;i++){
                String str=String.valueOf(i);
                for(int j=0;j<str.length();j++){
                    if(str.charAt(j)=='1')
                        count++;
                }
            }
            return count;


        }
    }

  class Solution2 {
        public int NumberOf1Between1AndN_Solution(int n) {
            if(n <= 0)
                return 0;
            int count = 0;
            for(long i = 1; i <= n; i *= 10){
                long diviver = i * 10;
                count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
            }
            return count;
        }
    }
}
