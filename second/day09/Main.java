package second.day09;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-13
 * Time:21:42
 */

/*
找x
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strings = sc.nextLine().split(" ");
        int x = Integer.parseInt(sc.nextLine());
        for (int i =0;i < strings.length;i++) {
            int e = Integer.parseInt(strings[i]);
            if (e == x) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
