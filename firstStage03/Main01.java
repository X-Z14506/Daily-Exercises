package firstStage03;

import javax.imageio.stream.IIOByteBuffer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-03
 * Time:20:41
 */

/*
题目描述
KiKi现在得到一个包含n*m个数的整数序列，现在他需要把这n*m个数按顺序规划成一个n行m列的矩阵并输出，请你帮他完成这个任务。
输入描述:
一行，输入两个整数n和m，用空格分隔，第二行包含n*m个整数（范围-231~231-1）。(1≤n≤10, 1≤m≤10)
输出描述:
输出规划后n行m列的矩阵，每个数的后面有一个空格。

输入：
2 3
1 2 3 4 5 6

输出：
1 2 3
4 5 6

 */

public class Main01 {
    //法二：
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        strings = reader.readLine().split(" ");
        int index = 0;//定义一维数组的下标

        //开辟一个n*m的二维数组，将一维数组内的元素按顺序放入二维数组
        String[][] str = new String[n][m];
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                str[i][j] = strings[index];
                System.out.print(str[i][j]+" ");
                index++;
            }
            System.out.println();
        }
    }

    //法一
    public static void main1(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        //int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        String[] strings1 = reader.readLine().split(" ");
        for (int j = 1;j <= strings1.length;j++) {
            if (j % m == 0) {
                System.out.print(strings1[j-1]+" ");
                System.out.println();
            }else {
                System.out.print(strings1[j-1]+" ");
            }
        }

    }
}
