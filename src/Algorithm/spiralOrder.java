package Algorithm;

import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class spiralOrder {

    public static int[] spiralOrder(int[][] matrix) {
        int x_min = 0; int x_max = matrix.length;
        if (x_max == 0) {
            return new int[0];
        }
        int y_min = 0; int y_max = matrix[0].length;
        if (y_max == 0) {
            return new int[0];
        }
        int len = x_max * y_max;
        x_max--;y_max--;
        int[] list = new int[len];
        int flag = 0;
        int index = 0;
        while (index < len) {
            if (flag == 0) {
                for (int i = y_min; i <= y_max; i++) {
                    list[index++] = matrix[x_min][i];
                }
                x_min++;
//                x_min = Math.min(x_min, x_max);
                flag = 1;
            } else if (flag == 1) {
                for (int i = x_min; i <= x_max; i++) {
                    list[index++] = matrix[i][y_max];
                }
                y_max--;
//                y_max = Math.max(y_max, y_max);
                flag = 2;
            } else if (flag == 2) {
                for (int i = y_max; i >= y_min; i--) {
                    list[index++] = matrix[x_max][i];
                }
                x_max--;
//                x_max = Math.max(x_max, x_min);
                flag = 3;
            } else if (flag == 3) {
                for (int i = x_max; i >= x_min; i--) {
                    if (y_min >= y_max) {
                        y_min = y_max;
                    }
                    list[index++] = matrix[i][y_min];
                }
                y_min++;
//                y_min = Math.min(y_max, y_min);
                flag = 0;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
//        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
//        int[][] matrix = new int[][]{{3}, {2}};
        System.out.println(Arrays.asList(spiralOrder(matrix)).toString());

    }
}
