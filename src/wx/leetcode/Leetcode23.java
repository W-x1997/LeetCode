package wx.leetcode;

import java.util.PriorityQueue;

public class Leetcode23 {
    /**
     *
     * 23. Merge k Sorted Lists
     * Hard
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     *
     * Example:
     *
     * Input:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     *
     *
     *    两种方法，一种是根据归并排序的思想直接对list指数进行操作。
     *    推荐另一种，用优先队列来做。
     *
     */

      public class ListNode {
          int val;
          ListNode next;
         ListNode(int x) { val = x; }
      }



    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;

        PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.length,(ListNode a, ListNode b)->(a.val-b.val));

        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;

        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null) ///!!!! 注意！！这里要记住！！判断是否为空 ！！
                queue.offer(lists[i]);
        }

        while(!queue.isEmpty()){
            ListNode tmp=queue.poll();
            cur.next=tmp;
            cur=tmp;
            if(tmp.next!=null)queue.offer(tmp.next);
        }

        return dummy.next;



    }

//    class Solution {
//        public ListNode mergeKLists(ListNode[] lists) {
//            int len=lists.length;
//            if(len==0)
//                return null;
//            merge(lists,0,len-1);
//            return lists[0];
//
//
//        }
//
//        public void  merge(ListNode[] lists, int lo, int hi){
//            if(lo<hi){
//                int mid=lo+(hi-lo)/2;
//                merge(lists,lo,mid);
//                merge(lists,mid+1,hi);
//                lists[lo]=mergetwoLists(lists[lo],lists[mid+1]);
//            }
//
//
//
//
//        }
//
//        public ListNode mergetwoLists(ListNode n1,ListNode n2){
//            if(n1==null)
//                return n2;
//            if(n2==null)
//                return n1;
//
//            ListNode tmp=new ListNode(0);
//            ListNode res=tmp;
//
//            ListNode n11=n1;
//            ListNode n22=n2;
//
//            while(n11!=null&&n22!=null){
//                int temp1=n11.val;
//                int temp2=n22.val;
//
//                if(temp1<=temp2){
//                    tmp.next=new ListNode(temp1);
//                    tmp=tmp.next;
//                    n11=n11.next;
//                }
//                else{
//                    tmp.next=new ListNode(temp2);
//                    tmp=tmp.next;
//                    n22=n22.next;
//
//                }
//
//
//            }
//
//            if(n11!=null){
//                tmp.next=n11;
//            }
//
//            if(n22!=null){
//                tmp.next=n22;
//            }
//
//
//            return res.next;
//
//        }
//
//
//    }
}
