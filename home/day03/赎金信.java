package home.day03;

import javax.naming.NamingEnumeration;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-14
 * Time:18:44
 */
public class 赎金信 {
    public static void main(String[] args) {
       /* String s = "abcde";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.indexOf("h")); //-1
        System.out.println(sb.deleteCharAt(0));//bcde*/
        String s1 = "zdyabc";
        String s2 = "abczdysd";
        boolean b = canConstruct(s1, s2);
        System.out.println(b);

    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder sb = new StringBuilder(magazine);
        for (char c : ransomNote.toCharArray()) {
            int index = sb.indexOf(String.valueOf(c));
            if (index>=0) {
                sb.deleteCharAt(index);//每找到一个删除一个
            }else {
                return false;
            }
        }
        return true;
       /* for(int i = 0;i < ransomNote.length();i++) {
            String s = String.valueOf(ransomNote.charAt(i));
            if(!magazine.contains(s)) {
                return false;
            }
        }
        return true;*/
    }

}
