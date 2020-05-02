import java.util.Arrays;

/**
 * n 个骰子的点数
 */
public class Problem60 {
    /**
     * 递归的思路总能转换为逆向的循环求解。
     * 这里用两个数组存放骰子的每个点数之和出现的次数，
     * 依次从骰子个数为 1~n 计算点数之和出现的次数，
     * 有 n 个骰子时，点数之和为 s 的个数是在 n-1 个骰子时，
     * 点数之和为 s-1，s-2，s-3，s-4，s-5，s-6 的次数之和。
     */
    public double[] twoSum(int n) {
        if (n == 0) return new double[0];
        final int diceMaxValue = 6;
        int[][] cnt = new int[2][n * diceMaxValue + 1];
        int flag = 0;
        for (int i = 1; i <= diceMaxValue; i++) {
            cnt[flag][i] = 1;
        }
        flag = 1 - flag;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                cnt[flag][j] = 0;
            }
            for (int j = i; j <= i * diceMaxValue; j++) {
                cnt[flag][j] = 0;
                for (int k = j - 1; k > 0 && k >= j - diceMaxValue ; k--) {
                    cnt[flag][j] += cnt[1 - flag][k];
                }
            }
            flag = 1 - flag;
        }
        double[] res = new double[n * diceMaxValue - n + 1];
        double total = Math.pow(diceMaxValue, n);
        for (int i = n; i <= n * diceMaxValue; i++) {
            res[i - n] = (double) cnt[1- flag][i] / total;
        }
        return res;
    }

    public static void main(String[] args) {
        var p = new Problem60();
        System.out.println(Arrays.toString(p.twoSum(2)));
    }
}
