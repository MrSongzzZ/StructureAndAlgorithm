package Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class isValidBST {

    public static boolean check(TreeNode root, Integer min, Integer max) {
        if (min != null) {
            if (root.val >= min) {
                return false;
            }
        }

        if (max != null) {
            if (root.val <= max) {
                return false;
            }
        }

        if (root.left != null) {
            if (!check(root.left, root.val, max)) {
                return false;
            }
        }

        if (root.right != null) {
            if (!check(root.right, min, root.val)){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidBST(TreeNode root) {
        if (root.right != null) {
            if (!check(root.right, null, root.val)){
                return false;
            }
        }
        if (root.left != null) {
            if (!check(root.left, root.val, null)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode temp = new TreeNode(5);
//        temp.left = new TreeNode(30);
//        temp.right = new TreeNode(70);
//        temp.left.right = new TreeNode(40);
//        temp.right.right = new TreeNode(80);
//        temp.right.left = new TreeNode(60);
        temp.left = new TreeNode(1);
        temp.right = new TreeNode(4);
//        temp.left.right = new TreeNode(4);
//        temp.left.left = new TreeNode(2);
        temp.right.left = new TreeNode(3);
        temp.right.right = new TreeNode(6);
//        root = deleteNode(root, 50);
        System.out.println(isValidBST(temp));
    }
}
