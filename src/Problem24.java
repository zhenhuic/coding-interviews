import entity.ListNode;

/**
 * 反转链表
 */
public class Problem24 {
    /**
     * 需要设置三个指针
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (curr.next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }

    /**
     * 用递归实现反转链表
     */
    public ListNode ReverseList_recur(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode last = head;
        reverseCore(head, last);
        last = last.next;
        head.next = null;
        return last;
    }

    private ListNode reverseCore(ListNode node, ListNode last) {
        if (node.next.next == null) {
            node.next.next = node;
            last.next = node.next;
        } else {
            reverseCore(node.next, last).next = node;
        }
        return node;
    }
}
