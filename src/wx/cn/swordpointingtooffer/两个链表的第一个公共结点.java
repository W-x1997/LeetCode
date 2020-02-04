package wx.cn.swordpointingtooffer;

import java.util.HashMap;

public class 两个链表的第一个公共结点 {



    public class Solution {
        public class ListNode {
            int val;
            ListNode next = null;

            ListNode(int val) {
                this.val = val;
            }
        }
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            if(pHead1==null||pHead2==null){
                return null;
            }

            ListNode cur1=pHead1;
            ListNode cur2=pHead2;
            HashMap<ListNode,Integer> map=new HashMap<ListNode,Integer>();
            while(cur1!=null){
                map.put(cur1,1);
                cur1=cur1.next;
            }

            while(cur2!=null){
                if(map.containsKey(cur2))
                    return cur2;

                cur2=cur2.next;

            }

            return null;



        }
    }
}
