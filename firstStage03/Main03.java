package firstStage03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarOutputStream;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-03
 * Time:21:39
 */

/*
两个n行m列的矩阵，他想知道两个矩阵是否相等

输入：
2 2
1 2
3 4
1 2
3 4

输出：
Yes
 */
public class Main03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < 2*n;i++) {
            strings = reader.readLine().split(" ");
            for (int j = 0;j < m;j++) {
                list.add(Integer.parseInt(strings[j]));
            }
        }
        //用两个指针遍历list并比较
        int pre = 0;
        int last = m*n;
        //判断的标志
        boolean flag = true;

        for (int i = 0;i < m*n;i++) {
            if (list.get(pre++) != list.get(last++)) {
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
