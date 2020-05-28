package wx.leetcode;
import java.util.*;

public class Leetcode347 {

    class Solution {

        /**
         347. Top K Frequent Elements
         依然是经典的最小堆
         用一个map来存储 次数 根据map中次数来自定义排序

         最小堆 找 最大的k个  如果比堆顶大 则poll推出顶部元素 然后push当前
         **/
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<nums.length;i++){
                if(map.containsKey(nums[i])){
                    map.put(nums[i],map.get(nums[i])+1);
                }else
                    map.put(nums[i],1);

            }



            PriorityQueue<Integer> queue=new PriorityQueue<Integer>(k,new Comparator<Integer>(){
                public int compare(Integer n1,Integer n2){


                    return map.get(n1)-map.get(n2);
                }
            });

            for(int n:map.keySet()){
                int value=map.get(n);
                if(queue.size()<k){
                    queue.add(n);
                }else {
                    if(value>map.get(queue.peek())){
                        queue.poll();
                        queue.add(n);
                    }
                }

            }

            int[] res=new int[queue.size()];

            int index=0;
            while(!queue.isEmpty()){
                res[index]=queue.poll();
                index++;
            }
            return res;


        }
    }
}
