package second.day18;

import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-22
 * Time:20:27
 */

/*
字母统计
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //TreeMap内部自动实现排序
        TreeMap<Character,Integer> treeMap =  new TreeMap<>();

        //初始化treeMap
        for (int i = 65;i < 91;i++) {
            treeMap.put((char)i,0);
        }
        while (sc.hasNext()) {
            String str = sc.nextLine();
            for (int i = 0;i<str.length();i++) {
                char c = str.charAt(i);
                if (treeMap.containsKey(c) && c>='A' && c <= 'Z') {
                    int e = treeMap.get(c);
                    treeMap.replace(c,++e);
                }
            }

            //打印统计完的key和value
            Set<Map.Entry<Character, Integer>> entrySet = treeMap.entrySet();
            for (Map.Entry<Character,Integer> entry :entrySet) {
                System.out.println(entry.getKey()+":"+entry.getValue());
            }
        }
    }

}