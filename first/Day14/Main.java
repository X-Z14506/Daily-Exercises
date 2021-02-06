package first.Day14;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-08
 * Time:7:23
 */

/*
           给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。
        目标是使得最后得到的数尽可能小（注意0不能做首位）。

        例如：给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。

        现给定数字，请编写程序输出能够组成的最小的数。
        输入描述:
        每个输入包含1个测试用例。每个测试用例在一行中给出10个非负整数，
        顺序表示我们拥有数字0、数字1、……数字9的个数。整数间用一个空
        格分隔。10个数字的总个数不超过50，且至少拥有1个非0的数字。

        输出描述:
        在一行中输出能够组成的最小的数。

        输入：2200030010：即两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558
        输出：10015558
 */


//思路 ：找到所给数字中非零并且最小的数，让它为数字最高位，，
//然后将剩余元素从小到大依次添加
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            //用数组存，数组内元素值代表数字0-9的个数
            int[] nums = new int[10];
            for(int i = 0;i<10;i++){
                nums[i] = in.nextInt();
            }
            System.out.println(GetNum(nums));
        }
    }
        public static String GetNum( int[] nums) {
            //找到所给数字中非零并且最小的数，让它为数字最高位
            //因为是顺序表示我们拥有数字0、数字1、……数字9的个数，所以数组中下标1代表的就是数字1的个数，
            // 从1开始找，找到直接break并且数组i下标减一
            String s = "";
            for(int i = 1; i<10;i++){
                if(nums[i] != 0){
                    s += i;
                    nums[i] --;
                    break;
                }
            }
            //找到最小值放在最高位后，然后将剩余元素从小到大依次添加，外层循环代表数字0-9，内层循环数字0-9分别的个数
            for(int i = 0;i<10;i++){
                while(nums[i] != 0){
                    s += i;
                    nums[i] --;
                }
            }
            return s;
        }
}
