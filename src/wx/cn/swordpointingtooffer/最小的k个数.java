package wx.cn.swordpointingtooffer;
import java.util.*;
public class 最小的k个数 {

    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     *
     *
     *
     * 最大堆 或者 最小堆 或者排序
     */


    public class Solution {//最小堆
        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            ArrayList<Integer> res=new ArrayList<Integer>();
            if(input==null||input.length==0||k>input.length)
                return res;
            PriorityQueue<Integer> queue=new PriorityQueue<Integer>(input.length,new Comparator<Integer>(){

                public int compare(Integer n1,Integer n2){
                    return n1-n2;
                }
            });
            for(int i=0;i<input.length;i++){
                queue.add(input[i]);
            }

            for(int i=0;i<k;i++){
                res.add(queue.poll());
            }

            return res;
        }
    }
}

 class Solution {//最大堆
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(input==null||input.length==0||k>input.length||k<=0)
            return res;
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(k,new Comparator<Integer>(){

            public int compare(Integer n1,Integer n2){
                return n2-n1;
            }
        });
        for(int i=0;i<input.length;i++){
            if(queue.size()!=k)
                queue.add(input[i]);
            else{
                if(queue.peek()>input[i]){
                    queue.poll();
                    queue.add(input[i]);
                }
            }

        }

        for(int i=0;i<k;i++){
            res.add(queue.poll());
        }

        return res;
    }
}