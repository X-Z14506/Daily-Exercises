package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:18:28
 */

/*
    题目描述
    将一个四位数，反向输出。

    输入描述:
    一行，输入一个整数n（1000 <= n <= 9999）。
    输出描述:
    针对每组输入，反向输出对应四位数。

    输入：1234
    输出：4321
 */

public class Main14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //创建一个长度和字符串长度相等的字符数组
        char[] chars = new char[s.length()];
        int len = s.length()-1;

        //颠倒顺序
        for (int i = 0;i < s.length();i++) {
            chars[len--] = s.charAt(i);
        }
        //将字符数组转换为字符串
        System.out.println(new String(chars));

        //将字符数组部分字符转换为字符串
        System.out.println(new String(chars,2,2));
    }
}
