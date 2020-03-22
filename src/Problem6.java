import entity.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class Problem6 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        Stack<Integer> stack = new Stack<>();
        do {
            stack.push(listNode.val);
            listNode = listNode.next;
        }while (listNode != null);
        ArrayList<Integer> ret = new ArrayList<>();

        while (!stack.empty()) {
            ret.add(stack.pop());
        }
        return ret;
    }
}

