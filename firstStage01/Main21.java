package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:15:58
 */

/*
        题目描述
            根据给出的三角形3条边a, b, c（0 < a, b, c < 100,000），计算三角形的周长和面积。
            输入描述:
            一行，三角形3条边（能构成三角形），中间用一个空格隔开。
            输出描述:
            一行，三角形周长和面积（保留两位小数），中间用一个空格隔开，输出具体格式详见输出样例。

            输入：3 3 3
            输出：circumference=9.00 area=3.90
 */
public class Main21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        double circumference = 0;
        double area = 1;
        for (int i = 0; i < s.length;i++) {
            circumference+=Double.parseDouble(s[i]);
        }
        double p = circumference/2;
        double ret = 1;
        for (int i = 0;i<s.length;i++) {
            ret *= ( p - Double.parseDouble(s[i]));
        }
        ret*=p;
        area = Math.sqrt(ret);
        System.out.println("circumference="+String.format("%.2f",circumference)+" area="+String.format("%.2f",area));

    }
}
