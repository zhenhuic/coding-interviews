import java.util.*;

/**
 * 字符串的排列
 * 全排列算法
 */
public class Problem38 {
    /**
     * 递归算法
     */
    public ArrayList<String> Permutation1(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str != null && str.length() > 0) {
            char[] chars = str.toCharArray();
            permutationHelper(chars, 0, result);
            Collections.sort(result);
        }
        return result;
    }

    private void permutationHelper(char[] chars, int index, ArrayList<String> result) {
        if (index == chars.length - 1) {
            result.add(String.valueOf(chars));
        } else {
            Set<Character> charSet = new HashSet<>();
            for (int i = index; i < chars.length; i++) {
                if (i == index || !charSet.contains(chars[i])) {
                    charSet.add(chars[index]);
                    swap(chars, i, index);
                    permutationHelper(chars, index + 1, result);
                    swap(chars, i, index);
                }
            }
        }
    }

    private void swap(char[] chars, int idx1, int idx2) {
        char c = chars[idx1];
        chars[idx1] = chars[idx2];
        chars[idx2] = c;
    }


    /**
     * 字典序排列算法
     */
    public ArrayList<String> Permutation2(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        list.add(String.valueOf(chars));
        int len = chars.length;
        while (true) {
            int lIndex = len - 1;
            int rIndex;
            while (lIndex >= 1 && chars[lIndex - 1] >= chars[lIndex]) {
                lIndex--;
            }
            if (lIndex == 0) break;
            rIndex = lIndex;
            while (rIndex < len && chars[rIndex] > chars[lIndex - 1]) {
                rIndex++;
            }
            swap(chars, lIndex - 1, rIndex - 1);
            reverse(chars, lIndex);
            list.add(String.valueOf(chars));
        }
        return list;
    }

    private void reverse(char[] chars, int k) {
        if (chars == null || chars.length <= k) {
            return;
        }
        int len = chars.length;
        for (int i = 0; i < (len - k) / 2; i++) {
            int m = k + i;
            int n = len - 1 - i;
            if (m <= n) {
                swap(chars, m, n);
            }
        }
    }
}
