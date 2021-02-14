package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:21:53
 */

/*
    题目描述
    KiKi想判断输入的字符是不是字母，请帮他编程实现。

    输入描述:
    多组输入，每一行输入一个字符。
    输出描述:
    针对每组输入，输出单独占一行，判断输入字符是否为字母，输出内容详见输出样例。

    输入：A
         6
    输出：A is an alphabet.
         6 is not an alphabet.

 */
public class Main36 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            char ch = s.next().charAt(0);
            if (ch>='A'&&ch<='Z' || ch>='a'&&ch<='z') {
                System.out.println(ch+" is an alphabet.");
            }else {
                System.out.println(ch+" is not an alphabet.");
            }
        }
    }
}
