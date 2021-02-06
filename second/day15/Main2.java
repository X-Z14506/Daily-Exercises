package second.day15;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-20
 * Time:16:48
 */

/*
    上楼梯
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            System.out.println(countWays(n));
            System.out.println(countWays2(n));
        }
    }
    //递归
    public static int countWays(int n) {
        if (n<0) {
            return 0;
        }
        if (n==1 || n==0) {
            return 1;
        }
        if (n==2) {
            return 2;
        }
        return countWays(n-1)%1000000007+countWays(n-2)%1000000007+countWays(n-3)%1000000007;
    }
    //迭代法（动态规划）
    public static int countWays2(int n) {
        if (n<0) {
            return 0;
        }
        if (n==1 || n==0) {
            return 1;
        }
        if (n==2) {
            return 2;
        }
        if (n==3) {
            return 4;
        }
        int c1 = 1;
        int c2 = 2;
        int c3 = 4;
        for (int i = 4;i <= n;i++) {
            int temp = (c1+c2+c3)%1000000007;
            c1 = c2%1000000007;
            c2 = c3%1000000007;
            c3 = temp;
        }
        return c3;
    }
}
