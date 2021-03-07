package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
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
 * 输出：[1,2]
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
 *  
 *
 */
public class preorderTraversal {


//    List<Integer> result = new ArrayList<>();
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if (root == null) {
//            return result;
//        }
//        result.add(root.val);
//        if (root.left != null) {
//            preorderTraversal(root.left);
//        }
//        if (root.right != null) {
//            preorderTraversal(root.right);
//        }
//        return result;
//    }

//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) {
//            return result;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            root = stack.pop();
//            result.add(root.val);
//            if (root.right != null) {
//                stack.push(root.right);
//            }
//            if (root.left != null) {
//                stack.push(root.left);
//            }
//        }
//        return result;
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {
                result.add(root.val);
                root = root.right;
            } else {
                TreeNode p = getP(root);
                if (p.right == null) {
                    result.add(root.val);
                    p.right = root;
                    root = root.left;
                } else {
                    p.right = null;
                    root = root.right;
                }
            }
        }
        return result;
    }

    private TreeNode getP(TreeNode root) {
        TreeNode result = root.left;
        while (result.right != null && result.right != root) {
            result = result.right;
        }
        return result;
    }
}
