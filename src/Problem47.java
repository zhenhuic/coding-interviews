/**
 * 礼物的最大价值
 */
public class Problem47 {
    /**
     * 动态规划问题，用一个二维数组缓存中间计算结果，
     * 数组中坐标为 (i, j) 的元素表示到达该坐标格子能拿到的礼物最大值。
     * 非最优解，因为缓存了到达每个位置的礼物最大值，照成空间浪费。
     */
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int row = grid.length;
        int col = grid[0].length;
        int[][] value = new int[row][col];

        int left, up;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                left = 0;
                up = 0;
                if (i > 0) up = value[i - 1][j];
                if (j > 0) left = value[i][j - 1];
                value[i][j] = Math.max(left, up) + grid[i][j];
            }
        }
        return value[row - 1][col - 1];
    }

    /**
     * 只缓存每一行的记录
     */
    public int maxValueRecommended(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int row = grid.length;
        int col = grid[0].length;
        int[] value = new int[col];

        int left, up;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                left = 0;
                up = 0;
                if (i > 0) up = value[j];
                if (j > 0) left = value[j - 1];
                value[j] = Math.max(left, up) + grid[i][j];
            }
        }
        return value[row - 1];
    }

}
