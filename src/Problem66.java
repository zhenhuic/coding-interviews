/**
 * 构建乘积数组
 * 给定一个数组 A[0,1,...,n-1]，请构建一个数组 B[0,1,...,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×...×A[i-1]×A[i+1]×...×A[n-1]。
 * 不能使用除法。
 */
public class Problem66 {
    /**
     * C[i] = A[0] * A[1] * ... * A[i - 1],
     * D[i] = A[i + 1] * A[i + 2] * ... * A[n - 1],
     * Answer: B[i] = C[i] * D[i].
     */
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return new int[0];
        int[] arr1 = new int[a.length];
        int[] arr2 = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i != 0) {
                arr1[i] = arr1[i - 1] * a[i - 1];
                arr2[a.length - i - 1] = arr2[a.length - i] * a[a.length - i];
            } else {
                arr1[i] = 1;
                arr2[a.length - i - 1] = 1;
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] * arr2[i];
        }
        return arr1;
    }
}
