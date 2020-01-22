package wx.cn.swordpointingtooffer;

public class 合并两个有序的链表 {
    /**
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

        public ListNode Merge(ListNode list1,ListNode list2) {
            //新建一个头节点，用来存合并的链表。
            ListNode head=new ListNode(-1);
            head.next=null;
            ListNode root=head;
            while(list1!=null&&list2!=null){
                if(list1.val<list2.val){
                    head.next=list1;
                    head=list1;
                    list1=list1.next;
                }else{
                    head.next=list2;
                    head=list2;
                    list2=list2.next;
                }
            }
            //把未结束的链表连接到合并后的链表尾部
            if(list1!=null){
                head.next=list1;
            }
            if(list2!=null){
                head.next=list2;
            }
            return root.next;
        }
    }
}
