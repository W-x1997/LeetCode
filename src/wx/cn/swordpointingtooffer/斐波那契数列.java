package wx.cn.swordpointingtooffer;

public class 斐波那契数列 {
    public class Solution {
        public int Fibonacci(int n) {
            if(n<=0)
                return 0;

            int []nums=new int[n+1];
            nums[0]=0;
            nums[1]=1;
            for(int i=2;i<=n;i++){
                nums[i]=nums[i-2]+nums[i-1];
            }

            return nums[n];
        }
    }
}
