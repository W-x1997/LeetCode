package wx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode173 {
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
    class BSTIterator {

        /**
         * I think I will use a preorder traverse
         * Use a list-array to store all elements
         */

        List<Integer> list;
        int index;

        public BSTIterator(TreeNode root) {
            list=new ArrayList<Integer>();
            index=0;
            dfs(root);

        }

        public void dfs(TreeNode root){
            if(root==null)
                return;
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }


        /** @return the next smallest number */
        public int next() {
            int node=list.get(index);
            index++;
            return node;

        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if(list.size()==0)
                return false;
            if(index>list.size()-1)//!
                return false;
            return true;
        }

    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

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
