package firstStage02;

import java.util.Collections;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-30
 * Time:18:41
 */

/*
        题目描述
        KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的带空格直角三角形图案。

        输入描述:
        多组输入，一个整数（2~20），表示直角三角形直角边的长度，即“*”的数量，也表示输出行数。

        输出描述:
        针对每行输入，输出用“*”组成的对应长度的直角三角形，每个“*”后面有一个空格。

        输入：5
        输出：
                    *
                  * *
                * * *
              * * * *
            * * * * *

        输入：3
        输出：
                *
              * *
            * * *


 */
public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 1; i <=n; i++) {
                System.out.println(String.join("", Collections.nCopies(n-i, "  "))+
                        String.join("", Collections.nCopies(i, "* ")));
            }
        }
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int num = sc.nextInt();
            int count = 1;
            //输入几行，打印几行
            for(int i=num;i>0;i--) {
                //先打印每一行的空格字符"  "
                for(int j = i-1;j>0;j--){
                    System.out.print("  ");
                }
                //在打印每一行的星号+空格字符 即"* "
                for(int k = 0;k < count;k++ ) {
                    System.out.print("* ");
                }
                //一行打印完成换行
                System.out.println();
                count++;
            }
        }
    }
}
