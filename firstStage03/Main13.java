package firstStage03;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-06
 * Time:23:05
 */

/*
想把每位的数变成0或1。如果某一位是奇数，就把它变成1，如果是偶数，那么就把它变成0
输入：22222
输出：0

输入：123
输出：101
 */
public class Main13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.nextLine();
            char[] c = s.toCharArray();
            for (int i = 0;i < c.length;i++) {
                if (c[i]%2==0) {
                    c[i]='0';
                }else {
                    c[i]='1';
                }
            }
            String newStr = new String(c);
            int a = Integer.parseInt(newStr);
            System.out.println(a);
        }
    }
}
