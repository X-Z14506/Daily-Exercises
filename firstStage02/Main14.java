package firstStage02;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-31
 * Time:22:09
 */

/*
输入：4
输出：
*
* *
*   *
* * * *

输入：5
输出：
*
* *
*   *
*     *
* * * * *
 */
public class Main14 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int num = s.nextInt();
            for (int i = 1;i <= num ;i++) {
                for (int j = 1;j<=num;j++) {
                    //核心代码
                    if (i==j || j==1 || i==num) {
                        System.out.print("* ");
                    }else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
        }
    }
}
