package wx.leetcode;

public class Leetcode148 {
    /**
     *
     * Sort a linked list in O(n log n) time using constant space complexity.
     *
     * Example :
     *
     * Input: 4->2->1->3
     * Output: 1->2->3->4
     *
     *
     思路：由于linkedlist是一个不回头的只向下走的数据结构，因此，我们在考虑多种排序方式时，会发现快排需要双指针找pivot，因此不合适，
     而merge sort不需要回头，只需要找mid切断，再merge起来即可，并且时间复杂度较好，达到要求。因此，这里我们使用merge sort的思想来sort linkedlist.
     *
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }

}
    class Solution {
        public ListNode sortList(ListNode head) {
            if(head==null||head.next==null)return head;
            ListNode slow=head;
            ListNode fast=head;

            ListNode pre=head;//used to disconnect the list to get the 1st half

            while(fast!=null&&fast.next!=null){
                pre=slow;

                slow=slow.next;
                fast=fast.next.next;
            }

            pre.next=null; //!! So, we get the 1st half list

            return merge(sortList(head),sortList(slow));

        }


        public ListNode merge(ListNode l1,ListNode l2){
            ListNode dummy=new ListNode(0);
            ListNode cur=dummy;

            while(l1!=null&&l2!=null){
                if(l1.val<=l2.val){
                    cur.next=l1;
                    cur=cur.next;
                    l1=l1.next;
                }else{
                    cur.next=l2;
                    cur=cur.next;
                    l2=l2.next;
                }
            }
            if(l1!=null)cur.next=l1;
            if(l2!=null)cur.next=l2;

            return dummy.next;

        }

    }

}
