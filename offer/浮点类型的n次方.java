/*
题目描述：
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
保证base和exponent不同时为0

输入：
2,3
输出：
8.00000
 */
public class Main15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strings = sc.nextLine().split(",");
            double a = Double.parseDouble(strings[0]);
            int b = Integer.parseInt(strings[1]);
            double ret = Power(a,b);
            System.out.println(ret);
            System.out.println(Power2(a,b));
        }
    }
    //法一：注此题考察点应该不在这里
    public static double Power(double base, int exponent) {
        return Math.pow(base,exponent);
    }
    //法二：不使用API，自己实现，注意要区分次方的正负
    public static double Power2(double base,int exponent) {
        if (exponent < 0) {
            base = 1/base;
            exponent = -exponent;
        }
        if (exponent == 0) {
            return 1;
        }
        double ret = 1;
        for (int i = exponent;i>=1;i--) {
            ret*=base;
        }
        return ret;


    }
}
