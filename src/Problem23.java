import entity.ListNode;

/**
 * 链表中环的入口节点
 */
public class Problem23 {
    /**
     * 双指针法
     * 1. 通过快慢指针遍历，找到环内的一个节点，
     * 2. 遍历环，记录环上节点的个数 n，
     * 3. 再用两个指针指向头节点，一个指针先向前移动 n 步，然后连个指针以相同的速度向前移动。
     * 当第二个指针指向环的入口节点时，第一个指针已经围绕着环走了一圈，又回到了入口节点。
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        if (pHead.next == null) return null;

        ListNode fast = pHead.next;
        ListNode slow = pHead;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;

            if (slow.next == null) return null;
            slow = slow.next;
        }

        int num = 1;
        fast = fast.next;
        while (fast != slow) {
            fast = fast.next;
            num++;
        }

        fast = pHead;
        slow = pHead;
        for (int i = 0; i < num; i++) {
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
