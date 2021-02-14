package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:17:59
 */

/*
题目描述

输入两个整数，范围-231~231-1，交换两个数并输出。

输入描述:
输入只有一行，按照格式输入两个整数，范围，中间用“,”分隔。
输出描述:
把两个整数按格式输出，中间用“,”分隔。


输入：a=1,b=2
输出：a=2,b=1
 */
public class Main10 {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char i = s.charAt(2);
        char j = s.charAt(6);
        char temp = i ;
        i = j;
        j = temp;
        System.out.println("a="+i);
        System.out.println("b="+j);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split("[=,]");
        System.out.print("a="+s[3]);
        System.out.print(",b="+s[1]);
    }
}
