package wx.leetcode.OA;

public class DistanceBetweenNodesinBST {
/**
 * Given a list of unique integers nums, construct a BST from it (you need to insert nodes one-by-one with the given order to get the BST)
 * and find the distance between two nodes node1 and node2. Distance is the number of edges between two nodes.
 * If any of the given nodes does not appear in the BST, return -1.
 *
 * Example 1:
 *
 * Input: nums = [2, 1, 3], node1 = 1, node2 = 3
 * Output: 2
 * Explanation:
 *      2
 *    /   \
 *   1     3
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value){
        this.val = value;
    }
}


    public int getdistance(int[] nums, TreeNode n1, TreeNode n2){
        //insert each node O(nlogn)
        //find the depth of two nodes and their LCA in the tree
        TreeNode root = new TreeNode(nums[0]);
        for(int i = 1; i < nums.length; i++){
            insert(root, nums[i]);
        }

        return lowestCommonAncestor(root, n1, n2);
    }
    public int lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            int h1 = getHeight(root, p);
            int h2 = getHeight(root, q);
            if(h1 == -1 || h2 == -1) return -1;
            return h1 + h2;
        }
    }
    private int getHeight(TreeNode root, TreeNode node){
        if(root == null) return -1;
        if(root.val == node.val) return 0;
        if(root.val > node.val){
            int left = getHeight(root.left, node);
            return left == -1 ? -1 : left + 1;
        }else{
            int right = getHeight(root.right, node);
            return right == -1 ? -1 : right + 1;
        }
    }

    private TreeNode insert(TreeNode root, int num){
        if(root == null){
            return new TreeNode(num);
        }else if(root.val > num){
            root.left = insert(root.left, num);
        }else{
            root.right = insert(root.right, num);
        }
        return root;
    }

}
