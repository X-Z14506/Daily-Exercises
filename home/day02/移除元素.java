package home.day02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-14
 * Time:17:27
 */
/*
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

 */
public class 移除元素 {
    public static void main(String[] args) {
        int[] a = {3,2,2,3,3,2,4,5};
        int val = 3;
        int i = removeElement(a, val);
        System.out.println(i);
    }
    public static int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        //空间复杂度为0（1），且元素的顺序可以改变。不需要考虑数组中超出新长度后面的元素。
        int index = 0;//数组不需要删除元素的新下标
        for(int i = 0;i < nums.length;i++) {
            if(nums[i]!=val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
