package Algorithm;

/**
 *给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 */
public class longestPalindrome {

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int[][] d = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {

                if (j == 0 && i == 3) {
                    System.out.println("aaa");
                }

                if (i == j) {
                    d[j][i] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (i - j > 2) {
                        d[j][i] = d[j + 1][i - 1];
                    } else {
                        d[j][i] = 1;
                    }
                } else {
                    d[j][i] = 0;
                }

                if (d[j][i] == 1) {
                    if (maxLength < i - j + 1) {
                        maxLength = i - j + 1;
                        left = j;
                        right = i;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("babad"));
//        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(longestPalindrome("a"));
//        System.out.println(longestPalindrome("ac"));
//        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
}
