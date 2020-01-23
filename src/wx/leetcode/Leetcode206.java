package wx.leetcode;

public class Leetcode206 {
    /**
     *
     * 反转链表
     *非递归和递归版本
     *
     *
     */


        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
     }

    class Solution {



        public ListNode reverseList1(ListNode head){
            ListNode prev=null;
            ListNode cur=head;
            ListNode next=null;

            while(cur!=null){
                next=cur.next;
                cur.next=prev;
                prev=cur;
                cur=next;

            }
            return prev;

        }

        /**
         * 递归版本
         * @param head
         * @return
         */
        public ListNode reverseList2(ListNode head) {
            if (head == null || head.next == null) return head;
             ListNode p=reverseList2(head.next);
             head.next.next=head;
             head.next = null;
            return p;

        }
    }
}
