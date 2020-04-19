/**
 * 数组序列中某一位的数字
 */
public class Problem44 {
    /**
     * 找出数字序列规律，注意每个索引都从 0 开始
     */
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            ++len;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        return Character.getNumericValue(Integer.toString(start).charAt((n - 1) % len));

    }

    public static void main(String[] args) {
        Problem44 p = new Problem44();
        System.out.println(p.findNthDigit(2890));
    }
}
