package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *  示例 1:
 *  输入: 12258
 *  输出: 5                          12258    12258   12258   12258   12258
 *  解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  提示：
 *  0 <= num < 2^31
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class translateNum {


    //动态规划
    public static int translateNum(int num) {
        //自顶向下
        int result = 0;
        if (num == 0) {
            return 1;
        }
        int x = num % 10;
        num = num / 10;
        int y = num % 10;
        if (y > 0 && (y * 10) + x < 26) {
            result = translateNum(num / 10) + translateNum(num);
        } else {
            result = translateNum(num);
        }
        return result;

        //自底向上
//        if (num == 0) {
//            return 1;
//        }
//        int a = 1;
//        int b = 1;
//        int result = 0;
//        //动态规划
//        while (num != 0) {
//            int x = num % 10;
//            int y = num % 100 / 10;
//            if (y > 0 && (y * 10 + x < 26)) {
//                result = a + b;
//            } else {
//                result = a;
//            }
//            b = a;
//            a = result;
//            num /= 10;
//        }
//        return result;
    }

    public static void main(String[] args) {
        System.out.println(translateNum(25));
        System.out.println(translateNum(12258));
        System.out.println(translateNum(506));
    }
}

