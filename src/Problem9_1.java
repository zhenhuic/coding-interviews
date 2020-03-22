import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 * 入栈：将元素进队列A
 * 出栈：判断队列A中元素的个数是否为1，如果等于1，则出队列，否则将队列A中的元素
 *   依次出队列并放入队列B，直到队列A中的元素留下一个，然后队列A出队列，再把
 *   队列B中的元素出队列以此放入队列A中。
 */
public class Problem9_1 {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        queue1.add(node);
    }

    public int pop() {
        if (queue1.size() == 1) {
            return queue1.remove();
        } else if (queue1.size() > 1) {
            while (queue1.size() != 1) {
                queue2.add(queue1.remove());
            }
            return queue1.remove();
        }else if (!queue2.isEmpty()){
            while (queue2.size() != 1) {
                queue1.add(queue1.remove());
            }
            return queue2.remove();
        }else {
            return queue1.remove();
        }
    }
}
