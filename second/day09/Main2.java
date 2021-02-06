package second.day09;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-14
 * Time:14:39
 */

/*
整数与IP地址间的转换
 */
    //TODO 存在数组越界问题待解决
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            //输入的是IP地址
            if (s.contains(".")) {
                IPToInt(s);
            }else {//输入的是整数
                IntToIP(s);
            }
       }
    }

    public static void IPToInt(String s) {
        String[] strings = s.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < strings.length;i++) {
            int e = Integer.parseInt(strings[i]);
            String str = Integer.toBinaryString(e);
            //所有二进制补全成八位
            while (str.length() < 8) {
                str="0"+str;
            }
            sb.append(str);
        }
        System.out.println(Integer.parseInt(sb.toString(),2));
    }

    public static void IntToIP(String s) {
        //1.先将十进制转换为二进制
        String s1 = Integer.toBinaryString(Integer.parseInt(s));
        //2.补0
        while (s1.length() < 32) {
            s1="0"+s1;
        }
        //3.存进数组
        String[] strings = new String[4];
        int [] ints = new int[4];
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < 4;i++) {
            strings[i] = s1.substring(count,count+8);
            ints[i] = Integer.parseInt(strings[i],2);
            sb.append(ints[i]+".");
            count+=8;
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
