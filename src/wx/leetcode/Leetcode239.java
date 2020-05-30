package wx.leetcode;
import java.util.*;
public class Leetcode239 {
    class Solution {

        /**
         239. Sliding Window Maximum
         Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

         *  思路：
         *  这道题双向链表来解决。 需要注意的是！！放入queue的是 下标 不是数值  加入list的时候加入的数值 注意转换
         *
         *  两个循环！ 分别看 队首元素是否过期
         *                  队末元素是否要删除


         **/
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums==null||nums.length==0)
                return nums;
            List<Integer> list=new ArrayList<>();

            Deque<Integer> queue=new LinkedList<>();

            for(int i=0;i<nums.length;i++){

                while(!queue.isEmpty()&&(queue.peekFirst()+k<=i)){// compare the index
                    queue.pollFirst();
                }

                while(!queue.isEmpty()&&nums[queue.peekLast()]<nums[i]){ // compare the number
                    queue.pollLast();
                }

                queue.add(i);

                if(i>=k-1){
                    list.add(nums[queue.peekFirst()]);
                }


            }

            int[] res=new int[list.size()];
            for(int i=0;i<list.size();i++)
                res[i]=list.get(i);

            return res;
        }
    }
}
