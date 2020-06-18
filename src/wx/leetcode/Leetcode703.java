package wx.leetcode;
import java.util.*;
public class Leetcode703 {
    class KthLargest {
        //703. Kth Largest Element in a Stream
        PriorityQueue<Integer> queue;
        int k;
        public KthLargest(int k, int[] nums) {
            queue=new PriorityQueue<Integer>(new Comparator<Integer>(){
                public int compare(Integer n1,Integer n2){
                    return n1-n2;
                }
            });

            this.k=k;

            for(int i=0;i<nums.length;i++){
                this.add(nums[i]);
            }
        }

        public int add(int val) {
            if(queue.size()<k){
                queue.add(val);
                return queue.peek();
            }

            if(queue.peek()<val){
                queue.poll();
                queue.add(val);
                return queue.peek();
            }

            return queue.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
