package firstStage03;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-07
 * Time:11:45
 */
public class Main20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        double a = Double.parseDouble(strings[0]);
        double b = Double.parseDouble(strings[1]);
        double c = Double.parseDouble(strings[2]);
        double d1 = max3(a+b,b,c);
        double d2 = max3(a,b+c,c);
        double d3 = max3(a,b,b+c);
        System.out.println(String.format("%.2f",d1/(d2+d3)));

    }

    private static double max3(double a,double b,double c) {
        double max =  Math.max(Math.max(a,b),c);

        return max;
    }
}
