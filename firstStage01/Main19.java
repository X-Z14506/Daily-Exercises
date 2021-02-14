package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:19:18
 */
/*
    题目描述
        依次输入一个学生的3科成绩，在屏幕上输出该学生的总成绩以及平均成绩。
        输入描述:
        一行，3科成绩，成绩之间用一个空格隔开。
        输出描述:
        一行，总成绩和平均成绩（小数点后保留两位），用一个空格隔开。

        输入：79.5 80.0 98.0
        输出：257.50 85.83
 */
public class Main19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        double sum = 0;
        double avg = 0;
        for (int i = 0;i < strings.length;i++) {
            sum += Double.parseDouble(strings[i]);
        }
        avg = sum/3;
        System.out.println(String.format("%.2f",sum)+" "+String.format("%.2f",avg));
    }
}
