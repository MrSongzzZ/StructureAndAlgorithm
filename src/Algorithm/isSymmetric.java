package Algorithm;

import struts.Tree;

import javax.management.Query;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 */
public class isSymmetric {

    public boolean isSymmetric(TreeNode root) {
//        return isSymmetric(root.left, root.right);//递归
        Queue<TreeNode> left = new ArrayDeque<>();
        Queue<TreeNode> right = new ArrayDeque<>();
        if (root.left != null && root.right == null) {
            return false;
        }
        if (root.right != null && root.left == null) {
            return false;
        }
        if (root.right == null && root.left == null) {
            return true;
        }
        if (root.right.val != root.left.val) {
            return false;
        }
        left.add(root.left);
        right.add(root.right);
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode tempLeft = left.poll();
            TreeNode tempRight = right.poll();
            if (tempLeft.left != null && tempRight.right != null) {
                if (tempLeft.left.val != tempRight.right.val) {
                    return false;
                } else {
                    left.add(tempLeft.left);
                    right.add(tempRight.right);
                }
            } else if (tempLeft.left != null || tempRight.right != null) {
                return false;
            }


            if (tempLeft.right != null && tempRight.left != null) {
                if (tempLeft.right.val != tempRight.left.val) {
                    return false;
                } else {
                    left.add(tempLeft.right);
                    right.add(tempRight.left);
                }
            } else if (tempLeft.right != null || tempRight.left != null) {
                return false;
            }
        }
        if (!left.isEmpty()) {
            return false;
        }
        if (!right.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left != null && right == null) {
            return false;
        }
        if (right != null && left == null) {
            return false;
        }
        if (right == null && left == null) {
            return true;
        }
        if (right.val != left.val) {
            return false;
        }
        boolean flag = isSymmetric(left.left, right.right);
        if (!flag) {
            return false;
        }
        flag = isSymmetric(left.right, right.left);
        return flag;
    }
}
