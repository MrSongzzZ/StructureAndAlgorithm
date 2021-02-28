package Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0

 */
public class reverse {

    public static int reverse(int x) {
        int result = 0;
        int falg = 1;
        if (x < 0) {
            falg = -1;
            x *= falg;
        }
        while (x > 0) {
            int temp = x % 10;
            x = x / 10;
            if (result * 10 / 10 != result) {
                return 0;
            }
            result = result * 10 + temp;
        }

        return result * falg;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
