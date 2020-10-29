package Algorithm;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *  
 *
 * 提示:
 *
 * 0 < nums.length <= 100
 * 说明:
 *
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class minNumber {

    /**
     * 使用字符串的比较会更快
     * @param x
     * @param y
     * @return
     */
    public static boolean better(int x, int y) {
        if ((String.valueOf(x) + String.valueOf(y)).compareTo(String.valueOf(y) + String.valueOf(x)) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 3,30,34,5,9
     * @param nums
     * @param start
     * @param end
     * @return
     */

    public static int[] sort(int[] nums, int start, int end) {
        if (start >= end) {
            return nums;
        }
        int left = start + 1;
        int right = end;
        int key = start;
        while (left <= right) {

            while (right >= left) {
                if (!better(nums[right], nums[key])) {
                    int temp = nums[key];
                    nums[key] = nums[right];
                    nums[right] = temp;
                    key = right;
                    break;
                } else {
                    right--;
                }
            }

            while (left <= right) {
                if (better(nums[left], nums[key])) {
                    int temp = nums[key];
                    nums[key] = nums[left];
                    nums[left] = temp;
                    key = left;
                    break;
                } else {
                    left++;
                }
            }

            if (left >= right) {
                break;
            }
        }
        sort(nums, start, key - 1);
        sort(nums, key + 1, end);
        return nums;
    }

    public static String minNumber(int[] nums) {
        nums = sort(nums, 0, nums.length - 1);
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(String.valueOf(num));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
//        int[] a = new int[]{10,2};
//        System.out.println(minNumber(a));
        int[] b = new int[]{3,30,34,5,9};
        System.out.println(minNumber(b));
    }
}
