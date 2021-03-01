package Algorithm;

import java.util.Stack;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 */
public class longestValidParentheses {

    public static int longestValidParentheses(String s) {
//        int result = 0;
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            stack.clear();
//            for (int j = i; j < s.length(); j++) {
//                char temp = s.charAt(j);
//                if (temp == '(') {
//                    stack.push(temp);
//                } else {
//                    if (stack.isEmpty()) {
//                        break;
//                    }
//                    char isV = stack.pop();
//                    if (isV != '(') {
//                        break;
//                    }
//                }
//                if (stack.isEmpty()) {
//                    result = Math.max(result, j + 1 - i);
//                }
//            }
//        }
//        return result;

        int result = 0;
        int index = 0;
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < s.length(); j++) {
            char temp = s.charAt(j);
            if (temp == '(') {
                stack.push(temp);
            } else {
                if (stack.isEmpty()) {
                    result = Math.max(index, result);
                    index = 0;
                    continue;
                }
                char isV = stack.pop();
                if (isV != '(') {
                    result = Math.max(index, result);
                    index = 0;
                    continue;
                }
                result += 2;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("()(()"));
    }
}
