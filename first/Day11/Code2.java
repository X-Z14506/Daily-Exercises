package first.Day11;

import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-04
 * Time:8:11
 */

/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
 */
public class Code2 {
    public static int[] multiply(int[] A) {
        int[] b = new int[A.length];
        for (int i = 0;i < A.length;i++) {
            int sum = 1;
            for (int j = 0 ;j < A.length;j++) {
                if (j == i) {
                    continue;
                }else {
                    sum*=A[j];
                }
            }
            System.out.println(sum);
            b[i]=sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] ret = multiply(a);
        System.out.println(Arrays.toString(ret));
    }
}
