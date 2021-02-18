package home.day12;

import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-16
 * Time:19:55
 */
public class 最短连续无序子数组 {
    public static void main(String[] args) {
        int[] a = {1,3,2,2,2};
        int unsortedSubarray = findUnsortedSubarray2(a);
        System.out.println(unsortedSubarray);

    }
    public static int findUnsortedSubarray(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<right && nums[left] < nums[left+1]) {
            left++;
        }
        while(left<right && nums[right]>nums[right-1]) {
            right--;
        }
        if (left==right) {
            return 0;
        }else {
            return right - left + 1;
        }
    }
    public static int findUnsortedSubarray2(int[] nums) {
       int[] num = nums.clone();
        Arrays.sort(num);
        int start = num.length-1;
        int end = 0;
        for (int i = 0;i < num.length;i++) {
            if (num[i]!=nums[i]) {
                start = Math.min(start,i);
                end  = Math.max(end,i);
            }
        }
        return (end-start>=0) ? end-start+1 : 0;
    }
}
