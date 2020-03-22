/**
 * 剪绳子
 */
public class Problem14 {
    public int cutRope(int target) {
        if (target < 2) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;

        int[] temp = new int[target + 1];
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 2;
        temp[3] = 3;

        int max;
        for (int i = 4; i < target + 1; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int mul = temp[j] * temp[i - j];
                if (mul > max) {
                    max = mul;
                }
            }
            temp[i] = max;
        }
        return temp[target];
    }

    public static void main(String[] args) {
        Problem14 p = new Problem14();
        System.out.println(p.cutRope(8));

    }
}
