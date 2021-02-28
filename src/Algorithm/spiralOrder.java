package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * q54
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

    public static List<Integer> spiralOrder(int[][] matrix) {
        int xMin = 0;
        int xMax = matrix.length;
        int yMin = 0;
        int yMax = matrix[0].length;
        int length = xMax * yMax;
        List<Integer> result = new ArrayList<>();
        int x = 0;
        int y = 0;
        int flag = 1;
        result.add(matrix[x][y]);
        while (true) {
            if (result.size() == length) {
                break;
            }
            if (flag == 0) {
                if (x < xMax - 1) {
                    x++;
                    result.add(matrix[x][y]);
                }
                if (x == xMax - 1) {
                    yMax--;//2
                    flag = 3;
                }
            } else if (flag == 1) {
                if (y < yMax - 1) {
                    y++;
                    result.add(matrix[x][y]);
                }
                if (y == yMax - 1) {
                    flag = 0;
                    xMin++;
                }
            } else if (flag == 2) {
                x--;
                result.add(matrix[x][y]);
                if (x == xMin) {
                    flag = 1;
                    yMin++; //1
                }
            } else {
                y--;
                result.add(matrix[x][y]);
                if (y == yMin) {
                    flag = 2;
                    xMax--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
//        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
//        int[][] matrix = new int[][]{{3}, {2}};
        int[][] matrix = new int[][]{{3}};
        System.out.println(spiralOrder(matrix));

    }
}
