package second.day18;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-22
 * Time:21:09
 */

/*
进制转换，十六进制数值字符串转换为十进制字符串
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String sub = s.substring(2);
            System.out.println(Integer.parseInt(sub,16));
        }
    }
}
