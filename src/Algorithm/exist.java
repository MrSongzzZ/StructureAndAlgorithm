package Algorithm;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class exist {


    public static boolean booleanMethod(char[][] board, String word, int target, int x, int y, int[][] done) {

        if (target == word.length()) {
            return true;
        }
        char temp = word.charAt(target);
        if (x + 1 < board.length && done[x + 1][y] == 0 && board[x + 1][y] == temp) {
            done[x + 1][y] = 1;
            if (booleanMethod(board, word, target + 1, x + 1, y, done)) {
                return true;
            } else {
                done[x + 1][y] = 0;
            }
        }
        if (x - 1 >= 0 && done[x - 1][y] == 0 && board[x - 1][y] == temp) {
            done[x - 1][y] = 1;
            if (booleanMethod(board, word, target + 1, x - 1, y, done)) {
                return true;
            } else {
                done[x - 1][y] = 0;
            }
        }
        if (y - 1 >= 0 && done[x][y - 1] == 0 && board[x][y - 1] == temp) {
            done[x][y - 1] = 1;
            if (booleanMethod(board, word, target + 1, x, y - 1, done)) {
                return true;
            } else {
                done[x][y - 1] = 0;
            }
        }
        if (y + 1 <board[0].length && done[x][y + 1] == 0 && board[x][y + 1] == temp) {
            done[x][y + 1] = 1;
            if (booleanMethod(board, word, target + 1, x, y + 1, done)) {
                return true;
            } else {
                done[x][y + 1] = 0;
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, String word) {
        int xl = board.length;
        int yl = board[0].length;
        if (xl * yl < word.length()) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char temp = board[i][j];
                if (temp == word.charAt(0)) {
                    int[][] done = new int[xl][yl];
                    done[i][j] = 1;
                    if (booleanMethod(board, word, 1, i, j, done)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        char[][] board1 = {{'a','b'},{'c','d'}};
        String word1 = "abcd";

        char[][] board2 = {{'a', 'b'}};
        String word2 = "ba";
        System.out.println(exist(board, word));
        System.out.println(exist(board1, word1));
        System.out.println(exist(board2, word2));
    }
}
