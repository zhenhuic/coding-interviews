/**
 * 和为s的两个数字
 */
public class Problem57_1 {
    /**
     * 有序数组，利用双指针啊，这都没想到！
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        int i = 0, j = nums.length - 1;
        int sum;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[]{};
    }
}
