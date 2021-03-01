package Algorithm;

import java.util.Stack;

/**
 * q20
 *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class isValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp != '(' && temp != '{' &&temp != '[' &&temp != '}' &&temp != ')' && temp != ']') {
                return false;
            }
            if (temp == '[' || temp == '(' || temp == '{') {
                stack.push(temp);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char isV = stack.pop();
                if (temp == '}' && isV != '{') {
                    return false;
                }

                if (temp == ')' && isV != '(') {
                    return false;
                }

                if (temp == ']' && isV != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
