package Algorithm;

import jdk.nashorn.internal.objects.NativeArray;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

import static jdk.nashorn.internal.objects.NativeArray.join;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Codec {

    public static List<String> integers = new ArrayList<>();
    public static List<TreeNode> treeNodes = new ArrayList<>();
    public static List<TreeNode> treeNodes2= new ArrayList<>();

    public static int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(treeNode.left), getHeight(treeNode.right));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        int height = getHeight(root);
        treeNodes.add(root);
        int flag = 1;
        for (int i = 0; i < height; i++) {
            if (flag == 1) {
                while (!treeNodes.isEmpty()) {
                    TreeNode treeNode = treeNodes.remove(0);
                    if (treeNode == null) {
                        integers.add(null);
                    } else {
                        integers.add(String.valueOf(treeNode.val));
                        treeNodes2.add(treeNode.left);
                        treeNodes2.add(treeNode.right);
                    }
                }
                flag = 0;
            } else {
                while (!treeNodes2.isEmpty()) {
                    TreeNode treeNode = treeNodes2.remove(0);
                    if (treeNode == null) {
                        integers.add(null);
                    } else {
                        integers.add(String.valueOf(treeNode.val));
                        treeNodes.add(treeNode.left);
                        treeNodes.add(treeNode.right);
                    }

                }
                flag = 1;
            }
        }
        int index = integers.size() - 1;
        String temp = integers.get(index);
        while (temp == null || temp.equals("null")) {
            integers.remove(index--);
            temp = integers.get(index);
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < integers.size(); i++) {
            builder.append(String.valueOf(integers.get(i)));
            if (i < integers.size() - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if (data.equals("")) {
            return null;
        }
        String[] ints = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(ints[0]));
        treeNodes.add(root);
        int flag = 0;
        int index = 1;
        while (index < ints.length) {
            if (flag == 0) {
                while (!treeNodes.isEmpty()) {
                    if (index > ints.length - 1) {
                        return root;
                    }
                    TreeNode node = treeNodes.remove(0);
                    if (node == null) {
                        continue;
                    }
                    String left = ints[index++];
                    if (left.equals("null")) {
                        node.left = null;
                    } else {
                        node.left = new TreeNode(Integer.parseInt(left));
                    }
                    if (index > ints.length - 1) {
                        return root;
                    }
                    String right = ints[index++];
                    if (right.equals("null")) {
                        node.right = null;
                    } else {
                        node.right = new TreeNode(Integer.parseInt(right));
                    }
                    treeNodes2.add(node.left);
                    treeNodes2.add(node.right);
                }

                flag = 1;
            } else {
                while (!treeNodes2.isEmpty()) {
                    if (index > ints.length - 1) {
                        return root;
                    }
                    TreeNode node = treeNodes2.remove(0);
                    if (node == null) {
                        continue;
                    }

                    String left = ints[index++];
                    if (left.equals("null")) {
                        node.left = null;
                    } else {
                        node.left = new TreeNode(Integer.parseInt(left));
                    }
                    if (index > ints.length - 1) {
                        return root;
                    }
                    String right = ints[index++];
                    if (right.equals("null")) {
                        node.right = null;
                    } else {
                        node.right = new TreeNode(Integer.parseInt(right));
                    }
                    treeNodes.add(node.left);
                    treeNodes.add(node.right);
                }
                flag = 0;
            }
        }
        return root;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
//        System.out.println(serialize(root));
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = null;
        root.left.left = new TreeNode(3);
        root.left.right = null;
        root.left.left.left = new TreeNode(4);
        root.left.left.right = null;
        root.left.left.left.left = new TreeNode(5);
        root.left.left.left.right = null;
        System.out.println(serialize(root));
//        deserialize("[1,2,3,null,null,4,5]");
//        deserialize("[]");
//        deserialize("[5,2,3,null,null,2,4,3,1]");
        deserialize("[1,2,null,3,null,4,null,5]");
//        deserialize("[1,2,null,3,null,4,null,5,null]");
//        System.out.println((int)Math.pow(2, 0) > 1);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));