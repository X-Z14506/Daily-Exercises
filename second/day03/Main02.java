package second.day03;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-06
 * Time:21:02
 */

/*
最难的问题
 */
    public class Main02 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                char[] chars = s.toCharArray();
                for (int i = 0;i < chars.length;i++) {
                    if ('A' <= chars[i]) {
                        chars[i] = (char) ('E' < chars[i] ? (chars[i]-5) : (chars[i]+21));
                    }
                }
                System.out.println(new String(chars));
            }
        }
    }
