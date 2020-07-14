package wx.leetcode;



public class Leetcode865 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        /**
         865. Smallest Subtree with all the Deepest Nodes
         和1123完全相同
         两边高度相同 即为目标结果
         **/
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            if (root == null )
                return null;

            int left = getHeight(root.left);
            int right = getHeight(root.right);
            if (left == right)
                return root;

            if (left > right)
                return subtreeWithAllDeepest(root.left);
            else
                return subtreeWithAllDeepest(root.right);

        }

        public int getHeight(TreeNode root){
            if (root == null) {
                return 0;
            }

            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
    }
}}
