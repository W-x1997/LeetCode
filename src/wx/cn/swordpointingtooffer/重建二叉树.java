package wx.cn.swordpointingtooffer;

public class 重建二叉树 {
    /**
     *
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     *  在中序遍历中查找  前序遍历的第一个元素 作为根结点。 然后根据index在中序遍历的位置，分为左子树和右子树，再进行重复的递归操作。
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public class Solution {
            public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
                if (pre == null || in == null)
                    return null;

                return createTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
            }


            public TreeNode createTree(int[] pre, int ps, int pe, int[] in, int is, int ie) {

                if (ps > pe || is > ie)
                    return null;
                TreeNode root = new TreeNode(pre[ps]);

                int index = is;
                for (int i = is; i <= ie; i++) {
                    if (in[i] == root.val) {
                        index = i;
                        break;
                    }

                }

                int len = index - is;
                root.left = createTree(pre, ps + 1, ps + len, in, is, index - 1);
                root.right = createTree(pre, ps + len + 1, pe, in, index + 1, ie);

                return root;


            }
        }
    }
}