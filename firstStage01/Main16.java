package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:18:46
 */

/*
        题目描述
        给定一个浮点数，要求得到该浮点数的个位数。
        输入描述:
        一行，包括一个浮点数。
        输出描述:
        一行，包含一个整数，为输入浮点数对应的个位数。

        输入：13.141
        输出：3
 */
public class Main16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /**
         * 当以.(点号)作为String.split()的分割符时，表达式不应该写成String.split(".")，因为点号在正则表达式中由特殊含义，所以此处应该用转义字符String.split("\\.")。
         */
        String[] string =  scanner.nextLine().split("\\.");
        //System.out.println(string.length);
        System.out.println(Integer.parseInt(string[0]) % 10);
    }


}
