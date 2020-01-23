package wx.leetcode;

public class Leetcode141 {
    /**
     * Given a linked list, determine if it has a cycle in it.
     *
     * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
     *
     *
     *
     * Example 1:
     *
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where tail connects to the second node.
     *
     *
     * 用快慢指针看是否相遇
     *
     */

    public class Solution {
        class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
                next = null;
            }

            public boolean hasCycle(ListNode head) {
                if (head == null || head.next == null)
                    return false;


                ListNode fast = head;
                ListNode slow = head;

                while (fast != null && fast.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                    if (fast == slow) return true;


                }

                return false;


            }
        }
    }
}

