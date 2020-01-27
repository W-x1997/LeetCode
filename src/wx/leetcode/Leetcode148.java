package wx.leetcode;

public class Leetcode148 {
    /**
     *
     * Sort a linked list in O(n log n) time using constant space complexity.
     *
     * Example :
     *
     * Input: 4->2->1->3
     * Output: 1->2->3->4
     *
     *
     思路：由于linkedlist是一个不回头的只向下走的数据结构，因此，我们在考虑多种排序方式时，会发现快排需要双指针找pivot，因此不合适，
     而merge sort不需要回头，只需要找mid切断，再merge起来即可，并且时间复杂度较好，达到要求。因此，这里我们使用merge sort的思想来sort linkedlist.
     *
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }

    public ListNode SortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        //找到链表的中间结点
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;

        //对链表的前半部分和后半部分分别进行排序
        ListNode list1 = SortList(head);
        ListNode list2 = SortList(slow);

        return Merge(list1, list2);
    }

    //将两个排序好的链表进行合并
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode temp = result;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            }else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return result.next;
    }
}}
