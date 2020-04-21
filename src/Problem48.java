import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 */
public class Problem48 {
    /**
     * 动态规划问题，题解很牛逼
     * 字符串中只含有字母的情况
     */
    public int lengthOfLongestSubstringOnlyLetters(String s) {
        if (s.length() == 0) return 0;
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        int maxLen = 0;
        int currLen = 0;

        int index;
        for (int i = 0; i < s.length(); i++) {
            index = s.charAt(i) - 'a';
            if (pos[index] < 0 || i - pos[index] > currLen) {
                ++currLen;
            } else {
                if (currLen > maxLen) maxLen = currLen;
                currLen = i - pos[index];
            }
            pos[index] = i;
        }
        if (currLen > maxLen) maxLen = currLen;
        return maxLen;
    }

    /**
     * 利用 HashMap 保存字符和位置索引
     */
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        if (l < 2) return l;
        Map<Character, Integer> pos = new HashMap<>();
        int maxLen = 0;
        int currLen = 0;

        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            Integer index = pos.get(c);
            if (index == null || i - index > currLen) {
                ++currLen;
            } else {
                if (currLen > maxLen) maxLen = currLen;
                currLen = i - index;
            }
            pos.put(c, i);
        }
        if (currLen > maxLen) maxLen = currLen;
        return maxLen;
    }
}
