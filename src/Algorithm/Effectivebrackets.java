package Algorithm;

import java.util.Stack;

/**
 *  给定⼀个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，
 *  判断字符串 是否有效。
 *  有效字符串需满⾜：
 *  1. 左括号必须⽤相同类型的右括号闭合。
 *  2. 左括号必须以正确的顺序闭合。
 *  * 注意空字符串可被认为是有效字符串。
 *  示例 1： 输⼊: "()"
 *  输出: true
 *  示例 2： 输⼊: "(]"
 *  输出: false
 *
 */
public class Effectivebrackets {

    private static boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        if (("").equals(str)) {
            return true;
        }

        if (str.length() % 2 != 0) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a == '(' || a == '{' || a == '[') {
                stack.push(a);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char b = stack.pop();
                    if ((a == ')' && b != '(') || (a == ']' && b != '[') || (a == '}' && b != '{')) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int[] temperature(int[] temperature) {
        int[] result = new int[temperature.length];
        
        return result;
    }

    public static void main(String[] args) {
        System.out.println(check("(())()()()(){{{}}}"));
        System.out.println(check("{{}{}{}}}}"));
    }
}
