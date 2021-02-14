package firstStage01;

import java.io.IOException;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:16:17
 */

/*
        输入一个字符，用它构造一个三角形金字塔。
        输入描述:
        输入只有一行，一个字符。
        输出描述:
        该字符构成的三角形金字塔

        输入：1
        输出：
            1
           1 1
          1 1 1
         1 1 1 1
        1 1 1 1 1
 */
public class Main6 {
    public static void main  (String[] args) throws IOException {
        char c=(char)System.in.read();
        int n = 5;
        for(int i = 1; i <= n; i++){   // 控制行数
            for (int m = 1; m <= n-i; m++) { // 左侧空格
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                if ((j+1)%2 == 0){  // 基数输出1，偶数输出空格
                    System.out.print(c);
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}