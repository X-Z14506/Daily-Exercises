package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:17:31
 */

/*
    题目描述
        输入一个十六进制数a，和一个八进制数b，输出a+b的十进制结果（范围-231~231-1）。
        输入描述:
        一行，一个十六进制数a，和一个八进制数b，中间间隔一个空格。
        输出描述:
        一行，a+b的十进制结果。

        输入：0x12 05
        输出：23
 */

/**
 * 利用Integer.valueOf()方法可以把其他进制转成10进制
 *    Integer.parseInt()方法也可以
 *    subString()方法是左闭右开的
 */
public class Main28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        String num1 = strings[0].substring(2,strings[0].length());
        String num2 = strings[1].substring(1,strings[1].length());
        int a = Integer.parseInt(num1,16);
        int b = Integer.parseInt(num2,8);
        System.out.println(a+b);
    }
}
