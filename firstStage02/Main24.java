package firstStage02;

import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-01
 * Time:20:38
 */

/*
题目描述
输入NxM矩阵，矩阵元素均为整数，计算其中大于零的元素之和。

输入描述:
第一行为N M(N: 矩阵行数；M: 矩阵列数,且M,N<=10)，接下来的N行为矩阵各行。
输出描述:
一行，其中大于零的元素之和。

输入：

3 3
2 3 4
-5 -9 -7
0 8 -4

输出：17
 */
public class Main24 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings1 = reader.readLine().split(" ");
        int M = Integer.parseInt(strings1[0]);
        int N = Integer.parseInt(strings1[1]);
        int sum = 0;
        for (int i = 0;i < M;i++) {
            String[] strings = reader.readLine().split(" ");
            for (int j = 0;j < strings.length;j++) {
                if (Integer.parseInt(strings[j]) > 0) {
                    sum+=Integer.parseInt(strings[j]);
                }
            }
        }
        System.out.println(sum);
    }
}
