package Algorithm;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();

        int index = 0;
        while (true) {
            String first = strs[0];
            if (first.length() <= index) {
                break;
            }
            char temp = first.charAt(index);
            int flag = 0;
            for (int i = 1; i < strs.length; i++) {
                String tempStr = strs[i];
                if (tempStr.length() <= index) {
                    flag = 1;
                    break;
                }
                if (tempStr.charAt(index) != temp) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
            result.append(temp);
            index++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
