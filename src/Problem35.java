import entity.RandomListNode;

/**
 * 复杂链表的复制
 */
public class Problem35 {
    /**
     * 当需要多次循环遍历链表或者
     * 只能用空间换时间的链表操作时，
     * 可以考虑借用原链表本身做操作，
     * 完事后再遍历一次改回去就好了
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        // 复制每个节点，接到原节点的后面
        RandomListNode node = pHead;
        RandomListNode copy;
        while (node != null) {
            copy = new RandomListNode(node.label);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
        // 设置复制出来的节点的 sibling
        node = pHead;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        // 拆分原链表和复制链表
        RandomListNode cloneHead = pHead.next;
        node = pHead;
        copy = cloneHead;
        while (copy.next != null) {
            node.next = copy.next;
            copy.next = copy.next.next;
            node = node.next;
            copy = copy.next;
        }
        node.next = null;  // 注意
        return cloneHead;
    }
}
