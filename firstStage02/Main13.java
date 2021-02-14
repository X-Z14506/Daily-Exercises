package firstStage02;

import java.util.Collections;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-31
 * Time:21:46
 */

/*
输入：4
输出：
* * * *
*     *
*     *
* * * *


输入：5
输出：
* * * * *
*       *
*       *
*       *
* * * * *


 */
public class Main13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int n = num-2;
            System.out.println(String.join("", Collections.nCopies(num,"* ")));
            for (int i = num-2;i > 0;i--) {
                System.out.println("* "+String.join("",Collections.nCopies(n,"  "))+"* ");
            }
            System.out.println(String.join("", Collections.nCopies(num,"* ")));
        }
    }
}
