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
        实现字母的大小写转换。多组输入输出。
        输入描述:
        多组输入，每一行输入大写字母。
        输出描述:
        针对每组输入输出对应的小写字母。
        输入：A
             B
        输出：a
             b
 */
public class Main23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(s.toLowerCase());
        }
    }
}
