import java.util.Stack;

/**
 * 用两个栈实现队列
 * 入队：将元素进栈A
 * 出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈；
 *  如果不为空，栈B直接出栈。
 */
public class Problem9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node){
        stack1.push(node);

    }

    public int pop() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }else if (!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else {
            return stack2.pop();
        }
    }
}
