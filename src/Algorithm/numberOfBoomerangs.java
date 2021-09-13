package Algorithm;

import javax.print.attribute.IntegerSyntax;
import java.util.*;

/**
 *447. 回旋镖的数量
 *
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 返回平面上所有回旋镖的数量。
 *
 *  
 * 示例 1：
 *   x x x
 *
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 示例 2：
 *
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * 示例 3：
 *
 * 输入：points = [[1,1]]
 * 输出：0
 *
 * 提示：
 *
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * 所有点都 互不相同
 */
public class numberOfBoomerangs {

    public static int numberOfBoomerangs(int[][] points) {
        int result = 0;

        for (int[] p : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (Integer integer : map.keySet()) {
                int m = map.get(integer);
                result += m * (m - 1);
            }
        }
        return result;
    }

    private static boolean isssss(int[][] points, int i, int l) {
        if (i + l >= points.length) {
            return false;
        }
        int[] m = points[i];
        int[] le = points[i - l];
        int[] ri = points[i + l];

        int lll = m[0] + m[1] - le[0] - le[1];
        int rrr = ri[0] + ri[1] - m[0] - m[1];
        if (lll == rrr) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        System.out.println(numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
//        System.out.println(numberOfBoomerangs(new int[][]{{0, 0}, {1, 1}, {2, 2}}));
//        System.out.println(numberOfBoomerangs(new int[][]{{1, 1}}));
        System.out.println(numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}}));

        /**
         *      * 0 -1
         *-1 0* * * 1,0
         *      *   0, 1
         */
    }
}
