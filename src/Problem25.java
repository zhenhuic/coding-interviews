import entity.ListNode;

/**
 * 合并连个排序的链表
 */
public class Problem25 {
    /**
     * 两个指针分别指向两个链表的节点，比较节点的大小，
     * 值较小的接入 merged 链表，该指针后移一步。
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = null;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode merged;
        if (p1.val < p2.val) {
            head = p1;
            merged = p1;
            p1 = p1.next;
        }else {
            head = p2;
            merged = p2;
            p2 = p2.next;
        }

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                merged.next = p1;
                merged = p1;
                p1 = p1.next;
            }else {
                merged.next = p2;
                merged = p2;
                p2 = p2.next;
            }
        }
        if (p1 == null) {
            merged.next = p2;
        } else {
            merged.next = p1;
        }
        return head;
    }
}
