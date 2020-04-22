import java.util.Arrays;

/**
 * 第一个只出现一次的字符
 */
public class Problem50 {
    /**
     * 可以用一个初始大小为256的 HashMap 记录次数；
     * 这里用了一个大小为256的数组记录，用字符的值做数组索引，
     * 数组里存放字符在字符串中的索引，当该字符第二次出现时，
     * 加上一个字符串的长度值，用来标记重复出现过。
     */
    public char firstUniqChar(String s) {
        if (s.isEmpty()) return ' ';
        int[] cnt = new int[256];
        Arrays.fill(cnt, -1);
        int len = s.length();
        int index;
        for (int i = 0; i < len; i++) {
            index = s.charAt(i);
            if (cnt[index] > -1) {
                cnt[index] += len;
            } else {
                cnt[index] = i;
            }
        }
        int first = len;
        for (int value : cnt) {
            if (value > -1 && value < len && first > value) {
                first = value;
            }
        }
        return first < len ? s.charAt(first) : ' ';
    }

    public static void main(String[] args) {
        Problem50 p = new Problem50();
        System.out.println(p.firstUniqChar("cc"));
    }
}
