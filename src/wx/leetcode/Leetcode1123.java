//package wx.leetcode;
//
//public class Leetcode1123 {
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
//        /**1123. Lowest Common Ancestor of Deepest Leaves
//
//
//         The node of a binary tree is a leaf if and only if it has no children
//         The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d+1.
//         The lowest common ancestor of a set S of nodes is the node A with the largest depth such that every node in S is in the subtree with root A.
//         **/
//        /**
//         找最深叶节点的父节点
//         找深度 最深的 遍历即可
//         如果左右深度相同 就返回
//         否则 返回深度大的
//         **/
//        public TreeNode lcaDeepestLeaves(TreeNode root) {
//            if (root == null)
//                return null;
//
//            int left = getHeight(root.left);
//            int right = getHeight(root.right);
//            if (left == right)
//                return root;
//
//            if (left > right)
//                return lcaDeepestLeaves(root.left);
//            else
//                return lcaDeepestLeaves(root.right);
//
//        }
//
//
//        public int getHeight(TreeNode root){
//            if (root == null) {
//                return 0;
//            }
//
//            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
//        }
//    }
//}
