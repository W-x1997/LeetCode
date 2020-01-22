package wx.cn.swordpointingtooffer;


import java.util.Stack;
public class 包含min的栈 {
    /**
     *
     * 题目描述
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     *
     *
     * 用两个栈1 2 来实现
     *
     * push的时候 先压入1 如果2 为空则同时压入 否则看压入的值是否小于2的peek如果小于则压入2
     * pop的时候 看1 要pop的数是否和2 的peek相等 若相等则pop
     *
     *
     */




    public class Solution {
        Stack<Integer> stack1=new Stack<Integer>();
        Stack<Integer> stack2=new Stack<Integer>();


        public void push(int node) {
            stack1.push(node);
            if(stack2.isEmpty())
                stack2.push(node);
            else{
                if(stack2.peek()>=node)
                    stack2.push(node);
            }
        }

        public void pop() {
            if(stack1.peek()==stack2.peek())
                stack2.pop();
            stack1.pop();

        }

        public int top() {
            return stack1.peek();

        }

        public int min() {
            return stack2.peek();
        }
    }
}
