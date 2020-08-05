package wx.leetcode;
import java.util.*;

public class Leetcode314 {
    // *
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }

    class Solution {
        /**
         314. Binary Tree Vertical Order Traversal
         Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

         If two nodes are in the same row and column, the order should be from left to right.
         **/

        /**
         construct  a new data struture that contains hd(horizontal distance)

         use HashMap + hd  to store the results
         use min and max to loop the values in Hashmap

         min and max  denotes the range of hd

         **/
        class Node {
            TreeNode root;
            int hd;

            public Node(TreeNode root, int hd) {
                this.root = root;
                this.hd = hd;
            }
        }
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null)
                return res;

            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(root, 0));
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            HashMap<Integer, List<Integer>> map = new HashMap<>();

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int hd = node.hd;

                min = Math.min(min, hd);
                max = Math.max(max, hd);

                if (!map.containsKey(hd)) {
                    map.put(hd, new ArrayList());
                }
                map.get(hd).add(node.root.val);

                if (node.root.left != null) {
                    queue.offer(new Node(node.root.left, hd - 1));
                }

                if (node.root.right != null) {
                    queue.offer(new Node(node.root.right, hd + 1));
                }
            }

            for (int i = min; i <= max; i++) {
                res.add(map.get(i));
            }
            return res;


        }
        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }

        }

    }
}

