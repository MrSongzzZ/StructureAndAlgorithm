package Algorithm;

/**
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 * 示例 2：
 *
 * 输入：matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 */
public class countSquares {

    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = Math.min(n, m);
        int result = 0;
        int[][][] dp = new int[m][n][l];
        for (int i = 0; i < l; i++) {
            for (int x = 0; x + i < m; x++) {
                for (int y = 0; y + i < n; y++) {
                    if (i == 0) {
                        if (matrix[x][y] == 1) {
                            dp[x][y][0] = 1;
                            result += 1;
                        }
                    } else {
                        if (dp[x][y][i - 1] == 1 && dp[x + 1][y][i - 1] == 1 && dp[x][y + 1][i - 1] == 1 && dp[x + 1][y + 1][i - 1] == 1) {
                            dp[x][y][i] = 1;
                            result += 1;
                        } else {
                            dp[x][y][i] = 0;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSquares(new int[][]{{0,1,1,1}, {1,1,1,1},{0,1,1,1}}));
    }
}
