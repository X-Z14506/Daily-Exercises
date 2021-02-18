package home.day08;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-15
 * Time:16:36
 */
/*
输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。

输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321

输入：digits = [0]
输出：[1]
 */

/*
    //只要+1求余数，余数不等于0，说明没有进位，直接返回。
    //如果余数等于0，说明有进位，遍历前一个数字，加1再求余数，以此循环。
    //如果for循环都遍历完了，说明最高位也有进位，则重新建立一个数组，
    //初始化为0，将第一位设置为1就可以了，因为，99、999之类的数字加一为100、1000
 */
public class 加一 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1;i>=0;i++) {
            digits[i]++;
            digits[i] = digits[i]%10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        int[] newInt = new int[digits.length+1];
        newInt[0] = 1;
        return newInt;
    }
}
