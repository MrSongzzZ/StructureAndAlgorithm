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
        int result = 0;
        int[][] dp = new int[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (matrix[x][y] == 0) {
                    dp[x][y] = 0;
                } else {
                    if (x > 0 && y > 0) {
                        dp[x][y] = 1 + Math.min(dp[x - 1][y], Math.min(dp[x][y - 1], dp[x - 1][y - 1]));
                    } else {
                        dp[x][y] = 1;
                    }
                }
                result += dp[x][y];
            }
        }
        return result;
    }

//    public static int countSquares(int[][] matrix) {
//        if (matrix.length < 1) {
//            return 0;
//        }
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        int[][] dp = new int[m][n];
//
//        int rs = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    dp[i][j] = 0;
//                } else {
//                    if (i > 0 && j > 0) {
//                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
//                    } else {
//                        dp[i][j] = 1;
//                    }
//                    rs += dp[i][j];
//                }
//            }
//        }
//        return rs;
//    }


    public static void main(String[] args) {
        System.out.println(countSquares(new int[][]{{0,1,1,1}, {1,1,1,1},{0,1,1,1}}));
    }
}
