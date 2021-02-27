package Algorithm;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 *
 * 示例 1：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 * 提示：
 * 1 <= n <= 231 - 1
 */
public class isHappy {

    public int getNum(int n) {
        int result = 0;
        int t = 0;
        while (n != 0) {
            t = n % 10;
            result += t * t;
            n = n / 10;
        }
        return result;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNum(n);
        while (slow != fast && slow != 1 && fast != 1) {
            slow = getNum(slow);
            fast = getNum(getNum(fast));
        }
        if (slow == 1 || fast == 1) {
            return true;
        } else {
            return false;
        }
    }
}
