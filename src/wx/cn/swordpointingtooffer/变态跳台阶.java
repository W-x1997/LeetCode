package wx.cn.swordpointingtooffer;

public class 变态跳台阶 {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     */

    public class Solution {
        public int JumpFloorII(int target) {
            if(target<=2)
                return target;
            int n[]=new int[target+1];
            n[0]=0;
            n[1]=1;
            n[2]=2;
            n[3]=4;
            for(int i=4;i<=target;i++){

                for(int j=i-1;j>=1;j--){
                    n[i]=n[i]+n[j];
                }
                n[i]++;
            }
            return n[target];

        }
    }
}
