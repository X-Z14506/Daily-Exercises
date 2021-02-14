package firstStage02;

import java.util.Collections;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-30
 * Time:20:41
 */
/*
    题目描述
        KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的金字塔图案。
        输入描述:
        多组输入，一个整数（2~20），表示金字塔边的长度，即“*”的数量，，也表示输出行数。
        输出描述:
        针对每行输入，输出用“*”组成的金字塔，每个“*”后面有一个空格

输入：4
输出：
   *
  * *
 * * *
* * * *

输入：5
输出：
    *
   * *
  * * *
 * * * *
* * * * *

 */
public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            for (int i = 1;i<=num;i++) {
                //Collections.nCopies(num-i," ")方法作用：将num-i个空格字符串连接起来
                System.out.println(String.join("", Collections.nCopies(num-i," "))
                        +String.join("",Collections.nCopies(i,"* ")));
            }

        }
    }
}
