package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 * 树中节点数范围是 [0, 104]
 * 0 <= Node.val <= 104
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 */
public class CodecSerialize {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        TreeNode head = root;
        Stack<TreeNode> stack = new Stack<>();
        List<String> first = new ArrayList<>();
        List<String> mid = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
            first.add(root.val + "");
        }
        while (!stack.isEmpty() || head != null) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            head = stack.pop();
            mid.add(head.val + "");
            head = head.right;
        }
        return String.join(",", first) + "|" + String.join(",", mid);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] ss = data.split("\\|");
        String[] first = ss[0].split(",");
        String[] mid = ss[1].split(",");
        return doTree(first, mid);
    }

    private static TreeNode doTree(String[] first, String[] mid){
        if (first.length == 0) {
            return null;
        }
        int rootVal = Integer.parseInt(first[0]);
        TreeNode root = new TreeNode(rootVal);
        int index = -1;
        int length = 0;
        for (int i = 0; i < mid.length; i++) {
            if (rootVal == Integer.parseInt(mid[i])) {
                index = i;
                break;
            } else {
                length++;
            }
        }
        if (first.length == 1) {
            return root;
        }
        root.left = doTree(Arrays.copyOfRange(first, 1, 1 + length), Arrays.copyOfRange(mid, 0, index));
        root.right = doTree(Arrays.copyOfRange(first, 1 + length, first.length), Arrays.copyOfRange(mid, index + 1, mid.length));
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode a = deserialize(serialize(root));
        TreeNode b = deserialize(serialize(null));
        System.out.println(a);
    }
}
