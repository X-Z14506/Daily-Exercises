package firstStage01;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:18:09
 */

/*
        题目描述
        BoBo教KiKi字符常量或字符变量表示的字符在内存中以ASCII码形式存储。BoBo出了一个问题给KiKi，输入一个字符，输出该字符相应的ASCII码。

        输入描述:
        一行，一个字符。
        输出描述:
        一行，输出输入字符对应的ASCII码。

        输入：c
        输出：99
 */
public class Main11 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char s = scanner.nextLine().charAt(0);

        //使用Integer.valueOf就可以直接将char类型的数据转为十进制数据表现形式.
        System.out.println(Integer.valueOf(s));
    }


    public static void main(String[] args) throws IOException {
        //使用read()方法读取一个字符,返回值是int
        System.out.println(System.in.read());
    }
}
