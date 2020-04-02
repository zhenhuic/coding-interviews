import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 */
public class Problem29 {
    /**
     * 多个循环嵌套，提取出最内圈特例情况
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return null;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int dim = Math.min(row, column);
        int circle;
        if ((dim & 1) == 1) {
            circle = (dim >> 1) + 1;
        }else {
            circle = dim >> 1;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < circle; i++) {
            for (int j = i; j < column - i; j++) {
                result.add(matrix[i][j]);
            }
            if ((row-i) - i == 1) break;  // 只剩最后一行时
            for (int j = i + 1; j < row - i; j++) {
                result.add(matrix[j][column - 1 - i]);
            }
            if (column - i - i == 1) break;  // 只剩最后一列时
            for (int j = column - 2 - i; j >= i; j--) {
                result.add(matrix[row - 1 - i][j]);
            }
            if ((row-i) - i == 2) break;  // 只剩最后两行时
            for (int j = row - 2 - i; j > i; j--) {
                result.add(matrix[j][i]);
            }

        }
        return result;
    }

    public static void main(String[] args) {

//        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
//        int[][] matrix = {{1,2,3,4,5}};
//        int[][] matrix = {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12}
//        };
        int[][] matrix = {
                {1,2},
                {3,4},
                {5,6},
                {7,8},
                {9,10}
        };

        Problem29 p = new Problem29();
        System.out.println(p.printMatrix(matrix));
    }
}
