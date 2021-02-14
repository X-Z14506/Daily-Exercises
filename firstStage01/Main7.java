package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:16:42
 */

/*
输出一个图形
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *

Process finished with exit code 0

 */
public class Main7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //总共9行
        int lay = input.nextInt();
        //输出前5行
        for (int m = 1; m <= (lay + 1) / 2; m++){
            //每一行先输出空格
            for (int b = 1; b <= (lay + 1) / 2 - m; b++){
                System.out.print(" ");
            }
            //在输出*号
            for (int c = 1; c <= m * 2 - 1; c++){
                System.out.print("*");
            }
            //一行打印完了需要换行
            System.out.println();
        }
        //打印后4行
        for (int d = (lay + 1) / 2 - 1; d >= 1; d--){
            //先打印后四行的空格
            for (int b = 1; b <= (lay + 1) / 2 - d; b++){
                System.out.print(" ");
            }
            //在打印后四行的*号
            for (int c = (lay + 1) / 2 - d; c <= (lay + 1) / 2 - 2 + d; c++){
                System.out.print("*");
            }
            //每行打印完换行
            System.out.println();
        }
    }
}
