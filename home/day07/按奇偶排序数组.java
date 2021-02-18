package home.day07;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-15
 * Time:13:56
 */
/*
输入：[3,1,2,4]
输出：[2,4,3,1]
输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 */
public class 按奇偶排序数组 {
    public static void main(String[] args) {
        int[] a = {3,1,2,4};
        int[] ints = sortArrayByParity(a);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length-1;
        int temp;
        while (left<right) {
            //找到左边奇数的位置
            while (left<right && A[left]%2==0) {
                left++;
            }
            //找到右边偶数的位置
            while (left<right && A[right]%2==1) {
                right--;
            }
            //交换
            temp = A[left];
            A[left] = A[right];
            A[right] = temp;
        }
        return A;
    }
}
