package firstStage02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-01
 * Time:14:44
 */

/*
    题目描述
    公务员面试现场打分。有7位考官，从键盘输入若干组成绩，每组7个分数（百分制），去掉一个最高分和一个最低分，输出每组的平均成绩。
    输入描述:
    一行，输入7个整数（0~100），代表7个成绩，用空格分隔。
    输出描述:
    一行，输出去掉最高分和最低分的平均成绩，小数点后保留2位，每行输出后换行。

    输入：99 45 78 67 72 88 60
    输出：73.00
 */
public class Main16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int[] ints = new int[strings.length];
        for (int i = 0;i < ints.length;i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(ints);
        double sum = 0;
        for (int i = 1;i < ints.length-1;i++) {
            sum += ints[i];
        }
        System.out.println(String.format("%.2f",sum/(ints.length-2)));

    }
}
