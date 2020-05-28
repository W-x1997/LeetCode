package wx.leetcode;
import java.util.*;
public class Leetcode215 {
    class Solution {
        /**

         215. Kth Largest Element in an Array

         经典题 minheap即可 时间复杂度为nlogk
         **/
        public int findKthLargest(int[] nums, int k) {
            if(nums==null)return 0;
            PriorityQueue<Integer> queue=new PriorityQueue<Integer>(k,new Comparator<Integer>(){
                public int compare(Integer n1,Integer n2){
                    return n1-n2;
                }
            });

            for(int i=0;i<nums.length;i++){
                if(queue.size()<k){
                    queue.add(nums[i]);
                }else {

                    if(nums[i]>queue.peek()){
                        queue.poll();
                        queue.add(nums[i]);
                    }
                }


            }

            return queue.peek();



        }
    }
}
