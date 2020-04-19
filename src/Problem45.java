import java.util.Arrays;

/**
 * 把数组排成最小的数
 */
public class Problem45 {
    /**
     * 思路：给出数字 m 和 n，判断拼接后的数字 mn 和 nm 的大小
     */
    public String minNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(strNums, ((o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) < s2.charAt(i)) {
                    return -1;
                } else if (s1.charAt(i) > s2.charAt(i)) {
                    return 1;
                }
            }
            return 0;
        }));

        StringBuilder ret = new StringBuilder();
        for (String s : strNums) {
            ret.append(s);
        }
        return ret.toString();

    }
}
