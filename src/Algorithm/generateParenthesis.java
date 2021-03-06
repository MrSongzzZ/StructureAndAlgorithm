package Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * q22
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class generateParenthesis {
    List<String> tempList = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        gen("", 0, 0, n);
        return tempList;
    }

    public void gen(String temp, int left, int right, int n) {
        if (left == n && right == n) {
            tempList.add(temp);
        } else {
            if (left < n) {
                gen(temp + "(", left + 1, right, n);
            }
            if (right < n && right < left) {
                gen(temp + ")", left, right + 1, n);
            }
        }
    }
}
