package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *524. 通过删除字母匹配到字典里最长单词
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 */
public class findLongestWord {

    static class Dict{
        List<Dict> childList = new ArrayList<>();
        char now;
        int length;
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        List<Dict> dictList = new ArrayList<>();
        String result = "";
        for (int i = 0; i < s.toCharArray().length; i++) {
            Dict dict = new Dict();
            dict.now = s.charAt(i);
            dict.length = 1;
            for (Dict dict1 : dictList) {
                dict1.childList.add(dict);
            }
            dictList.add(dict);
        }

        for (String s1 : dictionary) {
            if (s1.length() < result.length()) {
                continue;
            }
            int i = 0;
            List<Dict> temp = dictList;
            do {
                int i1 = 0;
                for (; i1 < temp.size(); i1++) {
                    Dict dict = temp.get(i1);
                    if (dict.now == s1.charAt(i)) {
                        i++;
                        if (i == s1.length()) {
                            break;
                        }
                        temp = dict.childList;
                        i1 = -1;
                    }
                }
                if (i1 == temp.size()) {
                    break;
                }
            } while (temp != null && temp.size() > 0 && i < s1.length());
            if (i == s1.length()) {
                if (s1.length() > result.length()) {
                    result = s1;
                } else {
                    result = s1.compareTo(result) > 0 ? result : s1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea", Arrays.asList(new String[]{"ale", "apple", "monkey", "plea"})));
        System.out.println(findLongestWord("abpcplea", Arrays.asList(new String[]{"a","b","c"})));
    }
}
