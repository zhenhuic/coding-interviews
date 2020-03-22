public class Problem5 {

    /**
     * 替换空格
     * 1. 替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换！
     * 2. 在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）,
     * 从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下,
     * 从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }

        int len = str.length();
        int numBlank = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                numBlank++;
            }
        }
        int newLen = len + 2 * numBlank;
        str.setLength(newLen);

        int oldIdx = len - 1;
        int newIdx = newLen - 1;

        char ch;
        for (; oldIdx >= 0 && newIdx >= 0; oldIdx--) {
            ch = str.charAt(oldIdx);
            if (ch == ' ') {
                str.setCharAt(newIdx--, '0');
                str.setCharAt(newIdx--, '2');
                str.setCharAt(newIdx--, '%');
            }else {
                str.setCharAt(newIdx--, ch);
            }
        }
        return str.toString();
    }
}
