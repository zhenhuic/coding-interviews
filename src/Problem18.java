import entity.ListNode;


public class Problem18 {
    /**
     * 删除链表的节点
     * 这里给的待删除节点的值，所以需要遍历查找，时间复杂度为 O(n).
     * 原题给出待删除节点的引用，那么可以将该节点后一个节点的数据复制给该节点，
     * 删除该节点的后一个节点，使在时间复杂度为 O(1) 内完成删除节点
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.next == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }

        ListNode front = new ListNode(0);
        front.next = head;
        ListNode target = head;
        while (target.val != val) {
            front = target;
            target = target.next;
        }
        front.next = target.next;
        return head;
    }

    /**
     * 删除链表中重复的节点
     * 小心 NullPointerException，
     * 如果第一个节点就是重复的，这里不全部删除，保留一个做头结点
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        if (pHead.next == null) return pHead;

        // 标志位如果为 true，表示保留了一个重复的做头结点
        boolean flag = false;
        if (pHead.next.val == pHead.val) {
            flag = true;
            while (pHead.next != null && pHead.next.val == pHead.val) {
                pHead = pHead.next;
            }
            if (pHead.next == null) return null;
        }

        ListNode front = new ListNode(0);
        front.next = pHead;

        ListNode current = pHead;

        while (current != null && current.next != null) {
            if (current.next.val != current.val) {
                front = current;
                current = current.next;
            }else {
                while (current.next != null && current.next.val == current.val) {
                    current = current.next;
                }
                current = current.next;
                front.next = current;
            }
        }
        if (!flag) {
            return pHead;
        } else {
            return pHead.next;
        }

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        Problem18 p = new Problem18();
        p.deleteDuplication(null);
    }
}

