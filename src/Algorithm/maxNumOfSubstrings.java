package Algorithm;

import java.util.*;

/**
 * 给你一个只包含小写字母的字符串 s ，你需要找到 s 中最多数目的非空子字符串，满足如下条件：
 *
 * 这些字符串之间互不重叠，也就是说对于任意两个子字符串 s[i..j] 和 s[k..l] ，要么 j < k 要么 i > l 。
 * 如果一个子字符串包含字符 char ，那么 s 中所有 char 字符都应该在这个子字符串中。
 * 请你找到满足上述条件的最多子字符串数目。如果有多个解法有相同的子字符串数目，请返回这些子字符串总长度最小的一个解。可以证明最小总长度解是唯一的。
 *
 * 请注意，你可以以 任意 顺序返回最优解的子字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "adefaddaccc"
 * 输出：["e","f","ccc"]
 * 解释：下面为所有满足第二个条件的子字符串：
 * [
 *   "adefaddaccc"
 *   "adefadda",
 *   "ef",
 *   "e",
 *   "f",
 *   "ccc",
 * ]
 * 如果我们选择第一个字符串，那么我们无法再选择其他任何字符串，所以答案为 1 。如果我们选择 "adefadda" ，剩下子字符串中我们只可以选择 "ccc" ，它是唯一不重叠的子字符串，所以答案为 2 。同时我们可以发现，选择 "ef" 不是最优的，因为它可以被拆分成 2 个子字符串。所以最优解是选择 ["e","f","ccc"] ，答案为 3 。不存在别的相同数目子字符串解。
 * 示例 2：
 *
 * 输入：s = "abbaccd"
 * 输出：["d","bb","cc"]
 * 解释：注意到解 ["d","abba","cc"] 答案也为 3 ，但它不是最优解，因为它的总长度更长。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s 只包含小写英文字母。
 */
public class maxNumOfSubstrings {

    public static List<String> maxNumOfSubstrings(String s) {
        List<String> temp = new ArrayList<>();
        Map<Character, Integer> leftMap = new HashMap<>();
        Map<Character, Integer> rightMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            if (leftMap.containsKey(tempChar)) {
                rightMap.put(tempChar, i);
            } else {
                leftMap.put(tempChar, i);
                rightMap.put(tempChar, i);
            }
        }
        List<TempStruct> tempStructList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int end = i;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                end = Math.max(end, rightMap.get(c));
                if (leftMap.get(c) < i) {
                    break;
                }
                if (end == j) {
                    TempStruct tempStruct = new TempStruct();
                    tempStruct.left = i;
                    tempStruct.right = end;
                    tempStructList.add(tempStruct);
                    break;
                }
            }
        }

        Collections.sort(tempStructList, new Comparator<TempStruct>() {
            @Override
            public int compare(TempStruct o1, TempStruct o2) {
                return o1.compareTo(o2);
            }
        });
        int end = -1;
        List<String> result = new ArrayList<>();
        for (TempStruct tempStruct : tempStructList) {
            if (end == -1 || end < tempStruct.left) {
                result.add(s.substring(tempStruct.left, tempStruct.right + 1));
                end = tempStruct.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxNumOfSubstrings("adefaddaccc"));
    }
}

class TempStruct implements Comparable<TempStruct> {
    int left;
    int right;

    @Override
    public int compareTo(TempStruct o) {
        if (right == o.right) {
            return o.left - left;
        };
        return right - o.right;
    }
}