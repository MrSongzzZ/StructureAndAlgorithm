package Algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 */
public class topKFrequent {

    static Map<Integer, Integer> map = new HashMap<>();
    public static int[] topKFrequent(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int heapSize = map.size();
        int[] tempHeap = new int[heapSize];

        int index = 0;
        for (Integer integer : map.keySet()) {
            tempHeap[index++] = integer;
        }
        buildHeap(tempHeap, heapSize);
        for (int i = index; i > k; i--) {
            tempHeap[0] = tempHeap[heapSize - 1];
            heapSize--;
            minHeap(tempHeap, 0, heapSize);
        }
        int[] result = Arrays.copyOf(tempHeap, k);
        return result;
    }

    private static void buildHeap(int[] tempHeap, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            minHeap(tempHeap, i, size);
        }
    }

    private static void minHeap(int[] result, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int small = -1;
        if (left < size && map.getOrDefault(result[i], 0) > map.getOrDefault(result[left], 0)) {
            small = left;
        } else {
            small = i;
        }
        if (right < size && map.getOrDefault(result[small], 0) > map.getOrDefault(result[right], 0)) {
            small = right;
        }

        if (small != i) {
            int temp = result[small];
            result[small] = result[i];
            result[i] = temp;
            minHeap(result, small, size);
        }
    }

    public static void main(String[] args) {
        topKFrequent(new int[]{1,1,1,2,2,3}, 2);
//        topKFrequent(new int[]{6,0,1,4,9,7,-3,1,-4,-8,4,-7,-3,3,2,-3,9,5,-4,0}, 6);
    }
}
