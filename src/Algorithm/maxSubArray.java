package Algorithm;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxSubArray {


    /**
     * 利用动态规划  一次算前一部分的最大子序列的值， 如果前一部分的最大值小于0 那么当前最大值 就等于他自己
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
//            nums[i] += Math.max(nums[i - 1], 0);
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            max = Math.max(nums[i], max);
        }
        return max;
    }
//
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = new int[]{1, 2};
        System.out.println(maxSubArray(nums));
    }
}

/**
 * class Solution:
 *     def maxSubArray(self, nums: List[int]) -> int:
 *         for i in range(1, len(nums)):
 *             nums[i] += max(nums[i - 1], 0)
 *         return max(nums)
 */
