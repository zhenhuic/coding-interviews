import entity.ListNode;

/**
 * 链表中倒数第k个节点
 */
public class Problem22 {
    /**
     * 双指针法
     * 指针间隔控制为 k-1，遍历一次
     *
     * 扩展题：求链表中间节点，同样可以用双指针法
     * 两个指针同时从链表的头节点出发，
     * 一个指针一次走一步，两一个指针一次走两步。
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) return null;

        ListNode front = head;
        ListNode rear = head;
        int cnt = 0;
        while (front.next != null && cnt < k - 1) {
            front = front.next;
            cnt++;
        }
        if (cnt != k - 1) return null;

        while (front.next != null) {
            front = front.next;
            rear = rear.next;
        }
        return rear;

    }
}
