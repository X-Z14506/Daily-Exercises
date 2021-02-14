package firstStage02;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-01
 * Time:18:36
 */


/*

题目描述
今年是2019年，KiKi想知道1~2019中有多少个包含数字9的数。包含数字的数是指有某一位是“9”的数，例如“2019”、“199”等。

 */
public class Main21{
    public static void main(String[] args) {
        String s = null;
        int count = 0;
        for(int i = 1;i<=2019;i++) {
             s = String.valueOf(i);
            for(int j = 0; j < s.length();j++) {
                if (s.charAt(j)=='9') {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
