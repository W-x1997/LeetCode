package wx.cn.swordpointingtooffer;

import java.util.ArrayList;
import java.util.Stack;

public class 从尾到头打印链表 {

    /**
     *Solution 1:
     * 通过递归遍历
     */

    public class ListNode {
       int val;
       ListNode next = null;

       ListNode(int val) {
           this.val = val;
       }
    }

    public class Solution {
        ArrayList<Integer> list=new ArrayList();

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            if(listNode==null)
                return list;
            bianli(listNode);

            return list;




        }

        public void bianli(ListNode listNode){
            if(listNode.next!=null){
                bianli(listNode.next);

            }
            list.add(listNode.val);

        }
    }


    /**
     *
     * Solution2
     * 通过Stack
     *
     */

    public static void printListInverselyUsingIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }
        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.print(tmp.val + " ");
        }
    }

    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用栈的方式进行
     *
     * @param root 链表头结点
     */
    public static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion(root.next);
            System.out.print(root.val + " ");
        }
    }


}
