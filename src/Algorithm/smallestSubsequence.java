package Algorithm;

import java.util.Stack;

/**
 * q1081  q316
 * 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
 *
 * 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class smallestSubsequence {

    public static String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        int[] charNum = new int[26];
        boolean[] hasChar = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            charNum[index] ++;
        }

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (!hasChar[temp - 'a']) {
                while (!stack.isEmpty()) {
                    if (stack.peek() > temp && charNum[stack.peek() - 'a'] > 0) {
                        char a = stack.pop();
                        hasChar[a - 'a'] = false;
                    } else {
                        break;
                    }
                }
                stack.push(temp);
                hasChar[temp - 'a'] = true;
            }
            charNum[temp - 'a']--;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
//        System.out.println(smallestSubsequence("bcabc"));
//        System.out.println(smallestSubsequence("cbacdcbc"));
        System.out.println(smallestSubsequence("bbcaac"));
    }
}
