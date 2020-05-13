package wx.leetcode;

import java.util.Stack;

public class Leetcode739 {
    /**
     *
     * 739. Daily Temperatures
     * Medium
     *
     * 2463
     *
     * 74
     *
     * Add to List
     *
     * Share
     * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
     *
     * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
     */


    class Solution {
        /**
         * 单调栈！
         * 如果温度递减 则直接入栈
         * 否则 按顺序pop  当前i 即为pop 元素的warmer day
         *
         * @param
         * @return
         */
        class Solution2 {
            public int[] dailyTemperatures(int[] T) {
                if(T==null||T.length==0)
                    return null;
                int res[]=new int[T.length];

                Stack<Integer> stack=new Stack<>();

                for(int i=0;i<T.length;i++){
                    if(stack.isEmpty()){
                        stack.push(i);
                    }else if(T[stack.peek()]>=T[i]){
                        stack.push(i);
                    }else {
                        while(!stack.isEmpty()&&T[stack.peek()]<T[i]){
                            res[stack.peek()]=i-stack.peek();
                            stack.pop();
                        }
                        stack.push(i);

                    }



                }


                return res;
            }
        }

        public int[] dailyTemperatures2(int[] T) {
            if(T==null||T.length==0)
                return null;
            int res[]=new int[T.length];

            for(int i=0;i<T.length;i++){
                int count=1;
                for(int j=i+1;j<T.length;j++){
                    if(T[i]>=T[j]){
                        count++;
                    }else{
                        res[i]=count;
                        break;
                    }
                }


            }


            return res;
        }
    }
}
