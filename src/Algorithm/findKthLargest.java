package Algorithm;

import java.util.Stack;

public class findKthLargest {

    public int findKthLargest(int[] nums, int k) {
        Stack<Integer> stack =new Stack<>();
        int larger = 0;
        int smaller = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() >= nums[i]) {
                    smaller ++;
                }
            } else {
                stack.push(nums[i]);
            }
        }
        return result;
    }
}
