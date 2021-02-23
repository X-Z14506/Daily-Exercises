package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-10
 * Time:14:50
 */

public class 数组中重复的数字 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        //(Output) the duplicated number in the array number,
        //length of duplication array is 1,so using duplication[0] = ? in implementation;
        int[] a = new int[1];
        boolean duplicate = duplicate(arr, arr.length, a);
        System.out.println(duplicate);
    }
    public static boolean duplicate(int[] numbers,int length,int [] duplication) {
        boolean[] b = new boolean[length];
        for(int i = 0;i < length;i++) {
            //如果该数被标记过了说明是第一个重复的数字
            if(b[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            }
            //程序走到这里说明此时number[i]在数组中是第一次出现
            //出现将标志位置为true，便于后面的元素进行判断
            b[numbers[i]] = true;
        }
        //程序执行到这里还没有结束，说明数组中无重复数字
        return false;
    }
}
