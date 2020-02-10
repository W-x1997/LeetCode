package wx.cn.swordpointingtooffer;

public class 删除链表中重复的结点 {

    /**
     *
     *
     * 题目描述
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * 借助两个指针prev 和 cur来遍历
     *
     * 若cur.val==cur.next.val
     *   则cur=cur.next   直到cur.val!=cur.next.val 此时暂时让prev.next=cur.next
     *
     *  否则 prev.next=cur
     *     prev=prev.next
     *
     */

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public ListNode deleteDuplication(ListNode pHead){
            if(pHead==null)
                return null;
            if(pHead.next==null)
                return pHead;

            ListNode res=new ListNode(0);
            ListNode prev=res;
            res.next=pHead;
            ListNode cur=pHead;

            while(cur!=null&&cur.next!=null){
                if(cur.val==cur.next.val){
                    while(cur!=null&&cur.next!=null&&cur.val==cur.next.val){
                        cur=cur.next;
                    }
                    prev.next=cur.next;
                }else{
                    prev.next=cur;
                    prev=prev.next;
                }

                cur=cur.next;

            }

            return res.next;
        }
    }
}
