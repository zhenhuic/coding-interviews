/**
 * 数组中数字出现的次数
 */
public class Problem56_1 {
    /**
     * 先从头到尾依次异或数组中的每个数字，
     * 最终的到的结果就是两个只出现一次的数字的异或结果；
     * 由于这两个数字肯定不一样，那么异或的结果肯定不为 0，
     * 也就是说，在这个结果数字的二进制表示中至少有一位为 1；
     * 找到第一个为 1 的位的位置，记为第 n 位，
     * 以第 n 位是不是 1 为标准把原数组中的数字分成两个子数组，
     * 第一个子数组中每个数字的第 n 位都是 1，
     * 而第二个子数组中每个数字的第 n 位都是 0。
     * 再分别对这两个子数组的每个数字依次异或。
     */
    public int[] singleNumbers(int[] nums) {
        if (nums == null) return null;
        int two = 0;
        for (int n : nums) {
            two ^= n;
        }
        int i;
        for (i = 0; i < 31; i++) {
            if ((two & 1) == 1) break;
            two >>= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if (((num >> i) & 1) == 1) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
