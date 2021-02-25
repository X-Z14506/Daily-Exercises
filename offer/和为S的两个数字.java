package offer;

import java.util.ArrayList;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-10
 * Time:12:10
 */
/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
对应每个测试案例，输出两个数，小的先输出。

输入：[1,2,4,7,11,15],15
输出：[4,11]
 */
public class 和为S的两个数字 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,11,15};
        int n = 15;
        ArrayList<Integer> list = FindNumbersWithSum(arr, n);
        System.out.println(list);
    }
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        //左右定义两个指针，向内遍历，遇到的第一组数相距最远，一定就是乘积最小的
        ArrayList<Integer> list = new ArrayList<>();
        if(array == null || array.length < 2) {
            return list;
        }
        int left = 0;
        int right = array.length-1;
        while(left < right) {
            if( array[left]+array[right] == sum) {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            }else if(array[left]+array[right] > sum) {//和大了只能是右指针的数大了
                right--;
            }else{//和小了只能是左指针的数小了
                left++;
            }
        }
        return list;
    }
}
