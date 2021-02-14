package firstStage02;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-01
 * Time:18:17
 */

/*
    题目描述
有个软件系统登录的用户名和密码为（用户名：admin，密码：admin），用户输入用户名和密码，判断是否登录成功。
输入描述:
多组测试数据，每行有两个用空格分开的字符串，第一个为用户名，第二个位密码。
输出描述:
针对每组输入测试数据，输出为一行，一个字符串（“Login Success!”或“Login Fail!”）。

输入：admin admin
输出：Login Success!

输入：admin abc
输出：Login Fail!

 */

public class Main20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strings = scanner.nextLine().split(" ");
            String s1 = strings[0];
            String s2 = strings[1];
            if ("admin".equals(s1) && "admin".equals(s2)) {
                System.out.println("Login Success!");
            }else {
                System.out.println("Login Fail!");
            }
        }
    }
}
