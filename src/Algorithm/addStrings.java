package Algorithm;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *  
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class addStrings {

    public static String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int c = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            int r = a + b + c;
            c = r / 10;
            r = r % 10;
            builder.append(r);
        }
        if (c > 0) {
            builder.append(c);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
        System.out.println(addStrings("11111111111111", "99999999999999999999"));
    }
}
