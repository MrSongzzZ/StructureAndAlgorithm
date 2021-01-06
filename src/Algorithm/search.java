package Algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class search {
    public static int search(int[] nums, int target) {
        int result = 0;
//        int flag = 0;
//        for (int num : nums) {
//            if (num == target) {
//                flag = 1;
//                result += 1;
//            } else {
//                if (flag == 1) {
//                    break;
//                }
//            }
//        }
//
        //改用二分法
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int flag = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                flag = 1;
                result ++;
                left = mid - 1;
                right = mid + 1;
                break;
            }
        }
        if (flag == 1) {
            while (left >= 0 && left < nums.length && nums[left--] == target) {
                result++;
            }
            while (right >= 0 && right < nums.length && nums[right++] == target) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(search(new int[]{0,1,2,3,4,4,4}, 2));
        System.out.println(search(new int[]{0,0,2,3,4,4,4,5}, 5));
    }
}
