/**
 * 圆圈中最后剩下的数字
 */
public class Problem62 {
    /**
     * 公式：
     *           | 0                    , if n = 1;
     * f(n, m) = |
     *           | (f(n - 1, m) + m) % n, if n > 1.
     */
    public int lastRemainingBull(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    /**
     * 用环形链表模拟圆圈
     * 还是用 ArrayList 吧
     */
    public int lastRemaining(int n, int m) {
        return 0;
    }
}
