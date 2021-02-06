package second.day16;

import javafx.scene.transform.Scale;

import java.awt.image.AffineTransformOp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-21
 * Time:17:28
 */

/*
    BrokenKey
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine().toUpperCase();
            String s2 = sc.nextLine().toUpperCase();
            List<String> list = new ArrayList<>();
            for (int i = 0 ;i < s1.length();i++) {
                String str = String.valueOf(s1.charAt(i));
                if (!s2.contains(str)) {
                    if (!list.contains(str)){
                        list.add(str);
                    }
                }
            }
            for (String ret : list) {
                System.out.print(ret);
            }
            System.out.println();
        }
    }
}
