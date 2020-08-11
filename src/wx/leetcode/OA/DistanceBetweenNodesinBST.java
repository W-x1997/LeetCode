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
 *
 *
 *
 *
 */


    /**
     * Java Solution :
     *
     * 1.Build BST
     * 2/Find LCA
     * 3.Find Distance from LCA to given points
     */
    static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value){
        this.val = value;
    }
}

    public static int findDistance(int[] is, int i, int j) {
        TreeNode root = null;
        for(int k=0;k< is.length;k++){
            root = buildBST(root, is[k]);
        }
        TreeNode lca = findLeastCommonAncestor(root, i, j);
        int distance = findDistanceFromLCA(lca,i)+findDistanceFromLCA(lca,j);
        return distance;
    }

    private static int findDistanceFromLCA(TreeNode lca, int i) {
        int distanceSum= 0;
        while(true){
            if(lca!=null){
                if(lca.val==i)
                    return distanceSum;
                else if(lca.val<i){
                    distanceSum++;
                    lca = lca.right;
                }
                else if(lca.val>i){
                    distanceSum++;
                    lca = lca.left;
                }
            }
            else
                return distanceSum;
        }
    }

    private static TreeNode findLeastCommonAncestor(TreeNode root, int i, int j) {
        while(true){
            if(root.val>i && root.val>j){
                root = root.left;
            }
            else if(root.val<i && root.val<j){
                root = root.right;
            }
            else{
                return root;
            }
        }
    }

    private static TreeNode buildBST(TreeNode root , int node) {
        if(root==null){
            root = new TreeNode(node);
            return root;
        }
        else if(root.val<node){
            if(root.right ==null)
                root.right = new TreeNode(node);
            else
                buildBST(root.right, node);
        }
        else if(root.val>node){
            if(root.left==null)
                root.left = new TreeNode(node);
            else
                buildBST(root.left, node);
        }
        return root;
    }

}
