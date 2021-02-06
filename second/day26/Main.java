package second.day26;

import javafx.scene.transform.Scale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-03
 * Time:10:20
 */

/*
骆驼命名法
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strings = sc.nextLine().split("_");
            change(strings);
        }
    }

    private static void change(String[] strings) {
        List<String> list = new ArrayList<>();
        list.add(strings[0]);
        for (int i = 1;i < strings.length;i++) {
            StringBuilder sb = new StringBuilder();
            String s = strings[i].substring(0,1).toUpperCase();
            sb.append(s).append(strings[i].substring(1));
            list.add(sb.toString());
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
}
