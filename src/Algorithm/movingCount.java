package Algorithm;

import java.util.*;

/**
 *地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外）
 * ，也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class movingCount {

    public static int count(int x, int y) {
        int result = 0;
        while (x > 0) {
            result += x % 10;
            x = x / 10;
        }
        while (y > 0) {
            result += y % 10;
            y = y / 10;
        }
        return result;
    }

    public static int movingCount(int m, int n, int k) {
        int result = 1;
        int[][] sets = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        sets[0][0] = 1;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            if (x + 1 < m) {
                int tempX = x + 1;
                int count = count(tempX, y);
                if (count <= k && sets[tempX][y] != 1) {
                    result += 1;
                    queue.add(new int[]{tempX, y});
                    sets[tempX][y] = 1;
                }
            }
            if (y + 1 < n) {
                int tempY = y + 1;
                int count = count(x, tempY);
                if (count <= k && sets[x][tempY] != 1) {
                    result += 1;
                    queue.add(new int[]{x, tempY});
                    sets[x][tempY] = 1;
                }
            }

            //只需要考虑向右或者向下
//            if (x - 1 >= 0) {
//                int tempX = x - 1;
//                int count = count(tempX, y);
//                if (count <= k && sets[tempX][y] != 1) {
//                    result += 1;
//                    queue.add(new int[]{tempX, y});
//                    sets[tempX][y] = 1;
//                }
//            }
//            if (y - 1 >= 0) {
//                int tempY = y - 1;
//                int count = count(x, tempY);
//                if (count <= k && sets[x][tempY] != 1) {
//                    result += 1;
//                    queue.add(new int[]{x, tempY});
//                    sets[x][tempY] = 1;
//                }
//            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
        System.out.println(movingCount(3, 1, 0));
    }
}
