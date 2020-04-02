import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 给出栈的压入序列顺序和弹出序列顺序，
 * 判断该压入顺序是否可能为该弹出序列
 */
public class Problem31 {
    /**
     * 模拟栈的压入和弹出
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) return false;
        if (pushA.length == 0 && popA.length == 0) return true;
        if (pushA.length == 0 || popA.length == 0) return false;

        Stack<Integer> tempStack = new Stack<>();
        int idx = 0;
        for (int curr : popA) {
            while (true) {
                if (tempStack.empty()) {
                    tempStack.push(pushA[idx++]);
                }
                if (tempStack.peek() == curr) {
                    tempStack.pop();
                    break;
                } else {
                    if (idx < pushA.length) {
                        tempStack.push(pushA[idx++]);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};

        Problem31 p = new Problem31();
        System.out.println(p.IsPopOrder(pushA, popA));
    }
}
