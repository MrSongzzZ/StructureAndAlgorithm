package Algorithm;

import java.util.*;

/***
 * 787. K 站中转内最便宜的航班
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 *
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findCheapestPrice {

    public static void main(String[] args) {
        System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
        System.out.println(findCheapestPrice(17, new int[][]{{0,12,28},{5,6,39},{8,6,59},{13,15,7},{13,12,38},{10,12,35},{15,3,23},{7,11,26},{9,4,65},{10,2,38},{4,7,7},{14,15,31},{2,12,44},{8,10,34},{13,6,29},{5,14,89},{11,16,13},{7,3,46},{10,15,19},{12,4,58},{13,16,11},{16,4,76},{2,0,12},{15,0,22},{16,12,13},{7,1,29},{7,14,100},{16,1,14},{9,6,74},{11,1,73},{2,11,60},{10,11,85},{2,5,49},{3,4,17},{4,9,77},{16,3,47},{15,6,78},{14,1,90},{10,5,95},{1,11,30},{11,0,37},{10,4,86},{0,8,57},{6,14,68},{16,8,3},{13,0,65},{2,13,6},{5,13,5},{8,11,31},{6,10,20},{6,2,33},{9,1,3},{14,9,58},{12,3,19},{11,2,74},{12,14,48},{16,11,100},{3,12,38},{12,13,77},{10,9,99},{15,13,98},{15,12,71},{1,4,28},{7,0,83},{3,5,100},{8,9,14},{15,11,57},{3,6,65},{1,3,45},{14,7,74},{2,10,39},{4,8,73},{13,5,77},{10,0,43},{12,9,92},{8,2,26},{1,7,7},{9,12,10},{13,11,64},{8,13,80},{6,12,74},{9,7,35},{0,15,48},{3,7,87},{16,9,42},{5,16,64},{4,5,65},{15,14,70},{12,0,13},{16,14,52},{3,10,80},{14,11,85},{15,2,77},{4,11,19},{2,7,49},{10,7,78},{14,6,84},{13,7,50},{11,6,75},{5,10,46},{13,8,43},{9,10,49},{7,12,64},{0,10,76},{5,9,77},{8,3,28},{11,9,28},{12,16,87},{12,6,24},{9,15,94},{5,7,77},{4,10,18},{7,2,11},{9,5,41}}, 13, 4, 13));
    }

    /**
     * 方法一：动态规划
     * 思路与算法
     *
     * 我们用 f[t][i]f[t][i] 表示通过恰好 tt 次航班，从出发城市 \textit{src}src 到达城市 ii 需要的最小花费。在进行状态转移时，我们可以枚举最后一次航班的起点 jj，即：
     *
     * f[t][i] = \min_{(j, i) \in \textit{flights}} \big\{ f[t-1][j] + \textit{cost}(j, i) \big\}
     * f[t][i]=
     * (j,i)∈flights
     * min
     * ​
     *  {f[t−1][j]+cost(j,i)}
     *
     * 其中 (j, i) \in \textit{flights}(j,i)∈flights 表示在给定的航班数组 \textit{flights}flights 中存在从城市 jj 出发到达城市 ii 的航班，\textit{cost}(j, i)cost(j,i) 表示该航班的花费。该状态转移方程的意义在于，枚举最后一次航班的起点 jj，那么前 t-1t−1 次航班的最小花费为 f[t-1][j]f[t−1][j] 加上最后一次航班的花费 \textit{cost}(j, i)cost(j,i) 中的最小值，即为 f[t][i]f[t][i]。
     *
     * 由于我们最多只能中转 kk 次，也就是最多搭乘 k+1k+1 次航班，最终的答案即为
     *
     * f[1][\textit{dst}], f[2][\textit{dst}], \cdots, f[k+1][\textit{dst}]
     * f[1][dst],f[2][dst],⋯,f[k+1][dst]
     *
     * 中的最小值。
     *
     * 细节
     *
     * 当 t=0t=0 时，状态 f[t][i]f[t][i] 表示不搭乘航班到达城市 ii 的最小花费，因此有：
     *
     * f[t][i] = \begin{cases} 0, & i = \textit{src} \\ \infty, & i \neq \textit{src} \end{cases}
     * f[t][i]={
     * 0,
     * ∞,
     * ​
     *
     * i=src
     * i
     * 
     * ​
     *  =src
     * ​
     *
     *
     * 也就是说，如果 ii 是出发城市 \textit{src}src，那么花费为 00；否则 f[0][i]f[0][i] 不是一个合法的状态，由于在状态转移方程中我们需要求出的是最小值，因此可以将不合法的状态置为极大值 \infty∞。根据题目中给出的数据范围，航班的花费不超过 10^410
     * 4
     *  ，最多搭乘航班的次数 k+1k+1 不超过 101101，那么在实际的代码编写中，我们只要使得极大值大于 10^4 \times 10110
     * 4
     *  ×101，就可以将表示不合法状态的极大值与合法状态的花费进行区分。
     *
     * 在状态转移中，我们需要使用二重循环枚举 tt 和 ii，随后枚举所有满足 (j, i) \in \textit{flights}(j,i)∈flights 的 jj，这样做的劣势在于没有很好地利用数组 \textit{flights}flights，为了保证时间复杂度较优，需要将 \textit{flights}flights 中的所有航班存储在一个新的邻接表中。一种可行的解决方法是，我们只需要使用一重循环枚举 tt，随后枚举 \textit{flights}flights 中的每一个航班 (j, i, \textit{cost})(j,i,cost)，并用 f[t-1][j] + \textit{cost}f[t−1][j]+cost 更新 f[t][i]f[t][i]，这样就免去了邻接表的使用。
     *
     * 注意到 f[t][i]f[t][i] 只会从 f[t-1][..]f[t−1][..] 转移而来，因此我们也可以使用两个长度为 nn 的一维数组进行状态转移，减少空间的使用。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/solution/k-zhan-zhong-zhuan-nei-zui-bian-yi-de-ha-abzi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int max = 10000 * 100 + 1;  //这是根据题目要求 设置的最大值  不会比这个更大  也可以直接用 MaxIntValue
        int cost = max;
        //dp[x][y] 表示 需要几步到达 y点
        int[][] dp = new int[k + 2][n];

        //因为求最小值 填充所有最大值
        for (int i = 0; i <= k + 1; i++) {
            Arrays.fill(dp[i], max);
        }

        //初始化 0 - 原地是0
        dp[0][src] = 0;
        for (int i = 1; i <= k + 1; i++) {

            //可以求出 所以用 1 - k+1 个点 到达目的地 所需要的钱  到达不了的目的地 就是无穷大
            for (int[] f : flights) {
                int d = f[1];
                int s = f[0];
                int p = f[2];
                dp[i][d] = Math.min(dp[i][d], dp[i - 1][s] + p);
            }
        }

        //比较消耗钱最小的步数
        for (int i = 1; i <= k + 1; i++) {
            cost = Math.min(dp[i][dst], cost);
        }

        return cost == max ? -1 : cost;
    }
}
