import java.util.Arrays;

/**
 * 扑克牌中的顺子
 */
public class Problem61 {
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length < 5) return false;
        Arrays.sort(nums);
        int zeroNum = 0;
        int prev = -1;
        for (int n : nums) {
            if (n == 0) {
                zeroNum++;
            } else {
                if (prev == -1) {
                    prev = n;
                } else {
                    if (n == prev + 1) {
                        prev = n;
                    } else if (n == prev) {
                        return false;
                    } else {
                        while (zeroNum > 0 && n != prev + 1) {
                            prev++;
                            zeroNum--;
                        }
                        if (n == prev + 1) {
                            prev = n;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
