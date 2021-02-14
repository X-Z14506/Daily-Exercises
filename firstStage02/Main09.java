package firstStage02;

import java.util.Collections;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-30
 * Time:22:30
 */

/*
输入：2
输出：
    *
  **
***
  **
    *

输入：3
输出：
      *
    **
  ***
****
  ***
    **
      *
 */
public class Main09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int init = 1;
            int init2 = num;
            //先打印前num+1行
            for (int i = num;i >= 0;i--) {
                System.out.println(String.join("", Collections.nCopies(i,"  "))+String.join("",Collections.nCopies(init++,"*")));
            }
            //后打印后num行
            for (int j = 1;j <= num;j++) {
                System.out.println(String.join("",Collections.nCopies(j,"  "))+String.join("",Collections.nCopies(init2--,"*")));
            }
        }
    }
}
