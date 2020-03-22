/**
 * 二进制中1的个数
 */
public class Problem15 {
    /**
     * 把一个整数减去 1，再和原整数做与运算，
     * 会把该整数最右边的 1 变成 0
     */
    public int NumberOf1_excel(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public int NumberOf1_norm(int n) {
        int a = 1;
        int count = 0;
        while (a != 0) {
            if ((n & a) != 0){
                count++;
            }
            a = a << 1;
        }
        return count;
    }
}
