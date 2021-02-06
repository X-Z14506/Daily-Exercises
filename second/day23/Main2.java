package second.day23;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-28
 * Time:21:09
 */

/*
坐标移动
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strings = sc.nextLine().split(";");
            validXYZ(strings);
        }
    }

    //从输入的字符串中找出有效的坐标来
    private static void validXYZ(String[] strings) {
        List<String> list = new ArrayList<>();
        for (int i = 0;i < strings.length;i++) {
            if (!"".equals(strings[i]) && strings[i] != null  ) {
                char c1 = strings[i].charAt(0);
                if (strings[i].length() <= 3 && c1 == 'A' || c1 == 'W' || c1 == 'S' || c1 == 'D') {
                    if (strings[i].length() == 2) {
                        char c2 = strings[i].charAt(1);
                        if (c2 >= '0' && c2 <= '9') {
                            list.add(strings[i]);
                        }
                    } else if (strings[i].length() == 3) {
                        char c2 = strings[i].charAt(1);
                        char c3 = strings[i].charAt(2);
                        if (c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9') {
                            list.add(strings[i]);
                        }
                    }
                }
            }
        }
        action(list);
    }

    //执行合法的坐标
    private static void action(List<String> list) {
        int x = 0;
        int y = 0;
        for (int i = 0;i < list.size();i++) {
            char c1 = list.get(i).charAt(0);
            int e = Integer.parseInt(list.get(i).substring(1));
            switch (c1) {
                case 'A': x -= e; break;
                case 'S': y -= e; break;
                case 'W': y += e; break;
                case 'D': x += e; break;
            }
        }
        System.out.println(x+","+y);
    }
}
