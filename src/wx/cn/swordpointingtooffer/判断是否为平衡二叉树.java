package wx.cn.swordpointingtooffer;

public class 判断是否为平衡二叉树 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        public class Solution {


            public boolean IsBalanced_Solution(TreeNode root) {
                if (root == null)
                    return true;
                int left_depth = depth(root.left);
                int right_depth = depth(root.right);

                if (Math.abs(left_depth - right_depth) > 1)
                    return false;
                return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);

            }


            public int depth(TreeNode node) {
                if (node == null)
                    return 0;

                int left = depth(node.left);
                int right = depth(node.right);

                return left < right ? (right + 1) : (left + 1);

            }
        }
    }
}