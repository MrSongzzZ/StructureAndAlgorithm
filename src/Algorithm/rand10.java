package Algorithm;

import java.util.Random;

/**
 *
 * 470. 用 Rand7() 实现 Rand10()
 *
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *
 * 不要使用系统的 Math.random() 方法。
 *
 *
 * 提示:
 *
 * rand7 已定义。
 * 传入参数: n 表示 rand10 的调用次数。
 *
 *       10  20  30  40 50 60 70
 * 进阶: 3   6    2   5 8  4  7
 *
 *  1 2 3 4 5 6 7
 *
 *
 * rand7()调用次数的 期望值 是多少 ?
 * 你能否尽量少调用 rand7() ?
 *
 */
public class rand10 {

    /**
     * 概率计算
     * @return
     */
    public static int rand10() {
        int f = 7;
        while (f > 6) {
            f = rand7();
        }
        int s = 6;
        while (s > 5) {
            s = rand7();
        }
        return (f & 1) == 1 ? s : 5 + s;
    }

    public static int rand7() {
        return new Random().nextInt(7) + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            System.out.println(i + ":" + (7 * i - i + 1));
            System.out.println(rand10());
        }
    }
}
