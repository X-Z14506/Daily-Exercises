package second.day22;

import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-27
 * Time:21:04
 */

/*
删除公共字符
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < s1.length();i++) {
                String temp = String.valueOf(s1.charAt(i));
                if (!s2.contains(temp)) {
                    sb.append(temp);
                }
            }
            System.out.println(sb);
        }

    }
}
