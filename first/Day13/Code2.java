package first.Day13;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-07
 * Time:8:51
 */

/*
        请设计一个算法完成两个超长正整数的加法。
        输入参数：
        String addend：加数
        String augend：被加数
        返回值：加法结果
               public String AddLongInteger(String addend, String augend)
                {
                /在这里实现功能/
                return null;
                }
                输入描述:
                输入两个字符串数字
                123456789123456789 123456789123456789

                输出描述:
                246913578246913578
                输出相加后的结果，string型

 */

public class Code2 {

    //法一：
    //Java语言处理该问题，优势比较大，参考BigInteger类就可以处理。核心API考察，
    //如果API限制，可以考虑采用字符串解析处理。
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String addend = in.nextLine();
        String augend = in.nextLine();
        BigInteger a = new BigInteger(addend);
        BigInteger b = new BigInteger(augend);
        System.out.println(a.add(b));
    }


    //法二：
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String addend = in.nextLine();
        String augend = in.nextLine();
        String s = add(addend,augend);
        System.out.println(s);
    }

    private static String add(String addend, String augend) {
        int len1 = addend.length();
        int len2 = augend.length();
        int[] a = new int[1000];
        int[] b = new int[1000];
        //因为两个数相加字符串后面的位数小，应该先加，所以讲字符串逆序存入数组
        //将字符串1的字符逆序取出减去0字符就是该字符对应的数字，存入a数组
        for (int i = 0;i < len1;i++) {
            a[i] = addend.charAt(len1-1-i)-'0';
        }
        //将字符串1的字符逆序取出减去0字符就是该字符对应的数字，存入a数组
        for (int i = 0; i < len2;i++) {
            b[i] = addend.charAt(len2-1-i)-'0';
        }

        //取串1和串2长度的最大值，将两个字符串各位上的字符相加，和超过十的向前进一位，本位存取余10的值
        int len = Math.max(len1,len2);
        for (int i =0; i<len;i++) {
            a[i] = a[i] + b[i];
            if (a[i]>=10) {
                a[i] = a[i]%10;
                a[i+1] = a[i+1]+1;
            }
        }

        //如果a[len]>0,说明第len位进了一位，字符串长度变成了len+1，应该拼接上len+1位的数
        StringBuffer sb = new StringBuffer();
        if (a[len] > 0) {
            sb.append(a[len]);
        }
        //此时在将得到的数逆序存入sb，即得到相加的结果
        for (int i = len-1;i>=0;i--) {
            sb.append(a[i]);
        }

        return sb.toString();


    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String addend = in.nextLine();
//        String augend = in.nextLine();
//        String ret = AddLongInteger(addend,augend);
//        System.out.println(ret);
//    }
//    public static String AddLongInteger(String addend,String augend) {
//        long add = Integer.parseInt(addend);
//        long aug = Integer.parseInt(augend);
//        long ret = add+aug;
//        return String.valueOf(ret);
//    }
}
