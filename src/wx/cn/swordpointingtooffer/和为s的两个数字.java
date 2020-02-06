package wx.cn.swordpointingtooffer;
import java.util.*;

public class 和为s的两个数字 {

    /**
     *
     *输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     *
     *
     * solution1:hashmap
     * solution2: 双指针
     */
    public class Solution {
        public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
            ArrayList<Integer> res=new ArrayList<Integer>();
            int cur_max=Integer.MAX_VALUE;
            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
            for(int i=0;i<array.length;i++){
                if(map.containsKey(sum-array[i])){
                    int tmp_max=(sum-array[i])*array[i];
                    if(tmp_max<cur_max){
                        res=new ArrayList<Integer>();
                        res.add(array[i]);
                        res.add(sum-array[i]);
                    }
                }else {
                    map.put(array[i],1);
                }

            }



            Collections.sort(res);
            return res;
        }
    }



    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i=0,j=array.length-1;
        while(i<j){
            if(array[i]+array[j]==sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }else if(array[i]+array[j]>sum){
                j--;
            }else{
                i++;
            }

        }
        return list;
    }
}
