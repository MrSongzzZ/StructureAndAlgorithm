package Algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int temp = 0;
        int res = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            int index = map.getOrDefault(c, -1);
            map.put(c, i);
            temp = temp < i - index ? temp + 1 : i - index;
            res = Math.max(res, temp);
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "dvdf";
        System.out.println(lengthOfLongestSubstring(a));
        String b = "bbbbb";
        System.out.println(lengthOfLongestSubstring(b));
        String c = "pwwkew";
        System.out.println(lengthOfLongestSubstring(c));
    }
}

/**
 * 动态规划+哈希表
 *
 * 从左向右遍历 通过hash表依次求得 已右边界结尾的最长不重复字符串（因为hash表中会存左边存在的那个重复字符，所以很简单）
 * class Solution {
 *     public int lengthOfLongestSubstring(String s) {
 *         Map<Character, Integer> dic = new HashMap<>();
 *         int res = 0, tmp = 0;
 *         for(int j = 0; j < s.length(); j++) {
 *             int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
 *             dic.put(s.charAt(j), j); // 更新哈希表
 *             tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
 *             res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
 *         }
 *         return res;
 *     }
 * }
 */
