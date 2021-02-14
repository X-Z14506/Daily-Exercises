package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:19:04
 */

/*
        题目描述
         问题：一年约有3.156×10^7秒，要求输入您的年龄，显示该年龄合多少秒。
         输入描述:
        一行，包括一个整数age(0<age<=200)。
        输出描述:
        一行，包含一个整数，输出年龄对应的秒数。

        输入：20
        输出：631200000
 */
public class Main17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        long se=(long)(age*3.156*Math.pow(10,7));
        System.out.println(se);
    }
}
