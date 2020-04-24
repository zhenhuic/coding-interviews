import entity.ListNode;

/**
 * 两个链表的第一个公共点
 */

public class Problem52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return a;
    }

    /**
     * 剑指 Offer 题解
     * 两个链表在末尾必成一条路，
     * 先遍历一遍计算出两个链表的长度，
     * 在较长的链表上先走他们长度的差值步数，
     * 最后一步一步比较
     */
    public ListNode FindFirstCommonNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        int len1 = 0, len2 = 0;
        while (a != null) {
            ++len1;
            a = a.next;
        }
        while (b != null) {
            ++len2;
            b = b.next;
        }

        int diff = Math.abs(len1 - len2);
        for (int i = 0; i < diff; i++) {
            if (len1 > len2) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null && headA.val != headB.val) {
            headA = headA.next;
            headB = headB.next;
        }
        if (headA != null || headB != null) {
            return headA;
        } else {
            return null;
        }

    }
}
