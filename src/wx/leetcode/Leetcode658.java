package wx.leetcode;
import java.util.*;
public class Leetcode658 {
    class Solution {

        /**
         658. Find K Closest Elements
         Given a sorted array arr, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
         **/


        /**
         这题要注意！！

         存入heap的是当前arr[i]与x的差值

         所以比较的时候 priority优先级比较 比较绝对值即可

         **/
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> res=new ArrayList();
            if (arr == null || arr.length < k) {
                return res;
            }
            //最大堆
            PriorityQueue<Integer> queue=new PriorityQueue<Integer>(new Comparator<Integer>(){
                public int compare(Integer a, Integer b){
                    if (Math.abs(a) != Math.abs(b)) { //！！！重点！！
                        return Math.abs(b) - Math.abs(a);
                    } else {
                        return b - a;
                    }
                }
            });


            for(int i=0;i<arr.length;i++){
                int gap=arr[i]-x;
                queue.offer(gap);

                if(queue.size()>k)
                    queue.poll();

            }

            while(!queue.isEmpty()){
                res.add(queue.poll()+x);
            }

            Collections.sort(res);


            return res;
        }



    }
}
