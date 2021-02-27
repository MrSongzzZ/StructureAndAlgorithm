package Algorithm;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class minSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums) {
        int result = 0;
        int left = 0;
        int right = 0;
        int sum = nums[right];
        while (left <= right && right < nums.length) {
            if (left == right) {
                if (nums[left] >= target) {
                    return 1;
                } else {
                    right++;
                    if (right < nums.length) {
                        sum = sum + nums[right];
                    }
                }
            } else {
                if (sum >= target) {
                    if (result == 0) {
                        result = right - left + 1;
                    } else {
                        result = Math.min(result, right - left + 1);
                    }
                    sum = sum - nums[left];
                    left++;
                } else {
                    right++;
                    if (right < nums.length) {
                        sum = sum + nums[right];
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
