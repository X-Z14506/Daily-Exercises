package home.day01;

import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-14
 * Time:14:28
 */
public class 旋转数组 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int i = 3;
        rotate(a,i);
        rotate2(a,i);
    }
    //TODO 这个方法在idea可以跑通，在力扣不行 奇怪
    public static void rotate(int[] nums, int k) {
        int[] newNums = new int[nums.length];
        int index = 0;
        for (int i = k+1;i < nums.length;i++) {
            newNums[index++] = nums[i];
        }
        for (int i = 0;i <= k;i++) {
            newNums[index++] = nums[i];
        }
        nums = newNums;
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(newNums));
    }
    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
         subRotate(nums,0,n-1);
        subRotate(nums,0,k-1);
        subRotate(nums,k,n-1);
        System.out.println(Arrays.toString(nums));
    }
    private static void subRotate(int[] arr ,int left,int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

}
