package Algorithm;

import struts.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * q236
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }
//    int pLength = 0;
//    int qLength = 0;
//    int qflag = 0;
//    int pflag = 0;
//    Map<TreeNode, TreeNode> map = new HashMap<>();
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) {
//            return root;
//        }
//        tree(root, p, q, 1);
//        while (qLength < pLength) {
//            pLength--;
//            p = map.get(p);
//        }
//
//        while (pLength < qLength) {
//            qLength--;
//            q = map.get(q);
//        }
//
//        while (pLength >= 0) {
//            if (q == p) {
//                return q;
//            } else {
//                q = map.get(q);
//                p = map.get(p);
//            }
//        }
//        return root;
//    }
//
//    public void tree(TreeNode root, TreeNode p, TreeNode q, int tempLength) {
//        if (root.left != null) {
//            map.put(root.left, root);
//        }
//        if (root.right != null) {
//            map.put(root.right, root);
//        }
//        if (root == p) {
//            pflag = 1;
//            pLength = tempLength;
//        }
//        if (root == q) {
//            qflag = 1;
//            qLength = tempLength;
//        }
//        if (qflag + pflag != 2 && root.left != null) {
//            tree(root.left, p, q, tempLength + 1);
//        }
//        if (qflag + pflag != 2 && root.right != null) {
//            tree(root.right, p, q, tempLength + 1);
//        }
//    }
}
