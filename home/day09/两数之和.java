package home.day09;

import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-15
 * Time:17:43
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(a, 9)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for (int i = 0;i < nums.length;i++) {
            for (int j = i+1;j < nums.length;j++) {
                if (nums[i]+nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    break;
                }
            }
        }
        return index;
    }
}
