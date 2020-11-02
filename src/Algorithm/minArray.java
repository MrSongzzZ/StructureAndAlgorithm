package Algorithm;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class minArray {

    public static int minArray(int[] numbers) {
        int left = 0;
        int hight = numbers.length - 1;
        while (left < hight) {
            int point = (left + hight) / 2;
            if (numbers[point] > numbers[hight]) {
                left = point;
            } else if (numbers[point] == numbers[hight]) {
                hight -= 1;
            } else {
                hight = point;
            }
            if (hight - left == 1) {
                return Math.min(numbers[left], numbers[hight]);
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        System.out.println(minArray(new int[]{1,3,3}));
        System.out.println(minArray(new int[]{3,3,1,3}));
        System.out.println(minArray(new int[]{1,1}));
        System.out.println(minArray(new int[]{3,4,5,1,2}));
        System.out.println(minArray(new int[]{2,2,2,0,1}));
    }
}
