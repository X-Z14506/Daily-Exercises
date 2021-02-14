package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:18:22
 */

/*
        题目描述
       给定两个整数a和b (－10,000 < a,b < 10,000)，计算a除以b的整数商和余数。

        输入描述:
        一行，包括两个整数a和b，依次为被除数和除数（不为零），中间用空格隔开。
        输出描述:
        一行，包含两个整数，依次为整数商和余数，中间用一个空格隔开。

        输入：15 2
        输出：7 1
 */
public class Main13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[1]);
        System.out.print(a/b);
        System.out.print(" "+a%b);
    }
}
