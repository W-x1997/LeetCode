package wx.cn.swordpointingtooffer;

public class 链表中环的入口结点 {
    /**
     *
     * 题目描述
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     *
     *
     *  注意循环的条件
     */
    public class Solution {

        public class ListNode {
            int val;
            ListNode next = null;

            ListNode(int val) {
                this.val = val;
            }
        }

        public ListNode EntryNodeOfLoop(ListNode pHead){
            if(pHead==null)
                return null;
            ListNode fast=pHead;
            ListNode slow=pHead;

            while(fast!=null&&fast.next!=null){    //  fast.next!=null
                slow=slow.next;
                fast=fast.next.next;
                if(fast==slow){
                    break;
                }
            }

            if(fast==null||fast.next==null)   //fast.next==null
                return null;

            fast=pHead;

            while(slow!=fast){
                slow=slow.next;
                fast=fast.next;
                if(fast==slow){
                    break;
                }


            }
            return fast;

        }
    }
}
