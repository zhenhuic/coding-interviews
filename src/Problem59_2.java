import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的最大值
 */
public class Problem59_2 {
    /**
     * 用一个双相对列保存有可能的最大值
     */
    class MaxQueue {
        Queue<Integer> data;
        Deque<Integer> max;

        public MaxQueue() {
            data = new LinkedList<>();
            max = new LinkedList<>();
        }

        public int max_value() {
            return !max.isEmpty() ? max.peekFirst() : -1;
        }

        public void push_back(int value) {
            data.add(value);
            while (!max.isEmpty() && max.peekLast() < value) {
                max.removeLast();
            }
            max.addLast(value);
        }

        public int pop_front() {
            int front = !data.isEmpty() ? data.poll() : -1;
            if (!max.isEmpty() && max.peekFirst() == front) {
                max.removeFirst();
            }
            return front;
        }
    }
}
