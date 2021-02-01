package Algorithm;

import java.util.Random;

/**
 * // -Xmx：最大堆内存，-Xms：最小堆内存，这里设置为一样的，表示堆内存固定200M
 * -Xmx200M -Xms200M
 *
 * NewRatio表示老年代和新生代的比例，3表示3：1
 * 即把整个堆内存分为4份，老年代占3份，新生代1份
 * 目前堆内存为200M，NewRatio=3时，新生代=50M，老年代=150M
 * -XX:NewRatio=3
 *
 * SurvivorRatio表示Eden区和两个Survivor区的比例，3表示3：2（注意是两个Survivor区）
 *即把新生代分为5份，Eden占3份，Survivor区占2份
 *目前新生代为50M，Survivor=3时，Eden=30M，Survivor=20M（from=10M, to=10M）
 * -XX:SurvivorRatio=3
 *
 * -XX:+UseSerialGC：显示指定使用Serial GC
 * -XX:+PrintGCDetails：打印GC详细日志
 * -XX:+PrintGCTimeStamps：打印GC发生的时间
 * -XX:+UseSerialGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 */
public class GCTest {

    public static void main(String[] args) {
        byte[][] useMemory = new byte[1000][];
        Random random = new Random();
        for (int i = 0; i < useMemory.length; i++) {
            useMemory[i] = new byte[1024 * 1024 * 10]; // 创建10M的对象
            // 20%的概率将创建出来的对象变为可回收对象
            if (random.nextInt(100) < 20) {
                System.out.println("created byte[] and set to null: " + i);
                useMemory[i] = null;
            } else {
                System.out.println("created byte[]: " + i);
            }
        }
    }
}
