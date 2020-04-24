import java.util.Arrays;

/**
 * 数组中的逆序对
 */
public class Problem51 {
    /**
     * 利用归并排序，如果左边组有元素大于右边组的元素，那么就存在逆序对
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return reversePairsCore(nums, 0, nums.length - 1);
    }

    /**
     * 归并排序
     */
    private int reversePairsCore(int[] nums, int l, int r) {
        if (l == r) return 0;

        int m = (l + r) / 2;
        int lNum = reversePairsCore(nums, l, m);
        int rNum = reversePairsCore(nums, m+1, r);
        int cnt = 0;

        int[] copy = Arrays.copyOfRange(nums, l, r + 1);
        int i = 0, j = m + 1 - l, k = l;
        while (i <= m - l && j <= r - l) {
            if (copy[i] > copy[j]) {
                cnt += (m - l - i +1);
                nums[k] = copy[j++];
            } else {
                nums[k] = copy[i++];
            }
            ++k;
        }
        while (i <= m - l) {
            nums[k] = copy[i++];
            ++k;
        }
        while (j <= r - l) {
            nums[k] = copy[j++];
            ++k;
        }
        return lNum + rNum + cnt;
    }

    public static void main(String[] args) {
        Problem51 p = new Problem51();
        System.out.println(p.reversePairs(new int[]{7, 5, 6, 4}));
    }
}
