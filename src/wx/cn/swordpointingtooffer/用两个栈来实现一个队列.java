package wx.cn.swordpointingtooffer;
import java.util.Stack;

public class 用两个栈来实现一个队列 {


    /**
     *
     *  用两个stack
     *  push： 直接将数据push进第一个stack
     *
     *  pop： 如果stack2不为空直接pop stact2
     *           stack2若为空 则先将stack1中所有数据push进stack2 然后再从stack2中pop
     *
     *
     */

    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if(stack1.isEmpty()&&stack2.isEmpty())
                return -1;

            if(!stack2.isEmpty()){
                return stack2.pop();
            }
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }

            return stack2.pop();


        }
    }
}
