/**
 * 数值的整数次方
 * 完整性考虑，exponent 的正负情况，
 * 利用 (exponent & 1) == 0 代替求余 % 运算，判断整数奇偶性，
 * 利用位移运算代替乘除
 */
public class Problem16 {
    public double Power(double base, int exponent) {
        if (exponent < 0) {
            return 1 / PowerWithUnsignedExponent(base, -exponent);
        }else {
            return PowerWithUnsignedExponent(base, exponent);
        }
    }

        public double PowerWithUnsignedExponent(double base, int exponent) {
            if (base == 0) return 0;
            if (exponent == 0) return 1;
            if (exponent == 1) return base;

            if ((exponent & 1) == 0){
                return Power(base, exponent >> 1)
                        * Power(base, exponent >> 1);
            }else {
                return Power(base, (exponent - 1) >> 1)
                        * Power(base, (exponent - 1) >> 1)
                        * base;
            }
    }

    public static void main(String[] args) {
        Problem16 p = new Problem16();
        System.out.println(p.Power(2, 3));
    }
}
