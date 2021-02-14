package firstStage02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-02
 * Time:21:59
 */

/*
序列中整数去重
保证按照输入的顺序输出
输入：5
     10 12 93 12 75

输出：10 12 93 75

 */

public class Main29 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] strings = reader.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < strings.length;i++) {
            if (!list.contains(Integer.parseInt(strings[i]))) {
                list.add(Integer.parseInt(strings[i]));
            }
        }
        for (int i : list) {
            System.out.print(i+" ");
        }

       /* //不能用HashSet 或者 TreeSet，因为要按照输入的顺序输出
        Set<Integer> set = new HashSet<>();
        for (int i=0 ;i < strings.length;i++) {
            set.add(Integer.parseInt(strings[i]));
        }
        System.out.println(set);*/
    }
}
