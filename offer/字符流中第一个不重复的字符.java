package offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-10
 * Time:15:12
 */

/*
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class 字符流中第一个不重复的字符 {
    static HashMap<Character,Integer> map = new HashMap<>();
    //用来存放map的key值，从而可以得到map的kay的顺序
    static ArrayList<Character> list = new ArrayList<>();

    public static void main(String[] args) {
        String s = "google";
        for (int i = 0;i<s.length();i++) {
            Insert(s.charAt(i));
        }
        System.out.println(list);
        System.out.println(map);
        char c = FirstAppearingOnce();
        System.out.println(c);
    }
    //Insert one char from stringstream
    public static void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch,map.get(ch)+1);
        }else {
            map.put(ch,1);
            list.add(ch);
        }

    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce() {
        char ch = '#';
        for (char key : list) {
            if (map.get(key)==1) {
                ch = key;
                break;
            }
        }
        return ch;
    }
}
