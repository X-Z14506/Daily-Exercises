package firstStage02;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-31
 * Time:21:30
 */


/*
输入：5
输出：
*   *
 * *
  *
 * *
*   *

输入：6
输出：
*    *
 *  *
  **
  **
 *  *
*    *

 */


import java.util.Scanner;

/**
 *       X形图案可以拆分成两根斜线，其中i==j时输出星号，或者j==n-i-1时输出星号即可，其他情况皆输出空格。
  */
public class Main12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            for (int i = 0;i < num ;i++) {
                for (int j = 0;j < num ;j++) {
                    //i==j时输出星号，或者j==n-i-1时输出星号
                    if (i == j || j == num-1-i) {
                        System.out.print("*");
                    }else {//其他情况皆输出空格
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
