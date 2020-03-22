/**
 * 表示数值的字符串
 * 字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值
 * "12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是
 */
public class Problem20 {
    public boolean isNumeric(char[] str) {
        // 0： 正负符号；1：符号之后，e之前；2：e之后的符号；3：指数符号之后
        int status = 0;
        boolean num = false;
        boolean point = false;
        boolean exp = false;
        boolean expNum = false;

        for (char curr : str) {
            if (status == 0 || status == 2) {
                ++status;
                if (curr == '+' || curr == '-') {
                    continue;
                }
            }

            if (status == 1) {
                if ((curr == 'e' || curr == 'E')) {
                    if (exp || !num) return false;
                    exp = true;
                    ++status;
                    continue;
                }
                if (curr == '.') {
                    if (!point) {
                        point = true;
                    } else {
                        return false;
                    }
                } else if (!(curr >= '0' && curr <= '9')) {
                    return false;
                } else {
                    num = true;
                    continue;
                }
            }

            if (status == 3) {
                if (!(curr >= '0' && curr <= '9')) {
                    return false;
                } else {
                    expNum = true;
                }
            }
        }

        if (num) {
            if (exp) {
                return expNum;
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Problem20 p = new Problem20();
        char[] c = {'1', '0', '0'};
        System.out.println(p.isNumeric(c));;
    }
}
