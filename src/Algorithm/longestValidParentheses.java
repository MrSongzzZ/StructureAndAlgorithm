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
//        int x = s.length() % 2 == 0 ? s.length() : s.length() - 1;
//        Stack<Character> stack = new Stack<>();
//        while (x > 0) {
//            for (int i = 0; i + x <= s.length(); i++) {
//                int j = i;
//                for (; j < i + x; j++) {
//                    char temp = s.charAt(j);
//                    if (temp == '(') {
//                        stack.push(temp);
//                    } else {
//                        if (stack.isEmpty()) {
//                            break;
//                        }
//                        stack.pop();
//                    }
//                }
//                if (stack.isEmpty() && j == i + x) {
//                    return x;
//                }
//                stack.clear();
//            }
//            x -= 2;
//        }
//        return result;

//        int maxLength = 0;
//        int length = 0;
//        Stack<Integer> integers = new Stack<>();
//        integers.push(-1);
//        for (int i = 0; i < s.length(); i++) {
//            char temp = s.charAt(i);
//            if (temp == '(') {
//                integers.push(i);
//            } else {
//                int x = integers.pop();
//                if (x < 0 || s.charAt(x) != '(') {
//                    length = 0;
//                    integers.push(i);
//                } else {
//                    length = i - integers.peek();
//                    maxLength = Math.max(length, maxLength);
//                }
//            }
//        }
//        return maxLength;

        int left = 0;
        int right = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(') {
                left++;
            } else if (temp == ')') {
                right ++;
            }
            if (left == right) {
                result = Math.max(result, left * 2);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char temp = s.charAt(i);
            if (temp == ')') {
                left++;
            } else if (temp == '(') {
                right++;
            }
            if (left == right) {
                result = Math.max(result, left * 2);
            } else if (right > left) {
                left = right = 0;
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
