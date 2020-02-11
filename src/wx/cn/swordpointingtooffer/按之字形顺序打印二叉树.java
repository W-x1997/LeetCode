package wx.cn.swordpointingtooffer;
import java.util.*;

public class 按之字形顺序打印二叉树 {

    /**
     *
     * 解题思路1：
     * 直接层序遍历 然后偶数层Collections reverse即可
     *
     * 思路2:
     * 设两个栈，s2存放奇数层，s1存放偶数层
     * 遍历s2节点的同时按照左子树、右子树的顺序加入s1，
     * 遍历s1节点的同时按照右子树、左子树的顺序加入s2
     */

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

    public class Solution2 {
        public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
            Stack<TreeNode> s1 = new Stack<TreeNode>();
            Stack<TreeNode> s2 = new Stack<TreeNode>();
            int flag = 1;
            if(pRoot == null)
                return res;
            s2.push(pRoot);
            ArrayList<Integer> temp = new ArrayList<Integer>();
            while(!s1.isEmpty() || !s2.isEmpty()){
                if(flag % 2 != 0){
                    while(!s2.isEmpty()){
                        TreeNode node = s2.pop();
                        temp.add(node.val);
                        if(node.left != null){
                            s1.push(node.left);
                        }
                        if(node.right != null){
                            s1.push(node.right);
                        }
                    }
                }
                if(flag % 2 == 0){
                    while(!s1.isEmpty()){
                        TreeNode node = s1.pop();
                        temp.add(node.val);
                        if(node.right != null){
                            s2.push(node.right);
                        }
                        if(node.left != null){
                            s2.push(node.left);
                        }
                    }
                }
                res.add(new ArrayList<Integer>(temp));
                temp.clear();
                flag ++;
            }
            return res;
        }

    }

    public class Solution {
        public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
            if(pRoot==null)return res;
            ArrayList<Integer>list=new ArrayList<Integer>();
            Queue<TreeNode> queue=new LinkedList<TreeNode>();
            queue.offer(pRoot);
            int start=0;
            int end=1;
            boolean flag=false;
            while(!queue.isEmpty()){
                TreeNode node=queue.poll();
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
                list.add(node.val);
                start++;
                if(start==end){
                    if(!flag)
                        res.add(new ArrayList(list));
                    else{
                        Collections.reverse(list);
                        res.add(new ArrayList(list));
                    }

                    start=0;
                    end=queue.size();
                    list=new ArrayList<Integer>();
                    flag=!flag;
                }



            }
            return res;

        }

    }



}
