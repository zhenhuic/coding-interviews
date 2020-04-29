import java.util.Arrays;

/**
 * 翻转单词顺序
 */
public class Problem58_1 {
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length-1; i >= 0; i--) {
            if (!strArr[i].isEmpty() || !strArr[i].isBlank()) {
                sb.append(strArr[i]).append(" ");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

}
