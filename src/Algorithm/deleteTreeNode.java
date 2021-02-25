package Algorithm;

import struts.Tree;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树
 * （有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class deleteTreeNode {

    public static TreeNode fixStruct(TreeNode left, TreeNode right) {
        if (right == null) {
            return left;
        }
        TreeNode temp = right;
        while (temp.left != null) {
            temp = temp.left;
        }
        temp.left = left;
        return right;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root = fixStruct(root.left, root.right);
        }
        return root;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(50);
        TreeNode root = new TreeNode(5);
        TreeNode temp = root;
//        temp.left = new TreeNode(30);
//        temp.right = new TreeNode(70);
//        temp.left.right = new TreeNode(40);
//        temp.right.right = new TreeNode(80);
//        temp.right.left = new TreeNode(60);
        temp.left = new TreeNode(3);
        temp.right = new TreeNode(6);
        temp.left.right = new TreeNode(4);
        temp.left.left = new TreeNode(2);
        temp.right.right = new TreeNode(7);
//        root = deleteNode(root, 50);
        root = deleteNode(root, 3);
        System.out.println(root);
    }
}
