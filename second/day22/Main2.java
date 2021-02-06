package second.day22;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-27
 * Time:21:13
 */

/*
句子逆序
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strings = sc.nextLine().split(" ");
            for (int i = strings.length-1;i>=0;i--) {
                System.out.print(strings[i]+" ");
            }
            System.out.println();
        }
    }
}
