package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:17:33
 */
/*
        输入一个人的出生日期（包括年月日），将该生日中的年、月、日分别输出。
        输入描述:
        输入只有一行，出生日期，包括年月日，年月日之间的数字没有分隔符。
        输出描述:
        三行，第一行为出生年份，第二行为出生月份，第三行为出生日期。输出时如果月份或天数为1位数，需要在1位数前面补0。

        输入：20130225
        输出：year=2013
             month=02
             date=25
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s=scanner.nextLine();
        String year=s.substring(0,4);
        String month=s.substring(4,6);
        String date=s.substring(6,8);
        System.out.println("year="+year);
        System.out.println("month="+month);
        System.out.println("date="+date);
    }
}
