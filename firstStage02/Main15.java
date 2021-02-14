package firstStage02;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-31
 * Time:23:16
 */
public class Main15 {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            for(int i = 1;i <= num;i++) {
                for(int j = 1;j <= i;j++) {
                    System.out.print(j);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }

}
