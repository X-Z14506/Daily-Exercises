package second.day24;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.EventListener;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-29
 * Time:21:33
 */

/*
字符串加解密

例如：
输入：
abcdefg
BCDEFGH

输出：
BCDEFGH
abcdefg
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String code1 = sc.nextLine();
            String code2 = sc.nextLine();
            //加密
            encode(code1);
            //解密
            decode(code2);
        }
    }

    private static void decode(String code2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < code2.length();i++) {
            char ch = code2.charAt(i);
            //当内容数字时
            if (ch >= '0' && ch <= '9') {
                if (ch>='1') {
                    sb.append(ch - 49);
                }
                if (ch == '0') {
                    sb.append(9);
                }
            }
            //当内容为字母时
            else if (ch == 'A'){
                sb.append('z');
            }else if (ch == 'a') {
                sb.append('Z');
            }else if (ch>'a' && ch <= 'z'){
                sb.append((char)(ch-33));
            }else if ( ch>'A'&& ch<='Z') {
                sb.append((char)(ch+31));
            }else {
                sb.append(ch);
            }

        }
        System.out.println(sb);
    }

    private static void encode(String code) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < code.length();i++) {
            char ch = code.charAt(i);
            //当内容数字时
            if (ch >= '0' && ch <= '9') {
                if (ch <= '8') {
                    sb.append(ch - 47);
                }
                if (ch == '9') {
                    sb.append(0);
                }
            }
            //当内容为字母时
            else if (ch == 'z'){
                sb.append('A');
            }else if (ch == 'Z') {
                sb.append('a');
            }else if (ch>='a' && ch < 'z'){
                sb.append((char)(ch-31));
            }else if ( ch>='A'&& ch<'Z') {
                sb.append((char)(ch+33));
            }else {
                sb.append(ch);
            }

        }
        System.out.println(sb);
    }
}
