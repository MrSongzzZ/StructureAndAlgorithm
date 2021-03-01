package Algorithm;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：0
 *
 */
public class findUnsortedSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        int index = -1;
        int end = index;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < max) {
                int temp = index == -1 ? i - 1 : index;
                while (temp >= 0 && nums[temp] > nums[i]) {
                    index = temp;
                    temp--;
                }
                end = i;
            } else {
                max = nums[i];
            }
        }

        return index == -1 ? 0 : end - index + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,6,4,8,10,9,15};
        int[] ab = new int[]{1,3,5,4,2};
        int[] ac = new int[]{2,3, 3, 2, 4};
        System.out.println(findUnsortedSubarray(a));
        System.out.println(findUnsortedSubarray(ab));
        System.out.println(findUnsortedSubarray(ac));
    }
}
