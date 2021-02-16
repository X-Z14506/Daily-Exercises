package firstStage03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-03
 * Time:22:54
 */

/*
第一行包含两个整数n和m，表示一个矩阵包含n行m列
从2到n+1行，每行输入m个整数
接下来一行输入k，表示要执行k次操作
接下来有k行，每行包括一个字符t和两个数a和b，t代表需要执行的操作，当t为字符'r'时代表进行行变换，当t为字符'c'时代表进行列变换，a和b为需要互换的行或列

输入：
2 2
1 2
3 4
1
r 1 2

输出:
3 4
1 2

 */

public class Main06 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        String[][] strings1 = new String[n][m];

        //给二维数组赋值
        for (int i = 0;i < n;i++) {
            strings = reader.readLine().split(" ");
            strings1[i] = strings;
        }

        int k = Integer.parseInt(reader.readLine());
        while (k > 0) {
            strings = reader.readLine().split(" ");
            String t = strings[0];
            int a = Integer.parseInt(strings[1]);
            int b = Integer.parseInt(strings[2]);

            //如果t为"r"，交换a行和b行
            if ("r".equals(t)) {
                //交换行的值
                for (int i = 0;i < m;i++) {
                    String temp = strings1[a-1][i];
                    strings1[a-1][i] = strings1[b-1][i];
                    strings1[b-1][i] = temp;
                }
            }

            //如果twe"c"，交换a列和b列
            if ("c".equals(t)) {
                //交换列的值
                for (int i = 0;i < n;i++) {
                    String temp = strings1[i][a-1];
                    strings1[i][a-1] = strings1[i][b-1];
                    strings1[i][b-1] = temp;
                }
            }
            k--;
        }

        //打印
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                System.out.print(strings1[i][j]+" ");
            }
            System.out.println();
        }

    }
}


        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        String[][] str = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] nums = br.readLine().split(" ");
            str[i] = nums;
        }
        int k = Integer.parseInt(br.readLine());
        while(k>0){
            String[] cc = br.readLine().split(" ");
            String t = cc[0];
            int a = Integer.parseInt(cc[1]);
            int b = Integer.parseInt(cc[2]);
            if("r".equals(t)){
                for(int i = 0;i<m;i++){
                    String temp = str[a-1][i];
                    str[a-1][i] = str[b-1][i];
                    str[b-1][i] = temp;
                }
            }
            if("c".equals(t)){
                for(int i = 0;i<n;i++){
                    String temp = str[i][a-1];
                    str[i][a-1] = str[i][b-1];
                    str[i][b-1] = temp;
                }
            }
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(str[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        sb.setLength(0);*/
