package firstStage03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-03
 * Time:22:35
 */

/*
矩阵的转置

输入：
2 3
1 2 3
4 5 6

输出：
1 4
2 5
3 6

 */
public class Main05 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);

         String[][] str = new String[n][m];
        for (int i = 0;i < n;i++) {
            String[] strings1 = reader.readLine().split(" ");
            for (int j = 0;j < m;j++) {
                str[i][j] = strings1[j];
            }
        }

        for (int i = 0;i < m;i++) {
            for (int j = 0;j<n;j++) {
                System.out.print(str[j][i] + " ");
            }
            System.out.println();
        }
    }
}
