package Algorithm;

import java.util.*;

/**
 * 102
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        Queue<TreeNode> treeNodes1 = new ArrayDeque<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty() || !treeNodes1.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (!treeNodes.isEmpty()) {
                root = treeNodes.poll();
                temp.add(root.val);
                if (root.left != null) {
                    treeNodes1.add(root.left);
                }
                if (root.right != null) {
                    treeNodes1.add(root.right);
                }
            }
            if (temp.size() > 0) {
                result.add(temp);
            }
            temp = new ArrayList<>();
            while (!treeNodes1.isEmpty()) {
                root = treeNodes1.poll();
                temp.add(root.val);
                if (root.left != null) {
                    treeNodes.add(root.left);
                }
                if (root.right != null) {
                    treeNodes.add(root.right);
                }
            }
            if (temp.size() > 0) {
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        List<TreeNode> list = new ArrayList<>();
        list.add(a);
        System.out.println(list);
    }
}
