package wx.leetcode;

import java.util.Stack;

public class Leetcode85 {

    /**
     * 85. Maximal Rectangle
     * Hard
     *
     * 2435
     *
     * 61
     *
     * Add to List
     *
     * Share
     * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
     *
     * Example:
     *
     * Input:
     * [
     *   ["1","0","1","0","0"],
     *   ["1","0","1","1","1"],
     *   ["1","1","1","1","1"],
     *   ["1","0","0","1","0"]
     * ]
     * Output: 6
     */
    class Solution {

        /**
         *
         * 可转换为leetcode 84
         * 利用一个数组 一次遍历每一行 让每一行作为起始行 调用方法计算最大长方形面积
         *
         *
         *
         *
         * @param matrix
         * @return
         */
        public int maximalRectangle(char[][] matrix) {
            if(matrix==null||matrix.length==0||matrix[0].length==0)
                return 0;
            int maxR=0;
            int[] heights=new int[matrix[0].length];

            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j]=='1'){
                        heights[j]=heights[j]+1;
                    }else{
                        heights[j]=0;  // tricky！
                    }


                }
                maxR=Math.max(maxR,maxArea(heights));

            }

            return maxR;
        }



        public int maxArea(int[] heights){
            int maxArea=0;
            Stack<Integer> stack=new Stack();
            stack.push(-1);

            for(int i=0;i<heights.length;i++){
                while(stack.peek()!=-1&&heights[stack.peek()]>=heights[i]){
                    maxArea=Math.max(maxArea,heights[stack.pop()]*(i-stack.peek()-1));
                    // stack.pop();
                }

                stack.push(i);

            }


            while(stack.peek()!=-1){
                maxArea=Math.max(maxArea,heights[stack.pop()]*(heights.length-stack.peek()-1));
                //  stack.pop();

            }




            return maxArea;
        }
    }
}
