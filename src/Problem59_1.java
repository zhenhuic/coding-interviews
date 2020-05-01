import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 滑动窗口的最大值
 */
public class Problem59_1 {
    /**
     * 方法 1. 用一个双向队列，只把有可能成为滑动窗口最大值的索引存入队列。
     * 方法 2. 利用双栈模拟队列，仿照 Problem 30 用 O(1) 时间得到最大值的栈的最大值。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        res.add(nums[dq.getFirst()]);
        for (int i = k; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.getFirst() == i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            res.add(nums[dq.getFirst()]);
        }
        int[] ret =  new int[res.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
