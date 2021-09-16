package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *212. 单词搜索 II
 *
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 示例 2：
 *
 *
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 */
public class findWords {

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int flag = 0;
                for (int k = 0; k < board[j].length; k++) {
                    if (board[j][k] != words[i].charAt(0)) {
                        continue;
                    }
                    int[][] has = new int[board.length][board[0].length];
                    has[j][k] = 1;
                    if (isDoTheWord(j, k, 0, words[i], board, has)) {
                        result.add(words[i]);
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    break;
                }
            }
        }
        return result;
    }

    private static boolean isDoTheWord(int j, int k, int i, String word, char[][] board, int[][] has) {

        if (board[j][k] != word.charAt(i)) {
            return false;
        }
        if (i == word.length() - 1) {
            return true;
        }

        boolean a = false;
        if (j - 1 >= 0 && has[j - 1][k] == 0) {
            has[j - 1][k] = 1;
            a = isDoTheWord(j - 1, k, i + 1, word, board, has);
            has[j - 1][k] = 0;
        }
        if (a) {
            return a;
        }
        if (k - 1 >= 0 && has[j][k - 1] == 0) {
            has[j][k - 1] = 1;
            a = isDoTheWord(j, k - 1, i + 1, word, board, has);
            has[j][k - 1] = 0;
        }
        if (a) {
            return a;
        }
        if (j + 1 < board.length && has[j + 1][k] == 0) {
            has[j + 1][k] = 1;
            a = isDoTheWord(j + 1, k, i + 1, word, board, has);
            has[j + 1][k] = 0;
        }
        if (a) {
            return a;
        }
        if (k + 1 < board[0].length && has[j][k + 1] == 0) {
            has[j][k + 1] = 1;
            a = isDoTheWord(j, k + 1, i + 1, word, board, has);
            has[j][k + 1] = 0;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"}));
        System.out.println(findWords(new char[][]{{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}}, new String[]{"oath","pea","eat","rain"}));
        System.out.println(findWords(new char[][]{{'a','b'},{'c','d'}}, new String[]{"abcd"}));
        System.out.println(findWords(new char[][]{{'a'}}, new String[]{"a"}));
    }
}
