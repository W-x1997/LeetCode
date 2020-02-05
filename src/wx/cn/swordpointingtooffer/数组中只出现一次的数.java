package wx.cn.swordpointingtooffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 数组中只出现一次的数 {

    //num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

    public class Solution {
        public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
            if(array==null||array.length==0){
                return;
            }
            List<Integer> list=new ArrayList();
            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
            for(int i=0;i<array.length;i++){
                if(map.containsKey(array[i]))
                    map.put(array[i],map.get(array[i])+1);
                else
                    map.put(array[i],1);
            }

            for(int n:map.keySet()){
                if(map.get(n)==1){
                    list.add(n);
                }

            }
            num1[0]=list.get(0);
            num2[0]=list.get(1);



        }
    }
}
