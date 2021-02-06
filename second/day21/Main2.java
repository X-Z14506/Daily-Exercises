package second.day21;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-26
 * Time:21:37
 */

/*
回文串
给定一个字符串，能否通过添加一个字母将其变成回文串

思路：如果一个字符串通过添加一个字母可以变成回文串，呢么他去掉一个字母也可以变成回文串
     将字符串的每位都去掉一次，然后判断，出现一次，就结束循环，
     如果一次回文串都没出现，则说明添加一个字母也不会构成回文串
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        while (sc.hasNext()) {
            String s = sc.nextLine();
            for (int i = 0;i < s.length();i++) {
                String s1 = s.substring(0,i)+s.substring(i+1);
                flag = isPlindrome(s1);
                if (flag) {
                    System.out.println("YES");
                    break;
                }
            }
            if (!flag) {
                System.out.println("NO");
            }
        }
    }

    //判断去掉一个字母的字符串是不是回文
    private static boolean isPlindrome(String s1) {
        int i = 0;
        int j = s1.length()-1;
        while (i<j) {
            if (s1.charAt(i)==s1.charAt(j)) {
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
