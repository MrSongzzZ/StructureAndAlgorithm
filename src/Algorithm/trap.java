package Algorithm;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *  
 *
 * 提示：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *      使用栈
 *      // int sum = 0;
 * 	    // Stack<Integer> stack = new Stack<>();
 * 	    // int current = 0;
 * 	    // while (current < height.length) {
 * 	    //     //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
 * 	    //     while (!stack.empty() && height[current] > height[stack.peek()]) {
 * 	    //         int h = height[stack.peek()]; //取出要出栈的元素
 * 	    //         stack.pop(); //出栈
 * 	    //         if (stack.empty()) { // 栈空就出去
 * 	    //             break;
 * 	    //         }
 * 	    //         int distance = current - stack.peek() - 1; //两堵墙之前的距离。
 * 	    //         int min = Math.min(height[stack.peek()], height[current]);
 * 	    //         sum = sum + distance * (min - h);
 * 	    //     }
 * 	    //     stack.push(current); //当前指向的墙入栈
 * 	    //     current++; //指针后移
 * 	    // }
 * 	    // return sum;
 *
 */
public class trap {

    /**
     * 双指针
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            if (i == 0 || i == height.length - 1) {
                continue;
            }
            int leftMax = 0;
            int rightMax = 0;
            for (int j = 0; j < height.length; j++) {
                if (j > i) {
                    rightMax = Math.max(rightMax, height[j]);
                } else if (j < i) {
                    leftMax = Math.max(leftMax, height[j]);
                }
            }
            int x = Math.min(leftMax, rightMax);
            if (x > height[i]) {
                result += x - height[i];
            }
        }
        return result;
    }

    public static int trap(int[] height) {
        int result = 0;
        if (height.length == 0) {
            return result;
        }
        int[] left_max = new int[height.length];
        left_max[0] = height[0];
        int[] right_max = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        right_max[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(left_max[i], right_max[i]);
            if (height[i] < min) {
                result += min - height[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
        System.out.println(trap1(new int[]{4,2,0,3,2,5}));
    }
}
