package wx.cn.swordpointingtooffer;

import java.util.Stack;

public class reverse_k_list {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */


    /**
     *
     * Solution 1：用一个stack
     *             cur  next
     *
     *
     *
     *   ! Solution2:
     *      用prev 和 cur 每次翻转prev.next到cur 之间的链表
     *      prev和 next=cur.next 用来标记 插入之后的位置
     *       注意 ！调用reverseNode 时 要把cur.next 指向 null ！否则会一直向后遍历
     *
     *
     *
     *
     */


    class Solution2 {
        public class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            ListNode cur = dummy;

            while (cur.next != null) {
                for (int i = 0; i < k && cur != null; i++) {
                    cur = cur.next;
                }

                if (cur == null)
                    break;

                ListNode left = prev.next;

                ListNode next = cur.next;
                cur.next = null;

                ListNode newhead = reverseNode(left);
                prev.next = newhead;
                left.next = next;

                prev = left;
                cur = left;


            }
            return dummy.next;


        }


        public ListNode reverseNode(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            ListNode next = null;

            while (cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;

            }

            return prev;

        }


        class Solution {
            public class ListNode {
                int val;
                ListNode next;

                ListNode(int x) {
                    val = x;
                }
            }

            public ListNode reverseKGroup(ListNode head, int k) {
                ListNode dummy = new ListNode(0);
                ListNode cur = dummy;
                dummy.next = head;
                ListNode next = dummy.next;
                Stack<ListNode> stack = new Stack();

                while (next != null) {
                    for (int i = 0; i < k && next != null; i++) {
                        stack.push(next);
                        next = next.next;
                    }


                    if (stack.size() < k)
                        return dummy.next;

                    while (!stack.isEmpty()) {
                        cur.next = stack.pop();
                        cur = cur.next;

                    }
                    cur.next = next;


                }
                return dummy.next;


            }


        }
    }}
