package wx.leetcode;



public class Leetcode235 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */


    /**
     235. Lowest Common Ancestor of a Binary Search Tree
     Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

     According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

     Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]


     **/
    class Solution {

        /**
         we need to use the property of BST and use recursive.
         If this node is the lowest ancestor, then p and q  must be settled at different sides.


         **/
        public TreeNode lowestCommonAncestor(TreeNode root, Leetcode173.TreeNode p, Leetcode173.TreeNode q) {
            if(root==null)return null;
            if((root.val-p.val)*(root.val-q.val)<=0){
                return root;
            }else if(root.val<p.val&&root.val<q.val){
                return  lowestCommonAncestor(root.right,p,q);
            }else if(root.val>p.val&&root.val>q.val){
                return  lowestCommonAncestor(root.left,p,q);
            }

            return null;

        }
    }

    class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
}
