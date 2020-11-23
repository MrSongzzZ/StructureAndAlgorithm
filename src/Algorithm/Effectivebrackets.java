package Algorithm;

import javafx.util.Pair;

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

    /**
     * 基础算法题 测算温度最大值
     * @param temperature
     * @return
     */
    private static int[] temperature(int[] temperature) {
        Stack<Pair<Integer, Integer>> pairs = new Stack<>();
        int[] result = new int[temperature.length];
        for (int i = 0; i < temperature.length; i++) {
            while (!pairs.isEmpty() && pairs.peek().getKey() < temperature[i]) {
                Pair<Integer, Integer> temp = pairs.pop();
                result[temp.getValue()] = i - temp.getValue();
            }

            pairs.push(new Pair<Integer, Integer>(temperature[i], i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(check("(())()()()(){{{}}}"));
        System.out.println(check("{{}{}{}}}}"));
        System.out.println(temperature(new int[]{23, 24, 25, 21, 19, 22, 26, 23}));
    }
}
