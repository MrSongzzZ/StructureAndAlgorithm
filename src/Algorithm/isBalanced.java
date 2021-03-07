package Algorithm;

import struts.Tree;

import javax.swing.*;
import java.util.Stack;

public class isBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int result = doMethod(root);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public int doMethod(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = doMethod(root.left);
        int right = doMethod(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
