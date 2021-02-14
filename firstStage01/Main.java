package firstStage01;

import java.math.BigInteger;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:14:43
 */
//请输出十进制整数1234对应的八进制和十六进制。

public class Main {
    /*
        "%d"表示以十进制整数形式输出
        "%o"表示以八进制形式输出
        "%x"表示以十六进制输出
        "%X"表示以十六进制输出,并且将字母(A、B、C、D、E、F)换成大写
        "%e"表示以科学计数法输出浮点数
        "%E"表示以科学计数法输出浮点数,而且将e大写
        "%f"表示以十进制浮点数输出,在"%f"之间加上".n"表示输出时保留小数点后面n位
     */
    public static void main1(String[] args) {
        int i = 1234;
        System.out.printf("0"+"%o",i);
        System.out.println();
        System.out.printf("0x"+"%X",i);
    }

    /*
        Integer类的方法
            Integer.toBinaryString()可实现十进制转换成二进制
            Integer.toOctalString()可实现十进制转换成八进制
            Integer.toHexString()可实现十进制转换成十六进制
            Integer.valueOf(s, radix)
            将第一个参数解释为用第二个参数指定的基数表示的有符号整数
            将 s 以 radix 进制的形式转换为十进制
            toUpperCase表示转换为大写字母
            toLowerCase表示转换为小写字母
     */
    public static void main2(String[] args) {
        int i =1234;
        System.out.println("0"+ Integer.toOctalString(i));
        System.out.println("0X"+Integer.toHexString(i).toUpperCase());
    }

    /*

     */

    public static void main(String[] args) {
        System.out.println("0"+change("1234",10,8));
        System.out.println("0x"+change("1234",10,16));
        
    }

    /**
     *
     * @param num 要转换的数
     * @param from 原数的进制
     * @param to   要转换成的进制
     * @return
     */
    private static String change(String num,int from ,int to) {
        String s1 = new BigInteger(num,from).toString(to);
        return s1.toUpperCase();
    }
}
