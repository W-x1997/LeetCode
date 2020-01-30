package wx.cn.swordpointingtooffer;

import java.util.HashMap;

import java.util.*;

public class 数组中超过一半的数字 {
    /**
     *
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     */

    public class Solution {
        public int MoreThanHalfNum_Solution(int [] num) {
            int len=num.length;
            int flag=0;// 0---> not found

            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
            for(int i=0;i<len;i++){
                if(map.containsKey(num[i])){
                    map.put(num[i],map.get(num[i])+1);
                }else{
                    map.put(num[i],1);
                }

                if(map.get(num[i])>len/2){
                    flag=1;
                    return num[i];
                }

            }

            return 0;

        }
    }

}
