package first.Day12;

import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-06
 * Time:9:15
 */

/*
     交换数组0号下标和1号下标的值
 */
public class Code1 {
    public static void main(String[] args) {
        int[] a = {1,2};
        System.out.println(Arrays.toString(a));
        int[] b = exchangeAB(a);
        System.out.println(Arrays.toString(b));
    }
    public static int[] exchangeAB(int[] AB) {
        int temp = AB[0];
        AB[0] = AB[1];
        AB[1] = temp;
        return AB;
    }
}
