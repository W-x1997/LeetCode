package wx.cn.swordpointingtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 从上往下打印二叉树 {
    /**
     *
     * BFS遍历即可
     *
     */


    public class Solution {

        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;

            }

        }

        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> res=new ArrayList();
            if(root==null)return res;
            Queue<TreeNode> queue=new LinkedList();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size=queue.size();
                for(int i=0;i<size;i++){
                    TreeNode tmp=queue.poll();
                    res.add(tmp.val);
                    if(tmp.left!=null)queue.offer(tmp.left);
                    if(tmp.right!=null)queue.offer(tmp.right);
                }

            }
            return res;

        }
    }
}
