package wx.cn.swordpointingtooffer;

public class 反转链表 {

    /**
     *
     * 反转链表
     *
     * 两种方法
     * 1 递归   时间复杂度O（n） 空间复杂度 O（n）
     * 2 直接用三个指针进行反转  时间复杂度O（n） 空间复杂度 O（1）
     */

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode ReverseList(ListNode head) {
            if(head==null)return null;
            ListNode prev=null;
            ListNode cur=head;
            ListNode next;

            while(cur!=null){
                next=cur.next;
                cur.next=prev;
                prev=cur;
                cur=next;
            }


            return prev;

        }
    }


    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
