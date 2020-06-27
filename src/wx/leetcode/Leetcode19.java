package wx.leetcode;

public class Leetcode19 {
    /**
     * 19. Remove Nth Node From End of List
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /*
    快慢指针题，让快指针先走n+1步，然后慢指着再出发，
    当快指针到头的时候，这个时候只要删除慢指针的下一节点
    */
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode dummy = new ListNode(0);
            dummy.next=head;
            ListNode slow = dummy, fast = dummy;

            int dist=n+1;
            while(dist-->0){
                fast=fast.next;
            }

            while(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
          public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
    }


}
