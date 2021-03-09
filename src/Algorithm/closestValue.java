package Algorithm;

/**
 * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
 *
 * 注意：
 *
 * 给定的目标值 target 是一个浮点数
 * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
 * 示例：
 *
 * 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * 输出: 4
 */
public class closestValue {

    public int closestValue(TreeNode root, double target) {
        int result = 0;
        double max = -1d;
        while (root != null) {
            double temp = Math.abs((double)root.val - target);
            if (max > temp || max == -1d) {
                result = root.val;
                max = temp;
                if (root.val > target) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            } else {
                if (root.val > target) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }
        return result;
    }
}
