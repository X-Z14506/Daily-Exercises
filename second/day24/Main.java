package second.day24;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-29
 * Time:20:40
 */

/*
计算日期到天数转换
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int year = sc.nextInt();
            sc.nextLine();
            int month = sc.nextInt();
            sc.nextLine();
            int day = sc.nextInt();
            sc.nextLine();
            if (isLegalInput(year,month,day)) {
                int [] notLeapYear = {31,28,31,30,31,30,31,31,30,31,30,31};
                int [] leapYear = {31,29,31,30,31,30,31,31,30,31,30,31};
                if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    countDays(leapYear,month,day);
                }else {
                    countDays(notLeapYear,month,day);
                }
            }else {
                System.out.println(-1);
            }
        }

    }

    private static void countDays(int[] isLeapYear, int month, int day) {
        int sum = 0;
        for (int i = 0;i < month-1;i++) {
            sum+=isLeapYear[i];
        }
        sum+=day;
        System.out.println(sum);
    }

    /**
     * 判断输入日期是否合法
     * */
    private static boolean isLegalInput(int year , int month , int day){
        boolean flag = true;
        //判断年份
        if(year < 0){
            return false;
        }
        //判断月份
        if(month <= 0 || month > 12){
            return false;
        }
        //判断day,最大31天，暂不加更加精细的闰平年，月份的具体判断
        if(day > 31){
            return false;
        }
        return flag;
    }
}
