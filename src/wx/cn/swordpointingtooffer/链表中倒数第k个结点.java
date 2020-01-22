package wx.cn.swordpointingtooffer;

public class 链表中倒数第k个结点 {


    /**
     *
     *
     输入一个链表，输出该链表中倒数第k个结点。
     *
     * 时间复杂度O(n),一次遍历即可
     * 用两个快慢指针
     * 快指针抢先k-1个出发即可
     *
     *
     *
     *
      */

    public class Solution {


        public class ListNode {
            int val;
            ListNode next = null;

            ListNode(int val) {
                this.val = val;
            }
        }


        public ListNode FindKthToTail2(ListNode head,int k) {
            if(head==null||k<=0)
                return null;

            ListNode pre=head;
            ListNode cur=head;

            int a=k;

            while(cur!=null){
                if(a<=0)
                    pre=pre.next;
                else
                    a--;

                cur=cur.next;



            }
            if(a>0)return null;  //说明pre没动过


            return pre;


        }

        public ListNode FindKthToTail(ListNode head,int k) {
            ListNode pre=null,p=null;
            //两个指针都指向头结点
            p=head;
            pre=head;
            //记录k值
            int a=k;
            //记录节点的个数
            int count=0;
            //p指针先跑，并且记录节点数，当p指针跑了k-1个节点后，pre指针开始跑，
            //当p指针跑到最后时，pre所指指针就是倒数第k个节点
            while(p!=null){
                p=p.next;
                count++;
                if(k<1){
                    pre=pre.next;
                }
                k--;
            }
            //如果节点个数小于所求的倒数第k个节点，则返回空
            if(count<a) return null;
            return pre;

        }
    }
}
