//package wx.leetcode;
//
//public class Leetcode1026 {
//    /**
//     * Definition for a binary tree node.
//     * public class TreeNode {
//     *     int val;
//     *     TreeNode left;
//     *     TreeNode right;
//     *     TreeNode() {}
//     *     TreeNode(int val) { this.val = val; }
//     *     TreeNode(int val, TreeNode left, TreeNode right) {
//     *         this.val = val;
//     *         this.left = left;
//     *         this.right = right;
//     *     }
//     * }
//     */
//    class Solution {
//        /**
//         1026. Maximum Difference Between Node and Ancestor
//         **/
//        int res = 0;
//        public int maxAncestorDiff(TreeNode root) {
//            if (root == null)
//                return 0;
//
//            dfs(root, root.val, root.val);
//            return res;
//        }
//
//        public void dfs(TreeNode node, int min, int max) {
//            if (node == null)
//                return;
//
//            if (node.val > max){
//                max = node.val;
//                res = Math.max(res, Math.abs(max - min));
//            }
//
//            if (node.val < min){
//                min = node.val;
//                res = Math.max(res, Math.abs(max - min));
//            }
//
//            dfs(node.left, min, max);
//            dfs(node.right, min, max);
//
//        }
//    }
//}
