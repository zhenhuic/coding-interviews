/**
 * 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数
 */
public class Problem53_1 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int firstIndex = findFirst(nums, target, 0, nums.length - 1);
        int lastIndex = findLast(nums, target, 0, nums.length - 1);
        if (firstIndex == -1) return 0;
        return lastIndex - firstIndex + 1;
    }

    private int findFirst(int[] nums, int target, int l, int r) {
        if (l == r && nums[l] != target) return -1;
        int m = (l + r) / 2;
        if (nums[m] == target && (m == 0 || nums[m - 1] < target)) return m;

        if (nums[m] > target || (nums[m] == target && nums[m - 1] == target)) {
            return findFirst(nums, target, l, m);
        }

        if (nums[m] < target) {
            return findFirst(nums, target, m + 1, r);
        }
        return -1;
    }

    private int findLast(int[] nums, int target, int l, int r) {
        if (l == r && nums[l] != target) return -1;
        int m = (l + r) / 2;
        if (nums[m] == target && (m == nums.length - 1 || nums[m + 1] > target)) return m;

        if (nums[m] < target || (nums[m] == target && nums[m + 1] == target)) {
            return findLast(nums, target, m + 1, r);
        }

        if (nums[m] > target) {
            return findLast(nums, target, l, m);
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem53_1 p = new Problem53_1();
        System.out.println(p.search(new int[]{5, 7, 7, 8, 8, 10}, 0));
    }
}
