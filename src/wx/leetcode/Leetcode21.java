package wx.leetcode;

public class Leetcode21 {
    /**
     *
     * 21. Merge Two Sorted Lists
     * Easy
     * Merge two sorted linked lists and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists.
     *
     * Example:
     *
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     *
     */



    class Solution {


        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1==null&&l2==null)return null;
            if(l1==null)return l2;
            if(l2==null)return l1;

            ListNode dummy=new ListNode(0);
            ListNode cur=dummy;
            ListNode c1=l1,c2=l2;
            while(c1!=null&&c2!=null){
                if(c1.val<=c2.val){
                    cur.next=c1;
                    c1=c1.next;

                }else{
                    cur.next=c2;
                    c2=c2.next;

                }
                cur=cur.next;
            }

            if(c2!=null){
                cur.next=c2;
            }

            if(c1!=null){
                cur.next=c1;
            }
            return dummy.next;



        }
    }
} }
