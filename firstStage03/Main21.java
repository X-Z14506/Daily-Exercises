package firstStage03;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-07
 * Time:12:24
 */

/*
所有三位整数中，有多少质数
 */
public class Main21{
    public static void main(String[] args) {

      int count = 0;
      for (int i =100;i<=999;i++) {
          boolean flag = true;
          for (int j = 2;j < i;j++) {
              if (i%j==0) {
                  flag = false;
                  //System.out.print(i+" ");
                  break;
              }
          }
          if (flag) {
              System.out.print(i+" ");
              count++;
          }
      }
        System.out.println();
        System.out.println(count);
    }
}
