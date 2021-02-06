package second.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-17
 * Time:19:55
 */

/*
说反话
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        reverse(s);
    }
    public static void reverse(String[] strings) {
        List<String> list = new ArrayList<String>();
        for (int i = 0;i < strings.length;i++) {
            list.add(strings[i]);
        }

        int e = list.size()-1;
        int b = 0;
        for (int i = e;i >= 0;i--) {
            strings[b++] = list.get(i);
        }

        for (String s : strings) {
            System.out.print(s+" ");
        }

    }
}
