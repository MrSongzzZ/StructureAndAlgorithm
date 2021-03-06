package Algorithm;

import java.util.Stack;

/**
 * q224
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class calculate {

    public static int calculate(String s) {
        if (s.startsWith("-")) {
            s = "0" + s;
        }
        int right = ')';
        Stack<Integer> stack = new Stack<>();
        int temp = 0;
        int n = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char cr = s.charAt(i);
            if (cr == ' ') {
                continue;
            }

            if (cr >= '0' && cr <= '9') {
                temp = (cr - '0') * n + temp;
                n = n * 10;
                continue;
            }

            if (n != 1) {
                stack.push(temp);
                temp = 0;
                n = 1;
            }

            if (cr == '-') {
                stack.push(-1);
            } else if (cr == '+') {
                stack.push(1);
            } else if (cr == '(') {
                int res = getNum(stack);
                stack.pop();
                stack.push(res);
            } else if (cr == ')') {
                stack.push(right);
            }
        }

        if (n != 1) {
            stack.push(temp);
        }
        return getNum(stack);
    }

    private static int getNum(Stack<Integer> stack) {
        int result = 0;
        while (!stack.isEmpty()) {
            result = stack.pop();
            break;
        }
        while (stack.size() > 1 && stack.peek() != ')') {
            result += stack.pop() * stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("-2"));
    }
}
