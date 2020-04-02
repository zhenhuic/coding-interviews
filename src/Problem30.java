import java.util.Stack;

/**
 * 包含 min 函数的栈
 */
public class Problem30 {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if (dataStack.empty()) {
            minStack.push(node);
        } else {
            int min = dataStack.peek();
            if (min <= node) {
                minStack.push(min);
            } else {
                minStack.push(node);
            }
        }
        dataStack.push(node);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
