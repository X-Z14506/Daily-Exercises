package home.day11;

import java.io.FileOutputStream;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-16
 * Time:15:29
 */
public class 验证回文串 {
    public static void main(String[] args) {
        String s ="A man, a plan, a canal: Panama";
        String s1 = "race a car";
        boolean palindrome = isPalindrome(s1);
        System.out.println(palindrome);
        boolean palindrome2 = isPalindrome2(s);
        System.out.println(palindrome2);
    }
    public static boolean isPalindrome(String s) {
        if (s==null || s.length()==0) {
            return true;
        }
        String s1 = s.toUpperCase();
        int left = 0;
        int right = s1.length()-1;
        while (left<right) {
            while (left<right && !Character.isLetter(s1.charAt(left)) && !Character.isDigit(s1.charAt(left))) {
                left++;
            }
            while (left<right && !Character.isLetter(s1.charAt(right)) && !Character.isDigit(s1.charAt(right))) {
                right--;
            }
            //走到 这里说明left和right对应的都是字母或者数字
            if (s1.charAt(left)!=s1.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //方法二：
    public static boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toUpperCase(c));
            }
        }
        StringBuilder sbRev = new StringBuilder(sb).reverse();
        return sb.toString().equals(sbRev.toString());
    }
}
