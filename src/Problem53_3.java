/**
 * 数组中数值和下标相等的元素
 */
public class Problem53_3 {
    /**
     * 同样是有序数组，利用二分查找，
     * 主要需要看出二分判断的条件
     */
    public int equalsIndex(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        int m;
        while (l != r) {
            m = (l + r) / 2;
            if (m == nums[m]) {
                return m;
            } else if (nums[m] < m) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Problem53_3 p = new Problem53_3();
        System.out.println(p.equalsIndex(new int[]{-1, 0, 2}));
    }
}
