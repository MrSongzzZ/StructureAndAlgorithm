package Algorithm;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 */
public class searchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        int tempResult = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                tempResult = mid;
                break;
            } else {
                right = mid - 1;
            }
        }
        if (tempResult >= 0) {
            left = tempResult;
            right = tempResult;
            for (int i = tempResult + 1; i < nums.length; i++) {
                if (nums[i] == target) {
                    right++;
                } else {
                    break;
                }
            }
            result[1] = right;

            for (int i = tempResult - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    left--;
                } else {
                    break;
                }
            }
            result[0] = left;
        }
        return result;
    }

    public static void main(String[] args) {
        searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
}
