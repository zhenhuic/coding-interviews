/**
 * 左旋转字符串
 */
public class Problem58_2 {
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.isEmpty() || s.isBlank()) return s;
        n = n % s.length();
        return s.substring(n) + s.substring(0, n);
    }
}
