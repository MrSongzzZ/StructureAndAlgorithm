package Algorithm;


import java.awt.event.ItemEvent;

/**
 * q215
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 */
public class findKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildHead(nums, heapSize);
        for (int i = heapSize; i >= k; i--) {
            nums[0] = nums[heapSize - 1];
            heapSize--;
            minHeap(nums, 0, heapSize);
        }
        return nums[0];
    }

    private static void buildHead(int[] nums, int heapSize) {
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            minHeap(nums, i, heapSize);
        }
    }

    public static void minHeap(int[] temp, int i, int heapSize) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int smallest = -1;
        if (left < heapSize && temp[i] > temp[left]) {
            smallest = left;
        } else {
            smallest = i;
        }
        if (right < heapSize && temp[smallest] > temp[right]) {
            smallest = right;
        }
        if (smallest != i) {
            int tempNum = temp[smallest];
            temp[smallest] = temp[i];
            temp[i] = tempNum;
            minHeap(temp, smallest, heapSize);
        }
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
//        System.out.println(findKthLargest(new int[]{-1, -1}, 2));
    }
}
