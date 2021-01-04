package Algorithm;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * 提示：
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class add {

    //需要灵活使用位运算

    /**
     *
     a(i)   b(i)	无进位和n(i)	进位c(i+1)
     0      0	    0	        0
     0	    1	    1	        0
     1	    0	    1	        0
     1	    1	    0	        1

     a + b = n + c

     观察发现，无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位）。因此，无进位和 nn 与进位 cc 的计算公式如下；

     n=a⊕b  非进位和：异或运算
     c=a&b<<1  进位：与运算+左移一位

     循环求 n 和 c ，直至进位 c=0 ；此时s=n ，返回 n 即可。

     Q ： 若数字 aa 和 bb 中有负数，则变成了减法，如何处理？
     A ： 在计算机系统中，数值一律用 补码 来表示和存储。补码的优势： 加法、减法可以统一处理（CPU只有加法器）。因此，以上方法 同时适用于正数和负数的加法 。
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 1 << 1;
        System.out.println(a);
        System.out.println(add(1, 2));
    }
}
