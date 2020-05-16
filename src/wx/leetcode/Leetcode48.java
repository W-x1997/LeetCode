package wx.leetcode;

public class Leetcode48 {
    class Solution {
        /**
         * 48. Rotate Image
         * Medium
         *
         * 2707
         *
         * 213
         *
         * Add to List
         *
         * Share
         * You are given an n x n 2D matrix representing an image.
         *
         * Rotate the image by 90 degrees (clockwise).
         * @param matrix
         */
        public void rotate(int[][] matrix) {
            /**
             *
             * 从外网内 依次旋转 即可
             */
            int n=matrix.length;
            for(int i=0;i<n/2;i++){ //一共要旋转n/2层
                for(int j=i;j<n-i-1;j++){  //每一层从头走到尾巴
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[n-1-j][i];     // 行变为列    列变为后者行的n-1-lie
                    matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                    matrix[j][n-1-i]=temp;
                }
            }
        }
    }
}
