package Algorithm;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *  
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class majorityElement {

    public static int majorityElement(int[] nums) {
        //摩尔投票法
        int result = 0;
        int vote = 0;
        for (int i = 0; i < nums.length; i++) {
            if (vote == 0) {
                result = nums[i];
            }
            if (result == nums[i]) {
                vote ++;
            } else {
                vote --;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,2,3,2,2,2,5,4,2}));
    }
}
