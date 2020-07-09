package wx.leetcode;
import java.util.*;
public class Leetcode662 {
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
         662. Maximum Width of Binary Tree

         Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
         The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

         Example 1:

         Input:

         1
         /   \
         3     2
         / \     \
         5   3     9

         Output: 4
         Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
         **/
        public int widthOfBinaryTree(TreeNode root) {
            /**
             好题啊！！
             这道题巧妙的利用 二叉树性质  即若当前节点序号为n 左节点为2*n 右节点为2*n+1
             因为我们要的是下表 所以 节点的值无关紧要
             这道题方法就是 把每一个存在的值 改为它本身的序号 然后用一个双向队列 存储 进行层次遍历即可

             change the val of node to be the index to save space. The value is useless. All we need is just the index.

             **/
            if (root == null)
                return 0;

            Deque<TreeNode> queue = new LinkedList<>();
            root.val = 1;
            queue.add(root);
            int max = 1;
            while (!queue.isEmpty()){
                int size = queue.size();
                max = Math.max(max, queue.peekLast().val - queue.peekFirst().val + 1);

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null){
                        node.left.val = node.val * 2;
                        queue.add(node.left);
                    }
                    if (node.right != null){
                        node.right.val = node.val * 2 + 1;
                        queue.add(node.right);
                    }

                }

            }
            return max;


        }
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
