package Algorithm;

import javax.swing.*;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class rob {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(doMethod(root, 0), doMethod(root, 1));
    }

    public int doMethod(TreeNode a, int flag) {
        int result = 0;
        if (flag == 1) {
            result = a.val;
            if (a.left != null) {
                result += doMethod(a.left, 0);
            }
            if (a.right != null) {
                result += doMethod(a.right, 0);
            }
        } else {
            if (a.left != null) {
                result += Math.max(doMethod(a.left, 0), doMethod(a.left, 1));
            }
            if (a.right != null) {
                result += Math.max(doMethod(a.right, 0), doMethod(a.right, 1));
            }
        }
        return result;
    }
}
