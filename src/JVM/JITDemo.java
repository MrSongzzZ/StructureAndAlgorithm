package JVM;

import java.util.Random;

/**
 * -Xint -XX:+PrintCompilation
 * 通过-Xint参数强行指定只使用解释模式，此时即时编译器完全不参与工作，java -version的最后一行会显示interpreted mode。、
 *
 * -Xcomp -XX:+PrintCompilation  纯编译执行模式
 *
 * -XX:+PrintCompilation  混合执行
 *
 *
 * 我们也可以通过-Xint参数强行指定只使用解释模式，此时即时编译器完全不参与工作，java -version的最后一行会显示interpreted mode。
 *
 * 可以通过参数-Xcomp强行指定只使用编译模式，此时程序启动后就会直接对所有代码进行编译，这种方式会拖慢启动时间，但启动后由于省去了解释执行和C1、C2的编译时间，代码执行效率会提升很多。此时java -version的最后一行会显示compiled mode。
 *
 *
 * 参数：-XX:+PrintCompilation -XX:-TieredCompilation（关闭分层编译）
 */
public class JITDemo {
    private static Random random = new Random();

//    //根据方法调用
//    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        int count = 0;
//        int i = 0;
//        while (i++ < 15000){
////        while (i++ < 99999999){
//            System.out.println(i);
//            count += plus();
//        }
//        System.out.println("time cost : " + (System.currentTimeMillis() - start));
//    }
//
//    private static int plus() {
//        return random.nextInt(10);
//    }


//    //根据循环回边
//    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        plus();
//        System.out.println("time cost : " + (System.currentTimeMillis() - start));
//    }
//
//    // 调用时，编译器计数器+1
//    private static int plus() {
//        int count = 0;
//        // 每次循环，编译器计数器+1
//        for (int i = 0; i < 15000; i++) {
//            System.out.println(i);
//            count += random.nextInt(10);
//        }
//        return random.nextInt(10);
//    }

//    根据方法调用和循环回边
//    PS：每次方法调用中有10次循环，所以每次方法调用计数器应该+11，所以应该会在差不多大于10000/11=909次调用时触发即时编译。
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int count = 0;
        int i = 0;
        while (i++ < 15000) {
            System.out.println(i);
            count += plus();
        }
        System.out.println("time cost : " + (System.currentTimeMillis() - start));
    }

    // 调用时，编译器计数器+1
    private static int plus() {
        int count = 0;
        // 每次循环，编译器计数器+1
        for (int i = 0; i < 10; i++) {
            count += random.nextInt(10);
        }
        return random.nextInt(10);
    }
}
