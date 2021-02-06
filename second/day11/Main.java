package second.day11;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-15
 * Time:21:16
 */

/*
年会抽奖
 */
    //TODO
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            if (n==1){
                System.out.println("100.00%");
            }
            if (n==2) {
                System.out.println("50.00%");
            }
            if (n>2) {
                 double noPrize = Math.pow(n-1,n-2);
                 int sum = 1;
                 for (int i =1;i <= n;i++) {
                     sum*=i;
                 }
                 double ret = (noPrize/sum)*100;
                System.out.println(String.format("%.2f",ret)+"%");
            }
        }
    }
}
