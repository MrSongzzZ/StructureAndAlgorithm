package Algorithm;

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
