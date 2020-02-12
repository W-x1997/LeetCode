package wx.cn.swordpointingtooffer;
import java.util.*;
public class 滑动窗口的最大值 {



    /**
     *
     *
     * 题目描述
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
     * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
     * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     *
     *
     *
     *
     *  思路：
     *  这道题双向链表来解决。 需要注意的是！！放入queue的是 下标 不是数值  加入list的时候加入的数值 注意转换
     *
     *  两个循环！ 分别看 队首元素是否过期
     *                  队末元素是否要删除
     *
     *
     */
    public class Solution {

        public ArrayList<Integer> maxInWindows(int [] num, int size){
            ArrayList<Integer> res=new ArrayList();
            if(num==null||num.length==0||size<=0)
                return res;


            Deque<Integer> queue=new LinkedList();
            for(int i=0;i<num.length;i++){

                while(!queue.isEmpty()&&i>queue.peekFirst()+size-1){
                    queue.pollFirst();
                }

                while(!queue.isEmpty()&&num[queue.peekLast()]<num[i]){
                    queue.pollLast();
                }
                queue.add(i);

                if(i>=size-1)
                    res.add(num[queue.peekFirst()]);



            }


            return res;
        }
    }
}
