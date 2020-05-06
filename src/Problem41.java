import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中的中位数
 */
public class Problem41 {
    /**
     * 维护两个堆（或者 priority queues）：
     * 最大堆 small 保存较小的一般数据；
     * 最小堆 large 保存较大的一般数据。
     */
    static class MedianFinder {
        Queue<Long> large = new PriorityQueue<>(),
                small = new PriorityQueue<>();

        public void addNum(int num) {
            large.add((long) num);  // 当 int 类型 -2**31 取相反数会出问题，所以用范围更大的 long 类型存储
            small.add(-large.remove());  // 保存相反数，相当于原数据的最大堆，
            if (large.size() < small.size()) {
                large.add(-small.remove());
            }
        }

        public double findMedian() {
            return large.size() > small.size() ?
                    large.peek() :
                    (large.peek() - small.peek()) / 2.0;
        }
    }
}
