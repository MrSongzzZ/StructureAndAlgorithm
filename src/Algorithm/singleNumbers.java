package Algorithm;

import java.util.*;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class singleNumbers {

    public static int[] singleNumbers(int[] nums) {
//        耗时太多
//        List<Integer> list = new ArrayList<>();
//        for (int i : nums) {
//            if (list.contains(i)) {
//                list.remove(new Integer(i));
//            } else {
//                list.add(i);
//            }
//        }
//        int[] listt = new int[list.size()];
//        int index = 0;
//        for (int i : list) {
//            listt[index++] = i;
//        }
//        return listt;

//        快了点点 空间消耗增大
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : nums) {
//            if (map.containsKey(i)) {
//                map.remove(i);
//            } else {
//                map.put(i, i);
//            }
//        }
//        int[] listt = new int[map.size()];
//        int index = 0;
//        for (int i : map.keySet()) {
//            listt[index++] = i;
//        }
//        return listt;
        int[] result = new int[2];
        int sum = 0;
        for (int num : nums) {
            sum ^= num; //异或运算，相同为0
        }
        int lowbit = sum & (-sum); //与运算 求低位、
        for (int num : nums) {
            if ((num & lowbit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,4,6};
        int[] a = singleNumbers(nums);
        System.out.println(a);
    }
}

/***
 * 答案很简单：全员进行异或操作即可。考虑异或操作的性质：对于两个操作数的每一位，相同结果为 00，不同结果为 11。那么在计算过程中，成对出现的数字的所有位会两两抵消为 00，最终得到的结果就是那个出现了一次的数字。
 *
 * 那么这一方法如何扩展到找出两个出现一次的数字呢？
 *
 * 如果我们可以把所有数字分成两组，使得：
 *
 * 两个只出现一次的数字在不同的组中；
 *
 * 相同的数字会被分到相同的组中。
 *
 * 那么对两个组分别进行异或操作，即可得到答案的两个数字。这是解决这个问题的关键。
 *
 * 那么如何实现这样的分组呢？
 *
 * 首先，两个相同的数字的对应位都是相同的，所以一个被分到了某一组，另一个必然被分到这一组，所以满足了条件 2。
 * 但是为了方便，这里的代码选取的是「不为 00 的最低位」，当然你也可以选择其他不为 00 的位置。
 *
 * 1。所有数字 异或得到的二进制数 最低位为1  因为其他所有数字都有两两相同的 所以为0  那么这两个数字 的该位就 一个为0 一个为1
 * 2。然后对所有数字分组  所有数字 与这个最低位数字与运算  该位为1的数字 分一组  为0的数字为1组
 *      因为两个数字 必然在两个组 而且他们组 同位相同的 必然都是两个数字 所以最后两个组分别异或即可得到最后两个数
 *
 *
 * 至此，答案已经呼之欲出了。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
