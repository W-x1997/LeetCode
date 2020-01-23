package wx.leetcode;

public class Leetcode24 {


    /**
     * Swap Nodes in Pairs
     * Given a linked list, swap every two adjacent nodes and return its head.
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     *
     *
     *
     * Example:
     *
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     *
     *
     * 创建一个dummy Node
     * 要反转两个Node 其实要对3个结点进行操作
     * 所以 cur指向prev 每次将 cur.next和cur.next.next  进行反转
     *
     *
     * public ListNode swapPairs(ListNode head) {
     *
     *         if(head==null||head.next==null)
     *             return head;
     *         ListNode dummy=new ListNode(0);
     *         dummy.next=head;
     *         ListNode current=dummy;    //current相当于prev
     *         while(current.next!=null&&current.next.next!=null){
     *             ListNode tmp=current.next;
     *             current.next=tmp.next;
     *             tmp.next=tmp.next.next;
     *             current.next.next=tmp;
     *
     *             current=current.next.next;
     *         }
     *
     *
     *         return dummy.next;
     *
     *     }
     *
     * 也可以用一个单独的函数swap来写 使得逻辑看起来更清晰  如下：
     *
     */

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
        public ListNode swapPairs(ListNode head) {

            if(head==null||head.next==null)
                return head;
            ListNode dummy=new ListNode(0);
            dummy.next=head;
            ListNode current=dummy;    //current相当于prev
            while(current.next!=null&&current.next.next!=null){
                swap(current);
                current=current.next.next;
            }


            return dummy.next;

        }


        public void swap(ListNode prev){   // 单独写使得逻辑看起来更清晰
            ListNode dummy=prev.next;
            prev.next=dummy.next;
            dummy.next=dummy.next.next;
            prev.next.next=dummy;


        }
    }

