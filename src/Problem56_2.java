/**
 * 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，
 * 其他数字都出现了三次（m），找出那个只出现一次的数字
 */
public class Problem56_2 {
    /**
     * 有限状态自动机解法
     *  https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
     */
    public int singleNumberBull(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    /**
     * 遍历统计每位 1 出现的次数，
     * 如果次数能被 m 整数，对应位上是 0，否则是 1
     */
    public int singleNumber(int[] nums) {
        int[] bitSum = new int[32];
        for (int n : nums) {
            int bitMask = 1;
            int bit;
            for (int i = 31; i >= 0 ; i--) {
                bit = n & bitMask;
                if (bit != 0) bitSum[i] += 1;
                bitMask <<= 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += bitSum[i] % 3;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem56_2 p = new Problem56_2();
        System.out.println(p.singleNumber(new int[]{-3, 4, -3, -3}));
    }
}
