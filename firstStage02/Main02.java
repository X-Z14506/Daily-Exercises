package firstStage02;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-30
 * Time:17:34
 */

/*
        题目描述
            KiKi想获得某年某月有多少天，请帮他编程实现。输入年份和月份，计算这一年这个月有多少天。
            输入描述:
            多组输入，一行有两个整数，分别表示年份和月份，用空格分隔。
            输出描述:
            针对每组输入，输出为一行，一个整数，表示这一年这个月有多少天。

            输入:2008 2
            输出：29
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            switch (month) {
                //判断是不是闰年
                case 2:
                    if ((year%100==0&&year%400!=0) || year%4!=0) {
                        System.out.println(28);
                    }else {
                        System.out.println(29);
                    };break;
                case 4:
                    System.out.println(30);break;
                case 6:
                    System.out.println(30);break;
                case 9:
                    System.out.println(30);break;
                case 11:
                    System.out.println(30);break;
                default:
                    System.out.println(31);
            }
        }
    }
}
