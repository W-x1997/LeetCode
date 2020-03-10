package wx.leetcode;

public class Leetcode543 {
    /**
     * 543. Diameter of Binary Tree
     * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
     *
     * Example:
     * Given a binary tree
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
     *
     * Note: The length of path between two nodes is represented by the number of edges between them.
     *
     * 通过次数28,981提交次数59,990
     */

    class Solution {
        int ans;
        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }
        public int depth(TreeNode node) {
            if (node == null) return 0; // 访问到空节点了，返回0
            int L = depth(node.left); // 左儿子为根的子树的深度
            int R = depth(node.right); // 右儿子为根的子树的深度
            ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
            return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
        }
    }

}
