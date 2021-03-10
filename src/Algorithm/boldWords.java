package Algorithm;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * q758_字符串中的加粗单词
 * 给定一个关键词集合 words 和一个字符串 S，将所有 S 中出现的关键词加粗。所有在标签 <b> 和 </b> 中的字母都会加粗。
 *
 * 返回的字符串需要使用尽可能少的标签，当然标签应形成有效的组合。
 *
 * 例如，给定 words = ["ab", "bc"] 和 S = "aabcd"，需要返回 "a<b>abc</b>d"。注意返回 "a<b>a<b>b</b>c</b>d" 会使用更多的标签，因此是错误的。
 *
 *
 *
 * 注：
 *
 * words 长度的范围为 [0, 50]。
 * words[i] 长度的范围为 [1, 10]。
 * S 长度的范围为 [0, 500]。
 * 所有 words[i] 和 S 中的字符都为小写字母。
 */
public class boldWords {
    public static String boldWords(String[] words, String S) {
        int[] temp = new int[S.length()];
        for (String word : words) {
            int templeft = S.indexOf(word, 0);
            while (templeft >= 0) {
                for (int i = 0; i < word.length(); i++) {
                    temp[templeft + i] = 1;
                }
                templeft = S.indexOf(word, templeft + 1);
            }
        }

        StringBuilder builder = new StringBuilder();
        int flag = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 1 && flag == 0) {
                builder.append("<b>");
                flag = 1;
            }
            if (flag == 1 && temp[i] == 0) {
                builder.append("</b>");
                flag = 0;
            }
            builder.append(S.charAt(i));

        }
        if (flag == 1) {
            builder.append("</b>");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(boldWords(new String[]{"ab", "bc"}, "aabzbcd"));
        System.out.println(boldWords(new String[]{"ab", "bc"}, "aabcd"));
        System.out.println(boldWords(new String[]{"ccb", "b", "d", "cba", "dc"}, "eeaadadadc"));
        System.out.println(boldWords(new String[]{"b", "dee", "a", "ee", "c"}, "cebcecceab"));
    }
}
