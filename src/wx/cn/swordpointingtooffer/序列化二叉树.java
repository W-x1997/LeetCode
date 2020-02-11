package wx.cn.swordpointingtooffer;
import java.util.*;
public class 序列化二叉树 {

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}


    public class Solution {
        String Serialize(TreeNode root) {
            StringBuilder builder=new StringBuilder();
            builderstring(builder,root);
            return builder.toString();


        }

        public void builderstring(StringBuilder builder,TreeNode root){
            if(root==null){
                builder.append("#").append(",");

            }else{
                builder.append(root.val).append(",");
                builderstring(builder,root.left);
                builderstring(builder,root.right);
            }


        }


        public TreeNode Deserialize(String str) {
            if(str==null){
                return null;
            }

            String[] strArr=str.split(",");
            Queue<String> queue=new LinkedList<>();
            Collections.addAll(queue,strArr);
            return buildtree(queue);

        }


        public TreeNode buildtree(Queue<String> queue){
            if(queue.isEmpty()){
                return null;
            }
            String s=queue.poll();
            if(s.equals("#")){
                return null;
            }
            TreeNode node=new TreeNode(Integer.parseInt(s));
            node.left=buildtree(queue);
            node.right=buildtree(queue);
            return node;
        }







    }
}