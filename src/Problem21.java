import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
 * 原题不需要保证奇偶数各自相对位置不变，可以采用双指针方法
 *
 */
public class Problem21 {
    public void reOrderArray(int[] array) {
        int evenIndex = 0;
        while (evenIndex < array.length && (array[evenIndex] & 1) == 1) {
            evenIndex++;
        }
        if (evenIndex == array.length || evenIndex == array.length - 1) return;

        int oddIndex = evenIndex + 1;

        int temp;
        while (oddIndex < array.length) {
            if ((array[oddIndex] & 1) == 1) {
                temp = array[oddIndex];
                for (int i = oddIndex - 1; i >= evenIndex; i--) {
                    array[i + 1] = array[i];
                }
                array[evenIndex] = temp;
                evenIndex++;
            }
            oddIndex++;
        }
    }
}
