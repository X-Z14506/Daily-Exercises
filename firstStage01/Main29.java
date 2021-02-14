package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:18:03
 */

/*
    题目描述
        从键盘任意输入一个字符，编程判断是否是字母（包括大小写）。
        输入描述:
        多组输入，每行输入包括一个字符。
        输出描述:
        针对每行输入，输出该字符是字母（YES）或不是（NO）。

        输入：H
             9
        输出：YES
             NO
 */

public class Main29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
             char c = scanner.next().charAt(0);
             if (c >= 'a' && c <= 'z' || c >= 'A'&& c <= 'Z') {
                 System.out.println("YES");
             }else {
                 System.out.println("NO");
             }
        }
    }
}
