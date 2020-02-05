package wx.cn.swordpointingtooffer;

public class 数字在排序数组中出现的次数 {

    public class Solution {
        public int GetNumberOfK(int [] array , int k) {
            int res=0;
            if(array==null||array.length==0)
                return res;

            for(int i=0;i<array.length;i++){
                if(array[i]==k)
                    res++;
            }

            return res;

        }
    }
}
