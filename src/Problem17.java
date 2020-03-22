import java.util.ArrayList;
import java.util.Arrays;

/**
 * 打印从1到最大的n位数
 * 利用 char[] 对每一位上 0-9 做全排列，
 * 递归按 1到最大数顺序输出，
 * 也可以用数组模拟加法的方式
 */
public class Problem17 {
    public int[] printNumbers(int n) {
        if (n <= 0) {
            return null;
        }
        char[] number = new char[n];
        ArrayList<String> stringNumbers = new ArrayList<>();
        print1toMaxOfNDigits(number, 0, stringNumbers);

        int[] numbers = new int[stringNumbers.size() - 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers.get(i + 1));
        }
        return numbers;
    }

    private void print1toMaxOfNDigits(char[] number, int digit, ArrayList<String> stringNumbers) {
        if (digit == number.length) {
            stringNumbers.add(String.valueOf(number));
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1toMaxOfNDigits(number, digit + 1, stringNumbers);
        }
    }

    public static void main(String[] args) {
        Problem17 problem17 = new Problem17();
        int[] a = problem17.printNumbers(1);
        System.out.println(Arrays.toString(a));
    }
}
