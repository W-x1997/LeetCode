package wx.leetcode;

import  java.util.*;
public class Leetcode445 {

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Follow up:
     * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
     *
     * Example:
     *
     * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 8 -> 0 -> 7
     *
     *
     *
     * 思路和leetcode2 一样   只是leetcode2 是左对齐相加 这道题是右对齐相加
     *  用stack即可
     */

    class Solution {

         public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> st1 = new Stack<>(), st2 = new Stack<>();
            load(st1, l1);
            load(st2, l2);
            ListNode curr, prev = null;
            int br = 0;
            while(!st1.isEmpty() || !st2.isEmpty() || br != 0){
                br += (st1.isEmpty() ? 0 : st1.pop()) + (st2.isEmpty() ? 0 : st2.pop());
                curr = new ListNode(br%10);
                br /= 10;
                curr.next = prev;
                prev = curr;
            }
            return prev;
        }

        private void load(Stack<Integer>st, ListNode node){
            ListNode head = node;
            while(head != null){
                st.push(head.val);
                head = head.next;
            }
        }
    }

}
