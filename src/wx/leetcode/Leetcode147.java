package wx.leetcode;

public class Leetcode147 {

    class Solution {
        /**
         * 147. Insertion Sort List

         * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
         * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
         *
         *
         * 用一个prev指针指向dummy node 每次从dummynode开始依次向后比较
         *
         */

          public class ListNode {
              int val;
              ListNode next;
              ListNode(int x) { val = x; }
          }

        public ListNode insertionSortList(ListNode head) {
            ListNode dummy=new ListNode(0);
            dummy.next=head;
            ListNode cur=head;
            ListNode prev=null;

            while(cur!=null&&cur.next!=null){
                if(cur.val<=cur.next.val){
                    cur=cur.next;
                }else {
                    ListNode tmp=cur.next;
                    cur.next=cur.next.next;
                    prev=dummy;

                    while(prev!=null&&prev.next!=null){
                        if (prev.next.val>tmp.val){
                            tmp.next=prev.next;
                            prev.next=tmp;
                            break;
                        }
                        prev=prev.next;
                    }

                }

            }
            return dummy.next;

        }
    }
}
