package wx.cn.swordpointingtooffer;

public class 丑数 {
    /**
     *
     * 题目描述
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     *
     *
     * 用三个指针来表示三条队列 即可
     *
     * 注意下表cur是从1 开始
     * 最后第n个丑数下表为index-1 因为第一个丑数为1 放在下标为0的数组中
     *
     */

    public class Solution {
        public int GetUglyNumber_Solution(int index) {
            if(index<=0)
                return 0;

            int[] res=new int[index];
            res[0]=1;
            if(index <= 0)return 0;
            int p2=0,p3=0,p5=0;
            int cur=1;
            while(cur<index){
                int value=Math.min(Math.min(res[p2]*2,res[p3]*3),res[p5]*5);
                res[cur]=value;
                if(value==res[p2]*2)
                    p2++;
                if(value==res[p3]*3)
                    p3++;
                if(value==res[p5]*5)
                    p5++;

                cur++;
            }

            return res[index-1];
        }
    }
}
