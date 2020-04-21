/**
 * 丑数
 */
public class Problem49 {
    /**
     * We have an array k of first n ugly number.
     * We only know, at the beginning, the first one, which is 1.
     * And set three pointers (2's pointer, 3's pointers and 5's pointers).
     * Then k[1] = min( k[0]*2, k[0]*3, k[0]*5). The answer is k[0]*2.
     * So we move 2's pointer to 1.
     * Then we test: k[2] = min( k[1]*2, k[0]*3, k[0]*5).
     * And so on. Be careful about the cases such as 6,
     * in which we need to forward both pointers of 2 and 3.
     */
    public int nthUglyNumber(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int p2 = 0, p3 = 0, p5 = 0;
        int[] arr = new int[n];
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(Math.min(arr[p2] * 2, arr[p3] * 3), arr[p5] * 5);
            if (arr[i] == arr[p2] * 2) ++p2;
            if (arr[i] == arr[p3] * 3) ++p3;
            if (arr[i] == arr[p5] * 5) ++p5;
        }
        return arr[n - 1];
    }
}
