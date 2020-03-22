/**
 * 机器人的运动范围
 */
public class Problem13 {
    public int movingCount(int threshold, int rows, int cols)
    {
        int[][] visited = new int[rows][cols];

        return moving(threshold, rows, cols, 0, 0, visited);

    }

    private int moving(int threshold, int rows, int cols, int x, int y, int[][] visited) {
        if (x >= rows || y >= cols || visited[x][y] != 0 || numSum(x) + numSum(y) > threshold){
            return 0;
        }
        visited[x][y] = 1;
        return 1 + moving(threshold, rows, cols, x + 1, y, visited)
                + moving(threshold, rows, cols, x, y + 1, visited)
                + moving(threshold, rows, cols, x + 1, y + 1, visited);

    }

    /**
     * 求整数的各位数之和
     */
    private int numSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + (num % 10);
            num = num / 10;
        }
        return sum;
    }
}
