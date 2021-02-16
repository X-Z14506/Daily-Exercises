package firstStage03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-03
 * Time:22:12
 */

/*
KiKi想知道一个n阶方矩是否为上三角矩阵，请帮他编程判定。上三角矩阵即主对角线以下的元素都为0的矩阵，主对角线为从矩阵的左上角至右下角的连线。

输入：
3
1 2 3
0 4 5
0 0 6

输出：
YES

 */

public class Main04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        String[][] strings1 = new String[n][n];
        for (int i = 0;i < n;i++) {
            String[] strings = reader.readLine().split(" ");
            for (int j = 0;j < n;j++) {
                strings1[i][j] = strings[j];
                if (i > j && !"0".equals(strings1[i][j])) {
                    System.out.println("NO");
                    break;
                }
            }
        }
        System.out.println("YES");
    }
}
