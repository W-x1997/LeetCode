package wx.cn.swordpointingtooffer;
import java.util.*;
public class 二叉搜索树的第k个结点 {
    /**
     *
     *  利用二叉搜索数的先序遍历是排序
     */

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}


    public class Solution {



        TreeNode KthNode(TreeNode pRoot, int k){

            List<TreeNode> list=new ArrayList();
            inorder(list,pRoot);
            if(k==0||k>list.size())
                return null;
            return list.get(k-1);
        }

        public void inorder(List<TreeNode> list,TreeNode pRoot){
            if(pRoot==null)
                return;

            inorder(list,pRoot.left);
            list.add(pRoot);
            inorder(list,pRoot.right);


        }


    }

}
