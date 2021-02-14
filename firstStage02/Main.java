package firstStage02;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-30
 * Time:16:49
 */
/*
    题目描述
        从键盘输入a, b, c的值，编程计算并输出一元二次方程ax2 + bx + c = 0的根，当a = 0时，输出“Not quadratic equation”，当a ≠ 0时，根据△ = b2 - 4*a*c的三种情况计算并输出方程的根。
        输入描述:
        多组输入，一行，包含三个浮点数a, b, c，以一个空格分隔，表示一元二次方程ax2 + bx + c = 0的系数。
        输出描述:
        针对每组输入，输出一行，输出一元二次方程ax2 + bx +c = 0的根的情况。

          如果a = 0，输出“Not quadratic equation”；

          如果a ≠  0，分三种情况：

        △ = 0，则两个实根相等，输出形式为：x1=x2=...。

        △  > 0，则两个实根不等，输出形式为：x1=...;x2=...，其中x1  <=  x2。

        △  < 0，则有两个虚根，则输出：x1=实部-虚部i;x2=实部+虚部i，即x1的虚部系数小于等于x2的虚部系数，实部为0时不可省略。实部= -b / (2*a),虚部= sqrt(-△ ) / (2*a)

        所有实数部分要求精确到小数点后2位，数字、符号之间没有空格。
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] strings = s.nextLine().split(" ");
            double a = Double.parseDouble(strings[0]);
            double b = Double.parseDouble(strings[1]);
            double c = Double.parseDouble(strings[2]);
            double d = b*b-4*a*c;
            //Math.sqrt()方法是开根号
            double e = Math.sqrt(d);
            double shiBu = -b/(2*a);
            double xuBu = Math.sqrt(-d)/(2*a);
            double x1 = 0;
            double x2 = 0;

            if (a == 0) {
                System.out.println("Not quadratic equation");
            }else {

                //△==0
                if (d==0) {
                    x1 = -b/(2*a);
                    System.out.printf("x1=x2=%.2f\n",x1);
                }
                //△>0
                else if (d>0) {
                    x1=(b-e)/(-2*a);
                    x2=(b+e)/(-2*a);
                    if (x1 > x2) {
                        double temp = x1;
                        x1 = x2;
                        x2 = temp;
                    }
                    System.out.printf("x1=%.2f",x1);
                    System.out.printf(";");
                    System.out.printf("x2=%.2f\n",x2);
                }
                //△<0
                else {
                    System.out.printf("x1=%.2f",shiBu);
                    System.out.printf("-%.2f",xuBu);
                    System.out.printf("i;x2=%.2f",shiBu);
                    System.out.printf("+%.2f",xuBu);
                    System.out.printf("i");

                }
            }
        }
    }
}
