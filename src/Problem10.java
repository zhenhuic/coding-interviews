/**
 * 斐波那契数列
 * 青蛙跳台阶问题
 * 2x1小矩形覆盖大矩形问题
 */
public class Problem10 {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int fibFront = 0;
        int fibRear = 1;
        int sum = 0;
        for (int i = 2; i < n+1; i++) {
            sum = fibFront + fibRear;
            fibFront = fibRear;
            fibRear = sum;
        }
        return sum;
    }
}
