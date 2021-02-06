package first.Day12;

import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-06
 * Time:9:34
 */

/*
    格雷码：任意两个相邻的代码只有一位二进制数不同
        要求：编写一个函数
             以递归的方式生成N位格雷码
             给定一个整数n，返回n位的格雷码

       测试案例：输入 1       返回["0","1"]

     解题思路：任意两个相邻的代码只有一位二进制数不同，即：
    当 n == 1 的时候，格雷码为：["0", "1"]
    当 n == 2 的时候，格雷码为：["00", "01", "11", "10"]
    当 n == 3 的时候，格雷码为：["000", "001", "011", "010", "110", "111", "101", "100"]
    发现：n每次增加一，格雷码的数量就多一倍
    要知道n=2时的格雷码，只需要知道n=1的格雷码
    然后将1的格雷码正序一下，再倒序一下
    然后在前面一半第一个数字前加上0
    后面一半的第一个数字前面加上1

*/

public class Code2 {
    public static void main(String[] args) {
        for (int i = 1;i<6;i++) {
            String[] a = getGray(i);
            System.out.println(Arrays.toString(a));
        }

        //数组逆序法一：
        int[] i = {1,25,78,9};
        System.out.println(Arrays.toString(i));
        System.out.println("===========================逆序前===================================");
        int[] j = new int[i.length];
        for (int a = 0;a < i.length;a++) {
            j[a] = i[i.length-1-a];
        }
        System.out.println(Arrays.toString(j));
        System.out.println("===========================逆序后=====================================");

        //数组逆序法二：
        int[] x = {1,25,9978,9};
        System.out.println(Arrays.toString(x));
        System.out.println("===========================逆序前===================================");
        int[] y = new int[x.length * 2];
        for (int a = 0;a < x.length;a++) {
            y[a] = x[a];
            y[y.length-1-a] = x[a];
        }
        System.out.println(Arrays.toString(y));
        System.out.println("============================逆序后====================================");
    }

    //暴力解法的优化
    public static String[] getGray(int n) {
        if (n ==1 ){
            return new String[] {"0","1"};
        }
        else{
            String[] preArr = getGray(n-1);
            //要算n个格雷码，先算上一个格雷码
            String[] curArr = new String[2*preArr.length];
            //需要上一个的二倍的长度来存当前的格雷码
            for(int i =0; i<preArr.length; i++){
                curArr[i] = "0"+preArr[i];
                //在前面的一半之前加零
                curArr[curArr.length-1-i] = "1"+preArr[i];
                //在后面的一半之后加1
            }
            return curArr;
        }
    }

   /* //暴力解法一
    public static String[] getGray(int n) {
        if (n==1) {
            return new String[]{"0","1"};
        }else {
            //要求第n个格雷码，先求出第n-1个格雷码
            String[] preArr = getGray(n-1);

            //当前保存格雷码数组的长度为上一个格雷码数组长度的2倍
            String[] curArr = new String[preArr.length * 2];

            //前面一半第一个数字前加上0
            for (int i = 0 ;i < preArr.length;i++) {
                curArr[i] = "0" + preArr[i];
            }

            //先将preArr逆序一遍
            String[] newArr = new String[preArr.length];
            for (int i= 0 ; i < preArr.length ;i++) {
                newArr[i] = preArr[preArr.length-1-i];
            }
            //后面一半的第一个数字前面加上1
            int j = 0;
            for (int i = preArr.length;i < curArr.length;i++) {
                curArr[i] = "1" + newArr[j++];
            }
           return curArr;
        }
    }*/
}
