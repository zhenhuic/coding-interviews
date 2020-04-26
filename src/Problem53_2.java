/**
 * 0～n-1中缺失的数字
 */
public class Problem53_2 {
    /**
     * 有序数组就应该想到用二分查找
     * 如果该索引上的数据等于索引的值，那么缺失的数在它的右边；
     * 如果索引上的数据大于索引的值，缺失的数在它的左边。
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        int m;
        while (l != r) {
            m = (l + r) / 2;
            if (nums[m] == m) {
                l = m + 1;
            } else if (nums[m] > m) {
                r = m;
            }
        }
        return nums[l] != l ? l : l + 1;
    }

    public static void main(String[] args) {
        Problem53_2 p = new Problem53_2();
        System.out.println(p.missingNumber(new int[]{0, 1, 2, 4}));
    }
}
