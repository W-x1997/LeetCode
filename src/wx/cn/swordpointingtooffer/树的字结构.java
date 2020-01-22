package wx.cn.swordpointingtooffer;

/**
 *
 *
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 判断当前两结点值是否相等 相等就进入下层递归
 * 否则 递归A的左右子树
 *
 *
 */

public class 树的字结构 {


    public class Solution {

        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;

            }

        }

        public boolean HasSubtree(TreeNode root1,TreeNode root2) {
            if(root2==null){
                return false;
            }

            return isEqual(root1,root2);

        }

        public boolean isEqual(TreeNode root1,TreeNode root2){
            if(root2==null)return true;
            if(root1==null)return false;


            if(root1.val==root2.val){
                boolean k=isEqual(root1.left,root2.left)&&isEqual(root1.right,root2.right);
                if(k){

                    return true;
                }
            }

            return isEqual(root1.left,root2)||isEqual(root1.right,root2);



        }


    }
}
