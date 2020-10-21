package Algorithm;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *     你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *     示例:
 *     输入：s = "abc"
 *     输出：["abc","acb","bac","bca","cab","cba"]
 *     限制：
 *             1 <= s 的长度 <= 8
 *     来源：力扣（LeetCode）
 *     链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class permutation {
    public static char[] chars = null;
    public static List<String> list = new ArrayList<>();

    //递归 深度遍历 交换位置后回溯 回溯算法
    public static void dfs(int x) {
        if (x == chars.length - 1) {
            list.add(String.copyValueOf(chars));
        } else {
            Set<Character> sets = new HashSet<>();
            for (int i = x; i < chars.length; i++) {
                if (sets.contains(chars[i])) {
                    continue;
                } else {
                    sets.add(chars[i]);
                }
                swap(i, x);
                dfs(x + 1);
                swap(x, i);
            }
        }
    }

    public static void swap(int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }

    public static String[] permutation(String s) {
        if (s.length() == 1) {
            return new String[]{s};
        }
        /**
         * dfs 深度遍历 + 回溯 + 剪枝
         */
        chars = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(permutation("aab")));
    }
}
