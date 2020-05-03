/**
 * 不用加减乘除做加法
 */
public class Problem65 {
    /**
     * 求和 s = a + b，a(i)代表 a 的二进制第 i 位，
     *
     *  a(i) b(i) 无进位和 n(i) 进位 c(i+1)
     *    0    0    0            0
     *    0    1    1            0
     *    1    0    1            0
     *    1    1    0            1
     * 观察发现，无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位）。
     */
    public int add(int a, int b) {
        int c;
        while (b != 0) {  // 当进位为 0 时跳出
            c = (a & b) << 1;  // c = 进位
            a ^= b;  // a = 非进位和
            b = c;  // b = 进位
        }
        return a;
    }
}
