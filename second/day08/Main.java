package second.day08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-12
 * Time:12:25
 */

/*
数字之和
 */
public class Main {

  /*  public static void main(String[] args) {
        String s = "123";
        String[] strings = s.split("");
        System.out.println(strings.length);
        System.out.println(Arrays.toString(strings));
        char c = 'a';
        System.out.println(s.charAt(0));
    }*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = Integer.parseInt(sc.nextLine());
            int ret1 = count(n);
            long n2 = n*n;
            int ret2 = count(n2);
            System.out.println(ret1+" "+ret2);
        }
    }

    //计算n的各位数字之和
    public static int count(long n) {
        String s = String.valueOf(n);
        int sum = 0;
        String[] strings = s.split("");
        for (int i = 0;i < strings.length;i++) {
            sum += Integer.parseInt(strings[i]);
        }
        return sum;
    }


}
