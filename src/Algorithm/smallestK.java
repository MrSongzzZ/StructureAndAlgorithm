package Algorithm;

import java.util.Arrays;

/**
 *面试题 17.14. 最小K个数
 *
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 */
public class smallestK {

    public static void main(String[] args) {
        int[] result = smallestK(new int[]{1,3,5,7,2,4,6,8}, 4);
        System.out.println(result);
    }

    public static int[] smallestK(int[] arr, int k) {

        if (k >= arr.length) {
            return arr;
        }

        //先建一个大根堆
        buildHeap(arr, k / 2 - 1, k, 1);
        for (int i = k; i < arr.length; i++) {
            if (arr[0] > arr[i]) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                genHeap(arr, 0, k, 1);
            }
        }

//        /**
//         * 用堆排序 小顶堆，
//         */
//        int l = arr.length;
//        if (flag == 0) {
//            for (int i = 0; i < k; i++) {
//
//                genDeap(arr, l / 2 - 1, l - i, flag);
//                n[i] = arr[0];
//                arr[0] = arr[l - 1 - i];
//            }
//        } else {
//            for (int i = 0; i < arr.length - k; i++) {
//                genDeap(arr, l / 2 - 1, l - i, flag);
//                n[i] = arr[0];
//                arr[0] = arr[l - 1 - i];
//            }
//            n = Arrays.copyOfRange(arr, 0, k);
//        }

        return Arrays.copyOfRange(arr, 0, k);
    }

    private static void buildHeap(int[] arr, int n, int l, int flag) {
        for (int i = l / 2 - 1; i >= 0; i--) {
            genHeap(arr, i, l, flag);
        }
    }

    /**
     *
     * @param arr 堆数组
     * @param n 第一个非叶子节点
     * @return
     */
    private static void genHeap(int[] arr, int n, int l, int flag) {
        if (l <= 1 || n < 0) {
            return;
        }

        /**
         * 对每个非叶子节点， 得到当前最小值， 上移
         */
        int left = n * 2 + 1;
        int right = n * 2 + 2;

        int min = n;

        if (left < l) {
            if (arr[min] > arr[left] && flag == 0) {
                min = left;
            } else if (arr[min] < arr[left] && flag == 1) {
                min = left;
            }

        }

        if (right < l) {
            if (arr[min] > arr[right] && flag == 0) {
                min = right;
            } else if (arr[min] < arr[right] && flag == 1) {
                min = right;
            }
        }

        if (min != n) {
            int temp = arr[n];
            arr[n] = arr[min];
            arr[min] = temp;
            genHeap(arr, min, l, flag);
        }


    }
}
