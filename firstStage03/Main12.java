package firstStage03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-05
 * Time:23:37
 */

/*
对于每组输入，输出一个正整数，为n和m的最大公约数与最小公倍数之和。

输入：10 20
输出：30

输入：15 20
输出：65


最大公约数和最小公倍数的关系：假设x和y的最大公约数是m,最小公倍数是n,则xy=mn

 */

public class Main12 {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] s = bf.readLine().split(" ");
        long n = Long.parseLong(s[0]);
        long m = Long.parseLong(s[1]);
        System.out.print(Yue(n,m)+ Bei(n,m));
    }
    public static long Yue(long x,long y){
        while(x!=0){
            long temp = y%x;
            y = x;
            x = temp;
        }
        return y;
    }

    //最大公约数和最小公倍数的关系：假设x和y的最大公约数是m,最小公倍数是n,则xy=mn
    public static long Bei(long x,long y){
        long s = Yue(x,y);
        return x*y/s;
    }



    //效率太低，速度太慢不行
    public static void main1(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        long n = Integer.parseInt(strings[0]);
        long m = Integer.parseInt(strings[1]);

        //求两个数的最大公约数
        long min = Math.min(n,m);
        long x = 1;
        for (long i = min;i>0;i--) {
            if (n%i==0 && m%i==0) {
                x=i;
                //System.out.println("最大公约数为："+i);
                break;
            }
        }

        //求两个数的最小公倍数
        long max = Math.max(n,m);
        long y = m*n;
        for (long i = max;i <= m*n;i++) {
            if (i%n==0 && i%m==0 ) {
                y = i;
                //System.out.println("最小公倍数为："+i);
                break;
            }
        }
        long sum = x+y;
        System.out.println(sum);

    }
}
