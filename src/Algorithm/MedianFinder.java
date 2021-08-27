package Algorithm;

import java.util.*;

/**
 * 295. 数据流的中位数
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 通过次数50,511提交次数96,712
 */
public class MedianFinder {

//    Stack<Integer> a = null;
//    Stack<Integer> b = null;

    PriorityQueue<Integer> a = null;
    PriorityQueue<Integer> b = null;

    /** initialize your data structure here. */
    public MedianFinder() {
        a = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer - t1;
            }
        });
        b = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }
        });
    }

    public void addNum(int num) {
        if (a.size() == b.size()) {
            if (b.isEmpty()) {
                a.add(num);
            } else {
                if (num > a.peek()) {
                    a.add(num);
                } else {
                    b.add(num);
                    a.add(b.poll());
                }
            }
        } else {
            if (num >= a.peek()) {
                if (a.size() > b.size()) {
                    a.add(num);
                    b.add(a.poll());
                } else {
                    a.add(num);
                }
            } else {
                b.add(num);
                if (b.size() > a.size()) {
                    a.add(b.poll());
                }
            }
        }
    }

    public double findMedian() {
        if (a.size() == b.size() && a.size() > 0) {
            return (double)(a.peek() + b.peek()) / 2;
        } else {
            return a.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
//        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(1);
//        medianFinder.addNum(2);
//        medianFinder.addNum(3);
//        System.out.println(medianFinder.findMedian());
    }
}
