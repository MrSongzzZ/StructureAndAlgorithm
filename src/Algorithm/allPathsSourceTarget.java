package Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. 所有可能的路径
 *
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 *
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class allPathsSourceTarget {

    public static void main(String[] args) {
        allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}});
    }

    static List<List<Integer>> result = new ArrayList<>();

    /**
     * DFS
     * @param graph
     * @return
     */
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        doPath(0, temp, graph);
        return result;
    }

    public static void doPath(int x, List<Integer> temp, int[][] graph) {
        if (x == graph.length - 1) {
            List<Integer> r = new ArrayList<>(temp);
            result.add(r);
            return;
        }
        for (int i : graph[x]) {

            //剪枝
            if (temp.contains(i)) {
                continue;
            }
            temp.add(i);
            doPath(i, temp, graph);
            temp.remove(Integer.valueOf(i));
        }
    }
}
