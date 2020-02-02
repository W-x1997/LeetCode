package wx.cn.swordpointingtooffer;

public class 连续自数组的最大和 {

    public class Solution {
        public int FindGreatestSumOfSubArray(int[] array) {
            if(array==null||array.length==0)
                return 0;

            int max=Integer.MIN_VALUE;
            int cur=0;
            for(int i=0;i<array.length;i++){

                if(cur<=0){
                    cur=array[i];

                } else
                    cur=cur+array[i];
                if(cur>max){
                    max=cur;
                }
            }


            return max;


        }
    }
}
