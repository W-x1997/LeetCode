package wx.leetcode;
import java.util.*;

public class Leetcode295 {
    class MedianFinder {

        /**
         295. Find Median from Data Stream
         Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
         **/


        /**
         * 用两个栈 来实现
         * 最大堆+最小堆
         *
         * 保证最小堆中每个元素都大于最大堆中任意元素
         *
         * 每次插入一个 第偶数个插入最小堆 第奇数个插入最大堆 插入之前先与另一个堆顶元素比较
         *
         *
         *      *    ************
         *      *      *********    最小堆
         *      *        *****
         *      *         ***
         *      *          *
         *      *
         *      *            *
         *      *           ***
         *      *          *****       最大堆
         *      *        *********
         *      *      ************
         *
         */
        PriorityQueue<Integer> minheap;
        PriorityQueue<Integer> maxheap;
        int data_n;
        /** initialize your data structure here. */
        public MedianFinder() {
            data_n=0;
            minheap=new PriorityQueue<Integer>(new Comparator<Integer>(){
                public int compare(Integer n1,Integer n2){
                    return n1-n2;
                }
            });

            maxheap=new PriorityQueue<Integer>(new Comparator<Integer>(){
                public int compare(Integer n1,Integer n2){
                    return n2-n1;
                }
            });

        }

        public void addNum(int num) {
            if(data_n%2==0){  //第偶数个 放上面最小堆       保证最小堆每个元素都大于最大堆中的元素
                if(maxheap.isEmpty()||num>maxheap.peek()){
                    minheap.add(num);
                }else{
                    minheap.add(maxheap.poll());
                    maxheap.add(num);
                }

            } else{  //第奇数个 放下面的最大堆
                if(minheap.isEmpty()||num<minheap.peek()){
                    maxheap.add(num);
                }else {
                    maxheap.add(minheap.poll());
                    minheap.add(num);
                }

            }
            data_n++;

        }

        public double findMedian() {
            if(data_n%2==1)
                return  minheap.peek();
            else
                return 1.0*(maxheap.peek()+minheap.peek())/2;


        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
