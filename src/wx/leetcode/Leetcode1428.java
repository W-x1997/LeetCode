//package wx.leetcode;
//
//public class Leetcode1428 {
//    /**
//     * // This is the BinaryMatrix's API interface.
//     * // You should not implement it, or speculate about its implementation
//     * interface BinaryMatrix {
//     *     public int get(int row, int col) {}
//     *     public List<Integer> dimensions {}
//     * };
//     */
//
//    /**
//     1428. Leftmost Column with at Least a One
//     (This problem is an interactive problem.)
//
//     A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
//
//     Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
//
//     You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
//
//     BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
//     BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.
//     Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
//
//     For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
//     **/
//    class Solution {
//
//
//        /**
//         好题！
//         从右上交往左下搜索
//
//         注意！ 最后返回的currentcol要+1
//         **/
//        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
//
//            int rows = binaryMatrix.dimensions().get(0);
//            int cols = binaryMatrix.dimensions().get(1);
//
//            // Set pointers to the top-right corner.
//            int currentRow = 0;
//            int currentCol = cols - 1;
//
//            while (currentRow < rows && currentCol >= 0) {
//                if (binaryMatrix.get(currentRow, currentCol) == 0){
//                    currentRow++;
//                }else{
//                    currentCol--;
//                }
//            }
//
//            if (currentCol == cols - 1)
//                return -1;
//
//            return currentCol + 1;
//
//        }
//    }
//}
