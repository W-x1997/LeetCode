package wx.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode297 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    /**
     297. Serialize and Deserialize Binary Tree
     **/

    public class Codec {


        /**
         * use a stringbuilder to store all nodes  each node we use ","(comma) to split them
         * and when the node is null we use a "#" to mark it
         *
         *
         * then when we deserialize we use a queue   , we put the string[] into the queue.
         * Then we loop the queue until queue is empty.
         *
         *
         */


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb=new StringBuilder("");
            buildString(sb,root);
            return sb.toString();
        }


        public void buildString(StringBuilder sb,TreeNode root){
            if(root==null){
                sb.append("#").append(",");
            }else {
                sb.append(root.val).append(",");
                buildString(sb,root.left);
                buildString(sb,root.right);
            }


        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data==null)return null;
            String[] nodes=data.split(",");
            Queue<String> queue=new LinkedList<String>();

            Collections.addAll(queue,nodes);
            return buildTree(queue);

        }


        public TreeNode buildTree(Queue<String> queue){
            if(queue.isEmpty())return null;

            String s=queue.poll();
            if(s.equals("#"))return null;
            TreeNode node=new TreeNode(Integer.valueOf(s));
            node.left=buildTree(queue);
            node.right=buildTree(queue);


            return node;
        }


        public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
