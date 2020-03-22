/**
 * 旋转数组的最小数字
 * 二分查找
 */
public class Problem11 {
    public int minNumberInRotateArray(int [] array) {
        int pFront = 0;
        int pRear = array.length - 1;
        int pMid = (pFront + pRear) / 2;

        while (pRear - pFront != 1) {
            if (array[pMid] == array[pFront] && array[pFront] == array[pRear]) {
                return oneByOne(array, pFront, pRear);
            }

            if (array[pMid] >= array[pFront]) {
                pFront = pMid;
                pMid = (pFront + pRear) / 2;
            } else if (array[pMid] <= array[pRear]) {
                pRear = pMid;
                pMid = (pFront + pRear) / 2;
            }
        }
        return Math.min(array[pFront], array[pRear]);

    }

    private int oneByOne(int[] array, int startIndex, int endIndex) {
        int min = array[startIndex];
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }

    public static void main(String[] args) {
        var p = new Problem11();

        int[] a = {3, 4, 5, 1, 2};
        System.out.println(p.minNumberInRotateArray(a));
    }
}
