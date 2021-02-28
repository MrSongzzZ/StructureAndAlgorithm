package Algorithm;

import java.util.Arrays;

/**
 *
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 */
public class setZeroes {

    public static void setZeroes(int[][] matrix) {

        boolean flag = false;


        //用第一个数标记 第一行是否有0
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                flag = true;
            }
        }

        //用一个额外的变量标记 当前列是否为0
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                matrix[0][0] = 0;
            }
        }

        //如果一个点为0  将这个点的行头 和 列头标记为0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //如果该点的 列头 或者 行头为0 意味着  这行或者这列 有过0  那么这个点就为0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //第一行有0时 该行 置零
        if (matrix[0][0] == 0) {
            Arrays.fill(matrix[0], 0);
        }

        //第一列有0时 该列置零
        if (flag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        System.out.println("a");

    }

    public static void main(String[] args) {
        setZeroes(new int[][]{{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}});
//        setZeroes(new int[][]{{0, 1}});
    }
}
