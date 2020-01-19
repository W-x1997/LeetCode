package wx.cn.swordpointingtooffer;

public class 跳台阶 {

    /**
     *
     *一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     *
     */
    public class Solution {
        public int JumpFloor(int target) {
            if(target<=2)
                return target;

            int nums[]=new int[target+1];

            nums[0]=0;
            nums[1]=1;
            nums[2]=2;
            for(int i=3;i<=target;i++){
                nums[i]=nums[i-1]+nums[i-2];
            }
            return nums[target];

        }
    }
}
