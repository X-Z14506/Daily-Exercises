package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:16:27
 */

/*
    给定一个球体的半径，计算其体积。其中球体体积公式为 V = 4/3*πr^3，其中 π= 3.1415926。
    输入描述:
    一行，用浮点数表示的球体的半径。
    输出描述:
    一行，球体的体积，小数点后保留3位。

    输入：3.0
    输出：113.097
 */

public class Main22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = scanner.nextDouble();
        double v = (4/3.0)*3.1415926*Math.pow(r,3);
        System.out.println(String.format("%.3f",v));
    }
}
