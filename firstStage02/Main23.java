package firstStage02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-01
 * Time:20:17
 */

/*
题目描述

有一个有序数字序列，从小到大排序，将一个新输入的数插入到序列中，保证插入新数后，序列仍然是升序。
输入描述:
共三行，
第一行输入一个整数(0≤N≤50)。
第二行输入N个升序排列的整数，输入用空格分隔的N个整数。
第三行输入想要进行插入的一个整数。
输出描述:
输出为一行，N+1个有序排列的整数。

输入：7
    5 30 40 50 60 70 90
    20

输出：5 20 30 40 50 60 70 90

 */
public class Main23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] ints = new int[num+1];
        for (int i = 0;i< num;i++) {
            ints[i] = scanner.nextInt();
        }
        int num2 = scanner.nextInt();
        ints[num] = num2;
        Arrays.sort(ints);
        //System.out.println(Arrays.toString(ints));
        for (int i = 0;i<ints.length;i++) {
            System.out.print(ints[i]+" ");
        }
    }
}
