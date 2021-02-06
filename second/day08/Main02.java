package second.day08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-12
 * Time:12:58
 *
 *
 */

/*
记票统计
 */
public class Main02 {
    public static void main(String[] args) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        Scanner scanner = new Scanner(System.in);
        //int votePerson = Integer.parseInt(scanner.nextLine());
        while (scanner.hasNext()) {
            //候选人人数
            int votePerson = scanner.nextInt();
            scanner.nextLine();
            //候选人名字
            char[] chars1 = scanner.nextLine().toCharArray();
            //投票人人数
            int candidatePerson = scanner.nextInt();
            scanner.nextLine();
            //投票人投的票
            char[] chars2 = scanner.nextLine().toCharArray();

            //将候选人名字放入map,i=i+2,因为每两个候选人名字中间有空格字符
            for (int i = 0;i < chars1.length;i=i+2) {
                map.put(chars1[i],0);
            }

            int Invalid = 0;

            //读取投票人的投票
            for (int i = 0;i < chars2.length;i=i+2) {
                if (map.containsKey(chars2[i])) {
                    map.put(chars2[i],map.get(chars2[i])+1);
                }else {
                    Invalid++;
                }
            }
            //输出
            for (Map.Entry<Character,Integer> me : map.entrySet()) {
                System.out.println(me.getKey()+" : "+me.getValue());
            }
            System.out.println("Invalid : "+Invalid);
        }

    }
}
