package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:16:34
 */

/*
    题目描述
        不使用累计乘法的基础上，通过移位运算（<<）实现2的n次方的计算。

        输入描述:
        多组输入，每一行输入整数n（0 <= n < 31）。
        输出描述:
        针对每组输入输出对应的2的n次方的结果

        输入：2
             10
        输出：4
             1024
 */
    //  <<左移是乘2
//      >>右移是除2


public class Main24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(1<<Integer.parseInt(s));
        }
    }
}
