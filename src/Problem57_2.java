import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和为s的连续正数序列
 */
public class Problem57_2 {
    /**
     * 有序数组，双指针滑动窗口
     */
    public int[][] findContinuousSequence(int target) {
        int l = 1, r = 1;
        int sum = 0;
        List<int[]> result = new ArrayList<>();
        while (l <= target / 2) {
            if (sum < target) {
                sum += r;
                r++;
            } else if (sum > target) {
                sum -= l;
                l++;
            } else {
                int[] arr = new int[r - l];
                for (int i = l; i < r; i++) {
                    arr[i - l] = i;
                }
                result.add(arr);
                sum -= l;
                l++;
            }
        }
        return result.toArray(new int[result.size()][]);  // 传入初始化的数组，不能使用强转
    }

    public static void main(String[] args) {
        Problem57_2 p = new Problem57_2();
        System.out.println(Arrays.deepToString(p.findContinuousSequence(9)));
    }
}
