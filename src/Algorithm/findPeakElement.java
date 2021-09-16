package Algorithm;

/**
 *162. 寻找峰值
 *
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 *
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 */
public class findPeakElement {

    public int findPeakElement1(int[] nums) {
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = (i - 1) < 0 ? Integer.MIN_VALUE : nums[i - 1];
            int right = (i + 1) >= nums.length ? Integer.MIN_VALUE : nums[i + 1];
            if (nums[i] > left && nums[i] > right) {
                r = i;
            }
        }
        return r;
    }

    /**
     * 二分法
     *
     * 当前值比左侧小 那么左侧一定有峰值
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
