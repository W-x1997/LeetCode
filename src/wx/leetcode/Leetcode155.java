package wx.leetcode;

import java.util.Stack;

public class Leetcode155 {
    /**
     *
     * 155. Min Stack
     * Easy
     *
     * 3124
     *
     * 302
     *
     * Add to List
     *
     * Share
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     *
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     */
    class MinStack {


        /**
         * we use 2 stacks. The first stack is used to store all integers and push every time we meet an integer.
         * the 2nd stack is min_stack
         * each time if the integer is smaller than the peek of our min_stack, we push it into our min_stack ,otherwise just skip it.
         *
         */
        Stack<Integer> stack;
        Stack<Integer> min_stack;


        /** initialize your data structure here. */
        public MinStack() {
            stack=new Stack<Integer>();
            min_stack=new Stack<Integer>();
            // min=Integer.MAX_VALUE;
        }

        public void push(int x) {
            stack.push(x);
            if(min_stack.isEmpty()||min_stack.peek()>=x){
                min_stack.push(x);
            }

        }

        public void pop() {
            int n=stack.pop();
            if(n==min_stack.peek())
                min_stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
