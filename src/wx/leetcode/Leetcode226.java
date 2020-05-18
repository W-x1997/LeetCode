package wx.leetcode;

public class Leetcode226 {
    /**
     *
     * 226. Invert Binary Tree
     * Easy
     *
     * 2884
     *
     * 43
     *
     * Add to List
     *
     * Share
     * Invert a binary tree.
     *
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

        public TreeNode invertTree(TreeNode root) {
            if (root != null){
                TreeNode temp = root.left;
                root.left = invertTree(root.right);
                root.right = invertTree(temp);
            }
            return root;
        }
//
//
//        public TreeNode invertTree(TreeNode root) {
//            if(root==null)
//                return null;
//
//            helper(root);
//            return root;
//        }
//
//
//        public void helper(TreeNode root){
//            if(root==null){
//                return;
//            }
//
//            TreeNode tmp=root.left;
//            root.left=root.right;
//            root.right=tmp;
//
//            helper(root.left);
//            helper(root.right);
//
//        }
    }


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

}
