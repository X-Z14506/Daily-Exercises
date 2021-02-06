package second.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-26
 * Time:20:39
 */

/*
二维数组打印
 */
public class Printer {
    public static void main(String[] args) {
        int[][] ints = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int n = 4;
        int[] ret = arrayPrint(ints,n);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] arrayPrint(int[][] arr, int n) {
        int[] ints = new int[n*n];
        int index = 0;
        //先打印上三角
        for (int i = 1;i <= n;i++) {
            int e1 = 0;
            for (int j = i;j > 0;j--) {
                int e2 = n-j;
                ints[index++] = arr[e1++][e2];
            }
        }
        //在打印对角线以下的下三角
        for (int i = n-1;i > 0;i--) {
            int e1 = 0;
            for (int j = i;j>0;j--) {
                int e2 = n-j;
                ints[index++] = arr[e2][e1++];
            }
        }
        return ints;
    }
}
