public class Problem4 {

    /**
     * 二维数组中的查找
     * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
     * 因此从左下角开始查找，当要查找数字比左下角数字大时, 右移;
     * 要查找数字比左下角数字小时，上移。
     */
    public boolean Find(int target, int [][] array) {
        if (array == null) {
            return false;
        }

        int i = array.length - 1;
        int j = 0;

        while (i >= 0 && j < array[0].length) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                i--;
            }else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        int[][] array = {{1,2,8,9},
                         {2,4,9,12},
                         {4,7,10,13},
                         {6,8,11,15}};
        System.out.println(problem4.Find(7, array));
    }
}
