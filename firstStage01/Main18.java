package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:19:12
 */

/*
        题目描述
        给定秒数seconds (0< seconds < 100,000,000)，把秒转化成小时、分钟和秒。

        输入描述:
        一行，包括一个整数，即给定的秒数。
        输出描述:
        一行，包含三个整数，依次为输入整数对应的小时数、分钟数和秒数（可能为零），中间用一个空格隔开。

        输入：3661
        输出：1 1 1
 */
public class Main18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        int hour = seconds/3600;
        int minute = seconds%3600/60;
        int second = seconds%3600%60;
        System.out.println(hour+" "+minute+" "+second+" ");

    }
}
