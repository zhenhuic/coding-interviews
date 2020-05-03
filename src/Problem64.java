/**
 * 求 1+2+…+n
 * 要求不能使用乘除法、for、while、if、else、
 * switch、case等关键字及条件判断语句（A?B:C）
 */
public class Problem64 {
    /**
     * 递归，逻辑运算符的短路效应
     *  “与 &&”，“或 ||”，“非 !” 有重要的短路效应
     *
     *  if(A && B)  // 若 A 为 false ，则 B 的判断不会执行（即短路），直接判定 A && B 为 false
     *  if(A || B) // 若 A 为 true ，则 B 的判断不会执行（即短路），直接判定 A || B 为 true
     */
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;  // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
        return n;
    }
}
