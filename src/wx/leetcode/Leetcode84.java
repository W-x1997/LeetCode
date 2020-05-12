package wx.leetcode;

import java.util.Stack;

public class Leetcode84 {
    /**
     * 84. Largest Rectangle in Histogram
     * Hard
     *
     * 3199
     *
     * 77
     *
     * Add to List
     *
     * Share
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
     */
    class Solution {
        /**
         *
         * 我们维护一个栈。一开始，我们把 -1 放进栈的顶部来表示开始。初始化时，按照从左到右的顺序，我们不断将柱子的序号放进栈中，
         * 直到遇到相邻柱子呈下降关系，也就是 a[i-1] > a[i]a[i−1]>a[i] 。现在，我们开始将栈中的序号弹出，直到遇到 stack[j]stack[j]
         * 满足a\big[stack[j]\big] \leq a[i]a[stack[j]]≤a[i] 。每次我们弹出下标时，我们用弹出元素作为高形成的最大面积矩形的宽是当前元素与
         * stack[top-1]stack[top−1] 之间的那些柱子。也就是当我们弹出 stack[top]stack[top] 时，记当前元素在原数组中的下标为 i ，
         * 当前弹出元素为高的最大矩形面积为：
         *
         * (i-stack[top-1]-1) \times a\big[stack[top]\big].
         * (i−stack[top−1]−1)×a[stack[top]].
         *
         * 更进一步，当我们到达数组的尾部时，我们将栈中剩余元素全部弹出栈。在弹出每一个元素是，我们用下面的式子来求面积：
         * (stack[top]-stack[top-1]) \times a\big[stack[top]\big](stack[top]−stack[top−1])×a[stack[top]]，
         * 其中，stack[top]stack[top]表示刚刚被弹出的元素。因此，我们可以通过每次比较新计算的矩形面积来获得最大的矩形面积。
         *


         * @param heights
         * @return
         */
        public int largestRectangleArea(int[] heights) {

            Stack<Integer> stack=new Stack<Integer>();
            int maxarea=0;

            stack.push(-1);
            // stack.push(0);
            for(int i=0;i<heights.length;i++){
                while(stack.peek()!=-1&&heights[stack.peek()] >= heights[i]){
                    maxarea=Math.max(maxarea,heights[stack.pop()]*(i-stack.peek()-1));
                }


                stack.push(i);
            }

            while(stack.peek()!=-1){
                maxarea=Math.max(maxarea,heights[stack.pop()]*(heights.length-stack.peek()-1));
            }


            return maxarea;
        }
    }
}
