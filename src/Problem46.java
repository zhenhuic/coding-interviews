/**
 * 把数字翻译成字符串
 */
public class Problem46 {
    /**
     * 动态规划，`f(i) = f(i + 1) + g(i, i + 1) * f(i + 2)`，
     * 当第 i 位和第 i+1 位两位数字拼接起来的数字在 10~25 的范围内时，
     * 函数 g(i, i + 1) 的值位 1，否则为 0。
     *
     * 通常动态规划的问题可以用递归来实现，但是由于存在重复的子问题，
     * 这里用一个数组保存子问题的个数。
     */
    public int translateNum(int num) {
        String str = Integer.toString(num);
        int[] counts = new int[str.length()];
        counts[0] = 1;
        int cnt = 0;
        int n;
        for (int i = 1; i < str.length(); i++) {
            cnt = counts[i - 1];
            n = Character.getNumericValue(str.charAt(i - 1)) * 10 + Character.getNumericValue(str.charAt(i));
            if (n >= 10 && n <= 25) {
                if (i > 1) {
                    cnt += counts[i - 2];
                } else {
                    ++cnt;
                }
            }
            counts[i] = cnt;
        }
        return counts[str.length() - 1];
    }
}
