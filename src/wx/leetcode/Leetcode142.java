package wx.leetcode;

public class Leetcode142 {

    /**
     *
     * Linked List Cycle II
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     *
     * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
     * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
     *
     *
     *
     *    和141相类似 但有点不同要求 求出环的入口
     *    让快指针慢指针从head出发，快指针步长为2，慢指针步长为1，相遇点记为M。
     *    再分别从head和M点出发，但这次两指针都步长为1，相遇点即为环的入口。
     *
     *  推导：
     *  链表的整个长度为L，链表头head为h，假设fp和sp按照箭头所示的方向走。其中环入口点为d，h到d的距离hd为a。
     *  fp和sp假设初次相遇在c，初次相遇的时候慢指针sp肯定没有走完整个链表。设d到c的距离dc为x，h到c的距离即为sp初次相遇所走的路程，即设hc长度为s。此外设环的长度为r。而在fp和sp初次相遇在c点的时候，fp则在环内已经走了n圈。由于fp的速度是sp的2倍，接下来我们可以得出：
     * 2s = s + nr
     * ->    s = nr  (1)
     * 又因为hd距离为a，dc距离为x，hc距离为s，所以可以得出：
     *  a + x = s   (2)
     * 结合(1)和(2)可以得出：
     * a + x = nr   ->    a + x = (n-1)r + r   ->    a + x = (n-1)r + (L-a)        注释：L-a即为环长r
     * ->     a = (n-1)r + (L-a-x)
     * 即此时h到d的距离a等于c到d的距离(L-a-x)。所以当fp和sp初次相遇在c点的时候，令fp从c点出发，sp指向
     * 链表头h，两个同时以步数为1同时出发，则再次相遇的时候即为环的入口节点d。
     *
     *
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            // 快指针fp和慢指针sp，
            ListNode fp = head, sp = head;
            while (fp != null && fp.next != null) {
                sp = sp.next;
                fp = fp.next.next;
                //此处应该用fp == sp ，而不能用fp.equals(sp) 因为链表为1 2 的时候容易
                //抛出异常
                if (fp == sp) {  //说明有环
                    break;
                }
            }
            //System.out.println( fp.val + "   "+ sp.val );
            if (fp == null || fp.next == null) {
                return null;
            }
            //说明有环，求环的起始节点
            sp = head;
            while (fp != sp) {
                sp = sp.next;
                fp = fp.next;
            }
            return sp;

        }
    }}