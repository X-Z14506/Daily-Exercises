package firstStage02;

import java.util.Collections;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-30
 * Time:21:04
 */
/*
输入：5
输出：
* * * * *
 * * * *
  * * *
   * *
    *

 */
public class Main06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int num = sc.nextInt();
            int count = num;
            for(int i = 1;i <= num;i++) {
                System.out.println(String.join("", Collections.nCopies(i-1," "))+String.join("",Collections.nCopies(count--,"* ")));
            }
        }
    }
}
