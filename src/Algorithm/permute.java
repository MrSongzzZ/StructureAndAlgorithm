package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * q46
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class permute {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        doMethod(nums, new LinkedList<>(), new int[nums.length]);
        return result;
    }

    private void doMethod(int[] nums, LinkedList<Integer> stack, int[] flag) {
        if (stack.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(stack);
            result.add(temp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == 0) {
                stack.push(nums[i]);
                flag[i] = 1;
                doMethod(nums, stack, flag);
                stack.pop();
                flag[i] = 0;
            }
        }
    }
}
