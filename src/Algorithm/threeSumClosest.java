package Algorithm;

import java.util.Arrays;
import java.util.Map;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 */
public class threeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int temp = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (temp == -1) {
                    temp = Math.abs(sum - target);
                    result = sum;
                } else {
                    if (temp > Math.abs(sum - target)) {
                        result = sum;
                        temp = Math.abs(sum - target);
                    }
                }

                if (sum < target) {
                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else if (sum == target) {
                    return sum;
                } else {
                    while (right - 1 > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 2, 1, -4};
//        System.out.println(threeSumClosest(nums, 1));
//        int[] nums = {1,2,4,8,16,32,64,128};
//        System.out.println(threeSumClosest(nums, 82));
        int[] nums = {-1,0,1,1,55};
        System.out.println(threeSumClosest(nums, 5));
    }
}
