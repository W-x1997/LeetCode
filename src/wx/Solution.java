package wx;//package wx;
//
//import java.util.PriorityQueue;
//
////评测题目:
///*
//将n个有序链表合并成一个有序链表，并分析算法的时间复杂度。
//举例:
//输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6
//*/
//public class Solution{
//
//    /**
//     思路：我的思路是用一个优先队列（最小堆）
//
//
//     假设有k条lists  首先，先将k条lists的每条链表的
//     第一个结点放入优先队列中，然后依次poll 那么每次poll出的即为当前最小的一个元素
//     将其作为新的结点插入合并的链表中 ，同时如果poll出的那个结点所在的链表的下一个结点不为空，则
//     将它的下一个结点加入我们的优先队列
//
//     **/
//
//    public static class ListNode{
//        int val;
//        ListNode next;
//        ListNode(int x){
//            val=x;
//        }
//
//    }
//    public static ListNode mergeKLists(ListNode[] lists){
//        if(lists==null||lists.length==0)   //首先看是否为空 输入是否合理
//            return null;
//
//        PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.length,(ListNode a, ListNode b)->(a.val-b.val));
//        //创建优先队列 最小堆
//
//        ListNode dummy=new ListNode(0);  //合并的有序链表
//        ListNode cur=dummy;  // cur表示当前指向的结点
//
//        for(int i=0;i<lists.length;i++){
//            if(lists[i]==null)
//                continue;
//            queue.offer(lists[i]);    //加入每条链表的首个元素
//        }
//
//        while(!queue.isEmpty()){
//            ListNode tmp=queue.poll();    //poll当前最小堆中的最小元素
//            cur.next=tmp;						//cur指向当前poll出的
//            cur=cur.next;
//            if(tmp.next!=null)					//如果tmp下一个结点不为空 则加入优先队列
//                queue.offer(tmp.next);
//        }
//
//        return dummy.next;  //返回最后结果
//
//
//    }
//
//
//    public static void printList(ListNode node){
//        if(node==null)
//            return ;
//
//        ListNode cur=node;
//        while(cur.next!=null){
//            System.out.print(cur.val+"->");
//            cur=cur.next;
//        }
//        System.out.print(cur.val);
//        System.out.println(" ");
//
//    }
//
//    public static void main(String[] args){
//        ListNode list1=new ListNode(1);
//        list1.next=new ListNode(4);
//        list1.next.next=new ListNode(5);
//
//
//        ListNode list2=new ListNode(1);
//        list2.next=new ListNode(3);
//        list2.next.next=new ListNode(4);
//
//        ListNode list3=new ListNode(2);
//        list3.next=new ListNode(6);
//
////        printList(list1);
////        printList(list2);
////        printList(list3);
//
//
//        ListNode[] lists=new ListNode[3];
//        lists[0]=list1;
//        lists[1]=list2;
//        lists[2]=list3;
//
//        ListNode res=mergeKLists(lists);
//        printList(res);
//
//
//    }
//
//}
//
///*
//将n个有序链表合并成一个有序链表，并分析算法的时间复杂度。
//举例:
//输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6
//*/

import java.util.PriorityQueue;

//评测题目:
/*
将n个有序链表合并成一个有序链表，并分析算法的时间复杂度。
举例:
输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
*/
public class Solution{

    /**
     思路：我的思路是用一个优先队列（最小堆）


     假设有k条lists  首先，先将k条lists的每条链表的
     第一个结点放入优先队列中，然后依次poll 那么每次poll出的即为当前最小的一个元素
     将其作为新的结点插入合并的链表中 ，同时如果poll出的那个结点所在的链表的下一个结点不为空，则
     将它的下一个结点加入我们的优先队列

     **/

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }

    }
    //
    public static void printList(ListNode node){
        if(node==null)
            return ;

        ListNode cur=node;
        while(cur.next!=null){
            System.out.print(cur.val+"->");
            cur=cur.next;
        }
        System.out.print(cur.val);
        System.out.println(" ");

    }
    public static ListNode mergeKLists(ListNode[] lists){
        if(lists==null||lists.length==0)   //首先看是否为空 输入是否合理
            return null;

        PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.length,(ListNode a, ListNode b)->(a.val-b.val));
        //创建优先队列 最小堆

        ListNode dummy=new ListNode(0);  //合并的有序链表
        ListNode cur=dummy;  // cur表示当前指向的结点

        for(int i=0;i<lists.length;i++){
            if(lists[i]==null)
                continue;
            queue.offer(lists[i]);    //加入每条链表的首个元素
        }

        while(!queue.isEmpty()){
            ListNode tmp=queue.poll();    //poll当前最小堆中的最小元素
            cur.next=tmp;						//cur指向当前poll出的
            cur=cur.next;
            if(tmp.next!=null)					//如果tmp下一个结点不为空 则加入优先队列
                queue.offer(tmp.next);
        }

        return dummy.next;  //返回最后结果


    }


    public static void main(String[] args){
        ListNode list1=new ListNode(1);
        list1.next=new ListNode(4);
        list1.next.next=new ListNode(5);


        ListNode list2=new ListNode(1);
        list2.next=new ListNode(3);
        list2.next.next=new ListNode(4);

        ListNode list3=new ListNode(2);
        list3.next=new ListNode(6);

//        printList(list1);
//        printList(list2);
//        printList(list3);


        ListNode[] lists=new ListNode[3];
        lists[0]=list1;
        lists[1]=list2;
        lists[2]=list3;

        ListNode res=mergeKLists(lists);
        printList(res);

    }

}