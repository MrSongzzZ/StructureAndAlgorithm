package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 你是一名行政助理，手里有两位客户的空闲时间表：slots1 和 slots2，以及会议的预计持续时间 duration，请你为他们安排合适的会议时间。
 *
 * 「会议时间」是两位客户都有空参加，并且持续时间能够满足预计时间 duration 的 最早的时间间隔。
 *
 * 如果没有满足要求的会议时间，就请返回一个 空数组。
 *
 *
 *
 * 「空闲时间」的格式是 [start, end]，由开始时间 start 和结束时间 end 组成，表示从 start 开始，到 end 结束。
 *
 * 题目保证数据有效：同一个人的空闲时间不会出现交叠的情况，也就是说，对于同一个人的两个空闲时间 [start1, end1] 和 [start2, end2]，要么 start1 > end2，要么 start2 > end1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * 输出：[60,68]
 * 示例 2：
 *
 * 输入：slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
 * 输出：[]
 */
public class minAvailableDuration {

    public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        };
        Arrays.sort(slots1, c);
        Arrays.sort(slots2, c);

        int l = 0;
        int r = 0;
        while (l < slots1.length && r < slots2.length) {
            if (slots1[l][0] == slots2[r][0]) {
                if (slots1[l][1] <= slots2[r][1]) {
                    int time = slots1[l][1] - slots1[l][0];
                    if (time >= duration) {
                        result.add(slots1[l][0]);
                        result.add(slots1[l][0] + duration);
                        return result;
                    } else {
                        if (slots1[l][1] == slots2[r][1]) {
                            r++;
                        }
                        l++;
                    }
                } else if (slots1[l][1] > slots2[r][1]) {
                    int time = slots2[r][1] - slots2[r][0];
                    if (time >= duration) {
                        result.add(slots2[r][0]);
                        result.add(slots2[r][0] + duration);
                        return result;
                    } else {
                        r++;
                    }
                }
            } else if (slots1[l][0] < slots2[r][0]) {
                if (slots1[l][1] < slots2[r][0]) {
                    l++;
                } else if (slots1[l][1] > slots2[r][1]) {
                    int time = slots2[r][1] - slots2[r][0];
                    if (time >= duration) {
                        result.add(slots2[r][0]);
                        result.add(slots2[r][0] + duration);
                        return result;
                    } else {
                        r++;
                    }
                } else {
                    int time = slots1[l][1] - slots2[r][0];
                    if (time >= duration) {
                        result.add(slots2[r][0]);
                        result.add(slots2[r][0] + duration);
                        return result;
                    } else {
                        l++;
                    }
                }
            } else {
                if (slots1[l][0] > slots2[r][1]) {
                    r++;
                } else if (slots1[l][1] > slots2[r][1]) {
                    int time = slots2[r][1] - slots1[l][0];
                    if (time >= duration) {
                        result.add(slots1[l][0]);
                        result.add(slots1[l][0] + duration);
                        return result;
                    } else {
                        r++;
                    }
                } else {
                    int time = slots1[l][1] - slots1[l][0];
                    if (time >= duration) {
                        result.add(slots1[l][0]);
                        result.add(slots1[l][0] + duration);
                        return result;
                    } else {
                        l++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

//        System.out.println(minAvailableDuration(new int[][]{{10,50},{60,120},{140,210}}, new int[][]{{0,15},{60,70}}, 8));
//        System.out.println(minAvailableDuration(new int[][]{{10,50},{60,120},{140,210}}, new int[][]{{0,15},{60,70}}, 12));
        System.out.println(minAvailableDuration(new int[][]{{216397070,363167701},{98730764,158208909},{441003187,466254040},{558239978,678368334},{683942980,717766451}}, new int[][]{{50490609,222653186},{512711631,670791418},{730229023,802410205},{812553104,891266775},{230032010,399152578}}, 456085));
    }
}
