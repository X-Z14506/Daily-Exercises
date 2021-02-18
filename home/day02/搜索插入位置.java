package home.day02;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-14
 * Time:17:57
 */

/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。
 */
public class 搜索插入位置 {
    public static void main(String[] args) {
        int[] a = {1,3,5,6};
        int t1 = 5;
        int t2 = 2;
        int t3 = 7;
        int t4 = 0;
        System.out.println(searchInsert(a, t1));
        System.out.println(searchInsert(a, t2));
        System.out.println(searchInsert(a, t3));
        System.out.println(searchInsert(a, t4));
    }
    public static int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0) {
            return -1;
        }
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        if(nums[0] > target) {
            return 0;
        }
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
