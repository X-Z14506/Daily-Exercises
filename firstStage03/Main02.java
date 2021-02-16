package firstStage03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-03
 * Time:21:13
 */

/*
从n行m列的方阵队列中找到身高最高的人的位置

输入：
2 2
175 180
176 185

输出：
2 2

 */
public class Main02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        //先创建一个list按顺序存放所有人的身高值
        List<String> list = new ArrayList<>();
        for (int i = 0;i < n;i++) {
            strings = reader.readLine().split(" ");
            for (int j = 0;j < strings.length;j++) {
                list.add(strings[j]);
            }
        }


        int[] max = new int[2];
        int maxNum = 0;

        //ArrayList底层数组的下标
        int index = 0;
        //将list内的值按顺序存入二维数组，随后进行比较，找出最大值，最大值的下标存入一维数组
        int[][] a = new int[n][m];
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                a[i][j] = Integer.parseInt(list.get(index));
                if (a[i][j] > maxNum) {
                    maxNum = a[i][j];
                    max[0] = i+1;
                    max[1] = j+1;
                }
                index++;
            }
        }
        System.out.println(max[0]+" "+max[1]);

    }
}
