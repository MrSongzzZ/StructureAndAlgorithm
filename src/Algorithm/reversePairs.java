package Algorithm;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * 限制：
 * 0 <= 数组长度 <= 50000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reversePairs {

    /**
     *         if (nums.length <= 1) {
     *             return 0;
     *         }
     *         int result = 0;
     *         int index = 0;
     *         while (index < nums.length - 1) {
     *             for (int i = index; i < nums.length; i++) {
     *                 if (nums[index] > nums[i]) {
     *                     result += 1;
     *                 }
     *             }
     *             index += 1;
     *         }
     *         return result;
     *         超时
     * @param nums
     * @return
     */


    //递归写法
    public static int guibing(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int left = guibing(nums, start, mid, temp);
        int right = guibing(nums, mid + 1, end, temp);
        int count = merage(nums, start, mid, end, temp);
        return left + right + count;
    }

    private static int merage(int[] nums, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int count = 0;
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }
        int index = start;
        while (left < mid + 1 && right < end + 1) {
            if (temp[left] > temp[right]) {
                count = count + mid + 1 - left;
                nums[index++] = temp[right];
                right +=1;
            } else {
                nums[index++] = temp[left];
                left += 1;
            }
        }

        if (left < mid + 1) {
            for (int i = left; i < mid + 1; i++) {
                nums[index++] = temp[i];
            }
        }
        if (right < end + 1) {
            for (int i = right; i < end + 1; i++) {
                nums[index++] = temp[i];
            }
        }
        return count;
    }



    /**
     * 非递归
     */
    public static int guibing_2(int[] nums) {
        int count = 0;
        int[] temp = new int[nums.length];
        for (int block = 2; block < nums.length * 2; block *= 2) {
            for (int start = 0; start < nums.length; start += block) {
                int end = start + block - 1;
                int mid = (start + end) / 2;
                end = Math.min(end, nums.length - 1);
                if (start >= end || mid >= end) {
                    continue;
                }
                if (nums[mid] < nums[mid + 1]) {
                    continue;
                }
                int left = start;
                int right = mid + 1;
                for (int i = start; i <= end; i++) {
                    temp[i] = nums[i];
                }
                int index = start;
                while (left < mid + 1 && right < end + 1) {
                    if (temp[left] > temp[right]) {
                        count = count + mid + 1 - left;
                        nums[index++] = temp[right];
                        right +=1;
                    } else {
                        nums[index++] = temp[left];
                        left += 1;
                    }
                }

                if (left < mid + 1) {
                    for (int i = left; i < mid + 1; i++) {
                        nums[index++] = temp[i];
                    }
                }
                if (right < end + 1) {
                    for (int i = right; i < end + 1; i++) {
                        nums[index++] = temp[i];
                    }
                }
            }
        }
        return count;
    }

    public static int reversePairs(int[] nums) {
        int count = guibing_2(nums);
//        int[] temp = new int[nums.length];
//        int count = guibing(nums, 0, nums.length - 1, temp);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,5,6,8};
//        int[] nums = new int[]{233,2000000001,234,2000000006,235,2000000003,236,2000000007,237,2000000002,2000000005,233,233,233,233,233,2000000004};
        System.out.println(reversePairs(nums));
    }


//    public static int reversePairs1(int[] nums) {
//        int len = nums.length;
//
//        if (len < 2) {
//            return 0;
//        }
//
//        int[] copy = new int[len];
//        for (int i = 0; i < len; i++) {
//            copy[i] = nums[i];
//        }
//
//        int[] temp = new int[len];
//        return reversePairs(copy, 0, len - 1, temp);
//    }
//
//    /**
//     * nums[left..right] 计算逆序对个数并且排序
//     *
//     * @param nums
//     * @param left
//     * @param right
//     * @param temp
//     * @return
//     */
//    private static int reversePairs(int[] nums, int left, int right, int[] temp) {
//        if (left == right) {
//            return 0;
//        }
//
//        int mid = left + (right - left) / 2;
//        int leftPairs = reversePairs(nums, left, mid, temp);
//        int rightPairs = reversePairs(nums, mid + 1, right, temp);
//
//        if (nums[mid] <= nums[mid + 1]) {
//            return leftPairs + rightPairs;
//        }
//
//        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
//        return leftPairs + rightPairs + crossPairs;
//    }
//
//    /**
//     * nums[left..mid] 有序，nums[mid + 1..right] 有序
//     *
//     * @param nums
//     * @param left
//     * @param mid
//     * @param right
//     * @param temp
//     * @return
//     */
//    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
//        for (int i = left; i <= right; i++) {
//            temp[i] = nums[i];
//        }
//
//        int i = left;
//        int j = mid + 1;
//
//        int count = 0;
//        for (int k = left; k <= right; k++) {
//
//            if (i == mid + 1) {
//                nums[k] = temp[j];
//                j++;
//            } else if (j == right + 1) {
//                nums[k] = temp[i];
//                i++;
//            } else if (temp[i] <= temp[j]) {
//                nums[k] = temp[i];
//                i++;
//            } else {
//                nums[k] = temp[j];
//                j++;
//                count += (mid - i + 1);
//            }
//        }
//        return count;
//    }
}