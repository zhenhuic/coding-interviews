import java.util.Arrays;

/**
 * 最小的k个数
 */
public class Problem40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k > arr.length || arr.length == 0 || k <= 0) return new int[k];

        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOfRange(arr, 0, k);
    }

    /**
     * 快速排序
     */
    private void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int index = partition(arr, l, r);
            quickSort(arr, l, index - 1);
            quickSort(arr, index + 1, r);
        }
    }

    private int partition(int[] arr, int l, int r) {
        int m = arr[l];
        int i = l;
        int j = r;

        while (i < j) {
            // 这里注意顺序，因为基数取的是arr[l]，所以要先从右到左找小于基数的索引
            while (arr[j] >= m && i < j) {
                --j;
            }
            while (arr[i] <= m && i < j) {
                ++i;
            }
            if (i < j) swap(arr, i, j);
        }
        swap(arr, l, i);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Problem40 p = new Problem40();
        int[] leastNumbers = p.getLeastNumbers(new int[]{2, 3, 1}, 2);
        System.out.println(Arrays.toString(leastNumbers));
    }
}
