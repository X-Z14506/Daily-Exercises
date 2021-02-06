package second.day26;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-03
 * Time:10:35
 */

/*
单词倒排
TODO 90%
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] strings = sc.nextLine().split(" ");
            List<String> list = new ArrayList<>();
            for (int i = strings.length-1;i>=0;i--) {
                list.add(strings[i]);
            }
            for (String s : list) {
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}
