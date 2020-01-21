package wx.cn.swordpointingtooffer;

public class 二进制中1的个数 {
    /**
     *   >>>   无符号右移
     *
     */

    public class Solution {
        public int NumberOf1(int n) {
            int count = 0;
            while(n != 0){
                count += (n & 1); //每次判断最低位是否为1
                n >>>= 1;
            }
            return count;
        }
    }
}
