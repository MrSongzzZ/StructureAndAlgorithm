package struts;

/**
 * 平衡二叉树 LL LR RR RL
 */
public class Tree {
    public static int getBalance(TreeNode root) {
        return height(root.getLeft()) - height(root.getRight());
    }
    public static void printPre(TreeNode node) {
        if (node != null) {
            System.out.print(node.getVal() + " ");
            if (node.getLeft() != null) {
                printPre(node.getLeft());
            }
            if (node.getRight() != null) {
                printPre(node.getRight());
            }
        }
    }

    public static int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return node.getHeight();
        }
    }

    public static TreeNode llRemote(TreeNode node){
        TreeNode left = node.getLeft();
        node.setLeft(left.getRight());
        left.setRight(node);
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        left.setHeight(1 + Math.max(height(left.getLeft()), height(left.getRight())));
        return left;
    }

    public static TreeNode lrRemote(TreeNode node) {
        TreeNode left = node.getLeft();
        TreeNode right = left.getRight();
        left.setRight(right.getLeft());
        node.setLeft(right.getRight());
        right.setLeft(left);
        right.setRight(node);
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        left.setHeight(1 + Math.max(height(left.getLeft()), height(left.getRight())));
        right.setHeight(1 + Math.max(height(right.getLeft()), height(right.getRight())));
        return right;
    }

    public static TreeNode rrRemote(TreeNode node) {
        TreeNode right = node.getRight();
        node.setRight(right.getLeft());
        right.setLeft(node);
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        right.setHeight(1 + Math.max(height(right.getLeft()), height(right.getRight())));
        return right;
    }

    private static TreeNode rlRemote(TreeNode node) {
        TreeNode right = node.getRight();
        TreeNode left = right.getLeft();
        node.setRight(left.getLeft());
        right.setLeft(left.getRight());
        left.setLeft(node);
        left.setRight(right);
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        right.setHeight(1 + Math.max(height(right.getLeft()), height(right.getRight())));
        left.setHeight(1 + Math.max(height(left.getLeft()), height(left.getRight())));
        return left;
    }

    public static TreeNode insert(int val, TreeNode root) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.getVal() > val) {
            if (root.getLeft() == null) {
                root.setLeft(new TreeNode(val));
            } else {
                root.setLeft(insert(val, root.getLeft()));
            }
        } else if (root.getVal() < val) {
            if (root.getRight() == null) {
                root.setRight(new TreeNode(val));
            } else {
                root.setRight(insert(val, root.getRight()));
            }
        }
        root.setHeight( 1 + Math.max(height(root.getLeft()), height(root.getRight())));
        int balance = getBalance(root);
        if (balance > 1) {
            if (root.getLeft() != null && root.getLeft().getVal() > val) {
                System.out.println("LL mode 插入：" + val);
                return llRemote(root);
            }
            if (root.getLeft() != null && root.getLeft().getVal() < val) {
                System.out.println("LR mode 插入：" + val);
                return lrRemote(root);
            }
        } else if (balance < -1) {
            if (root.getRight() != null && root.getRight().val < val) {
                System.out.println("RR mode 插入：" + val);
                return rrRemote(root);
            }
            if (root.getRight() != null && root.getRight().val > val) {
                System.out.println("RL mode 插入：" + val);
                return rlRemote(root);
            }
        }
        return root;
    }

    public static int getMinValue(TreeNode root){
        int min = root.getVal();
        while (root.getLeft() != null) {
            root = root.getLeft();
            min = root.getVal();
        }
        return min;
    }

    public static TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.getVal() > val) {
            root.setLeft(deleteNode(root.getLeft(), val));
        } else if (root.getVal() < val) {
            root.setRight(deleteNode(root.getRight(), val));
        } else {
            //如果删除节点的左节点或者右节点其中有一个为空，即可直接链接
            if (root.getLeft() == null || root.getRight() == null) {
                root = root.getLeft() != null ? root.getLeft() : root.getRight();
            } else {//当删除一个根节点时，将根节点与右侧最小节点值互换即可（删除后 在旋转平衡 得到同样结果）
                int minValue = getMinValue(root.getRight());
                root.setVal(minValue);
                root.setRight(deleteNode(root.getRight(), minValue));
            }
        }

        if (root == null) {
            return null;
        }

        root.setHeight( 1 + Math.max(height(root.getLeft()), height(root.getRight())));
        int balance = getBalance(root);
        if (balance > 1) {
            int minRight = height(root.getRight()) - 1;
            if (root.getLeft().getLeft() != null && height(root.getLeft().getLeft()) - minRight > 1) {
                System.out.println("LL mode 插入：" + val);
                return llRemote(root);
            }
            if (root.getLeft().getRight() != null && height(root.getLeft().getRight()) - minRight > 1) {
                System.out.println("LR mode 插入：" + val);
                return lrRemote(root);
            }
        } else if (balance < -1) {
            int minLeft = height(root.getLeft()) - 1;
            if (root.getRight().getRight() != null && height(root.getRight().getRight()) - minLeft > 1) {
                System.out.println("RR mode 插入：" + val);
                return rrRemote(root);
            }
            if (root.getRight().getLeft() != null && height(root.getRight().getLeft()) - minLeft > 1) {
                System.out.println("RL mode 插入：" + val);
                return rlRemote(root);
            }
        }
        return root;
    }

    public static void testTree() {
        TreeNode node = null;
        printPre(node);
        System.out.println();
        node = insert(9, node);
        printPre(node);
        System.out.println();
        node = insert(5, node);
        printPre(node);
        System.out.println();
        node = insert(10, node);
        printPre(node);
        System.out.println();
        node = insert(0, node);
        printPre(node);
        System.out.println();
        node = insert(6, node);
        printPre(node);
        System.out.println();
        node = insert(11, node);
        printPre(node);
        System.out.println();
        node = insert(-1, node);
        printPre(node);
        System.out.println();
        node = insert(1, node);
        printPre(node);
        System.out.println();
        node = insert(2, node);
        printPre(node);
        System.out.println();
        node = deleteNode(node, 10);
        printPre(node);
    }

    public static void main(String[] args) {

    }
}

class RBTreeNode {
    int val;
    RBTreeNode left;
    RBTreeNode right;
    int height;
    int color;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public RBTreeNode getLeft() {
        return left;
    }

    public void setLeft(RBTreeNode left) {
        this.left = left;
    }

    public RBTreeNode getRight() {
        return right;
    }

    public void setRight(RBTreeNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int height;

    public TreeNode(int val) {
        this.val = val;
        this.height = 1;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}