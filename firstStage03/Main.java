package firstStage03;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-07
 * Time:11:12
 */

/*
小乐乐计算求和
小乐乐想计算一下1!+2!+3!+...+n!。
 */
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //n=1的时候，不满足第一个循环条件，返回1
        //n>1的时候，开始加阶乘
        int sum = 1;
        for(int i = 2; i <= n;i++) {
            int e = 1;
            for(int j = 1; j <= i;j++) {
                e*=j;
            }
            sum+=e;
        }
        System.out.println(sum);
    }
}