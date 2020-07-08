package wx.leetcode;

public class Leetcode108 {
    /**
     二分查找+递归即可，每次找中间的那个设定为根
     注意lo要大于等于hi才返回，因为原本类型1是 while(lo<hi)进行

     */

    /**
     * 108. Convert Sorted Array to Binary Search Tree
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * Example:
     *
     * Given the sorted array: [-10,-3,0,5,9],
     *
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums.length==0) return null;
            int lo=0;
            int hi=nums.length;
            return buildBST(nums,lo,hi);

        }

        private TreeNode buildBST(int[]nums,int lo,int hi){
            if(lo>=hi) return null;//lo>=hi

            int mid=(lo+hi)/2;

            TreeNode cur=new TreeNode(nums[mid]);
            cur.left=buildBST(nums,lo,mid);
            cur.right=buildBST(nums,mid+1,hi);

            return cur;

        }
    }

     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


  public class TreeNode {
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
