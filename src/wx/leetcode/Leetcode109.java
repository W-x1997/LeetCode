//package wx.leetcode;
//
//public class Leetcode109 {
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     *     int val;
//     *     ListNode next;
//     *     ListNode() {}
//     *     ListNode(int val) { this.val = val; }
//     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     * }
//     */
//    /**
//     * Definition for a binary tree node.
//     * public class TreeNode {
//     *     int val;
//     *     TreeNode left;
//     *     TreeNode right;
//     *     TreeNode() {}
//     *     TreeNode(int val) { this.val = val; }
//     *     TreeNode(int val, TreeNode left, TreeNode right) {
//     *         this.val = val;
//     *         this.left = left;
//     *         this.right = right;
//     *     }
//     * }
//     */
//    class Solution {
//        /**
//         109. Convert Sorted List to Binary Search Tree
//         Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//
//         For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//         **/
//        public TreeNode sortedListToBST(ListNode head) {
//            /**
//             /*知名沙雕题，和上一个from sorted array 差不多
//             只不过每次要通过快慢指针找中点。。。时间复杂度是NlogN，找中点N，递归下去logN次大概
//
//             还有一个知名沙雕方法，转成array 时间复杂度是On
//             */
//        **/
//            if(head == null)
//                return null;
//
//            return buildTree(head, null);
//        }
//
//
//        public TreeNode buildTree(ListNode head, ListNode tail){
//            if (head == tail)
//                return null;
//
//            ListNode slow = head;
//            ListNode fast = head;
//            while(fast !=tail && fast.next != tail){
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//
//            TreeNode node = new TreeNode(slow.val);
//            node.left = buildTree(head, slow);
//            node.right = buildTree(slow.next, tail);
//            return node;
//
//        }
//    }
//    }
//}
