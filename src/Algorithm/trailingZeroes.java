package Algorithm;

import java.math.BigInteger;

/**
 *
 * 172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class trailingZeroes {

    public static int trailingZeroes(int n) {
        int result = 0;
        int a = 0;
        int b = 0;
        while (n > 0) {
            int temp = n;
            while (temp % 2 == 0) {
                a ++;
                temp = temp / 2;
            }
            temp = n;
            while (temp % 5 == 0) {
                b ++;
                temp = temp / 5;
            }
            while (a >= 1 && b >= 1) {
                result++;
                a--;
                b--;
            }
            n = n -1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(16));
        System.out.println(trailingZeroes(30));
    }
}
