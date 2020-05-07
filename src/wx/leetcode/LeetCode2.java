package wx.leetcode;

public class LeetCode2 {
    /**
     *
     * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     *
     *
     *
     *
     * 依次遍历即可
     * 用两个变量 value 和 carry来保存 数值和进位 每次都要更新
     * 如果两l1 l2有一个为空 自动每次补0 即可
     * 最后！！ 要注意最后一位末尾有进位的特殊情况 ！！
     *
     *
     */



    class Solution {

        public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

            ListNode dummy=new ListNode(0);
            ListNode cur=dummy;
            int carry=0;
            int sum=0;

            while(l1!=null||l2!=null||carry!=0){
                if(l1==null&&l2==null)
                    sum=carry;
                else if(l2==null)
                    sum=l1.val+carry;
                else if(l1==null)
                    sum=l2.val+carry;
                else
                    sum=l1.val+l2.val+carry;
                if(sum>=10){
                    sum=sum%10;
                    carry=1;
                }else {
                    carry=0;   ///!!!!!carry要恢复为0
                }
                cur.next=new ListNode(sum);
                cur=cur.next;

                if(l1!=null)   //l1可能为空
                    l1 = l1.next;
                if(l2!= null)
                    l2=l2.next;
            }
            return dummy.next;

        }

        public class ListNode {
            int val;
            ListNode next;

            ListNode(int n) {
                this.val = n;
            }
        }


        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(0);
            ListNode cur = res;
            ListNode cur1 = l1;
            ListNode cur2 = l2;

            int value = 0;
            int carry = 0;
            while (cur1 != null && cur2 != null) {
                value = (carry + cur1.val + cur2.val) % 10;   //！！
                carry = (carry + cur1.val + cur2.val) / 10; ///！！
                cur.next = new ListNode(value);
                cur = cur.next;
                cur1 = cur1.next;
                cur2 = cur2.next;
                if (cur1 == null && cur2 == null)
                    break;
                if (cur1 == null)
                    cur1 = new ListNode(0);   //补0
                if (cur2 == null)
                    cur2 = new ListNode(0);   //补0


            }
            if (carry != 0) {                  // 特例！！
                cur.next = new ListNode(carry);
                cur = cur.next;
            }


            return res.next;

        }

    }}
