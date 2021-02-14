package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:18:10
 */

/*
    题目描述
        KiKi非常喜欢网购，在一家店铺他看中了一件衣服，他了解到，如果今天是“双11”（11月11日）则这件衣服打7折，“双12” （12月12日）则这件衣服打8折，
        如果有优惠券可以额外减50元（优惠券只能在双11或双12使用），求KiKi最终所花的钱数。
        输入描述:
        一行，四个数字，第一个数表示小明看中的衣服价格，第二和第三个整数分别表示当天的月份、当天的日期、第四个整数表示是否有优惠券（有优惠券用1表示，无优惠券用0表示）。
        输出描述:
        一行，小明实际花的钱数（保留两位小数）。（提示：不要指望商家倒找你钱）

        输入：1000.0 11 11 1
        输出：650.00
        输入：999.8 12 12 0
        输出：799.84
        输入：66.6 11 11 1
        输出：0.00
 */
public class Main30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        double price = Double.parseDouble(s[0]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[2]);
        int i = Integer.parseInt(s[3]);

        //当今天是双11时
        if (month==11 && day==11) {
            //有优惠券
            if (i == 1) {
                //如果需要花费的钱减去50小于0即为0.00
                double pay = price*0.7-50 > 0 ? price*0.7-50 : 0.00;
                System.out.println(String.format("%.2f",pay));
            }
            //无优惠券
            if (i == 0) {
                double pay = price*0.7;
                System.out.println(String.format("%.2f",pay));
            }
        }else if (month==12 && day==12) {
            if (i==1) {
                double pay = price*0.8-50 > 0 ? price*0.8-50 : 0.00;
                System.out.println(String.format("%.2f",pay));
            }
            if (i==0) {
                double pay = price*0.8;
                System.out.println(String.format("%.2f",pay));
            }
        }else {
            System.out.println(String.format("%.2f",price));
        }
    }
}
