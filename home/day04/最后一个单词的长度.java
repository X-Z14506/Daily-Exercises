package home.day04;

import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-14
 * Time:19:22
 */

public class 最后一个单词的长度 {
    public static void main(String[] args) {
        String s = "Hello World";
        String[] strings = s.split(" ");
        //System.out.println(Arrays.toString(strings));//[a]

        System.out.println(lengthOfLastWord(s));
    }
    //法1
    public int lengthOfLastWord1(String s) {
        String[] str = s.split(" ");
        if(str.length==0) {
            return 0;
        }
        String lastWord = str[str.length-1];
        int count = 0;
        for(int i = 0;i < lastWord.length();i++){
            count++;
        }
        return count;
    }
    //法2
    public static int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length != 0) {
                return length;
            }
        }
        return length;
    }
}
