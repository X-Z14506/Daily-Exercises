package home.day08;

import javax.security.auth.login.CredentialException;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-15
 * Time:16:48
 */
public class 第三大的数 {
    public static void main(String[] args) {
        int[] nums = {85,4,2,8,8,9,9,6,3};
        System.out.println(thirdMax(nums));
    }
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length-1;i > 0;i--) {
            if (nums[i] != nums[i-1]) {
                count++;
            }
            if (count == 3) {
                return nums[i];
            }
        }
        //没有第三大的数，就返回当前数组最大值
        return nums[nums.length-1];
    }
}
