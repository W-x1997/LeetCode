package wx.leetcode;

public class Leetcode01_07 {
    /**
     *
     * Given an image represented by an N x N matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
     *
     *  
     *
     * Example 1:
     *
     * Given matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * Rotate the matrix in place. It becomes:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     *
     * 作为例子，先将其通过水平轴翻转得到：
     *
     *  5  1  9 11                 15 14 12 16
     *  2  4  8 10                 13  3  6  7
     * ------------   =水平翻转=>   ------------
     * 13  3  6  7                  2  4  8 10
     * 15 14 12 16                  5  1  9 11
     * 再根据主对角线 \backslash\ 翻转得到：
     *
     * 15 14 12 16                   15 13  2  5
     * 13  3  6  7   =主对角线翻转=>   14  3  4  1
     *  2  4  8 10                   12  6  8  9
     *  5  1  9 11                   16  7 10 11
     *
     *
     */
    class Solution {
        public void rotate(int[][] matrix) {
            int n=matrix.length;
            for(int i=0;i<n/2;i++){
                for(int j=0;j<n;j++){
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[n-i-1][j];
                    matrix[n-i-1][j]=temp;
                }
            }


            for(int i=0;i<n;i++){
                for(int j=0;j<i;j++){
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }

        }
    }
}
