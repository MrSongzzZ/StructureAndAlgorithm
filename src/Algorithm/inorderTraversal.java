package Algorithm;

import struts.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * q94
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class inorderTraversal {
       // 递归 很简单
//    List<Integer> result = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) {
//            return result;
//        }
//
//        if (root.left != null) {
//            result.add(root.left.val);
//            inorderTraversal(root.left);
//        }
//        result.add(root.val);
//        if (root.right != null) {
//            result.add(root.right.val);
//            inorderTraversal(root.right);
//        }
//        return result;
//    }

    //迭代
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) {
//            return result;
//        }
//
//        Stack<TreeNode> stack = new Stack<>();
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            result.add(root.val);
//            root = root.right;
//        }
//        return result;
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {
                result.add(root.val);
                root = root.right;
            } else {
                TreeNode press = getPress(root);
                if (press.right != null) {
                    result.add(root.val);
                    root = root.right;
                    press.right = null;
                } else {
                    press.right = root;
                    root = root.left;
                }
            }
        }
        return result;
    }

    private TreeNode getPress(TreeNode root) {
        TreeNode result = root.left;
        while (result.right != null && result.right != root) {
            result = result.right;
        }
        return result;
    }
}
