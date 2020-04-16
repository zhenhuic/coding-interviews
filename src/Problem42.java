/**
 * 连续子数组的最大和
 */
public class Problem42 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;

        int maxSum = nums[0];
        int sum = maxSum;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
