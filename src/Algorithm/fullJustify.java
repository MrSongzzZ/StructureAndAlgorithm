package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 68. 文本左右对齐
 *
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 *
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class fullJustify {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        List<String> a = new ArrayList<>();
        int length = 0;
        while (i < words.length) {
            if ((length + words[i].length() + 1 <= maxWidth && length > 0) || (length == 0 && words[i].length() <= maxWidth)) {
                a.add(words[i]);
                if (length > 0) {
                    length = length + 1 + words[i].length();
                } else {
                    length = words[i].length();
                }
                i ++;
            } else {
                int c = maxWidth - length;
                if (a.size() == 1) {
                    String temps = a.get(0);
                    while (c > 0) {
                        temps += " ";
                        c--;
                    }
                    result.add(temps);
                } else {
                    while (c > 0) {
                        for (int z = 0; z < a.size() - 1; z++) {
                            String temps = a.get(z);
                            a.set(z, temps + " ");
                            c--;

                            if (c == 0) {
                                break;
                            }
                        }
                    }
                    result.add(String.join(" ", a));
                }

                a.clear();
                length = 0;
            }
        }

        if (a.size() > 0) {
            String temp = String.join(" ", a);
            int c = maxWidth - length;
            while (c > 0) {
                temp += " ";
                c--;
            }
            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(fullJustify(new String[]{"Listen","to","many,","speak","to","a","few."}, 6));
//        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
//        System.out.println(fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
//        System.out.println(fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain",
//                "to","a","computer.","Art","is","everything","else","we","do"}, 20));
    }
}
