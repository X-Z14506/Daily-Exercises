package firstStage02;

import org.omg.PortableInterceptor.INACTIVE;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-02
 * Time:22:59
 */

/*
KiKi得到了一个n行m列的矩阵，现在他想知道第x行第y列的值是多少，请你帮助他完成这个任务。

输入描述:
第一行包含两个数n和m，表示这个矩阵包含n行m列。从2到n+1行，每行输入m个整数（范围-231~231-1），
用空格分隔，共输入n*m个数，表示矩阵中的元素。接下来一行输入x和y，用空格分隔，表示KiKi想得到的元素的位置。(1≤x≤n≤10，1≤y≤m≤10)

输出描述:
一行，输出一个整数值，为KiKi想知道的值。

输入：
2 3
1 2 3
4 5 6
1 2

输出：2
 */
public class Main32 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        int[][] a = new int[n][m];
        //将n行m列的数全部放入n*m的二维数组中
        for (int i = 0 ;i < n;i++) {
            //每进一次外层循环，读取一行数
            String[] strings1 = reader.readLine().split(" ");
            for (int j = 0;j < strings1.length;j++) {
                a[i][j] = Integer.parseInt(strings1[j]);
            }
        }
       /* System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));*/
        String[] strings2 = reader.readLine().split(" ");
        int i = Integer.parseInt(strings2[0]);
        int j = Integer.parseInt(strings2[1]);
        System.out.println(a[i-1][j-1]);
    }
}
