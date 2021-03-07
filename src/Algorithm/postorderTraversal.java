package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */
public class postorderTraversal {

//    List<Integer> result = new ArrayList<>();
//    public List<Integer> postorderTraversal(TreeNode root) {
//        if (root == null) {
//            return result;
//        }
//        if (root.left != null) {
//            postorderTraversal(root.left);
//        }
//        if (root.right != null) {
//            postorderTraversal(root.right);
//        }
//        result.add(root.val);
//        return result;
//    }

//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) {
//            return result;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<TreeNode> temp = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            if (stack.peek().left != null || stack.peek().right != null) {
//                if (!temp.isEmpty() && temp.peek() == stack.peek()) {
//                    root = stack.pop();
//                    temp.pop();
//                    result.add(root.val);
//                } else {
//                    root = stack.peek();
//                    temp.push(root);
//                    if (root.right != null) {
//                        stack.push(root.right);
//                    }
//                    if (root.left != null) {
//                        stack.push(root.left);
//                    }
//                }
//
//            } else {
//                root = stack.pop();
//                result.add(root.val);
//            }
//
//        }
//        return result;
//    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode head = root;
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode p = getP(root);
                if (p.right == null) {
                    p.right = root;
                    root = root.left;
                } else {
                    p.right = null;
                    getResult(result, root.left);
                    root = root.right;
                }
            }
        }
        getResult(result, head);
        return result;
    }

    private void getResult(List<Integer> result, TreeNode left) {
        List<Integer> temp = new ArrayList<>();
        while (left != null) {
            temp.add(left.val);
            left = left.right;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }

    private TreeNode getP(TreeNode root) {
        TreeNode result = root.left;
        while (result.right != null && result.right != root) {
            result = result.right;
        }
        return result;
    }

}
