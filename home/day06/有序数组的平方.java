package home.day06;

import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-15
 * Time:13:00
 */
public class 有序数组的平方 {
    public static int[] sortedSquares(int[] nums) {
        for(int i = 0;i < nums.length;i++) {
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(a));
        int[] ints = sortedSquares(a);
        System.out.println(Arrays.toString(ints));
    }
}
