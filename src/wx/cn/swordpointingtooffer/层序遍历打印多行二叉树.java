package wx.cn.swordpointingtooffer;
import java.util.*;
import java.util.ArrayList;
public class 层序遍历打印多行二叉树 {




public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}


    public class Solution {
        ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

            ArrayList<Integer> list=new ArrayList();
            if(pRoot==null)
                return res;

            Queue<TreeNode> queue=new LinkedList<TreeNode>();
            queue.offer(pRoot);

            while(!queue.isEmpty()){
                int size=queue.size();
                while(size>0){
                    TreeNode node=queue.poll();
                    list.add(node.val);

                    if(node.left!=null)queue.offer(node.left);
                    if(node.right!=null)queue.offer(node.right);
                    size--;
                }


                res.add(new ArrayList(list));
                list=new ArrayList();




            }

            return res;




        }

    }

}
