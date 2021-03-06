package Algorithm;

import java.util.*;

/**
 *
 * 贪心算法
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 * 示例：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class partitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        char[] chars = S.toCharArray();
        int[] lastChar = new int[26];
        for (int i = 0; i < chars.length; i++) {
            lastChar[chars[i] - 'a'] = i;
        }
        int start = 0;
        int end = lastChar[chars[start] - 'a'];
        for (int i = 0; i < chars.length; i++) {
            end = Math.max(end, lastChar[chars[i] - 'a']);
            if (end == i) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
