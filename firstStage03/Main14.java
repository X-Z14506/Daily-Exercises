package firstStage03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-06
 * Time:23:28
 */
/*
青蛙跳台阶
 */
public class Main14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n<=3) {
                System.out.println(n);
            }else {
                int ret = fib(n);
                System.out.println(ret);
            }
        }
    }
    static int fib(int n) {
        if (n<4) {
            return n;
        }else {
            return fib(n-1)+fib(n-2);
        }
    }

    public static void main1(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1){
            System.out.println(1);
        }else if(n == 2){
            System.out.println(2);
        }else{
            int a = 1;
            int b = 2;
            int c;
            for(int i = 3; i <= n; i++){
                c = a + b;
                a = b;
                b = c;
            }
            System.out.print(b);
        }
    }
}
