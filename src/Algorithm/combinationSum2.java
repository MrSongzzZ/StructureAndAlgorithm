package Algorithm;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */
public class combinationSum2 {
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        combination(candidates, 0, target, new LinkedList<>());
        return result;
    }

    private static void combination(int[] candidates, int index, int target, LinkedList<Integer> integers) {
        if (0 == target) {
            List<Integer> item = new ArrayList<>(integers);
            result.add(item);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < candidates.length; i++) {
            int temp = candidates[i];
            if (!set.contains(temp) && temp <= target) {
                integers.push(temp);
                combination(candidates, i + 1, target - temp, integers);
                integers.pop();
                set.add(temp);
            }
        }
    }

    public static void main(String[] args) {
//        combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        combinationSum2(new int[]{2,5,2,1,2}, 5);
    }
}
