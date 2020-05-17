package wx.leetcode;

public class Leetcode59 {
    /**
     * 59. Spiral Matrix II
     * Medium
     *
     * 871
     *
     * 105
     *
     * Add to List
     *
     * Share
     * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
     */
    class Solution {
        public int[][] generateMatrix(int n) {

            /**
             *
             * 和leetcode54 完全相同
             */
            int[][] matrix=new int[n][n];



            int left=0,right=matrix[0].length-1;
            int top=0,bottom=matrix.length-1;
            int cur=1;

            while(left<=right&&top<=bottom){
                for(int i=left;i<=right;i++){
                    matrix[top][i]=cur;
                    cur++;
                }
                top++;
                if(top>bottom)break;


                for(int i=top;i<=bottom;i++){
                    matrix[i][right]=cur;
                    cur++;
                }
                right--;
                if(right<left)break;

                for(int i=right;i>=left;i--){
                    matrix[bottom][i]=cur;
                    cur++;
                }
                bottom--;
                if(bottom<top)break;

                for(int i=bottom;i>=top;i--){
                    matrix[i][left]=cur;
                    cur++;
                }
                left++;
                if(left>right)break;

            }


            return matrix;

        }
    }

}
