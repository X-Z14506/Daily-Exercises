package firstStage03;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-07
 * Time:13:44
 */
public class Main22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = Integer.parseInt(sc.nextLine());
        String[] strings = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < strings.length;i++) {
            int e = Integer.parseInt(strings[i]);
            if (!list.contains(e)) {
                list.add(e);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<list.size();i++) {
            sb.append(list.get(i)+" ");
        }
        System.out.println(sb.toString().trim());
    }
}
