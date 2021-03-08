package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。

 */
public class frequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            int a = map.getOrDefault(temp, 0) + 1;
            max = Math.max(a, max);
            map.put(temp, a);
        }
        List<Character>[] list = new List[max + 1];
        for (Character character : map.keySet()) {
            int num = map.get(character);
            if (list[num] == null) {
                list[num] = new ArrayList<>();
            }
            list[num].add(character);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] != null) {
                for (Character character : list[i]) {
                    int num = map.get(character);
                    for (int j = 0; j < num; j++) {
                        builder.append(character);
                    }
                }
            }
        }
        return builder.toString();
    }
}
