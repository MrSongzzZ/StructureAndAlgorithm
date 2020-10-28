package Algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lastRemaining {

    public static int lastRemaining(int n, int m) {
        //模拟过程 超时
//        int i = 0;
//        int[] temp = new int[n];
//        int x = 0;
//        while (i < n - 1) {
//            for (int a = 0; a < n; a++) {
//                if (temp[a] == 1) {
//                    continue;
//                } else {
//                    x++;
//                    if (x == (m > n ? (m - n + i) : m)){
//                        temp[a] = 1;
//                        i += 1;
//                        if (i == n-1) {
//                            break;
//                        }
//                        x = 0;
//                    }
//                }
//            }
//        }
//
//        for (int a = 0; a < n; a++) {
//            if (temp[a] == 0) {
//                return a;
//            }
//        }
//        return 0;
//        int[] temp = new int[n + 1];
//        temp[1] = 0;
//        for (int i = 2; i < n + 1; i++) {
//            temp[i] = (temp[i - 1] + m) % i;
//        }
//        return temp[n];

        int ret = 0;
        for (int i = 2; i <= n; i++) {
            ret = (ret + m) % i;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
        System.out.println(lastRemaining(10, 17));
        System.out.println(lastRemaining(5, 1));
        System.out.println(lastRemaining(70866, 116922));
    }
}
