/**
 * 数组中重复的数字
 */
public class Problem3 {

    /**
     * 因为题目确定了数字都在0~n-1范围内，所以可以用数组内的值来索引，最终找到重复的数字
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    /**
     * 题目确定了数字都在0~n-1范围内，所以可以利用现有数组设置标志，
     * 当一个数字被访问过后，可以设置对应位上的数 + n，之后再遇到相同的数时，
     * 会发现对应位上的数已经大于等于n了，那么直接返回这个数即可。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicateRecommended(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int index = numbers[i];

            if (index >= length) {
                index -= length;
            }
            if (numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] += length;
        }
        return false;
    }


}
