package Algorithm;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class insertIntoBST {
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode temp = new TreeNode(4);
//        temp.left = new TreeNode(30);
//        temp.right = new TreeNode(70);
//        temp.left.right = new TreeNode(40);
//        temp.right.right = new TreeNode(80);
//        temp.right.left = new TreeNode(60);
        temp.left = new TreeNode(2);
        temp.right = new TreeNode(7);
        temp.left.left = new TreeNode(1);
        temp.left.right = new TreeNode(3);
//        root = deleteNode(root, 50);
        temp = insertIntoBST(temp, 5);
        System.out.println(temp);
    }
}
