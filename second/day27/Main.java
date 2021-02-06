package second.day27;

import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-03
 * Time:11:12
 */

/*
乒乓球框
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] strings = sc.nextLine().split(" ");
            compare(strings);
        }
    }

    private static void compare(String[] strings) {
        String A = strings[0];
        String B = strings[1];
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> map1 = new HashMap<>();
        for (int i = 0;i < B.length();i++) {
            String s = String.valueOf(B.charAt(i));
            if (!A.contains(s)) {
                System.out.println("NO");
                return;
            }else {
                if (!map.containsKey(B.charAt(i))) {
                    map.put(B.charAt(i),1);
                }else {
                    int count = map.get(B.charAt(i));
                    map.put(B.charAt(i),++count);
                }
            }
        }
        Set<Character> set = map.keySet();
        //System.out.println(set);
        for (int i = 0;i < A.length();i++) {
            if (set.contains(A.charAt(i))) {
                if (!map1.containsKey(A.charAt(i))) {
                    map1.put(A.charAt(i),1);
                }else {
                    int count = map.get(A.charAt(i));
                    map.put(A.charAt(i),++count);
                }
            }
        }
        List<Character> list = new ArrayList<>(set);
        //System.out.println(list);
        for (int i = 0;i < map.size();i++) {
            if (map.get(list.get(i)) > map1.get(list.get(i))) {
                System.out.println("NO");
                return;
            }
        }
        //System.out.println(map);
        //System.out.println(map1);
        System.out.println("YES");
    }
}
