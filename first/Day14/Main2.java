package first.Day14;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-08
 * Time:9:20
 */

/*
    验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
    例如：
    1^3=1
    2^3=3+5
    3^3=7+9+11
    4^3=13+15+17+19
    输入描述:
    输入一个int整数
    输出描述:
    输出分解后的string
 */

public class Main2 {

    //思路1：每一行第一个数都为 n*n-n+1

    public static void main1(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num[] = new int[n];
        int i = n * n - n + 1;
        num[0] = i;
        System.out.println(Arrays.toString(num));//n=6时：[31, 0, 0, 0, 0, 0]
        for (int j = 1; j < n; j++) {
            i += 2;
            num[j] = i;
        }
        System.out.println(Arrays.toString(num));//n=6时：[31, 33, 35, 37, 39, 41]
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < n - 1; j++) {
            sb.append(num[j]);
            sb.append("+");
        }
        sb.append(num[n - 1]);
        System.out.println(sb.toString());//n=6时：31+33+35+37+39+41
    }

    //方法2：
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            StringBuffer sb = new StringBuffer();
            int mid = n * n;
            if (mid % 2 == 1) {
                int count = (n - 1) / 2;
                for (int i = count; i >= 0; i--) {
                    sb.append(mid - i * 2);
                    sb.append("+");
                }
                for (int i = 1; i < count; i++) {
                    sb.append(mid + i * 2);
                    sb.append("+");
                }
                sb.append(mid + count * 2);
            }
            else {
                int count = n / 2;
                for (int i = count - 1; i >= 0; i--) {
                    sb.append(mid - i * 2 - 1);
                    sb.append("+");
                }
                for (int i = 0; i < count - 1; i++) {
                    sb.append(mid + i * 2 + 1);
                    sb.append("+");
                }
                sb.append(mid + (count - 1) * 2 + 1);
            }
            System.out.println(String.valueOf(sb));
        }
    }
}























