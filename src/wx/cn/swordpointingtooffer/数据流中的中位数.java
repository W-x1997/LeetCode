package wx.cn.swordpointingtooffer;
import java.util.*;
public class 数据流中的中位数 {

    /**
     *
     * 题目描述
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
     * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
     *
     *
     * 思路：
     *
     * 用一个最大堆 和一个最小堆来做  构造如下
     *
     *    ************
     *      *********    最小堆
     *        *****
     *         ***
     *          *
     *
     *            *
     *           ***
     *          *****       最大堆
     *        *********
     *      ************
     *
     *      保证最小堆中的每一个元素都大于最大堆中的每一个元素
     *      按顺序向两个堆中插入数据，用一个计数标记来记录 奇偶
     *      奇数插入最大堆  偶数插入最小堆
     *      每次将num先与 两个堆中一个堆顶元素做比较
     *
     *
     *
     *
     *
     */

    public class Solution {
        PriorityQueue<Integer> min_heap=new PriorityQueue<Integer>();
        PriorityQueue<Integer>  max_heap=new PriorityQueue<Integer>(10,new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                return o2-o1;
            }
        });
        int count=0;

        public void Insert(Integer num) {
            count++;
            if(count%2==1){
                if(min_heap.isEmpty()){
                    max_heap.add(num);
                }else {
                    if(num<min_heap.peek()){
                        max_heap.add(num);
                    }else {
                        max_heap.add(min_heap.poll());
                        min_heap.add(num);
                    }

                }

            }else{
                if(max_heap.isEmpty()){
                    min_heap.add(num);
                }else {
                    if(num>max_heap.peek()){
                        min_heap.add(num);
                    }else {
                        min_heap.add(max_heap.poll());
                        max_heap.add(num);
                    }

                }


            }

        }

        public Double GetMedian() {
            if(count%2==1)return 1.0*max_heap.peek();
            return 1.0*(max_heap.peek()+min_heap.peek())/2;



        }


    }
}
