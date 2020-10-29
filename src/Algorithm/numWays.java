package Algorithm;

import java.math.BigDecimal;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 */
public class numWays {

    public static int numWays(int n) {
//        if (n == 0) {
//            return 1;
//        }
//        BigDecimal[] temp = new BigDecimal[n + 1];
//        temp[0] = new BigDecimal(1);
//        temp[1] = new BigDecimal(1);
//        for (int i = 2; i <= n; i++) {
//            temp[i] = temp[i - 1].add(temp[i - 2]);
//        }
//        return temp[n].divideAndRemainder(new BigDecimal(1000000007))[1].intValue();

        int a = 1;
        int result = 1;
        while (n - 2 >= 0) {
            int temp = result;
            result = (a + result) % 1000000007;
            a = temp;
            n--;
        }
        return result;

//        if (n == 0 || n == 1) {
//            return 1;
//        }
//        int pre = 1, cur = 2;
//        for (int i = 3; i <= n; i++) {
//            int tmp = (pre + cur) % 1000_000_007;
//            pre = cur;
//            cur = tmp;
//        }
//        return cur;
    }

    public static void main(String[] args) {
        System.out.println(numWays(2));
        System.out.println(numWays(7));
        System.out.println(numWays(0));
//        System.out.println(numWays(46));
        System.out.println(numWays(92));
//        System.out.println(971215059L % 1000000007L);
    }
}
