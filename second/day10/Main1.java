package second.day10;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-15
 * Time:19:59
 */

/*
守形数
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int len = s.length();
            int n = Integer.parseInt(s);
            int n2 = n*n;
            String s1 = String.valueOf(n2);
            String ret = "";
            for (int i=s1.length()-len;i < s1.length();i++) {
                ret = ret + s1.charAt(i);
            }
            //System.out.println(ret);
            if (s.equals(ret)) {
                System.out.println("YES!");
            }else {
                System.out.println("NO!");
            }
        }
    }
}
