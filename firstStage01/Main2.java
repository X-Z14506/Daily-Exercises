package firstStage01;

import java.math.BigInteger;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:15:01
 */
/*
        BoBo写了一个十六进制整数ABCDEF，他问KiKi对应的十进制整数是多少。
 */
public class Main2 {
    public static void main1(String[] args) {
        String s = "ABCDEF";
        String str = new BigInteger(s,16).toString(10);
        System.out.printf("%15s",str);//       11259375
    }

    public static void main2(String[] args) {
        String s = Integer.valueOf("ABCDEF", 16).toString();
        StringBuilder sb = new StringBuilder(15);
        for (int i = 0; i < 15 - s.length(); i++) {
            sb.append(" ");
        }
        sb.append(s);
        System.out.println(sb);//       11259375
    }

    public static void main3(String[] args) {
        //       11259375
        System.out.println("       "+Integer.parseInt("ABCDEF",16));
    }

    public static void main(String[] args) {
        //       11259375
        System.out.printf("%15s",Integer.parseInt("ABCDEF",16));
    }
}
